/*
    ============================================================
    PROBLEM:
    Replace every element in the array with the greatest element
    among the elements to its right.
    The last element should be replaced with -1.
    ============================================================

    INPUT  : [17, 18, 5, 4, 6, 1]
    OUTPUT : [18, 6, 6, 6, 1, -1]

    ------------------------------------------------------------
    🔎 CONCEPT EXPLANATION:

    If we try brute force:
        For every element, we check all elements on its right.
        That takes O(n^2) time.

    Optimized Approach:
        Traverse from RIGHT → LEFT.
        Keep track of the maximum element seen so far.
        Replace current element with that maximum.
        Update the maximum.

    Why RIGHT → LEFT?
        Because when we move from right to left,
        we already know the maximum element to the right.

    Time Complexity  : O(n)
    Space Complexity : O(1) (in-place modification)
    ============================================================
*/

class Solution {

    public int[] replaceElements(int[] arr) {

        // Step 1: Initialize max to -1
        // Because the last element has no element to the right
        int max = -1;

        // Step 2: Get length of array
        int n = arr.length;

        /*
            Step 3: Traverse from right to left

            Loop runs from:
            n-1 → 0
        */
        for (int i = n - 1; i >= 0; i--) {

            // Store current element before replacing it
            int temp = arr[i];

            // Replace current element with max (greatest to the right)
            arr[i] = max;

            // Update max using original value (stored in temp)
            max = Math.max(max, temp);
        }

        // Return modified array
        return arr;
    }
}


/*
=================================================================
🔥 FULL DRY RUN (STEP BY STEP VISUAL)
=================================================================

Initial Array:
[17, 18, 5, 4, 6, 1]

Initial:
max = -1

-------------------------------------------------

Iteration 1:
i = 5
arr[i] = 1

temp = 1
arr[5] = -1
max = max(-1,1) = 1

Array:
[17, 18, 5, 4, 6, -1]

-------------------------------------------------

Iteration 2:
i = 4
arr[i] = 6

temp = 6
arr[4] = 1
max = max(1,6) = 6

Array:
[17, 18, 5, 4, 1, -1]

-------------------------------------------------

Iteration 3:
i = 3
arr[i] = 4

temp = 4
arr[3] = 6
max = max(6,4) = 6

Array:
[17, 18, 5, 6, 1, -1]

-------------------------------------------------

Iteration 4:
i = 2
arr[i] = 5

temp = 5
arr[2] = 6
max = max(6,5) = 6

Array:
[17, 18, 6, 6, 1, -1]

-------------------------------------------------

Iteration 5:
i = 1
arr[i] = 18

temp = 18
arr[1] = 6
max = max(6,18) = 18

Array:
[17, 6, 6, 6, 1, -1]

-------------------------------------------------

Iteration 6:
i = 0
arr[i] = 17

temp = 17
arr[0] = 18
max = max(18,17) = 18

Final Array:
[18, 6, 6, 6, 1, -1]

=================================================================

📊 VISUAL TABLE SUMMARY

Index | Original | New Value | max After Update
--------------------------------------------------
5     | 1        | -1        | 1
4     | 6        | 1         | 6
3     | 4        | 6         | 6
2     | 5        | 6         | 6
1     | 18       | 6         | 18
0     | 17       | 18        | 18

=================================================================

🧠 PATTERN NAME:
Reverse Traversal + Running Maximum Pattern

Used in:
- Stock problems
- Next greater element
- Right max problems
- Array transformation problems

=================================================================
*/
