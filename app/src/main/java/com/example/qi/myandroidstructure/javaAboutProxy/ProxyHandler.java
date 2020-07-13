package com.example.qi.myandroidstructure.javaAboutProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {
    private Object object;

    public ProxyHandler(Object object){
        this.object = object;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start");
        method.invoke(object,args);
        System.out.println("end");
        return null;
    }
}
