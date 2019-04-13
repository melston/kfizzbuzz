package com.elsoft.fbtest;

/**
 * Created by Mark.Elston on 5/21/2017.
 */
public class JFizzBuzz01_Orig {

    public static void main(String [] args) {

        for (int i = 1; i<=105; i++) {
            if (i%15 == 0) System.out.println("fizzbuzz");
            else if (i%5 == 0) System.out.println("buzz");
            else if (i%3 == 0) System.out.println("fizz");
            else  System.out.println(i);
        }
    }
}
