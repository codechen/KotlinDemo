package com.cc.kotlin

// 闭包:函数的运行环境、持有函数的运行状态、内部可以定义函数或类

fun makeFun(): () -> Unit {
    var count = 0
    return fun() {
        println(++count)
    }
}

fun makeFun2(): Function0<Unit> {
    var count = 0
    return fun() {
        println(++count)
    }
}

fun add(x: Int) = fun(y: Int) = x + y

fun main(args: Array<String>) {
    val funtion = makeFun()
    funtion()
    funtion()
    funtion()
    funtion()
    funtion.invoke()
    println(add(5)(6))



    println(multiplyBy2(add5(8)))
    val add5AndMultipayBy2 = add5 addThen multiplyBy2 // add5.addThen(multiplyBy2)
    println(add5AndMultipayBy2(8))
}


// 函数复合：f(g(x))   m(x) = f(g(x))

val add5 = { i: Int -> i + 5 }
val multiplyBy2 = { i: Int -> i * 2 }


// infix 中缀表达式 允许通过 addThen 方式执行函数，不需要.()
infix fun <P1, P2, R> Function1<P1, P2>.addThen(function: Function1<P2, R>): Function1<P1, R> {
    return fun(p1: P1): R {
        return function(this(p1))
//        return function.invoke(this.invoke(p1))
    }
}




