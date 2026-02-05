package com.example.DSA_JAVA.Recursion;

import java.util.ArrayList;

/*
========================================================
PERMUTATION USING RECURSION (INSERTION METHOD)
========================================================

CONCEPT:
---------
We build permutations by taking characters from `up` (unprocessed)
and inserting them at every possible position in `p` (processed).

p  → already formed string
up → remaining characters to process

Two methods:
1) Perm      → returns all permutations
2) Permcount → returns number of permutations
========================================================
*/

public class Permutation {

    public static void main(String[] args) {

        // Calling permutation count
        // p = "" (empty)
        // up = "abc"
        System.out.println(Permcount("", "abc")); // OUTPUT: 6
    }

    /*
    ========================================================
    METHOD 1: RETURN ALL PERMUTATIONS
    ========================================================
    */

    static ArrayList<String> Perm(String p, String up) {

        // BASE CASE:
        // If no characters left to process,
        // then p is one complete permutation
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);   // store the permutation
            return list;
        }

        // Take first character from unprocessed string
        char ch = up.charAt(0);

        // This list will store all permutations from this call
        ArrayList<String> ans = new ArrayList<>();

        // Insert `ch` at every possible position in `p`
        for (int i = 0; i <= p.length(); i++) {

            // Split p into two parts
            String f = p.substring(0, i);          // front part
            String s = p.substring(i, p.length()); // second part

            // Recursive call with:
            // new processed string = f + ch + s
            // remaining unprocessed string = up.substring(1)
            ans.addAll(Perm(f + ch + s, up.substring(1)));
        }

        return ans;
    }

    /*
    ========================================================
    METHOD 2: COUNT PERMUTATIONS
    ========================================================

    IMPORTANT IDEA:
    ---------------
    Each base case (up is empty) represents
    ONE valid permutation → return 1
    */

    static int Permcount(String p, String up) {

        // BASE CASE:
        // When no characters are left,
        // we have formed ONE permutation
        if (up.isEmpty()) {
            return 1;
        }

        char ch = up.charAt(0); // take first character
        int count = 0;

        // Try inserting ch at all positions of p
        for (int i = 0; i <= p.length(); i++) {

            String f = p.substring(0, i);
            String s = p.substring(i, p.length());

            // Add counts from recursive calls
            count = count + Permcount(f + ch + s, up.substring(1));
        }

        return count;
    }
}

/*
========================================================
DRY RUN WITH VISUAL EXAMPLE
========================================================

CALL:
-----
Permcount("", "abc")

STEP 1:
-------
p = ""
up = "abc"
ch = 'a'
positions = 1

→ Permcount("a", "bc")


STEP 2:
-------
p = "a"
up = "bc"
ch = 'b'
positions = 2

→ Permcount("ba", "c")
→ Permcount("ab", "c")


STEP 3:
-------
p = "ba"
up = "c"
positions = 3

→ "cba"  → up empty → return 1
→ "bca"  → up empty → return 1
→ "bac"  → up empty → return 1

Total from "ba" = 3


STEP 4:
-------
p = "ab"
up = "c"
positions = 3

→ "cab"  → up empty → return 1
→ "acb"  → up empty → return 1
→ "abc"  → up empty → return 1

Total from "ab" = 3


FINAL COUNT:
------------
3 + 3 = 6


========================================================
RECURSION TREE (VISUAL)
========================================================

Permcount("", "abc")
|
|-- Permcount("a", "bc")
    |
    |-- Permcount("ba", "c")
    |   |-- "cba" → 1
    |   |-- "bca" → 1
    |   |-- "bac" → 1
    |
    |-- Permcount("ab", "c")
        |-- "cab" → 1
        |-- "acb" → 1
        |-- "abc" → 1


TOTAL LEAF NODES = 6
========================================================

KEY INSIGHT:
------------
Permutation count = number of leaf nodes
= n! (factorial)

For "abc" → 3! = 6
========================================================
*/
