package com.example.DSA_JAVA.Recursion;

public class SumOfDigits {

    public static void main(String[] args) {
        int n = 123;

        // Call the recursive function to find sum of digits
        System.out.println(sum(n));   // Output: 6
    }

    static int sum(int n) {

        // BASE CASE:
        // When n becomes 0, there are no digits left to add.
        // So we return 0 and stop recursion.
        if (n == 0) {
            return 0;
        }

        /*
         RECURSIVE STEP (your understanding):

         Example: n = 123

         - n % 10 gives the last digit → 3
         - n / 10 removes the last digit → 12

         So this line becomes:
         sum(12) + 3

         But IMPORTANT:
         - sum(12) must finish completely first
         - This function WAITS here

         Call flow (going down):
         sum(123) → waits for sum(12) + 3
         sum(12)  → waits for sum(1)  + 2
         sum(1)   → waits for sum(0)  + 1
         sum(0)   → base case → return 0

         Now returning back (addition happens here):
         sum(1)   = 0 + 1 = 1
         sum(12)  = 1 + 2 = 3
         sum(123) = 3 + 3 = 6

         FINAL RESULT = 6
        */

        return sum(n / 10) + (n % 10);
    }
}
