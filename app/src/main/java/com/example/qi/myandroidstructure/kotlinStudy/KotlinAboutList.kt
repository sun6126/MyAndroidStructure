package com.example.qi.myandroidstructure.kotlinStudy

fun main() {
    testMap()
}


// map的使用
val map = HashMap<String, Int>()
val map2 = mapOf("apple" to 1, "pear" to 2) // 同上
fun testMap() {
    // 给map赋值
    map["apple"] = 1
    map["pear"] = 2
    println(map)

    // for循环遍历map2
    for ((fruit, num) in map2) {
        println("fruit is $fruit , num is $num")
    }
}


// set集合是无序的
val set = setOf("apple", "banana", "orange", "pear", "grape")

// 创建一个 不可变集合 （即不能添加、修改和删除）
val list = listOf("apple", "banana", "orange", "pear", "grape")

// 可变集合
val mutableList = mutableListOf("apple", "banana", "orange", "pear", "grape")

// 集合的函数式 API

// 通过条件找到满足最大值的水果
val maxLengthFruit = list.maxBy { it.length }

// map函数(将集合中的每一个值映射成另外的值，返回新的 list)
val newList = list.map { it.toUpperCase() }

// filter函数（过滤集合中的数据）
val listAfterFilter = list.filter { it.length > 4 }

// any函数（用来判断集合中是否至少存在一个数据满足条件，是就返回true）
val result = list.any { it.length == 5 }
// all函数（用于判断是否所有元素都满足条件）