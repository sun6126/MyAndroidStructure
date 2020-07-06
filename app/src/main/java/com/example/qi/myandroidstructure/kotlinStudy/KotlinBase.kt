package com.example.qi.myandroidstructure.kotlinStudy

fun main() {
// 测试downTo
    testDownTo()

    // 测试until
//    testUntil()

    // 循环打印数字
//    testFor()

}

// downTo 创建从大到小的闭区间
fun testDownTo(){
    for (i in 10 downTo 1){
        println(i)
    }
}

// until 创建左闭右开的区间 [0,10)
fun testUntil(){
    for (i in 0 until 10){
        println(i)
    }
}

// for循环
fun testFor(){
    // 创建【0，10】区间
    for (i in 0 .. 10){
        println(i)
    }
}

// 如果对kotlin变量延迟赋值的话，kotlin就无法自动推导出他的类型了

// kotlin中函数只有一行代码时，可以直接使用 = 相连（ = 后面的内容就可以当作函数的返回值）
fun add(a: Int, b: Int) = a + b

// kotlin中的if是有返回值的，就是if语句每一个条件的最后一行代码