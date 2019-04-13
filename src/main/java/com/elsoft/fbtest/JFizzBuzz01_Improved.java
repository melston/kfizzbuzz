package com.elsoft.fbtest;

/**
 * Created by Mark.Elston on 5/21/2017.
 */
public class JFizzBuzz01_Improved {

    public static void main(String [] args) {

        for (int i = 1; i<=105; i++) {
            String acc = "";
            acc = addStr(3, "fizz", i, acc);
            acc = addStr(5, "buzz", i, acc);
            // acc = addStr(7, "bang", i, acc);

            if (!acc.isEmpty()) System.out.println(acc);
            else System.out.println(i);
        }
    }

    public static String addStr(int div, String toAdd, int toTest, String acc) {
        if (toTest%div == 0) return acc + toAdd;
        else return acc;
    }
}
