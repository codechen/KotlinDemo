package com.cc.kotlin

import com.sun.xml.internal.fastinfoset.util.StringArray

fun getName(): String? {
    return "hi"
//    return null
}

fun setName():Unit { //void

}

val int2Long = fun(x:Int):Long{
    return x.toLong()
}

val iii = fun(arg1:Int, arg2:Int) = arg1 + arg2

fun sum(arg1:Int, arg2:Int) = arg1 + arg2

fun main(args: Array<String>) {
    val name: String = getName() ?: return
    println(name.length)
//    println(getName()?.length)

    val value: String? = "mark"

    if (value is String)
        println(value.length)

    if (value != null)
        println(value.length)

    println(value!!.length)

    val car:Car = Car("Ford", 5002, 2590, "red")
    println(car is BMW)
    val bmw:BMW? = car as? BMW
    println(bmw)

    val rang:IntRange = 200..900 // [200, 900]
    val range2:IntRange = 200 until 900 // [200, 900)
    val emptyRange:IntRange = 0..-1

    println()
    println()
    println(300 in rang)
    println(range2.contains(900))
    println(emptyRange.isEmpty())

    for (i in range2) {
        print("$i,")
    }

    val arrOfInt:IntArray = intArrayOf(1,3,5)
    val arrOfChar:CharArray = charArrayOf('h','i')
    val arrofString:Array<String> = arrayOf("we","are","family")
    val arrOfCar:Array<Car> = arrayOf(BMW("bmw", 4860, 2500, "blue"), Mazda("bmw", 4860, 2500, "blue"))

    println()
    println(arrOfChar.joinToString(""))
    println(arrofString.size)
    println(arrOfInt.slice(0..1))
    for (i in arrOfInt) {
        print("$i,")
    }
    println()
    println(arrOfCar[0])
    arrOfCar[0] = BMW("bmw M3", 4860, 2500, "blue")
    println(arrOfCar[0])

    println(int2Long(30000))
}