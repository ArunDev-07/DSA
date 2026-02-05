package com.example.DSA_JAVA.Recursion;

/*
 PERMUTATION USING INSERT-AT-POSITION (Kunal Kushwaha style explanation)

 ─────────────────────────────────────────────────────────────
 WHAT THIS PROGRAM DOES
 ─────────────────────────────────────────────────────────────
 It prints ALL permutations of a string.

 Example:
 Input  : "abc"
 Output :
 cba
 bca
 bac
 cab
 acb
 abc

 ─────────────────────────────────────────────────────────────
 CORE IDEA (VERY IMPORTANT)
 ─────────────────────────────────────────────────────────────
 1. We maintain two strings:
    p  → processed part (already built)
    up → unprocessed part (still left)

 2. At each step:
    - Take the first character from `up`
    - Insert it into ALL possible positions of `p`

 3. Recursively repeat until `up` becomes empty.

 ─────────────────────────────────────────────────────────────
 WHY THIS WORKS
 ─────────────────────────────────────────────────────────────
 Each recursive level fixes ONE character.
 Trying all positions guarantees ALL arrangements (n!).
*/

public class Permutation {

    public static void main(String[] args) {

        // Initial call
        // p  = ""   (nothing processed)
        // up = "abc" (everything unprocessed)
        Perm("", "abc");
    }

    static void Perm(String p, String up) {

        /*
         BASE CASE
         ----------
         When up is empty, it means:
         - All characters are used
         - p now holds one complete permutation
        */
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        /*
         STEP 1: Take first character from up
         Example:
         up = "abc" → ch = 'a'
        */
        char ch = up.charAt(0);

        /*
         STEP 2: Insert `ch` into ALL positions of `p`

         Why i <= p.length() ?
         If p = "ab", positions are:

         | a b |
         0 1 2

         Total positions = p.length() + 1
        */
        for (int i = 0; i <= p.length(); i++) {

            /*
             Split p into two parts:
             f → before index i
             s → after index i
            */
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());

            /*
             Insert character in between
             new string = f + ch + s

             Then reduce up by removing first character
            */
            Perm(f + ch + s, up.substring(1));
        }
    }
}

/*
 ─────────────────────────────────────────────────────────────
 FULL DRY RUN WITH VISUAL EXPLANATION
 ─────────────────────────────────────────────────────────────

 Initial Call:
 Perm("", "abc")

 ─────────────────────────────────────────────────────────────
 LEVEL 1
 ─────────────────────────────────────────────────────────────
 p = ""
 up = "abc"
 ch = 'a'

 Positions in p:
 | |
 0

 i = 0
 f = ""
 s = ""
 new p = "a"

 → Perm("a", "bc")

 ─────────────────────────────────────────────────────────────
 LEVEL 2
 ─────────────────────────────────────────────────────────────
 p = "a"
 up = "bc"
 ch = 'b'

 Positions:
 | a |
 0 1

 i = 0
 f = ""
 s = "a"
 new p = "ba"
 → Perm("ba", "c")

 i = 1
 f = "a"
 s = ""
 new p = "ab"
 → Perm("ab", "c")

 ─────────────────────────────────────────────────────────────
 LEVEL 3 — FIRST BRANCH
 ─────────────────────────────────────────────────────────────
 p = "ba"
 up = "c"
 ch = 'c'

 Positions:
 | b a |
 0 1 2

 i = 0 → "cba" → PRINT
 i = 1 → "bca" → PRINT
 i = 2 → "bac" → PRINT

 ─────────────────────────────────────────────────────────────
 LEVEL 3 — SECOND BRANCH
 ─────────────────────────────────────────────────────────────
 p = "ab"
 up = "c"

 Positions:
 | a b |
 0 1 2

 i = 0 → "cab" → PRINT
 i = 1 → "acb" → PRINT
 i = 2 → "abc" → PRINT

 ─────────────────────────────────────────────────────────────
 FINAL OUTPUT
 ─────────────────────────────────────────────────────────────
 cba
 bca
 bac
 cab
 acb
 abc

 ─────────────────────────────────────────────────────────────
 INTERVIEW ONE-LINER
 ─────────────────────────────────────────────────────────────
 "We generate permutations by inserting the current character
  into every possible position of the processed string."

 ─────────────────────────────────────────────────────────────
 TIME & SPACE COMPLEXITY
 ─────────────────────────────────────────────────────────────
 Time  : O(n!)
 Space : O(n) (recursion stack)
*/
