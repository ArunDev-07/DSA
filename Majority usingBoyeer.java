class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0; // current majority candidate
        int count = 0;     // strength of the candidate

        // Loop through each number in the array
        for (int num : nums) {

            if (count == 0) {
                // Candidate is dead → pick new candidate
                candidate = num; 
                count = 1; // new candidate starts with count 1 (itself)
            } else if (num == candidate) {
                // Same as candidate → strengthen candidate
                count++;
            } else {
                // Different from candidate → weaken candidate
                count--;
            }
        }

        // At the end, candidate holds the majority element
        // Majority element survives because it appears more than n/2
        return candidate;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int result = sol.majorityElement(nums);

        System.out.println("Majority Element: " + result);  
        // Output: 2 → because 2 is the majority element
    }
}
