package com.example.qi.myandroidstructure.kotlinStudy

fun main() {
//    val person = Person()
//    person.name = "jack"
//    person.age = 20
//    person.eat()

    // 新建student对象
    val student = Student("test")
    student.address = "north"
    println(student.address)

}

// 在柱构造函数中声明的 var和val 会被当成当前类的成员变量
class Student(val sno: String, val grade: Int, name: String, age: Int) : Person(name, age) {
    // 私有变量的get set
    var address: String? = null
        get() = field
//    fun getAddress() = address
//    fun setAddress(address: String) {
//        this.address = address
//    }

    // 次构造函数必须直接或者间接调用柱构造函数
    constructor(sno: String) : this(sno, 0, "", 0)

    // 如果这个类没有定义柱构造函数，并且定义了次构造函数，那此类就是没有柱构造函数，
    // 继承父类也就无需加上括号了，需要通过次构造函数调用父类的构造（使用super（））
}

// 一个类默认是public final 的，想要被继承需要添加 open关键字
open class Person(var name: String, var age: Int) {
    fun eat() {
        println("$name is $age years old,he is eating")
    }
}