import java.util.*;

/*
==========================
COMBINATION SUM – LEETCODE
==========================

Problem:
---------
candidates = [2, 3, 6, 7]
target = 7

Rules:
------
1) You can use the same element multiple times
2) Order does NOT matter
3) Find all combinations whose sum == target

Output:
-------
[[2,2,3], [7]]

---------------------------------
CORE IDEA (VERY IMPORTANT)
---------------------------------
At every index, we have TWO choices:

1️⃣ PICK the element
   - Add it to current list
   - Reduce target
   - Stay at SAME index (reuse allowed)

2️⃣ NOT PICK the element
   - Do NOT add it
   - Move to next index
*/

class Solution {

    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        // start recursion from index 0
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

        // ✅ BASE CASE 1: Target becomes exactly 0
        // This means the current combination is VALID
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // ❌ BASE CASE 2: Invalid path
        // target < 0 → sum exceeded
        // index == arr.length → no numbers left
        if (target < 0 || index == arr.length) {
            return;
        }

        /*
        -------------------
        CHOICE 1: PICK
        -------------------
        */

        // Add current number
        current.add(arr[index]);

        // Stay at SAME index (reuse allowed)
        backtrack(arr, index, target - arr[index], current, ans);

        // BACKTRACK → remove last added element
        current.remove(current.size() - 1);

        /*
        -------------------
        CHOICE 2: NOT PICK
        -------------------
        */

        // Move to next index
        backtrack(arr, index + 1, target, current, ans);
    }
}

/*
========================================================
DRY RUN (STEP BY STEP) – candidates = [2,3,6,7], target = 7
========================================================

Start:
------
index = 0, current = [], target = 7

--------------------------------
Pick 2
--------------------------------
current = [2], target = 5

Pick 2
current = [2,2], target = 3

Pick 2
current = [2,2,2], target = 1

Pick 2
target = -1 ❌ → return

Backtrack → remove last 2
current = [2,2,2]

Not Pick → move index to 1 (3)

Try 3
target = 1 - 3 = -2 ❌ → return

Backtrack → remove 2
current = [2,2]

--------------------------------
Try 3
--------------------------------
current = [2,2,3], target = 0 ✅
→ ADD [2,2,3] to answer

Backtrack → remove 3
current = [2,2]

Try 6 → target < 0 ❌
Try 7 → target < 0 ❌

Backtrack → remove 2
current = [2]

--------------------------------
Try 3
--------------------------------
current = [2,3], target = 2 ❌
(no valid continuation)

Backtrack → remove 3
current = [2]

Try 6 → ❌
Try 7 → ❌

Backtrack → remove 2
current = []

--------------------------------
Try 3
--------------------------------
current = [3], target = 4 ❌

--------------------------------
Try 6
--------------------------------
current = [6], target = 1 ❌

--------------------------------
Try 7
--------------------------------
current = [7], target = 0 ✅
→ ADD [7] to answer

--------------------------------
FINAL ANSWER
--------------------------------
[[2,2,3], [7]]
*/

/*
========================
KEY TAKEAWAYS
========================
✔ Backtracking = TRY → FAIL → REMOVE → TRY NEXT
✔ index does NOT reset, recursion handles it
✔ remove() only removes value, index is controlled by recursion
✔ target == 0 → answer found
✔ target < 0 → dead end
✔ Same index → reuse allowed
✔ index + 1 → move forward

If you understand THIS file,
👉 you understand 90% of recursion problems
*/
