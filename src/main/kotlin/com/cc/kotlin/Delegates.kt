package com.cc.kotlin

import kotlin.reflect.KProperty

// 属性代理 Groovy
class Delegates {
    val hello by lazy {
        "HelloWorld"
    }

    val hello2 by DelegateX(::println)

    var hello3:String by DelegateX {
        println(it)
    }
}

class DelegateX(initializer: (i:Int) -> Unit) {
    private var value: String? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return value ?: "X"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value:String) {
       this.value = "$value from DelegateX"
    }
}

fun main(args: Array<String>) {
    val delegates = Delegates()
    println(delegates.hello)
    println(delegates.hello2)
    delegates.hello3 = "nihao"
    println(delegates.hello3)
}