package com.elsoft.fbtest;

import io.vavr.Tuple;
import io.vavr.collection.Stream;

/**
 * Created by Mark.Elston on 5/21/2017.
 */
public class JFizzBuzz02 {

    public static void main(String [] args) {

        Stream.from(1)                     // Start with an infinite stream of integers
                .take(105)                 // Limit the number of elements to take from the infinite stream
                .map(i -> Tuple.of(i, ""))  // Create a Tuple from each integer
                .map(t -> (t._1 % 3 == 0) ? Tuple.of(t._1, t._2 + "fizz"): t )
                .map(t -> (t._1 % 5 == 0) ? Tuple.of(t._1, t._2 + "buzz"): t )
                .forEach( t -> { if (!t._2.isEmpty()) System.out.println(t._2); else System.out.println(t._1); });
    }
}
