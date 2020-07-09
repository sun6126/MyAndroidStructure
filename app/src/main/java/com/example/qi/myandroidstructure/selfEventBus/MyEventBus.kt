package com.example.qi.myandroidstructure.selfEventBus

import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/*
* 单例模式
* */
object MyEventBus { // 运行时反射原理

    // 缓存观察者中所有方法
    var cacheMap = HashMap<Any, ArrayList<SubscriberMethod>>()

    /*
    * 注册观察者
    * 保存订阅者信息
    * */
    public fun register(subscriber: Any) {
        val clazz = subscriber.javaClass
        // 从缓存中获取方法集合
        var methodList = cacheMap[subscriber]
        if (methodList == null) {
            methodList =
                getSubscriberMethods(
                    subscriber
                )
            cacheMap.put(subscriber, methodList)
        }
    }

    // 遍历获取所有带有订阅注解的方法
    private fun getSubscriberMethods(subscriber: Any): ArrayList<SubscriberMethod> {
        var javaClass = subscriber.javaClass
        val list: ArrayList<SubscriberMethod> = ArrayList()
        // 需要遍历 subscriber ---> BaseActivity ---> Activity
//        while (javaClass != null) {
        val name = javaClass.name
        // 系统的类就不需要
//            if (name.startsWith("java.") ||
//                name.startsWith("javax.") ||
//                name.startsWith("android.") ||
//                name.startsWith("androidx.")
//            )
//            {
//                break
//            }
//            javaClass = javaClass.superclass as Class<Any> // 遍历父类中是否有？？？
//        }
        val methods = javaClass.declaredMethods
        methods.forEach flag@{
            // 检查此方法是否含有注解
            val annotation = it.getAnnotation(MySubscribe::class.java) ?: return@flag
            // 拿到当前方法的参数类型数组
            val parameterTypes = it.parameterTypes
            if (parameterTypes.size != 1) { // 只支持一个参数
                throw RuntimeException("注册方法只能接受一个参数")
            }
            // 得到有效的方法后，封装一下
            val threadMode = annotation.threadMode
            list.add(
                SubscriberMethod(
                    it,
                    threadMode,
                    parameterTypes.get(0) as Class<Any>
                )
            )
        }
        return list
    }

    public fun unRegister(subscriber: Any) {
        val get = cacheMap.get(subscriber)
        if (get != null) {
            cacheMap.remove(subscriber)
        }
    }

    public fun post(obj: Any) {
        if (cacheMap.size > 0) {
            val keys = cacheMap.keys
            val iterator = keys.iterator()
            while (iterator.hasNext()) {
                // 拿到注册类
                val next = iterator.next()

                // 获取类中所有添加注解的方法
                val methodList = cacheMap.get(next)
                methodList?.forEach {
                    // 判断方法中的 参数类型 是否与 这个即将发送的参数类型（obj）匹配，再去执行这个方法
                    if (it.eventType.isAssignableFrom(obj.javaClass)) {

                        // 这边还可以加 线程的判断，分别处理 发送方在主线程还是子线程，接收方是在主线程还是
                        // 子线程，利用handler切换线程，在对应的地方处理方法

                        invokeMethod(next, it, obj)
                    }
                }
            }
        }
    }

    /*
    *  next : 拥有这个方法的对象
    *  it : 自定义的方法信息类
    *  params : 方法的参数
    * */
    private fun invokeMethod(next: Any, it: SubscriberMethod, params: Any) {
        // 得到方法
        val method = it.method
        // 方法调用，传入 对象和 参数
        method.invoke(next, params)
    }


}