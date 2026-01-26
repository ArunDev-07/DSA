import java.util.*;

/*
====================================================
PROBLEM: Minimum Absolute Difference
(LeetCode – Minimum Absolute Difference)

TASK:
Given an integer array, find all pairs of elements
with the minimum absolute difference.

APPROACH:
1. Sort the array
2. Find the minimum difference between adjacent elements
3. Collect all pairs that have this minimum difference

WHY SORT?
After sorting, the minimum absolute difference
will ALWAYS be between adjacent elements.
====================================================
*/

class Solution {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        // Step 1: Sort the array
        Arrays.sort(arr);

        /*
        Example after sorting:
        arr = [1, 3, 6, 10, 15]
        */

        // Result list to store pairs
        List<List<Integer>> list = new ArrayList<>();

        // Variable to store minimum difference
        int min = Integer.MAX_VALUE;

        /*
        ------------------------------------------------
        FIRST LOOP:
        Find the minimum absolute difference
        ------------------------------------------------
        */
        for(int i = 1; i < arr.length; i++){

            // Difference between adjacent elements
            int ans = arr[i] - arr[i - 1];

            // Update minimum difference
            min = Math.min(min, ans);
        }

        /*
        After first loop:
        min = smallest difference in the array
        */

        /*
        ------------------------------------------------
        SECOND LOOP:
        Collect all pairs having min difference
        ------------------------------------------------
        */
        for(int i = 1; i < arr.length; i++){

            int ans = arr[i] - arr[i - 1];

            // If difference equals minimum
            if(ans == min){

                // Add the pair to the list
                list.add(new ArrayList<>(List.of(arr[i - 1], arr[i])));
            }
        }

        // Return the list of pairs
        return list;
    }
}

/*
====================================================
FULL DRY RUN (VERY IMPORTANT)
====================================================

Input:
arr = [1, 3, 6, 10, 15]

Step 1: Sort
arr = [1, 3, 6, 10, 15]

----------------------------------------------------
FIRST LOOP (finding minimum difference)
----------------------------------------------------

i = 1
ans = 3 - 1 = 2
min = 2

i = 2
ans = 6 - 3 = 3
min = 2

i = 3
ans = 10 - 6 = 4
min = 2

i = 4
ans = 15 - 10 = 5
min = 2

Minimum difference found:
min = 2

----------------------------------------------------
SECOND LOOP (collecting pairs)
----------------------------------------------------

i = 1
ans = 3 - 1 = 2
ans == min → YES
add [1, 3]

i = 2
ans = 6 - 3 = 3
ans == min → NO

i = 3
ans = 10 - 6 = 4
ans == min → NO

i = 4
ans = 15 - 10 = 5
ans == min → NO

----------------------------------------------------
FINAL OUTPUT
----------------------------------------------------
[[1, 3]]
====================================================
*/

/*
TIME COMPLEXITY:
Sorting  → O(n log n)
Loops    → O(n)
Overall  → O(n log n)

SPACE COMPLEXITY:
O(n) (for result list)

KEY IDEA (INTERVIEW LINE):
"After sorting, minimum absolute difference
always occurs between adjacent elements."
*/
