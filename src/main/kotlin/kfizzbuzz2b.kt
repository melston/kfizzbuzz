package com.elsoft.kfizzbuzz2b

import com.elsoft.extensions.map
import com.elsoft.extensions.toStringVal
import com.elsoft.utilities.modStr

fun main(args: Array<String>) {
    for (i in 1..105) {
        val str =
                Pair(i, "")
                .map { p -> modStr(p, 3, "fizz") } // Using explicit lambda notation
                .map { modStr(it, 5, "buzz") }     // Using implicit 'it' notation
                .map { modStr(it, 7, "bang") }
//                .map { modStr(it, 11, "boom") }
                .toStringVal()

        println(str)
    }

    println()
    println("Functional Version 2b")
}

// modStr works well.
// You can also make it an extension function on Pair.  (addDivStr in extensions.kt)
