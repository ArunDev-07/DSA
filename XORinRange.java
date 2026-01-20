package com.example.DSA_JAVA;

public class XORinRange {

    public static void main(String[] args) {

        // Starting number of the range
        int a = 3;

        // Ending number of the range
        int b = 9;

        /*
         * We want XOR of numbers from a to b
         *
         * Instead of looping, we use prefix XOR concept:
         *
         * XOR(a to b) = XOR(0 to b) ^ XOR(0 to a-1)
         *
         * Why this works:
         * XOR(0 to b)   = 0 ^ 1 ^ 2 ^ ... ^ (a-1) ^ a ^ ... ^ b
         * XOR(0 to a-1) = 0 ^ 1 ^ 2 ^ ... ^ (a-1)
         *
         * Common numbers (0 to a-1) appear twice.
         * Since x ^ x = 0, they cancel out.
         *
         * Remaining result = a ^ (a+1) ^ ... ^ b
         */
        int ans = xor(b) ^ xor(a - 1);

        // Print the final XOR value for range [a, b]
        System.out.println(ans);
    }

    /*
     * This method returns XOR of all numbers from 0 to n
     *
     * Observation:
     * XOR values repeat every 4 numbers
     *
     * n % 4 == 0 → XOR = n
     * n % 4 == 1 → XOR = 1
     * n % 4 == 2 → XOR = n + 1
     * n % 4 == 3 → XOR = 0
     */
    static int xor(int n) {

        // If remainder is 0
        if (n % 4 == 0) {
            return n;
        }

        // If remainder is 1
        else if (n % 4 == 1) {
            return 1;
        }

        // If remainder is 2
        else if (n % 4 == 2) {
            return n + 1;
        }

        // If remainder is 3
        else {
            return 0;
        }
    }
}
