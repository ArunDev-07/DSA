package com.example.DSA_JAVA.Recursion;

public class DigitsOfNumbers {

    public static void main(String[] args) {
        int n = 721;

        // Call the recursive function to find product of digits
        System.out.println(digit(n));   // Output: 14
    }

    static int digit(int n) {

        // BASE CASE:
        // If the number has only ONE digit,
        // then n % 10 == n (example: 7 % 10 == 7)
        // So we return that digit and stop recursion.
        if (n % 10 == n) {
            return n;
        }

        /*
         RECURSIVE STEP (clear explanation with n = 721):

         digit(721)
         → last digit = 1   (721 % 10)
         → remaining number = 72 (721 / 10)
         → waits for digit(72) * 1

         digit(72)
         → last digit = 2
         → remaining number = 7
         → waits for digit(7) * 2

         digit(7)
         → single digit, base case
         → return 7

         NOW returning back (multiplication happens here):

         digit(72)  = 7 * 2 = 14
         digit(721) = 14 * 1 = 14

         IMPORTANT:
         - No multiplication happens while going down
         - Each function waits until the smaller problem is finished
         - Multiplication happens only while returning
        */

        return digit(n / 10) * (n % 10);
    }
}
