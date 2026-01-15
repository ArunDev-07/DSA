class Solution {
    public int[] getConcatenation(int[] nums) {
        // Step 1: Find the length of the input array
        int n = nums.length;  // n is the number of elements in nums

        // Step 2: Create a new array of size 2*n
        // This array will hold the concatenation of nums with itself
        int[] ans = new int[2 * n];  

        // Step 3: Fill the ans array
        for (int i = 0; i < n; i++) {    // in this first we need to get the nums length because we want the 2* size of nums so ans array have the size of 2* nums .  
            ans[i] = nums[i];      // Copy element from nums to the first half of ans    // now we start from 0 to 5 that 6 size in that we need to add the elements 
            ans[i + n] = nums[i];  // Copy same element to the second half of ans    // ans[0] = nums[0]  ans[0+3] = nums[0] like that it add and return the ans
        }

        // Step 4: Return the concatenated array
        return ans;
    }
}
