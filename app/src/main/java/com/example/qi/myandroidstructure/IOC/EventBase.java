package com.example.qi.myandroidstructure.IOC;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
* 该注解使用在其他注解上面
* */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface EventBase { // 定义事件三要素
    // 1、setOnClickListener 订阅关系
    String listenerSetter();
    // 2、new View.OnClickListener 事件类型
    Class<?> listenerType();
    // 3、onClick(View v) 事件处理程序
    String callbackMethod();
}
