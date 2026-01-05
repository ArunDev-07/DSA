class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;  // total number of elements in array

        // Loop through each element as a candidate for majority
        for (int i = 0; i < n; i++) {
            int count = 1;  // start counting this element itself, reset for each i and the count starts from 1 because we take the element we need to add that count also so we put 1 before taking the element

            // Compare this element with every element after it
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;  // found same element → increase count
                }
            }

            // Check if this element occurs more than n/2 times
            if (count > n / 2) {
                return nums[i];  // YES! this is majority → return element itself
                // count is just used to decide → the returned value is nums[i]
            }
            // If not, move to next i → new element → count starts fresh from 1
        }

        return -1; // not found (won't happen in LeetCode majority element problem)
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int result = sol.majorityElement(nums);

        System.out.println("Majority Element: " + result);  
        // Output: 2 → because 2 appears 4 times > 7/2
    }
}
