class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int sum = 0;    // Stores the maximum number of consecutive 1s found
        int count = 0;  // Stores the current consecutive 1s count

        // Loop through every element in the array
        for (int j = 0; j < nums.length; j++) {

            // If the current element is 1
            if (nums[j] == 1) {
                count++;   // Increase current consecutive count

                // Update maximum if current count is greater
                if (count > sum) {
                    sum = count;
                }
            }
            // If the current element is 0
            else {
                count = 0; // Reset count because 0 breaks the sequence
            }
        }

        // Return the maximum consecutive 1s
        return sum;
    }
}
