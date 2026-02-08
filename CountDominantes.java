class Solution {

    /*
    ============================================================
    PROBLEM: Count Dominant Indices
    ============================================================

    Definition:
    An index i is called DOMINANT if:

        nums[i] * (number of elements to the right of i)
            >
        sum of all elements to the right of i

    We must count how many such indices exist.

    ------------------------------------------------------------
    APPROACH (Idea):
    ------------------------------------------------------------
    1. First compute the TOTAL SUM of the array.
    2. Traverse the array from LEFT to RIGHT.
    3. For each index i:
       - Subtract nums[i] from total sum
         → now sum represents elements to the RIGHT.
       - Count how many elements remain on the right.
       - Check dominance condition.
    4. Count how many indices satisfy the condition.

    ------------------------------------------------------------
    TIME COMPLEXITY:  O(n)
    SPACE COMPLEXITY: O(1)
    ------------------------------------------------------------
    */

    public int dominantIndices(int[] nums) {
        return Dominant(nums);
    }

    public int Dominant(int[] nums){

        // Length of array
        int n = nums.length;

        /*
        --------------------------------------------------------
        STEP 1: Calculate total sum of array
        --------------------------------------------------------
        */
        int remainingsum = 0;
        for (int num : nums) {
            remainingsum += num;
        }

        // Variable to count dominant indices
        int dominant = 0;

        /*
        --------------------------------------------------------
        STEP 2: Traverse till n-2
        (last index cannot be dominant)
        --------------------------------------------------------
        */
        for (int i = 0; i < n - 1; i++) {

            /*
            Remove current element from sum
            After this, remainingsum contains
            sum of elements to the RIGHT of i
            */
            remainingsum -= nums[i];

            // Number of elements on the right side
            int remainingelement = n - i - 1;

            /*
            Dominant condition:
            nums[i] * remainingelement > remainingsum

            (long) is used to prevent integer overflow
            */
            if ((long) nums[i] * remainingelement > remainingsum) {
                dominant++;
            }
        }

        return dominant;
    }

    /*
    ============================================================
    FULL VISUAL DRY RUN
    ============================================================

    Input:
        nums = [5, 4, 3]

    ------------------------------------------------------------
    Initial Values:
    ------------------------------------------------------------
        n = 3
        remainingsum = 5 + 4 + 3 = 12
        dominant = 0

    ------------------------------------------------------------
    ITERATION 1: i = 0
    ------------------------------------------------------------
        nums[i] = 5

        remainingsum = 12 - 5 = 7
        remainingelement = 3 - 0 - 1 = 2

        Check:
            5 * 2 = 10
            10 > 7  ✅

        dominant = 1

    ------------------------------------------------------------
    ITERATION 2: i = 1
    ------------------------------------------------------------
        nums[i] = 4

        remainingsum = 7 - 4 = 3
        remainingelement = 3 - 1 - 1 = 1

        Check:
            4 * 1 = 4
            4 > 3  ✅

        dominant = 2

    ------------------------------------------------------------
    ITERATION 3: i = 2
    ------------------------------------------------------------
        Skipped (no elements on the right)

    ------------------------------------------------------------
    FINAL ANSWER:
    ------------------------------------------------------------
        dominant = 2

    ============================================================
    IMPORTANT NOTE:
    ============================================================

    Why (long) is used?

    nums[i] * remainingelement can overflow int for large values.
    Casting nums[i] to long ensures safe multiplication.

    ============================================================
    */
}
