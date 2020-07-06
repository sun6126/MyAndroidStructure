package com.example.qi.myandroidstructure.selfEventBus;

import com.example.qi.myandroidstructure.selfEventBus.MyThreadMode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MySubscribe {
    MyThreadMode threadMode() default MyThreadMode.POSTING; // 表明此注解可以指定参数，default 表示默认使用后面这个参数
}
