package com.cc.kotlin

enum class LogLevel(id: Int, n:String = "enum") {
    VERBOSE(1, "V"), DEBUG(2, "D"), WARNING(3), ERROR(4, "E")
}

fun main(args: Array<String>) {
    var level = LogLevel.ERROR
    when(level) {
        LogLevel.VERBOSE -> println("VERBOSE")
        LogLevel.DEBUG -> println("DEBUG")
        LogLevel.WARNING -> println("WARNING")
        LogLevel.ERROR -> println("ERROR")
        else -> println("NOT")
    }
}