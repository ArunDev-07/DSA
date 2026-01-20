package com.example.DSA_JAVA;

public class Power {
    public static void main(String[] args){
        int base = 3;     // The number we want to raise to a power
        int power = 5;    // The exponent
        int ans = 1;      // Stores the final result, starts from 1

        // Loop runs until all bits of 'power' are processed
        while(power > 0){

            // Check if the current least significant bit of 'power' is 1
            // If yes, multiply the current 'base' to the answer
            if((power & 1) == 1){
                ans *= base;
            }

            // Square the base to move to the next power of 2
            // This happens every iteration, independent of the if condition
            base *= base;

            // Right shift the power by 1
            // Effectively divides power by 2 and moves to the next bit
            power = power >> 1;
        }

        // Print the final answer
        System.out.println(ans); // Output: 243 (3^5)
    }
}
