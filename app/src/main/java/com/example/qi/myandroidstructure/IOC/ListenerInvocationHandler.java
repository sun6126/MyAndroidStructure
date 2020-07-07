package com.example.qi.myandroidstructure.IOC;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
* 将被代理类和代理方法做一个封装
* */
public class ListenerInvocationHandler implements InvocationHandler {
    Object activity;
    Method activityMethod;

    public ListenerInvocationHandler(Object activity, Method activityMethod) {
        this.activity = activity;
        this.activityMethod = activityMethod;
    }


    /*
    * 点击按钮会执行这个方法
    * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在这里调用了被注解的 onclick方法
        return activityMethod.invoke(activity,args);
    }
}
