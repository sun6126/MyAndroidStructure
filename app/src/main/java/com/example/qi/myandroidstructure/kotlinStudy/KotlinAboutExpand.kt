package com.example.qi.myandroidstructure.kotlinStudy

import java.lang.StringBuilder


fun main() {
    var str = "abc000".lettersCount()
    println(str)

    var str2 = "abc" * 3
    println(str2)
}

/*
*  扩展函数，直接类名.函数名。。。
*  定义一个 String 的扩展函数，计算string中字母的数量
* */
fun String.lettersCount(): Int {
    var count = 0
    for (char in this) {
        if (char.isLetter()) {
            count++
        }
    }
    return count
}

/*
*  运算符重载
* 必须加上operator
* */
class Money(val value: Int) {
    // 定义 “+” 运算符重载，实现 两个money对象相加
    operator fun plus(money: Money): Money {
        val sum = value + money.value
        return Money(sum)
    }

    // 重载，可以直接和数字相加
    operator fun plus(number: Int): Money {
        val sum = value + number
        return Money(sum)
    }
}

/*
  * 定义一个字符串乘以数字 使得字符串重复n次
  * */
operator fun String.times(n: Int): String {
    val stringBuilder = StringBuilder()
    repeat(n){
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}



















