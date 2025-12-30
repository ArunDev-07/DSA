class Solution {
    public int findGCD(int[] nums) {

        // Assume first element is both max and min initially
        int max = nums[0];
        int min = nums[0];

        // Loop through the array to find actual max and min values
        for (int i = 1; i < nums.length; i++) {

            // Update maximum value
            max = Math.max(max, nums[i]);

            // Update minimum value
            min = Math.min(min, nums[i]);
        }

        // Apply Euclidean Algorithm to find GCD of max and min
        while (min != 0) {

            // Store remainder of max divided by min
            int temp = max % min;

            // Move min value to max
            max = min;

            // Remainder becomes the new min
            min = temp;
        }

        // When min becomes 0, max holds the GCD
        return max;
    }
}
