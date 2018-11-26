package com.cc.kotlin

open class Outter {

    var a = 0

    fun getName() = "hello"


    // 默认是静态内部类
    inner class Inner {
        var b = a
        var c = this@Outter.a

        var name = getName()
        var d = this@Outter.getName()
    }
}

interface OnClickLister {
    fun onClick()
}

class View {
    var onClickLister: OnClickLister? = null
}

fun main(args: Array<String>) {
    var outter = Outter()
    var inner = outter.Inner()

    var view = View()
    // 匿名内部类
    view.onClickLister = object: Outter(), OnClickLister {
        override fun onClick() {

        }
    }
}