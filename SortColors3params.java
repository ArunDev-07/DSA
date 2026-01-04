class Solution {

    public void sortColors(int[] nums) {

        // Step 1: Count how many 0s, 1s, and 2s are present
        int count0 = 0;  // count of 0s
        int count1 = 0;  // count of 1s
        int count2 = 0;  // count of 2s

        // Traverse the array once to count values
        for (int val : nums) {
            if (val == 0) {
                count0++;
            } else if (val == 1) {
                count1++;
            } else { // val == 2
                count2++;
            }
        }

        // Step 2: Rewrite the array using the counts
        int index = 0; // points to current position in array

        // Place all 0s first
        for (int i = 0; i < count0; i++) {
            nums[index] = 0;
            index++;
        }

        // Place all 1s after 0s
        for (int i = 0; i < count1; i++) {
            nums[index] = 1;
            index++;
        }

        // Place all 2s at the end
        for (int i = 0; i < count2; i++) {
            nums[index] = 2;
            index++;
        }
    }
}
