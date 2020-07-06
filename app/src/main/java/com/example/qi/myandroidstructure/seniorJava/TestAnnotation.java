package com.example.qi.myandroidstructure.seniorJava;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestAnnotation {
    public static void main(String[] args) {
        Person person = new Person();
        Class<Person> personClass = Person.class;
        try {
            // 获取 somebody() 方法的Method实例
            Method somebody = personClass.getMethod("somebody", String.class, int.class);
            // 执行此方法
            somebody.invoke(person, new Object[]{"lily", 18});

            // 判断方法是都包含注解
            IiteratorAnnotations(somebody);

            Method empty = personClass.getMethod("empty");
            empty.invoke(person);
            IiteratorAnnotations(empty);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 判断 somebody() 方法是否包含MyAnnotation注解
    private static void IiteratorAnnotations(Method method) {
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            // 获取该方法的 注解实例
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            // 获取annotation的值并打印出来
            String[] value = annotation.value();
            for (String str : value) {
                System.out.println(str);
            }
        }

        // 获取方法中所有注解并打印
        Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
        for (Annotation annotation : declaredAnnotations) {
            System.out.println(annotation.toString());
        }

    }
}




















