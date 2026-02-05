import java.util.*;

/*
=========================================================
PERMUTATIONS II – UNIQUE PERMUTATIONS (LeetCode 47)
=========================================================

PROBLEM:
---------
Given an array that may contain duplicates,
return ALL UNIQUE permutations.

Example:
Input  : [1, 1, 2]
Output :
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

---------------------------------------------------------
KEY IDEAS:
---------------------------------------------------------
1) We use BACKTRACKING
2) We use a boolean[] "used" to track index usage
3) We SORT the array to handle duplicates
4) We SKIP duplicates using a smart condition

=========================================================
*/

class Solution {

    /*
    -----------------------------------------------------
    MAIN FUNCTION
    -----------------------------------------------------
    - Sorts the array
    - Initializes helper data structures
    - Starts recursion
    */
    public List<List<Integer>> permuteUnique(int[] arr) {

        // STEP 1: Sort array so duplicates come together
        // Example: [1,1,2]
        Arrays.sort(arr);

        // Current permutation (temporary list)
        List<Integer> c = new ArrayList<>();

        // Final answer list
        List<List<Integer>> ans = new ArrayList<>();

        // used[i] = true means index i is already used
        boolean[] used = new boolean[arr.length];

        // Start backtracking
        Perm47(arr, c, ans, used);

        return ans;
    }

    /*
    -----------------------------------------------------
    BACKTRACKING FUNCTION
    -----------------------------------------------------
    arr   -> input array
    c     -> current permutation
    ans   -> final answer
    used  -> tracks used indices
    */
    public void Perm47(int[] arr, List<Integer> c,
                       List<List<Integer>> ans, boolean[] used) {

        /*
        ---------------- BASE CASE ----------------
        If current list size equals array length,
        we formed ONE complete permutation.
        */
        if (c.size() == arr.length) {
            ans.add(new ArrayList<>(c)); // add COPY
            return;
        }

        /*
        ---------------- CHOICES ----------------
        Try every index from 0 to n-1
        */
        for (int i = 0; i < arr.length; i++) {

            // ❌ If already used, skip
            if (used[i]) {
                continue;
            }

            /*
            🔥 DUPLICATE SKIP CONDITION (MOST IMPORTANT)

            Meaning:
            - If current element equals previous element
            - AND previous element was NOT used in this recursion path
            → skip to avoid duplicate permutation

            Why?
            Because using arr[i] before arr[i-1] creates
            the SAME permutation structure.
            */
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) {
                continue;
            }

            // ✅ CHOOSE
            used[i] = true;       // mark index as used
            c.add(arr[i]);        // add element

            // 🔁 EXPLORE
            Perm47(arr, c, ans, used);

            // 🔙 BACKTRACK (UNDO)
            used[i] = false;      // unmark index
            c.remove(c.size() - 1); // remove last element
        }
    }
}

/*
=========================================================
DRY RUN WITH VISUAL EXAMPLE
=========================================================

Input:
arr = [1, 1, 2]

After sorting:
arr = [1, 1, 2]

used = [F, F, F]
c = []

---------------------------------------------------------
STEP 1:
Pick index 0 → 1
c = [1]
used = [T, F, F]

STEP 2:
Pick index 1 → 1 (allowed because used[0] = true)
c = [1, 1]
used = [T, T, F]

STEP 3:
Pick index 2 → 2
c = [1, 1, 2]  ✅ ADD TO ANSWER

Backtrack:
remove 2 → remove 1
c = [1]
used = [T, F, F]

---------------------------------------------------------
STEP 4:
Pick index 2 → 2
c = [1, 2]
used = [T, F, T]

STEP 5:
Pick index 1 → 1
c = [1, 2, 1]  ✅ ADD TO ANSWER

Backtrack to root:
c = []
used = [F, F, F]

---------------------------------------------------------
STEP 6:
Try index 1 → 1 ❌ SKIPPED

Why skipped?
arr[1] == arr[0] AND used[0] == false
→ duplicate structure

---------------------------------------------------------
STEP 7:
Pick index 2 → 2
c = [2]
used = [F, F, T]

STEP 8:
Pick index 0 → 1
c = [2, 1]
used = [T, F, T]

STEP 9:
Pick index 1 → 1
c = [2, 1, 1]  ✅ ADD TO ANSWER

---------------------------------------------------------
FINAL ANSWER:
[
 [1,1,2],
 [1,2,1],
 [2,1,1]
]

=========================================================
ONE-LINE SUMMARY (INTERVIEW READY):
=========================================================
"Sort the array, track index usage with a boolean array,
and skip duplicates by allowing equal elements only when
the previous identical element is already used."
=========================================================
