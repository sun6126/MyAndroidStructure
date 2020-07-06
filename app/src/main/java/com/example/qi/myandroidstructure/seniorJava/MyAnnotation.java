package com.example.qi.myandroidstructure.seniorJava;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 * @Retention // 标识这个注解怎么保存，是只在代码中，还是编入class文件中，或者是在运行时通过反射访问
 * @Documented // 标记这些注解是否包含在用户文档中
 * @Target // 标记这个注解应该是哪种java成员
 * @inherited // 标记这个注解是继承于哪个注解类（默认：注解并没有继承于任何子类）
 * */
@Retention(RetentionPolicy.RUNTIME) // 指定注解的保留策略,编译器会将 MyAnnotation 的信息保留在 .class 文件中，并且能被虚拟机读取。
public @interface MyAnnotation {
    String[] value() default "unKnow";
}

class Person {
    @MyAnnotation
    @Deprecated
    public void empty() {
        System.out.println("empty");
    }

    @MyAnnotation(value = {"girl","boy"})
    public void somebody(String name, int age) {
        System.out.println(name + "   " + age);
    }
}