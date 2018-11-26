package com.cc.kotlin

// 密封类: 子类只有定义在同一个文件中
sealed class PlayerCmd {
    class Play(val url: String, val position: Int = 0) : PlayerCmd()

    class Seek(val position: Int) : PlayerCmd() {
        fun go() {
            println("player is seeked to $position")
        }
    }

    object Pause : PlayerCmd() {
        fun go() {
            println("player is paused.")
        }
    }

    object Resume : PlayerCmd()

    object Stop : PlayerCmd()
}

fun main(args: Array<String>) {
    val playerCmd = PlayerCmd.Play("love.mp3", 3)
    val playerCmd1 = PlayerCmd.Seek( 16)
    playerCmd1.go()
    val playerCmd2 = PlayerCmd.Pause
    playerCmd2.go()
}