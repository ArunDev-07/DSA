import java.util.*;

/*
========================================================
📱 Letter Combinations of a Phone Number (LeetCode 17)
========================================================

PROBLEM:
Given a string containing digits from 2–9, return all possible
letter combinations that the number could represent.

--------------------------------------------------------
🧠 CORE IDEA (Explanation Paragraph):
--------------------------------------------------------
We solve this problem using RECURSION + BACKTRACKING.
At every step, we split the input into:
1) p  → processed part (letters already chosen)
2) up → unprocessed part (digits still remaining)

For the first digit of 'up', we find all its possible letters
using a keypad mapping. Then for each letter, we recursively
process the remaining digits. When 'up' becomes empty, it means
a full valid combination is formed, so we return it as a list.

--------------------------------------------------------
*/

class Solution {

    /*
    ----------------------------------------------------
    📌 MOBILE KEYPAD MAPPING
    ----------------------------------------------------
    Index = digit
    Value = letters corresponding to that digit
    */
    static String[] map = {
        "",     // 0 → no letters
        "",     // 1 → no letters
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7 (4 letters)
        "tuv",  // 8
        "wxyz"  // 9 (4 letters)
    };

    /*
    ----------------------------------------------------
    🚀 MAIN LEETCODE FUNCTION
    ----------------------------------------------------
    digits = input string
    */
    public List<String> letterCombinations(String digits) {

        // Edge case: if input is empty, return empty list
        if (digits.length() == 0) return new ArrayList<>();

        // Start recursion
        return Letters("", digits);
    }

    /*
    ----------------------------------------------------
    🔁 RECURSIVE FUNCTION
    ----------------------------------------------------
    p  → processed string (answer so far)
    up → unprocessed digits
    */
    public List<String> Letters(String p, String up) {

        /*
        ---------------------------
        🛑 BASE CASE
        ---------------------------
        If no digits are left to process,
        then 'p' is a complete combination.
        */
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);   // add completed string
            return list;
        }

        /*
        ---------------------------
        🔍 PROCESS FIRST DIGIT
        ---------------------------
        Convert character to integer
        '2' → 2
        */
        int digit = up.charAt(0) - '0';

        // Get letters for the digit
        String letters = map[digit];

        /*
        ans will collect all combinations
        from recursive calls
        */
        List<String> ans = new ArrayList<>();

        /*
        ---------------------------
        🔁 LOOP THROUGH LETTERS
        ---------------------------
        For each letter:
        - add it to processed part
        - recurse for remaining digits
        */
        for (int i = 0; i < letters.length(); i++) {

            ans.addAll(
                Letters(
                    p + letters.charAt(i), // add current letter
                    up.substring(1)         // remove first digit
                )
            );
        }

        // Return all collected combinations
        return ans;
    }
}

/*
========================================================
📊 FULL DRY RUN (digits = "23")
========================================================

Initial Call:
letterCombinations("23")
→ Letters("", "23")

--------------------------------------------------------
STEP 1:
p = ""
up = "23"
digit = 2 → letters = "abc"

--------------------------------------------------------
STEP 2: Loop over "abc"

1️⃣ Choose 'a'
Letters("a", "3")

   digit = 3 → letters = "def"

   → Letters("ad", "") → ["ad"]
   → Letters("ae", "") → ["ae"]
   → Letters("af", "") → ["af"]

   Returns → ["ad", "ae", "af"]

--------------------------------------------------------
2️⃣ Choose 'b'
Letters("b", "3")

   → ["bd", "be", "bf"]

--------------------------------------------------------
3️⃣ Choose 'c'
Letters("c", "3")

   → ["cd", "ce", "cf"]

--------------------------------------------------------
FINAL ANSWER:
["ad","ae","af","bd","be","bf","cd","ce","cf"]

========================================================
🌳 VISUAL RECURSION TREE
========================================================

Letters("", "23")
│
├── a → Letters("a", "3")
│   ├── ad
│   ├── ae
│   └── af
│
├── b → Letters("b", "3")
│   ├── bd
│   ├── be
│   └── bf
│
└── c → Letters("c", "3")
    ├── cd
    ├── ce
    └── cf

========================================================
📌 KEY INTERVIEW POINTS
========================================================
• Uses DFS (Depth First Search)
• addAll() merges child results
• Time Complexity: O(4^n)
• Space Complexity: O(n)
• Handles digits 7 & 9 correctly

========================================================
*/
