package com.elsoft.extensions

/**
 * Extension function on `Pair<P1, P2>` to apply a provided function to the
 * `Pair` object that `map` is called on.
 *
 * @param f the function to transform the input `Pair` to the output of type `R1`
 */
fun <P1, P2, R1> Pair<P1, P2>.map(f: (Pair<P1, P2>) -> R1) : R1 =
        f(this)

/**
 * Extension function on `Pair<Int, String>` that generates a `Pair<Int, String>`
 * by concatenating the `String` from the input `Pair` with `toAdd` if `value` is evenly
 * divisible by `div`.  Otherwise return the input `Pair` unchanged.
 *
 * @param div the value to use as the divisor in the divisibility check.
 * @param toAdd the value to append to the accumulator string if the divisibility check passes
 * @return a new `Pair<Int, String>` with the input integer and a string with the current
 *         state.
 */
fun Pair<Int, String>.addDivStr(div: Int, toAdd: String) : Pair<Int, String> {
    return if (this.first % div == 0) Pair(this.first, this.second + toAdd) else this
}

/**
 * Extension function on `Pair<Int, String>` to extract the string value if it is non-empty
 * or the string representation of the `Int` otherwise.
 */
fun Pair<Int, String>.toStringVal(): String =
        if (this.second.isNotEmpty()) this.second
        else this.first.toString()

