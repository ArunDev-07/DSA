import java.util.*;

class Solution {
    /*
     * Function to find the minimum difference between the maximum and minimum 
     * in any subarray of size k from the given array.
     *
     * Single-paragraph explanation (based on your understanding):
     * First, the array is sorted so that numbers are in ascending order. 
     * Then, for each contiguous subarray of size k, we calculate the difference 
     * between the last element (maximum) and the first element (minimum) of that subarray. 
     * We keep track of the smallest difference seen so far in `mindiff`. 
     * After checking all possible subarrays of size k, the smallest difference is returned.
     * Sorting ensures that the maximum and minimum in a subarray are just the first and last elements,
     * which makes this approach very efficient.
     *
     * Example:
     * nums = [9, 4, 1, 7], k = 2
     * Sorted: [1, 4, 7, 9]
     * Subarrays of size 2 and their differences:
     * [1,4] -> 4-1 = 3
     * [4,7] -> 7-4 = 3
     * [7,9] -> 9-7 = 2
     * Minimum difference = 2
     */
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);  // Step 1: Sort the array in ascending order

        int mindiff = Integer.MAX_VALUE; // Initialize minimum difference to maximum possible value

        // Step 2: Slide a window of size k and calculate difference between first and last
        for (int i = 0; i + k - 1 < nums.length; i++) {
            int ans = nums[i + k - 1] - nums[i]; // Difference between max and min in this window
            mindiff = Math.min(mindiff, ans);    // Update minimum difference
        }

        return mindiff; // Step 3: Return the smallest difference
    }

    // Optional main function to test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {9, 4, 1, 7};
        int k = 2;
        int result = sol.minimumDifference(nums, k);
        System.out.println(result); // Output: 2
    }
}
