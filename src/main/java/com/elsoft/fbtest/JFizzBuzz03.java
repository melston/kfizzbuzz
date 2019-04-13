package com.elsoft.fbtest;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.collection.Stream;

import java.util.function.Function;

/**
 * Created by Mark.Elston on 5/21/2017.
 */
public class JFizzBuzz03 {

    // Static fields
    static final Function<Integer, Tuple2<Integer, String>> initTuple =
            i -> Tuple.of(i, "");

    static final Function<Tuple2<Integer, String>, String> toStringVal =
            t -> {
                if (!t._2.isEmpty()) return t._2;
                else return t._1.toString();
            };

    // Static method to generate a Function that we will use below.
    static Function<Tuple2<Integer, String>, Tuple2<Integer, String>> genCheck(int divisor, String toAdd) {
        return t -> (t._1 % divisor == 0) ? Tuple.of(t._1, t._2 + toAdd) : t;
    }

    public static void main(String [] args) {

        Function<Tuple2<Integer, String>, Tuple2<Integer, String>> handle3 = genCheck(3, "fizz");
        Function<Tuple2<Integer, String>, Tuple2<Integer, String>> handle5 = genCheck(5, "buzz");
        //Function handle3 = genCheck(3, "fizz");
        //Function handle5 = genCheck(5, "buzz");

        Stream.from(1)                          // Start with an infinite stream of integers
                .map(initTuple)                 // Create a Tuple from each one
                .map(handle3)  // Generate a function to call that checks for the given
                .map(handle5)  // divisor and appends the appropriate string if needed
                .map(genCheck(7, "bang"))
                .map(toStringVal)               // Replace the Tuple with the string we need
                .take(105)                      // Limit the number of elements to take from the infinite stream
                .forEach(System.out::println);  // Replaced with a method reference
    }
}
