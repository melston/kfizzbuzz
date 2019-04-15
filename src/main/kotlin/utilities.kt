package com.elsoft.utilities

/**
 * Generate a string by concatenating `acc` and `divStr` if `value` is evenly
 * divisible by `divisor`.  Otherwise return `acc` unchanged.
 *
 * @param acc an "accumulator" string, meant to be the 'current' fizzbuzz string as it
 *            is built up in stages
 * @param divisor the value to use as the divisor in the divisibility check.
 * @param divStr the value to append to `acc` if the divisibility check passes
 * @param value the value to check for divisibility
 * @return a string with any necessary concatenation performed.
 */
fun addStr(acc: String, divisor: Int, divStr: String, value: Int) : String {
    return if (value % divisor == 0)
        "${acc}${divStr}"
    else
        acc
}

/**
 * Generate a `Pair<Int, String>` by concatenating the `String` from the input `Pair`
 * with `toAdd` if `value` is evenly divisible by `div`.  Otherwise return the input
 * `Pair` unchanged.
 *
 * @param p the input `Pair` with the integer and the current string state.
 * @param div the value to use as the divisor in the divisibility check.
 * @param toAdd the value to append to the accumulator string if the divisibility check passes
 * @return a new `Pair<Int, String>` with the input integer and a string with the current
 *         state.
 */
fun modStr(p: Pair<Int, String>, div: Int, toAdd: String) : Pair<Int, String> {
    return if (p.first % div == 0) Pair(p.first, p.second + toAdd) else p
}

/**
 * Generate a fizzbuzz 'stage' function.  This is used as a single stage in a sequence
 * of map calls to transform an input `Pair<Int, String>` based on whether the integer
 * value is divisible by a given number.
 *
 * @param div the divisor to check against
 * @param toAdd the string to concatenate to the input string if the input integer
 *              is divisible by `div`
 * @return a function that takes a `Pair<Int, String>` value and returns a new Pair
 *         based on whether the Int is divisible by `div`
 */
fun genFBFun(div: Int, toAdd: String) : (Pair<Int, String>) -> Pair<Int, String> {
    return {
        p ->
            if (p.first % div == 0)
                Pair(p.first, p.second + toAdd)
            else p
    }
}

// Infix functions must be member or extension functions!
/**
 * A function to compose two functions, the second one taking the output of the first one.
 *
 * This is an extension function on KFunction1<P1, R1> taking a second function as its
 * parameter.  It passes the result of calling `this` with a value of type P1
 * and passes that result to the the parameter function, `f`, returning
 * the result.
 *
 * This is an infix function so it can be called as:
 *     f1 then f2
 * and the result is a function that takes the input of `f1` and returns the
 * output of `f2`.
 *
 * @param f the right-hand side function.  This function is called after calling
 *          this with the input parameter when finally invoked.
 * @return a function which is the composition of the two functions involved.
 */
infix fun <P1, R1, R2> ((P1) -> R1).then(f: ((R1)-> R2)) : (P1) -> R2 {
    return { p1 : P1 -> f(this(p1)) }
}

