class Solution {
    public int[] shuffle(int[] nums, int n) {

        // Create a new array of size 2*n to store the shuffled result
        int[] ans = new int[n * 2];

        // This index is used to place elements sequentially in ans[]
        int index = 0;

        // Loop through the first half of the nums array
        for (int i = 0; i < n; i++) {

            // Place element from the first half (x part)
            ans[index] = nums[i];
            index++;   // Move to next position

            // Place element from the second half (y part)
            ans[index] = nums[i + n];
            index++;   // Move to next position
        }

        // Return the shuffled array
        return ans;
    }
}
