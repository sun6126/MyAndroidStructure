package com.example.qi.myandroidstructure.kotlinStudy

fun main() {
    Student.doAction01()
    Student.doAction02()

}

/*
* 单例类
* 把 class 关键字改成 object即可（但是这种单例无法传参进来，可以使用 companion object）
* */
object Singleton {
    // 调用方法，直接类名.方法  和Java中的静态使用一样
    fun test() {
        println("test singleton")
    }
}

/*
* 数据类
* 在class 之前 加上 data 关键字
* kotlin就会根据柱构造函数中的参数帮你将equals()、hashCode()、toString()等固定的且无实际逻辑意义的方法自动生成
* */
data class CellPhone(val brand: String, val price: Double)


// 在柱构造函数中声明的 var和val 会被当成当前类的成员变量
class Student(val sno: String, val grade: Int, name: String, age: Int) : Person(name, age) {

    /*
    * 类似于静态方法的使用
    * */
    companion object {
        fun doAction01() {
            println("test companion object")
        }

        // 真正的 static方法（只能在 companion object中或者 单例类中定义）
        // 可以在 java 代码中以静态方式调用
        @JvmStatic
        fun doAction02() {
            println("test static")
        }

    }

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