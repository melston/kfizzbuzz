package com.elsoft.kfizzbuzz1c

import com.elsoft.utilities.addStr

///////////////////////////////////////////////////////////////////////////////
// Instead of selecting the replacement string in one step, let's build
// up a string bit by bit.  This depends on the fact that our replacement
// strings have elements that always appear in the same order.  If a
// number is divisible by 3 then the replacement string will always have
// the string "fizz" at the start, regardless of which other elements are
// also present.  Likewise, if a number is divisible by 5 then "buzz" will
// always come after "fizz" (if "fizz" is present) and before any occurrence
// of "bang" or other replacement strings.

fun main(args: Array<String>) {
    val maxVal = 105 // 1155 for 3/5/7/11
    val calcFn = ::calcFB35_2
//    val calcFn = ::calcFB357_2
//    val calcFn = ::calcFB35711_2

    for (i in 1 .. maxVal) {
        val fbV = calcFn(i)
        println(fbV)
    }

    println()
}

fun calcFB35_2(i : Int): String {
    var accStr = ""
    accStr = addStr(accStr, 3, "fizz", i)
    accStr = addStr(accStr, 5, "buzz", i)

    val pstr = when {
        accStr.isNotEmpty() -> accStr
        else                -> i.toString()
    }
    return pstr
}

fun doFB357_2(i : Int): String {
    var accStr = ""
    accStr = addStr(accStr, 3, "fizz", i)
    accStr = addStr(accStr, 5, "buzz", i)
    accStr = addStr(accStr, 7, "bang", i)

    val pstr = when {
        accStr.isNotEmpty() -> accStr
        else                -> i.toString()
    }
    return pstr
}

fun calcFB35711_2(i : Int): String {
    var accStr = ""
    accStr = addStr(accStr,  3,  "fizz", i)
    accStr = addStr(accStr,  5,  "buzz", i)
    accStr = addStr(accStr,  7,  "bang", i)
    accStr = addStr(accStr, 11,  "boom", i)

    val pstr = when {
        accStr.isNotEmpty() -> accStr
        else                -> i.toString()
    }
    return pstr
}

/*
This works well enough.  It is easily extended to additional values and is
pretty simple to follow.  But there are additional things we can do that,
while not necessary, offer additional simplifications.

First of all, modifying a var is a bit messy.  I prefer to transform data using
a more functional approach.  This is typically done with the 'map' function.

But what to 'map' on?  For our purposes we are transforming a string based on the
value of an integer.  So let's push the integer and the accumulator string through
several successive stages of transformation using 'map' on the two items stored in a
Pair<Int, String>.  Since 'map' isn't defined on Pair we can create a map extension
function and use that (extensions.kt).

Using that function plus another to simplify the Pair to a string at the end of the
processing chain we have the following (kfizzbuzz2a)
*/
