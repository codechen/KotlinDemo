package com.cc.kotlin

val kBoolen:Boolean = false

val kInt:Int = 6
val kInt16:Int = 0xFF // 十六进制
val kInt2:Int = 0b00000010 // 二进制
val kIntMax:Int = Int.MAX_VALUE

val kLong:Long = 12222222222222
val kLongOther = 123L
val kLongMax:Long = Long.MAX_VALUE

val kFloat:Float = 9f
val kFloastMiN = -Float.MAX_VALUE // MIN_VALUE是一个正数
val kFloatNan:Float = Float.NaN // 0.0/0.0

val kDouble:Double = 3.0
val kDoubleMin:Double = -Double.MAX_VALUE

val kShort:Short = Short.MAX_VALUE
val kShortOther:Short = 255

val kByte:Byte = 127 // 有符号 最大为2^7-1

val kChar:Char = 'A' // 一个Char表示一个16位的Unicode字符
val kCharUnicode:Char = '\u0000' // \u 表示Unicode 后面四位为Unicode编码
val kCharUnicodeN:Char = '\'' // \ 表示转义

val anInt:Int = 2
val anLong:Long = anInt.toLong()

val kString:String = "hello"
val kStrChar:String = String(charArrayOf('h','e','l','l','o'))

fun main(args: Array<String>) {
    println("Hello World")

    println(kInt)
    println(kInt16)
    println(kLongMax)
    println(kFloatNan)
    println(kDoubleMin)

    println(kChar)
    println(kCharUnicode)
    println(kCharUnicodeN)

    println(kString == kStrChar)
    println(kString === kStrChar)

    val arg1:Int = 1
    val arg2:Int = 2
    println("$arg1+$arg2=${arg1+arg2}")

    val sayHello:String = "Hello \"Trump\""
    println(sayHello)

    val money:Int = 10000
    println("$$money")

    // 原始字符串
    val rawString:String = """
        The
        price
        is
        $money
    """
    println(rawString)
    println(rawString.length)


    mapOf<String, String>()
    setOf<String>()
    charArrayOf()
    intArrayOf()
    arrayOf("a", "b")
    listOf<String>()
}