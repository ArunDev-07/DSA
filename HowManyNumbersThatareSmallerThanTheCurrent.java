class Solution {

    // This method returns an array where
    // each index stores how many numbers are smaller than nums[i]
    public int[] smallerNumbersThanCurrent(int[] nums) {

        // Create result array of same size as nums
        int[] ans = new int[nums.length];

        // OUTER LOOP:
        // i selects one number at a time from nums
        for (int i = 0; i < nums.length; i++) {

            // count stores how many numbers are smaller than nums[i]
            int count = 0;

            // INNER LOOP:
            // j compares nums[i] with every element in the array
            for (int j = 0; j < nums.length; j++) {

                // If current number nums[i] is greater than nums[j]
                // then nums[j] is smaller
                if (nums[i] > nums[j]) {
                    count++;   // increase count
                }
            }

            // After comparing with all numbers,
            // store the count in ans[i]
            ans[i] = count;
        }

        // Return the final result array
        return ans;
    }
}
