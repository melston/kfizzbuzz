package com.elsoft.kfizzbuzz3a

import com.elsoft.extensions.toStringVal
import com.elsoft.utilities.genFBFun

fun main(args: Array<String>) {

    // genFBFun defined in utilities.kt
    val fizz3 = genFBFun(3, "fizz")  // fizz3 is a function: (Pair) -> Pair
    val buzz5 = genFBFun(5, "buzz")
    val bang7 = genFBFun(7, "bang")

    1.rangeTo(105)
        .map { Pair(it, "") }
        .map { fizz3(it) }
        .map { buzz5(it) }
        .map { bang7(it) }
        .map { genFBFun(11, "boom")(it) }
        .map { it.toStringVal() }
        .forEach { println(it) }

    println("Functional Version 3")
}

// Functions that take a single parameter can be used as a
// function reference in a lambda without explicitly passing 'it'
// (kfizzbuzz4)