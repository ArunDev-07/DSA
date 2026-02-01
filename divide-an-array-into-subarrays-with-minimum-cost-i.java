import java.util.*;

class Solution {

    /*
     EXPLANATION (IN SIMPLE WORDS):

     - We must choose exactly 3 elements.
     - nums[0] is compulsory (problem condition).
     - We choose the remaining 2 elements from the rest of the array.
     - Try ALL possible pairs (i, j) and calculate:
           cost = nums[0] + nums[i] + nums[j]
     - Keep track of the minimum cost found.
     - Return the minimum at the end.
    */

    public int minimumCost(int[] nums) {

        // Initialize minimum cost with a very large value
        int min = Integer.MAX_VALUE;

        // Length of the array
        int n = nums.length;

        // i starts from 1 because nums[0] is already included
        for (int i = 1; i <= n - 2; i++) {

            // j starts from i + 1 to avoid duplicate pairs
            for (int j = i + 1; j <= n - 1; j++) {

                // Calculate cost using fixed nums[0] + two chosen elements
                int count = nums[0] + nums[i] + nums[j];

                // Update minimum cost if current cost is smaller
                min = Math.min(min, count);
            }
        }

        // Return the minimum cost found
        return min;
    }


    /*
    =========================
    DRY RUN WITH VISUAL EXAMPLE
    =========================

    Input:
        nums = [1, 2, 3, 4]

    Step 1:
        nums[0] = 1  (always included)

    Initialize:
        min = ∞

    Loop iterations:

    i = 1 (nums[i] = 2)
        j = 2 (nums[j] = 3)
            count = 1 + 2 + 3 = 6
            min = 6

        j = 3 (nums[j] = 4)
            count = 1 + 2 + 4 = 7
            min = 6

    i = 2 (nums[i] = 3)
        j = 3 (nums[j] = 4)
            count = 1 + 3 + 4 = 8
            min = 6

    Final Answer:
        min = 6

    OUTPUT:
        6
    */

}
