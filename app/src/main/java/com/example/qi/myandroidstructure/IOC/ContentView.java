package com.example.qi.myandroidstructure.IOC;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)  // 将注解指定到类上面
public @interface ContentView {
    int value();
}
