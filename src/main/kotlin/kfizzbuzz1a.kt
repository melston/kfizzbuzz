package com.elsoft.kfizzbuzz1a

fun main(args: Array<String>) {
    val maxVal = 100
    for (i in 1 .. maxVal) {
        if (i % 15 == 0) println("fizzbuzz")
        else if (i % 5 == 0) println("buzz")
        else if (i % 3 == 0) println("fizz")
        else println(i)
    }

    println()
}

