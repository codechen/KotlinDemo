package com.cc.kotlin

import org.jetbrains.annotations.NotNull
import sun.security.krb5.internal.MethodData
import java.lang.annotation.ElementType
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.*

// 自定义注解
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.FIELD, AnnotationTarget.PROPERTY, AnnotationTarget.CLASS)
annotation class CC

// 反射
@CC
data class Human(val name: String?, @CC var age: Int) {
    override fun toString(): String {
        println("toSting is called.")
        return "$name $age"
    }

    // 扩展属性
    var Int.halo: String?
        get() = halo
        set(value) {
            halo = value
        }

    fun Int.halo() {
        println("Halo.")
    }
}

class NoPrimaryContructor {
    val time = 10

    constructor() {
        println("no params constructor.")
    }

    constructor(s: String) {
        println("params=$s constructor.")
    }
}

var i: Int = 0
    get() = field
    set(value) {
        field = value
    }


fun Human.sayHello() {
    println("Hello")
}

fun sayHi() {
    println("Hi")
}

fun main(args: Array<String>) {
    // ***************JAVA反射*****************

    // Class 获取方式
    //1
    val clazz = Human::class.java
    val human = Human("mark", 19)
    //2
    val clazz2 = human.javaClass
    //3
    val clazz3 = human::class.java

    // 实例对象
//    val human2 = clazz.newInstance() // 无参构造方法
    val human2 = clazz.getConstructor(String::class.java, Int::class.java).newInstance("benny", 18) // 有参构造方法
    println(human2.toString())
//    println(human2.name?.length)

    // 访问成员属性
    val name = clazz.getDeclaredField("name").apply { isAccessible = true }.get(human2)
    println("name=$name")

    // 访问成员方法
    val nameMethod = clazz.getDeclaredMethod("getName").invoke(human2)
    println("nameMethod=$nameMethod")

    val nameCopy = clazz.getDeclaredMethod("copy", String::class.java, Int::class.java).invoke(human2, human2.name, human2.age)
    println("nameCopy=$nameCopy")

    // 扩展方法
    human2.sayHello()
    Class.forName("com.cc.kotlin.ReflectionsKt").getDeclaredMethod("sayHello", Human::class.java).invoke(null, human2)

    // 包级方法
    Class.forName("com.cc.kotlin.ReflectionsKt").getDeclaredMethod("sayHi").invoke(null)

    // 访问注解
    clazz.getAnnotation(CC::class.java).let(::println)
    clazz.getDeclaredField("age").annotations.forEach {
        println(it)
    }


    // ***************KOTLIN反射*****************

    val kclazz = Human::class // KClass
    val kclazz2 = human::class
    val kClass3 = human.javaClass.kotlin


    val kHuman = kclazz.primaryConstructor!!.call("ketty", 10)
    println(kHuman)

//    NoPrimaryContructor::class.primaryConstructor?.call() //*不行
    NoPrimaryContructor::class.constructors.first().call()
    NoPrimaryContructor::class.constructors.last().call("Tom")


    kclazz.memberProperties.forEach {
        println("${it.name} ${it::class}")
    }
    NoPrimaryContructor::class.memberProperties.forEach(::println)
    kclazz.memberProperties.first { it.name == "age" }.get(kHuman).let { println(it) }
    (kclazz.memberProperties.first { it.name == "age" } as? KMutableProperty1<Human, Int>)?.set(kHuman, 18)
    println(kHuman)

    kclazz.memberFunctions.forEach(::println)
//    kclazz.memberFunctions.forEach{
//        it.call(kHuman)
//    }
    kclazz.memberFunctions.first { it.name == "toString" }.call(kHuman)

    // 扩展属性和方法(该类内部的扩展而不是该类的扩展)
    kclazz.memberExtensionProperties.forEach(::println)
    kclazz.memberExtensionFunctions.forEach(::println)

    kclazz.annotations.forEach(::println)
    kclazz.memberProperties.first { it.name == "age" }.annotations.forEach(::println)
}