package com.elsoft.kfizzbuzz5

import com.elsoft.extensions.toStringVal
import com.elsoft.utilities.genFBFun
import com.elsoft.utilities.then

fun main(args: Array<String>) {

    val fizz3 = genFBFun(3, "fizz")
    val buzz5 = genFBFun(5, "buzz")
    val bang7 = genFBFun(7, "bang")

    val toPair : (Int) -> Pair<Int, String> = { Pair(it, "") }
    val extractStr : (Pair<Int, String>) -> String  = { it.toStringVal() }

    // 'then' is an extension function on function types useful for composition.
    // It is defined in the project's utilities package.
    val doFB =
            toPair then fizz3 then buzz5 then bang7 then extractStr

    1.rangeTo(105)
        .map(doFB)
        .forEach { println(it) }  // Overloads prevent using function reference
}