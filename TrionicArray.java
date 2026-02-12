/*
Trionic Array Explanation
-------------------------

A Trionic array follows this pattern:

    Strictly Increasing → Strictly Decreasing → Strictly Increasing

Example:
    [1, 3, 5, 4, 2, 6]

    1 < 3 < 5 > 4 > 2 < 6

We scan the array using one pointer 'i' and divide the traversal
into three phases:

Phase 1: Move forward while elements are strictly increasing.
Phase 2: Move forward while elements are strictly decreasing.
Phase 3: Move forward while elements are strictly increasing again.

If after completing these 3 phases we reach the end of the array,
then it is a valid Trionic array.

Time Complexity: O(n)
Space Complexity: O(1)


---------------------------------------------------------
Dry Run Example
---------------------------------------------------------

Input:
    nums = [1, 3, 5, 4, 2, 6]

Index:
    0  1  2  3  4  5
    1  3  5  4  2  6

Step 1: Increasing phase
    3 > 1 → i = 2
    5 > 3 → i = 3
    4 > 5 ❌ stop

    Increasing part: [1, 3, 5]

Step 2: Decreasing phase
    4 < 5 → i = 4
    2 < 4 → i = 5
    6 < 2 ❌ stop

    Decreasing part: [5, 4, 2]

Step 3: Increasing again
    6 > 2 → i = 6

    i == n → valid

Graphically:

        5
      /   \
     3     4
    /       \
   1         2
                \
                 6

Pattern:
    Climb ↑ → Slide ↓ → Climb ↑

---------------------------------------------------------
Invalid Cases
---------------------------------------------------------

[1,2,3,4] → Only increasing → false
[1,3,5,4,2] → No final increasing → false
[5,4,3,2] → Only decreasing → false
*/

class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int i = 1;

        // Phase 1: Strictly Increasing
        while (i < n && nums[i] > nums[i - 1]) {
            i++;
        }

        // If no increasing part OR entire array increasing
        if (i == n || i == 1) {
            return false;
        }

        // Phase 2: Strictly Decreasing
        while (i < n && nums[i] < nums[i - 1]) {
            i++;
        }

        // If no final increasing part
        if (i == n) {
            return false;
        }

        // Phase 3: Strictly Increasing Again
        while (i < n && nums[i] > nums[i - 1]) {
            i++;
        }

        return i == n;
    }
}
