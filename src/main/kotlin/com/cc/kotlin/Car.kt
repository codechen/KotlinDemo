package com.cc.kotlin

open class Car constructor(var name:String, val length: Int, var width: Int, var color: String) {
//    var length:Int = 4800
//    var width:Int = 2500
//    var color:String = "深灰色"

    // 构造方法的方法体
    init{
        println("the car $name is length=$length width=$width color=$color")
    }
}

class Mazda(name: String, length: Int, width: Int, color: String): Car(name, length, width, color)
class BMW(name: String, length: Int, width: Int, color: String): Car(name, length, width, color) {
    override fun toString(): String {
        return "$name"
    }
}

fun main(args: Array<String>) {

    val car1:Mazda = Mazda("Mazda", 2800, 2530, "gray")
    val car2:BMW = BMW("BMW", 2850, 2600, "blue")

    println(car1 is Car)

    air()
}

