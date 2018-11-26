package com.cc.kotlin

// 扩展方法
fun String.multiply(time: Int): String {
    val stringBuilder = StringBuilder()
    for (i in 0 until 16) {
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}

// 扩展属性
var String.extendFiled: String
    get() = "hello"
    set(value) {
        extendFiled = value
    }

// 操作符重载 https://www.jianshu.com/p/2b26ebaa4c71
operator fun String.times(time: Int): String {
    val stringBuilder = StringBuilder()
    for (i in 0 until 16) {
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}

fun main(args: Array<String>) {
    println("abc".multiply(10))
    println("abc" * 10)
    println("adb".extendFiled)
}