package com.example.qi.myandroidstructure.kotlinStudy

fun main() {
    println(newStr)
    println(newStr2)
    println(newStr3)
}

// kotlin中，
// 1、当lambda参数是函数的最后一个参数时，可以将Lambda表达式移到函数括号的外面
// 2、当lambda参数是函数唯一一个参数时，可以将函数的 括号 去掉
// 3、在lambda中的参数列表，大多数情况可以不用声明 参数类型
// 4、当lambda表达式的参数列表中只有一个参数时，也可以不声明参数，直接用 it 来代替

// ?: 的使用
val a = 0
val c = a ?: 1 // 如果a不为空，则返回a，否则返回1

fun getTextLength(str:String?) = str?.length ?: 0

// let函数
fun foStudy(study: Study?){
    // 如果study为空，则什么都不做，否则执行lambda
    study?.let {
        it.doHomeWork()
        it.readBooks()
    }
}

/*
* with函数
* 最后一行作为函数返回值
* 函数体持有该对象的上下文
* */
var str:String = "testWith"
val newStr = with(str){
    this + "001"
}

/*
* run函数
* 效果同上，但是使用方法不一样
* */
val newStr2 = str.run {
    this + "002"
}

/*
*  apply函数
*  无法指定返回值，默认返回原对象
* */
var newStr3 = str.apply {
    this + "003"
}


























