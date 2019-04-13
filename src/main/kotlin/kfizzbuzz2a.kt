package com.elsoft.kfizzbuzz2a

import com.elsoft.extensions.map
import com.elsoft.extensions.toStringVal

fun main(args: Array<String>) {
    for (i in 1 .. 105) {
        val str =
                Pair(i, "")
                .map { p -> if (p.first % 3 == 0) Pair(p.first, p.second+"fizz"); else p; }
                .map { p -> if (p.first % 5 == 0) Pair(p.first, p.second+"buzz"); else p; }
                .map { p -> if (p.first % 7 == 0) Pair(p.first, p.second+"bang"); else p; }
                .toStringVal()

        println(str)
    }

    println()
    println("Functional Version 2a")
}

// The provided function to each 'map' call is pretty regular.  So
// create an external function and use it instead. (modStr in utilities.kt)
