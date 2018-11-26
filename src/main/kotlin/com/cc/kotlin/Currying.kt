package com.cc.kotlin

import java.nio.charset.Charset

// 柯里化: 将多个参数的函数调用转化一连串单参数函数的调用过程

fun hello(x: String, y: Int, z: Float): Boolean {
    return true
}

//fun curridHello2(x: String): (y: Int) -> (z: Float) -> Boolean {
//
//}

fun curridHello(x: String) = fun(y: Int) = fun(z: Float) = false


fun main(args: Array<String>) {
    println(hello("a", 1, 1.0f))
    println(curridHello("a")(1)(1.0f))
    println(::hello.curried()("a")(1)(1.0f))



    val bytes = "你说好的".toByteArray(charset("GBK"))
    val strFromGBK = makeStrFromGbkBytes(bytes)
    println(strFromGBK)
}

fun <P1, P2, P3, R> Function3<P1, P2, P3, R>.curried() = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = this(p1, p2, p3)


// 偏函数: 固定函数中的革某个参数值

val makeStr = fun(byteArray: ByteArray, charset: Charset) = String(byteArray, charset)

val makeStrFromGbkBytes = makeStr.partial2(charset("GBK"))

fun <P1, P2, R> Function2<P1, P2, R>.partial2(p2: P2) = fun(p1: P1) = this(p1, p2)
