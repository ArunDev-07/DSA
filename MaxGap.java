import java.util.Arrays;

class Solution {

    /*
     =====================================================
     SOLUTION 1: Your EASY / LEARNING APPROACH
     =====================================================
     NOTE:
     - This solution works for many cases
     - But it has a logical flaw in the first comparison
     - Kept here for learning and understanding
     =====================================================
    */
    public int maximumGapEasy(int[] nums) {

        // If the array has less than 2 elements,
        // no gap can be calculated
        if (nums.length < 2) {
            return 0;
        }

        // Sort the array so numbers are in order
        Arrays.sort(nums);

        // 'sum' is initially set to the first element
        // 'ans' will store the maximum gap
        int sum = nums[0];
        int ans = 0;

        // Enhanced for-loop to iterate through each element
        for (int num : nums) {

            // Calculate difference between current number
            // and the previous stored value
            sum = num - sum;

            // Update the maximum gap if current gap is larger
            if (ans < sum) {
                ans = sum;
            }

            // Update sum to current number
            // so it acts as "previous element"
            sum = num;
        }

        // Return the maximum gap found
        return ans;
    }

    /*
     =====================================================
     SOLUTION 2: CORRECT & INTERVIEW-READY APPROACH
     =====================================================
     - Uses index-based loop
     - Compares only valid consecutive elements
     - Safe, clean, and recommended
     =====================================================
    */
    public int maximumGap(int[] nums) {

        // If array size is less than 2,
        // no maximum gap exists
        if (nums.length < 2) {
            return 0;
        }

        // Sort the array to bring elements in order
        Arrays.sort(nums);

        // Variable to store the maximum gap
        int ans = 0;

        // Start from index 1 to compare with previous element
        for (int i = 1; i < nums.length; i++) {

            // Calculate gap between consecutive elements
            int sum = nums[i] - nums[i - 1];

            // Update maximum gap if current gap is larger
            if (ans < sum) {
                ans = sum;
            }
        }

        // Return the maximum gap between consecutive elements
        return ans;
    }
}
