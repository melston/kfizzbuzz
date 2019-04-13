package com.elsoft.kfizzbuzz1b

fun main(args: Array<String>) {
    val maxVal = 105 // 1155 for 3*5*7*11

    val calcFn = ::calcFB35_1
//    val calcFn = ::calcFB357_1
//    val calcFn = ::calcFB35711_1

    for (i in 1 .. maxVal) {
        val fbV = calcFn(i)
        println(fbV)
    }

    println()
}

fun calcFB35_1(i : Int): String {
    val rv= if (i % 15 == 0) "fizzbuzz"
                   else if (i % 5 == 0) "buzz"
                   else if (i % 3 == 0) "fizz"
                   else i.toString()
    return rv
}

// The previous function was for 2 prime number divisors
// Add one more for 3 prime number divisors:
// Handle 7, 3*7, 5*7, 3*5*7
// (4 more, in addition to those above: total = 7 - plus 1 for non-matching values)
fun calcFB357_1(i : Int) : String {
    val rv = if (i % 105 == 0) "fizzbuzzbang" // 3*5*7
                    else if (i % 35 == 0) "buzzbang" // 5*7
                    else if (i % 21 == 0) "fizzbang" // 3*7
                    else if (i % 15 == 0) "fizzbuzz"
                    else if (i % 7 == 0) "bang"      // 7
                    else if (i % 5 == 0) "buzz"
                    else if (i % 3 == 0) "fizz"
                    else i.toString()
    return rv
}

// Next handle 11, 3*11, 5*11, 7*11, 3*5*11, 3*7*11, 5*7*11, 3*5*7*11
// (8 more, in addition to what we had before: total = 15 + 1)
// All of these have to be in descending order
fun calcFB35711_1(i : Int): String {
    val rv =
        if (i % 1155 == 0) "fizzbuzzbangboom" // 3 * 5 * 7 * 11
        else if (i % 385 == 0) "buzzbangboom" // 5 * 7 * 11
        else if (i % 231 == 0) "fizzbangboom" // 3 * 7 * 11
        else if (i % 165 == 0) "fizzbuzzboom" // 3 * 5 * 11
        else if (i % 105 == 0) "fizzbuzzbang"
        else if (i % 77 == 0) "bangboom"      // 7 * 11
        else if (i % 55 == 0) "buzzboom"      // 5 * 11
        else if (i % 35 == 0) "buzzbang"
        else if (i % 33 == 0) "fizzboom"      // 3 * 11
        else if (i % 21 == 0) "fizzbang"
        else if (i % 15 == 0) "fizzbuzz"
        else if (i % 11 == 0) "boom"          // 11
        else if (i % 7 == 0) "bang"
        else if (i % 5 == 0) "buzz"
        else if (i % 3 == 0) "fizz"
        else i.toString()
    return rv
}

// Next handle 13, 3*13, 5*13, 7*13, 11*13, 3*5*13, 3*7*13, 3*11*13, 5*7*13,
//             5*11*13, 7*11*13, 3*5*7*13, 3*5*11*13, 5*7*11*13, 3*5*7*11*13
// (15 additional cases: total = 30 + 1)

// Not scaling well

// Notice the regular patterns of the generated strings.  "fizz" always comes first,
// if it is present.  This is always followed by "buzz" (again, if present).  etc.
// Add a utility: addStr (utilities.kt)