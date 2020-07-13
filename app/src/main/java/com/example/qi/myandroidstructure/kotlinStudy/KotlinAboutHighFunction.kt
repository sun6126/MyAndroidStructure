package com.example.qi.myandroidstructure.kotlinStudy

import com.example.qi.myandroidstructure.network.RxHelper

fun main() {
//    example { str, num ->
//        repeat(num) {
//            println(str)
//        }
//    }

    val list1 = listOf("apple", "pear", "orange", "watermelon", "cherry")
    val result = StringBuilder().build {
        append("start eating fruits.\n")
        for (fruit in list1) {
            append(fruit).append("\n")
        }
        append("ate all fruits")
    }
    println(result.toString())

}

// 定义一个高阶函数
fun example(func: (String, Int) -> Unit) {
    func("test", 3)
}

// 模仿apply函数
fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}

/*
*  类委托
*  委托实现MySet
*  在MySet构造函数中接受了一个HashSet参数，相当于一个辅助对象
* */
class MySet<T>(val helper: HashSet<T>) : Set<T> by helper {
    // 可以实现自己新增的方法
    public fun test() {
        println("test")
    }
}

/*
*  属性委托
* */

//


// infix函数
infix fun String.beginWith(str: String): Boolean = startsWith(str)

infix fun <T> Collection<T>.has(element: T): Boolean = contains(element)












