import java.util.*;

/*
=====================================
COMBINATION SUM II – LEETCODE 40
=====================================

Problem:
---------
candidates = [10,1,2,7,6,1,5]
target = 8

Rules:
------
1) Each number can be used ONLY ONCE
2) The array may contain DUPLICATES
3) Result must NOT contain duplicate combinations
4) Order does NOT matter

Output:
-------
[
 [1,1,6],
 [1,2,5],
 [1,7],
 [2,6]
]

-------------------------------------
MAIN DIFFERENCE FROM COMBINATION SUM I
-------------------------------------
Combination Sum I:
- Reuse allowed
- index stays same on pick

Combination Sum II:
- Reuse NOT allowed
- index always moves forward
- MUST SKIP DUPLICATES
*/

class Solution {

    public List<List<Integer>> combinationSum2(int[] arr, int target) {

        // VERY IMPORTANT → sort the array
        // This helps us SKIP duplicates
        Arrays.sort(arr);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(arr, 0, target, current, ans);
        return ans;
    }

    public void backtrack(
            int[] arr,
            int index,
            int target,
            List<Integer> current,
            List<List<Integer>> ans
    ) {

        /*
        -------------------
        BASE CONDITIONS
        -------------------
        */

        // ✅ Valid combination found
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // ❌ Invalid path
        if (target < 0) {
            return;
        }

        /*
        -------------------
        LOOP CHOICE
        -------------------
        We use a FOR LOOP instead of pick / not pick
        because reuse is NOT allowed
        */

        for (int i = index; i < arr.length; i++) {

            /*
            ----------------------------------
            DUPLICATE SKIPPING (MOST IMPORTANT)
            ----------------------------------
            If current element is same as previous
            AND we are at the same recursion level,
            then skip it.
            */
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }

            // ❌ If number is greater than target, stop
            if (arr[i] > target) {
                break;
            }

            /*
            -------------------
            PICK ELEMENT
            -------------------
            */
            current.add(arr[i]);

            // Move to NEXT index (reuse NOT allowed)
            backtrack(arr, i + 1, target - arr[i], current, ans);

            /*
            -------------------
            BACKTRACK
            -------------------
            */
            current.remove(current.size() - 1);
        }
    }
}

/*
=====================================================
DRY RUN – candidates = [1,1,2,5,6,7,10], target = 8
=====================================================

Start:
------
index = 0, current = [], target = 8

--------------------------------
Pick 1 (index 0)
--------------------------------
current = [1], target = 7

Pick 1 (index 1)
current = [1,1], target = 6

Pick 2 → target = 4 ❌
Pick 5 → target = 1 ❌

Pick 6
current = [1,1,6], target = 0 ✅
ADD [1,1,6]

Backtrack → current = [1]

--------------------------------
Pick 2
--------------------------------
current = [1,2], target = 5

Pick 5
current = [1,2,5], target = 0 ✅
ADD [1,2,5]

--------------------------------
Pick 7
--------------------------------
current = [1,7], target = 0 ✅
ADD [1,7]

--------------------------------
SKIP duplicate 1 at index 1
--------------------------------

--------------------------------
Pick 2 (index 2)
--------------------------------
current = [2], target = 6

Pick 6
current = [2,6], target = 0 ✅
ADD [2,6]

--------------------------------
Remaining picks exceed target → stop
--------------------------------

FINAL ANSWER:
-------------
[
 [1,1,6],
 [1,2,5],
 [1,7],
 [2,6]
]
*/

/*
===========================
WHY DUPLICATE SKIPPING WORKS
===========================

Example:
---------
[1,1,2]

At SAME recursion level:
- First 1 is allowed
- Second 1 is SKIPPED

But at DEEPER level:
- Second 1 is allowed

Condition:
-----------
if (i > index && arr[i] == arr[i - 1]) continue;

This avoids SAME combination structure.

===========================
KEY DIFFERENCES SUMMARY
===========================

Combination Sum I:
------------------
✔ Reuse allowed
✔ index stays same on pick
✔ No duplicate skip

Combination Sum II:
-------------------
✔ Reuse NOT allowed
✔ index moves forward
✔ Duplicate skip REQUIRED
✔ Array MUST be sorted

If you understand THIS FILE,
👉 you understand ALL combination problems 🔥
*/

