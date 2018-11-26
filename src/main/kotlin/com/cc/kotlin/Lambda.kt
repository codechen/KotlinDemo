package com.cc.kotlin

val sum = { ar1: Int, ar2: Int -> ar1 + ar2 }

val prinlnHello = {
    println("hello")
}

fun main(args: Array<String>) {
    println(sum(2, 6))
    println(sum.invoke(2, 6))
    prinlnHello()

    var i = "ddd"

//    for (str in args) {
//        println(str)
//    }
//
//    args.forEach({
//        element -> println(element)
//    })
//
//    args.forEach { println(it) }

    args.forEach For@{
        if (it == "s") return@For
        println(it)
    }

    args.forEach(::out)

    val array = intArrayOf(1, 2, 3)
    hi(5.0, *array, s = "s")
}

fun out(arg: Any) {
    println(arg)
}

// vararg 变长参数
fun hi(d: Double = 3.0, vararg ints: Int, s: String = "hello") {
    ints.forEach(::println)
}

class A {
   /* lateinit var b: Int
        get() {
            return b
        }
        set(value) {
            b = value
        }*/

    var c: String
        get() {
            return c
        }
        set(value) {
            c = value
        }

    val hello: String by lazy {
        "helloworld"
    }
}


abstract class B {
    abstract fun work()

    open fun go() {

    }
}

class C : B() {
    override fun work() {

    }

    override fun go() {
        super.go()
        var i = 1
    }
}

interface D {
    fun work()

    fun go() {

    }
}

interface F {

    fun work()
    fun go() {

    }
}

class E : D, F {
    override fun go() {
        super<D>.go()
        super<F>.go()
    }

    override fun work() {

    }
}