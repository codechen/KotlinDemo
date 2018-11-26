package com.cc.kotlin

import com.google.gson.Gson
import java.io.File
import java.math.BigDecimal

// 泛型:伪泛型，仅存在于编译前

fun <T : Comparable<T>> max(a: T, b: T): T {
    return if (a > b) a else b
//    return if (a.compareTo(b) > 0) a else b
}

data class Complex(val a: Int, val b: Int) : Comparable<Complex> {

    override fun compareTo(other: Complex): Int {
        return value() - other.value()
    }

    fun value(): Int {
        return a * a + b * b
    }

    override fun toString(): String {
        return "$a^2 $b^2 is max."
    }
}

data class GenericClass<T : Number>(val x: T, val y: T)


// inline：把这段代码植入到调用点处 reified: 让泛型参数具体化
inline fun <reified T> testGeneric() {
    println(T::class.java.simpleName)
}

data class House(val price: Double, val address: String) {
    override fun toString(): String {
        return "This house price is $price and address is $address"
    }
}

inline fun <reified T> Gson.fromJson(json: String): T {
    return fromJson(json, T::class.java)
}

fun findHouse(house: House) {
    println(house)
}

fun main(args: Array<String>) {
    val a = 2
    val b = 3
    val max = max(a, b)
    println(max)

    val complexA = Complex(3, 8)
    val complexB = Complex(2, 9)
    max(complexA, complexB).let(::println)

    val genericClass = GenericClass<Int>(1, 16)

    testGeneric<String>()


    val house = House(555.0, "china gz.")
    Gson().toJson(house).let {
        File("house.json").writeText(it)
    }

    val house2:House = Gson().fromJson(File("house.json").readText())
//    val house2 = Gson().fromJson<House>(File("house.json").readText())
    house2.let(::println)

    findHouse(Gson().fromJson(File("house.json").readText()))


    //************************泛型类型****************************
    // 逆变
    val comple: Comparable<Int> = object : Comparable<Any> {
        override fun compareTo(other: Any): Int {
            return 1
        }
    }

    // 协变
    val numberList: List<Number> = listOf<Int>(1, 2, 3)
//    numberList.contains(BigDecimal("0"))
//    numberList.add(BigDecimal("0"))
//    numberList.get(0)

    // 不变
    val numberArray: MutableList<Number> = mutableListOf<Number>(7, 8, 9)



    //*****************
//    val numberArray2: MutableList<Number> = mutableListOf<Int>(7, 8, 9)
//    val numberArray3: MutableList<Int> = mutableListOf<Number>(7, 8, 9)


    //************************** * 星投影 实参类型不能用 **********************************

    // 逆变 *代表所有类的子类==Nothing
//    val comple2: Comparable<Nothing> = object : Comparable<Any>
    val comple2: Comparable<*> = object : Comparable<Any> {
        override fun compareTo(other: Any): Int {
            return 1
        }
    }

    // 协变 *代表所有类的父类==Any?
//    val numberList2: List<Any?> = listOf<Int>(1, 2, 3)
    val numberList2: List<*> = listOf<Int>(1, 2, 3)

    // 不变 *平级
    val numberArray5: MutableList<*> = mutableListOf<Number>(7, 8, 9)
}


// in:逆变 泛型参数作为函数的传入参数类型叫逆变点 【只提供写入接口的模块，泛型使用in类型】
// out:协变 泛型参数作为函数的返回值类型叫协变点 【只提供读取接口（或者传参为泛型但不会改变对象本身的）的模块，泛型使用out类型】
// 没有修饰符:不变 可作参数也可以作返回值 【提供写入和读取接口的模块，泛型使用不变类型】

// 【使用类型的作用：调用时可以有更好的灵活性】

interface GenericType<out E> {

    fun getType(): E

    fun setType(element: @UnsafeVariance E)

    fun <T> hello() {

    }
}
