package com.elsoft.kfizzbuzz5

import com.elsoft.extensions.toStringVal
import com.elsoft.utilities.genFBFun
import com.elsoft.utilities.then

// Function to compose two functions, the second one taking the output of the first one
fun main(args: Array<String>) {

    // genFBFun defined in utilities.kt
    val fizz3 = genFBFun(3, "fizz")
    val buzz5 = genFBFun(5, "buzz")
    val bang7 = genFBFun(7, "bang")

    val toPair : (Int) -> Pair<Int, String> = { Pair(it, "") }
    val extractStr : (Pair<Int, String>) -> String  = { it.toStringVal() }

    val doFB =
            toPair then fizz3 then buzz5 then bang7 then extractStr

    1.rangeTo(105)
        .map(doFB)
        .forEach { println(it) }  // Overloads prevent using function reference
}