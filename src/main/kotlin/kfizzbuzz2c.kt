package com.elsoft.kfizzbuzz2c

import com.elsoft.extensions.addDivStr
import com.elsoft.extensions.map
import com.elsoft.extensions.toStringVal

// The Pair<Int, String>.map(...) extension is defined in extensions.kt
// The Pair<Int, String>.addDivStr(...) extension is defined in extensions.kt
// The Pair<Int, String>.toStringVal() extension is defined in extensions.kt
fun main(args: Array<String>) {
    for (i in 1..105) {
        val str = Pair(i, "")
                .map { it.addDivStr(3, "fizz") }
                .map { it.addDivStr(5, "buzz") }
                .map { it.addDivStr(7, "bang") }
//                .map { it.addDivStr(11, "boom") }
//                .map { it.addDivStr(13, "pow") }
                .toStringVal()

        println(str)
    }

    println()
    println("Functional Version 2c")
}

// Rather than using an explicit 'for' loop we can map over the range directly,
// creating a pair and then further transforming it.
//
// This also allows us to further transform the sequence by converting the
// final "Pair" to a string directly via 'map'.
//
// We can also print out the resulting value by calling 'println' in a
// 'foreach' function call.
// (kfizzbuzz2d)