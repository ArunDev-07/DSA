import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] nums, int limit) {

        // Sort people by weight
        Arrays.sort(nums);

        // Left pointer → lightest person
        int left = 0;

        // Right pointer → heaviest person
        int right = nums.length - 1;

        // Count total boats used
        int boats = 0;

        // Continue until all people are assigned
        while (left <= right) {

            // One boat is always used per iteration
            boats++;

            // If lightest + heaviest can fit together
            if (nums[left] + nums[right] <= limit) {
                left++;    // light person boards
                right--;   // heavy person boards
            }
            // Else heavy person goes alone
            else {
                right--;
            }
        }

        // Return total number of boats
        return boats;
    }
}
