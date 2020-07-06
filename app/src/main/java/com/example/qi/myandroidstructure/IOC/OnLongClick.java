package com.example.qi.myandroidstructure.IOC;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@EventBase(listenerSetter = "setOnLongClickListener",
        listenerType = View.OnLongClickListener.class,
        callbackMethod = "onLongClick")
public @interface OnLongClick { // 基于@eventBase 新增一个长按注解事件
    int[] value() default -1;
}
