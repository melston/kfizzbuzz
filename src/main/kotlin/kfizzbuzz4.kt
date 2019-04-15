package com.elsoft.kfizzbuzz4

import com.elsoft.extensions.toStringVal
import com.elsoft.utilities.genFBFun

fun main(args: Array<String>) {

    val fizz3 = genFBFun(3, "fizz")  // fizz3 is a function: (Pair) -> Pair
    val buzz5 = genFBFun(5, "buzz")
    val bang7 = genFBFun(7, "bang")

    1.rangeTo(105)
        .map { Pair(it, "") }
        .map(fizz3)  // Function reference.  Takes 'it' as parameter
        .map(buzz5)
        .map(bang7)
        .map { genFBFun(11, "boom")(it) }  // Cannot eliminate explicit 'it' parameter
        .map { it.toStringVal() }
        .forEach { println(it) }  // Overloads prevent using function reference
}

// Rather than having three separate 'map' stages it would be nice to be able to compose
// all the map functions together into a single function. (kfizzbuzz5)