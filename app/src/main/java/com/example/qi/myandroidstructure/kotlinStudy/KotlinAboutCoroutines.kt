package com.example.qi.myandroidstructure.kotlinStudy

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch {
        println("test coroutines")
         // 挂起当前协程
        delay(1500)
    }
    // 阻塞当前线程
    Thread.sleep(1000)
}

