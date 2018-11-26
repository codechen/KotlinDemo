package com.cc.kotlin

// 尾递归优化

data class LinkNode(val value: Int, var next: LinkNode? = null)

tailrec fun findNode(headNode: LinkNode?, value: Int): LinkNode? {
    headNode ?: return null
    if (headNode.value == value) return headNode
    return findNode(headNode.next, value)
}

fun main(args: Array<String>) {
    val MAX_COUNT = 100000
    val headNode:LinkNode = LinkNode(0)
    var p = headNode
    for (i in 1..MAX_COUNT) {
        p.next = LinkNode(i)
        p = p.next!!
    }

    val node = findNode(headNode, MAX_COUNT - 1)
    println(node?.value)

    // stackoverflow: 方法栈帧数超过jvm分配的栈深度
}

//
//   输入：Array数组，left/right整型
//   输出：合并后数组
//
//    function find(Array, left, right, num)
//        if left < right then
//           middle <- left + (right - left)/2
//           if middle == num then
//              return middle
//           else if middle > num then
//              find(Array, left, middle-1)
//           else
//              find(Array, middle+1, right)
