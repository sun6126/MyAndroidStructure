package com.example.qi.myandroidstructure.selfEventBus;

import com.example.qi.myandroidstructure.selfEventBus.MyThreadMode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MySubscribe {
    MyThreadMode threadMode() default MyThreadMode.POSTING;
}
