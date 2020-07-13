package com.example.qi.myandroidstructure.javaAboutProxy;

import java.lang.reflect.Proxy;

/*
* 静态代理的缺点：由于代理只能为一个类服务，如果需要代理的类很多，那么就需要编写大量的代理类，比较繁琐。
* */
/*
* 动态代理具体步骤：
    通过实现 InvocationHandler 接口创建自己的调用处理器；
    通过为 Proxy 类指定 ClassLoader 对象和一组 interface 来创建动态代理类；
    通过反射机制获得动态代理类的构造函数，其唯一参数类型是调用处理器接口类型；
    通过构造函数创建动态代理类实例，构造时调用处理器对象作为参数被传入。
* */
public class Test {
    public static void main(String[] args) {
        Hello hello = new Hello();
        ProxyHandler proxyHandler = new ProxyHandler(hello);
        HelloInterface helloInterface = (HelloInterface) Proxy.newProxyInstance(hello.getClass().getClassLoader(),
                hello.getClass().getInterfaces(), proxyHandler);
        helloInterface.sayHello();
    }
}
