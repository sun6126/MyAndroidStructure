package com.example.qi.myandroidstructure.IOC;

import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentNavigableMap;

public class InjectUtils {

    /*
     * 布局注入的功能
     * */
    public static void inject(Object context) {
        injectLayout(context);
        injectView(context);
//        injectClick(context);
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
