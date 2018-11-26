package com.cc.kotlin

import java.io.BufferedReader
import java.io.FileReader

// 高阶函数,参数或返回值为函数的函数

fun main(args: Array<String>) {
    args.forEach(::print)
    println()
    args.filter(String::isNotEmpty)
    val cFilter = CFilter()
    val filterArray = args.filter(cFilter::filter)
    filterArray.forEach(::print)


    // kotlin 常用高阶函数
    val data = listOf(1, 2, 5, 6, 3, 8, 7)
    val newData = data.map {
        it * 2 + 1
    }
    newData.forEach(::println)

    val flatData = listOf(1..50, 8..23, 55..100)
    val newFlatData = flatData.flatMap { itRange ->
        itRange.map { itElemtent ->
            "No. $itElemtent"
        }
    }
    newFlatData.forEach(::println)

    val flatData2 = listOf(1..50, 8..23, 55..100)
    val newFlatData2 = flatData.flatMap {
        it
    }
    println(newFlatData2.reduce { acc, i -> acc + i })

    (0..3).map(::factorial).forEach(::println)
    // initial：acc的初始值
    println((0..3).map(::factorial).fold(6) { acc, i->
        acc+i
    })
    println((0..3).map(::factorial).fold(StringBuilder("fold=")) { acc, i->
        acc.append("$i-")
    })
    println((0..3).map(::factorial).foldRight(StringBuilder("fold=")) {i, acc->
        acc.append("$i-")
    })

    println((0..6).joinToString("-"))

    println((0..8).map(::factorial).takeWhile { it % 2 == 1 }) // 遇到第一个不符合条件则退出处理



    findPerson()?.let { (name, age) ->
        println(name)
        println(age)
    }

    findPerson()?.let {
        it.work()
        println(it.age)
    }

    val name= findPerson()?.apply {
        work()
        println(age)
    }?.name

//    with(findPerson()) {
//        work()
//        println(age)
//    }

    val br = BufferedReader(FileReader("hello.txt"))
    with(br) {
        var line:String?
        while (true) {
            line = readLine()?:break
            println(line)
        }
        close()
    }

    val brtx = BufferedReader(FileReader("hello.txt")).readText()
    println(brtx)

    BufferedReader(FileReader("hello.txt")).use {
        var line:String?
        while (true) {
            line = it.readLine()?:break
            println(line)
        }
    }
}

class CFilter {

    fun filter(str: String): Boolean {
        return str == "A" || str == "R"
    }
}


// 求阶乘
fun factorial(n: Int): Int {
    if (n == 0) return 1
    return (1..n).reduce { acc, i -> acc * i }
}


fun findPerson():Person? {
    return null
}

data class Person(val name:String, val age:Int)  {
    fun work() {
        println("$name is working.")
    }
}