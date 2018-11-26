package com.cc.kotlin

// 对象，相当于单例模式
object MusicPlayer {

    fun play(url: String) {

    }

    fun stop() {

    }
}

class DisplayUtil {
    // 伴生对象
    companion object {
        @JvmField
        val TAG = "companion object"

        @JvmStatic // 静态方法
        fun getDip() {

        }

        fun getPx() {

        }
    }

    fun getScreen() {

    }
}

class Overloads {
    fun load(): Int {
        return 1
    }

    fun load(url: String): Int {
        return 2
    }

    fun load(dou: Double): Int {
        return 3
    }

    @JvmOverloads
    fun defParam(int: Int = 1, s: String? = null) {

    }
}


fun main(args: Array<String>) {
    val mp: MusicPlayer = MusicPlayer
    mp.play("kj.mp3")

    DisplayUtil.TAG
    DisplayUtil.getDip()
    DisplayUtil.getPx()
    DisplayUtil().getScreen()

    val min = minOf(1, 2)

    val ll: LL = LL(1, "3")

    val overloads = Overloads()
    overloads.load("")
    overloads.load()
    overloads.load(20.0)
    overloads.defParam(s="")
}


// moudel内权限
internal fun air() {

}

class LL {
    constructor(i: Int) {

    }

    constructor(i: Int, s: String) {

    }
}