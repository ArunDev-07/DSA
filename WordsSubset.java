/*
========================================
LeetCode: Word Subsets
========================================

PROBLEM IDEA:
-------------
A word A from s1 is a "universal word" if
for EVERY word B in s2,
A contains ALL characters of B (with frequency).

Instead of checking every B again and again,
we merge all requirements from s2 into ONE array.

----------------------------------------
EXAMPLE:
----------------------------------------
s1 = ["amazon","apple","facebook","google","leetcode"]
s2 = ["lc","eo"]

----------------------------------------
STEP 1: Build MAX requirement from s2
----------------------------------------

Word = "lc"
l → 1
c → 1

Word = "eo"
e → 1
o → 1

Final requirement (max array):
--------------------------------
a b c d e f g h i j k l m n o p q r s t u v w x y z
0 0 1 0 1 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 0 0 0

Meaning:
c >= 1
e >= 1
l >= 1
o >= 1

----------------------------------------
STEP 2: Check each word in s1
----------------------------------------

amazon:
a m a z o n
o = 1 ✔
c = 0 ❌
→ NOT universal

apple:
a p p l e
l = 1 ✔
e = 1 ✔
o = 0 ❌
→ NOT universal

facebook:
f a c e b o o k
c = 1 ✔
e = 1 ✔
l = 0 ❌
→ NOT universal

google:
g o o g l e
c = 0 ❌
→ NOT universal

leetcode:
l e e t c o d e
c = 1 ✔
e = 3 ✔
l = 1 ✔
o = 1 ✔
→ UNIVERSAL ✅

----------------------------------------
FINAL ANSWER:
----------------------------------------
["leetcode"]

========================================
CODE IMPLEMENTATION
========================================
*/

import java.util.*;

class Solution {
    public List<String> wordSubsets(String[] s1, String[] s2) {

        // Answer list
        List<String> ans = new ArrayList<>();

        // max[i] = maximum required count of character ('a' + i)
        int[] max = new int[26];

        /*
        ----------------------------------------
        STEP 1: Build max frequency array from s2
        ----------------------------------------
        */
        for (String word : s2) {

            // Frequency of current word
            int[] freq = new int[26];

            for (char c : word.toCharArray()) {
                freq[c - 'a']++;

                // Update global maximum requirement
                max[c - 'a'] = Math.max(max[c - 'a'], freq[c - 'a']);
            }
        }

        /*
        ----------------------------------------
        STEP 2: Check each word in s1
        ----------------------------------------
        */
        for (String word : s1) {

            // Frequency of current word
            int[] req = new int[26];

            for (char c : word.toCharArray()) {
                req[c - 'a']++;
            }

            // Assume it satisfies all conditions
            boolean match = true;

            // Compare with required max frequencies
            for (int i = 0; i < 26; i++) {
                if (req[i] < max[i]) {
                    match = false;
                    break;
                }
            }

            // If valid, add to answer
            if (match) {
                ans.add(word);
            }
        }

        return ans;
    }
}
