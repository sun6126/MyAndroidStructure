package com.example.qi.myandroidstructure.IOC;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@EventBase(listenerSetter = "setOnClickListener",
        listenerType = View.OnClickListener.class,
        callbackMethod = "click") // 如果是longClick则对应填写其他值
public @interface OnClick {
    int[] value() default -1;
}
