package com.example.DSA_JAVA.Recursion;

public class FactorialOfNumber {

    public static void main(String[] args) {
        int n = 5;

        // Call the recursive factorial function
        System.out.println(fact(n));   // Output: 120
    }

    static int fact(int n) {

        // BASE CASE:
        // When n becomes 0 or 1, recursion must stop.
        // Factorial of 0 or 1 is always 1.
        if (n == 0 || n == 1) {
            return 1;
        }

        /*
         RECURSIVE STEP (your understanding):

         - If n = 5, this line becomes:
           5 * fact(4)

         - 5 does NOT multiply immediately.
           It WAITS until fact(4) returns a value.

         - fact(4) again waits for fact(3)
         - fact(3) waits for fact(2)
         - fact(2) waits for fact(1)

         - fact(1) hits the base case and returns 1

         NOW multiplication starts while returning back:

         fact(2) = 2 * 1  = 2
         fact(3) = 3 * 2  = 6
         fact(4) = 4 * 6  = 24
         fact(5) = 5 * 24 = 120

         IMPORTANT:
         - We do NOT do: 1 * 2 * 6 * 12 * 24 * 120
         - Each function multiplies ONLY ONCE
           with the value returned by the smaller call.
        */

        return n * fact(n - 1);
    }
}
