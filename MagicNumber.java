package com.example.DSA_JAVA;

public class MagicNumber {

    public static void main(String[] args) {
        
        int n = 6;          // The input number. We will find the "magic number" for n = 6
        int ans = 0;        // Stores the final magic number
        int base = 5;       // Base is 5 because magic numbers are formed using powers of 5 (5^1, 5^2, 5^3...)

        /*
         * Why base = 5?
         * ----------------
         * Magic numbers are numbers formed by the sum of powers of 5, according to the binary
         * representation of n.
         * For example, if n = 6 (binary 110), the magic number is calculated as:
         * 1*5^2 + 1*5^1 + 0*5^0 = 150
         * So the first power we start with is 5^1 = 5 (not 1 or 2).
         */

        while (n != 0) {          // Loop until all bits of n are processed
            
            int last = n & 1;     // Get the last bit of n
                                  // & 1 gives 1 if the last bit is 1, otherwise 0
            ans += last * base;   // Add contribution of this bit to the answer
                                  // Only if last bit is 1, it contributes current power of 5
            
            n >>= 1;              // Right shift n by 1 to process the next bit
                                  // This is like dividing n by 2 and moving to the next binary digit

            base = base * 5;      // Move to the next power of 5 for the next bit
                                  // Powers of 5 sequence: 5, 25, 125, 625, ...
        }

        System.out.println(ans);  // Print the final magic number
    }
}
