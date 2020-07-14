package com.example.qi.myandroidstructure.IOC;

import android.view.View;

import androidx.core.app.RemoteInput;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentNavigableMap;

/*
getDeclaredMethod：获取当前类的所有声明的方法，包括public、protected和private修饰的方法。
需要注意的是，这些方法一定是在当前类中声明的，从父类中继承的不算，实现接口的方法由于有声明所以包括在内。

getMethod：获取当前类和父类的所有public的方法。这里的父类，指的是继承层次中的所有父类。比如说，A继承B，B继承C，那么B和C都属于A的父类。
*/

public class InjectUtils {

    /*
     * 布局注入的功能
     * */
    public static void inject(Object context) {
        injectLayout(context);
        injectView(context);
        injectClick(context);
    }

    // 事件注入
    private static void injectClick(Object context) {
        // 得到Activity
        Class<?> aClass = context.getClass();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            // 如下就写死了，应该对应与不同的注解来做处理
//            declaredMethod.getAnnotation(OnClick.class);
            Annotation[] annotations = declaredMethod.getAnnotations();
            if (annotations.length > 0){
                for (Annotation annotation : annotations) {
                    // 通过注解找到注解之上的注解，如果有 eventbase
                    // 先得到注解的注解类型，再去获取他上面的注解类型
                    Class<? extends Annotation> annotationType = annotation.annotationType();
                    EventBase eventBase = annotationType.getAnnotation(EventBase.class);
                    // 如果没有eventBase，则表示当前方法不是一个要求处理的事件
                    if (eventBase == null){
                        continue;
                    }else {  // 有eventBase就去处理对应的回调（通过事件三要素）

                        // 得到@onClick注解上面的eventBase注解里的值，才知道对应要执行的方法
                        // 订阅关系
                        String listenerSetter = eventBase.listenerSetter();
                        // 事件
                        Class<?> listenerType = eventBase.listenerType();
                        // 回调
                        String method = eventBase.callbackMethod();

                        // 通过反射拿到id，再根据id得到view
                        try {
                            // 得到第一层注解里声明的方法
                            Method method1 = annotationType.getDeclaredMethod("value");
                            // 反射得到注解里声明的viewId
                            int[] viewIds = (int[]) method1.invoke(annotation);
                            // 对每一个id进行事件绑定
                            for (int viewId : viewIds) {
                                // 找到id对应的view，再执行事件
                                Method findViewById = aClass.getMethod("findViewById", int.class);
                                View view = (View) findViewById.invoke(context, viewId); // 应该传入 实例，和参数
                                if (view == null){
                                    continue;
                                }

                                // 得到view后，执行监听
                                // 使用代理，View.OnClickListener
                                ListenerInvocationHandler listenerInvocationHandler =
                                        new ListenerInvocationHandler(context, declaredMethod); // 这个declareMethod就是activity中的onclik方法，传入到代理类中
                                Object proxyInstance = Proxy.newProxyInstance(listenerType.getClassLoader(),
                                        new Class[]{listenerType}, listenerInvocationHandler);
                                // 执行监听方法
                                Method setListenerMethod = view.getClass().getMethod(listenerSetter, listenerType);
                                setListenerMethod.invoke(view,proxyInstance);
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                }

            }


        }


    }

    private static void injectView(Object context) {
        Class<?> aClass = context.getClass();
        // 得到所有声明的成员变量
        Field[] declaredFields = aClass.getDeclaredFields();
        if (declaredFields != null) {
            for (Field field : declaredFields) {
                ViewInject annotation = field.getAnnotation(ViewInject.class);
                if (annotation != null) {
                    int resId = annotation.value();
                    // 通过注解来将view赋值给成员变量
                    try {
                        Method method = aClass.getMethod("findViewById", int.class);
                        // 得到view对象
                        View view = (View) method.invoke(context, resId);
                        // 赋值给field
                        field.setAccessible(true);
                        field.set(context, view);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static void injectLayout(Object context) {
        int layoutId = 0;
        // 得到activity 的Class对象
        Class<?> clazz = context.getClass();
        ContentView contentView = clazz.getAnnotation(ContentView.class);
        if (contentView != null) {
            layoutId = contentView.value();
            // 得到了布局id，反射去执行 setContentView即可
            try {
                Method setContentView = clazz.getMethod("setContentView", int.class);
                setContentView.invoke(context, layoutId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
