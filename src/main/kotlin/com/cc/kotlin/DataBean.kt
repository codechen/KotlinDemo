package com.cc.kotlin

data class Country(var name:String, val id:Int)

class ComponentX {
    operator fun component1():String {
        return "NiHao"
    }

    operator fun component2():String {
        return "Wo"
    }

    operator fun component3():String {
        return "Shi"
    }

    operator fun component4():String {
        return "Mark"
    }
}

fun main(args: Array<String>) {
    val china = Country("china", 1)
    println(china)
    china.name = "Italy"
    println(china.name)
    println(china.id)
    println(china.component1())
    println(china.component2())

    val(name, id) = china
    println(name) // ->component1()
    println(id) // ->component2()

    for ((index, value) in args.withIndex()) {
        println("$index $value")
    }

    val(a, b, c, d) = ComponentX()
    println("$a $b $c $d")
}