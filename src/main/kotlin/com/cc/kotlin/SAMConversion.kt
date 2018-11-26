package com.cc.kotlin

import java.util.concurrent.Executor
import java.util.concurrent.Executors

// SAM转换: 对于只有单个接口的接口参数可用lambda表达来替换

fun main(args: Array<String>) {
    Executors.newCachedThreadPool().submit(object: Runnable {
        override fun run() {
            println("java runing...")
        }
    })

    Executors.newCachedThreadPool().submit {
        println("kotlin runing...")
    }

    // lambda属性的值一个方法，该方法为lambda表达式
    val lambda = { i:Int, j:String ->
        println("lambda")
    }

    lambda(1, "2")

    // public actual typealias ArrayList<E> = java.util.ArrayList<E> 映射到java的ArrayList<E>
    val list:List<*> = ArrayList<String>()

    val list2 = listOf<String>("1", "2")
    mapOf<String, String>()
    setOf<String>()
    charArrayOf()
    intArrayOf()
    arrayOf("a", "b")
    listOf<String>()
}