package com.example.qi.myandroidstructure.selfEventBus

import java.lang.reflect.Method

// 观察者者中的注册方法信息
/*
* 包含注册的方法
* 指定的线程
*  方法的参数类型
* */
class SubscriberMethod(
    val method: Method,
    val myThreadMode: MyThreadMode,
    val eventType: Class<Any>
)