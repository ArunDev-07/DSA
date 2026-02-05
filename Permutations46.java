import java.util.ArrayList;
import java.util.List;

class Solution {

    // Main function called by LeetCode
    public List<List<Integer>> permute(int[] arr) {

        // c = current permutation being built
        List<Integer> c = new ArrayList<>();

        // ans = stores all permutations
        List<List<Integer>> ans = new ArrayList<>();

        // Start recursion
        perm(arr, c, ans);

        return ans;
    }

    // Recursive helper function
    public void perm(int[] arr, List<Integer> c, List<List<Integer>> ans) {

        // 🟢 BASE CASE:
        // If current list size equals array length,
        // we have formed ONE complete permutation
        if (c.size() == arr.length) {
            ans.add(new ArrayList<>(c)); // copy c into ans
            return;
        }

        // Try every number in the array
        for (int num : arr) {

            // ❌ If number already used in current permutation, skip it
            if (c.contains(num)) {
                continue;
            }

            // ✅ Choose
            c.add(num);

            // 🔁 Explore (recursive call)
            perm(arr, c, ans);

            // 🔙 Backtrack (undo the choice)
            c.remove(c.size() - 1);
        }
    }
}

/*
====================================================
📘 EXPLANATION (IN SIMPLE WORDS)
====================================================

This code generates ALL permutations of an array
using RECURSION + BACKTRACKING.

For input: [1, 2, 3]
Total permutations = 3! = 6

The idea:
- Build the permutation step by step
- At each step, try every number not used yet
- When the permutation is complete, store it
- Backtrack and try other possibilities

Key concepts:
1️⃣ Choice       → pick a number
2️⃣ Explore     → recurse
3️⃣ Backtrack   → remove the number and try next

----------------------------------------------------
Why c.contains(num)?
----------------------------------------------------
It ensures the same number is NOT reused
in the same permutation.

----------------------------------------------------
Why new ArrayList<>(c)?
----------------------------------------------------
Because c changes during backtracking.
We store a COPY, not a reference.

====================================================
🧪 DRY RUN (VISUAL EXAMPLE)
====================================================

Input: arr = [1, 2, 3]

Start:
c = []

---------------------------------
Level 1
---------------------------------
Add 1
c = [1]

  Level 2
  Add 2
  c = [1, 2]

    Level 3
    Add 3
    c = [1, 2, 3]  ✅ store

    Backtrack → remove 3
    c = [1, 2]

  Backtrack → remove 2
  c = [1]

  Add 3
  c = [1, 3]

    Add 2
    c = [1, 3, 2]  ✅ store

    Backtrack → remove 2
    c = [1, 3]

  Backtrack → remove 3
  c = [1]

Backtrack → remove 1
c = []

---------------------------------
Level 1 (continue)
---------------------------------
Add 2
c = [2]

  Add 1 → [2,1,3] ✅
  Add 3 → [2,3,1] ✅

---------------------------------
Add 3
---------------------------------
Add 1 → [3,1,2] ✅
Add 2 → [3,2,1] ✅

====================================================
✅ FINAL OUTPUT
====================================================

[
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
]

====================================================
🧠 TIME & SPACE COMPLEXITY
====================================================

Time:  O(n! * n)
Space: O(n) recursion stack

====================================================
*/
