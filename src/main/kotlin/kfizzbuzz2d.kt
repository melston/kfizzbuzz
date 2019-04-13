package com.elsoft.kfizzbuzz2d

import com.elsoft.extensions.addDivStr
import com.elsoft.extensions.map
import com.elsoft.extensions.toStringVal


// The Pair<Int, String>.map(...) extension is defined in extensions.kt
// The Pair<Int, String>.addDivStr(...) extension is defined in extensions.kt
// The Pair<Int, String>.toStringVal() extension is defined in extensions.kt
fun main(args: Array<String>) {
    1.rangeTo(105)
        .map { Pair(it, "") }
        .map { it.addDivStr(3, "fizz") }
        .map { it.addDivStr(5, "buzz") }
        .map { it.addDivStr(7, "bang") }
//        .map { it.addDivStr(11, "boom") }
//        .map { it.addDivStr(13, "pow") }
        .map { it.toStringVal() }
        .forEach { println(it) }

    println()
    println("Functional Version 2d")
}

// Rather than use an extension function we can have a function create
// another function and use that via a function reference in the call to 'map'
// (kfizzbuzz3)