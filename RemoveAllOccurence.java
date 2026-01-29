package com.example.DSA_JAVA.Recursion;

public class RemoveSubstringRecursion {

    /*
     * Problem: Remove all occurrences of a substring 'part' from string 's'.
     *
     * Concept:
     * - A substring is a sequence of characters, not a single character.
     * - At each recursive call:
     *      1. If the string contains 'part', remove the first occurrence and recurse again.
     *      2. If no occurrence exists, return the string as final result.
     * 
     * LeetCode Reference: 1910 - Remove All Occurrences of a Substring
     */

    public static void main(String[] args) {
        String s = "daabcbaabcbc";
        String part = "abc";

        // Call the recursive function
        String result = removeOccurrences(s, part);

        // Print final result
        System.out.println("Original String: " + s);
        System.out.println("Substring to remove: " + part);
        System.out.println("String after removals: " + result);

        /*
         * Dry Run Example:
         * s = "daabcbaabcbc", part = "abc"
         * Step 1: Remove first "abc" at index 2 → "dabbaabcbc"
         * Step 2: Remove first "abc" at index 5 → "dab"
         * Step 3: No "abc" remaining → recursion stops
         * Final Output = "dab"
         */
    }

    // Recursive function to remove all occurrences of 'part' from 's'
    static String removeOccurrences(String s, String part) {

        // Base case: if 'part' does not exist in 's', return 's' as final result
        if (!s.contains(part)) return s;

        // Remove first occurrence of 'part' from string
        s = s.replaceFirst(part, ""); // replaceFirst removes only the first occurrence

        // Recursive call on the new string after removal
        return removeOccurrences(s, part);
    }
}
