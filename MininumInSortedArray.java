class Solution {
    // LeetCode requires the solution inside a class named Solution

    public int findMin(int[] nums) {
        // This method finds the minimum element in a rotated sorted array
        // The array has no duplicates

        int start = 0;
        // start pointer initialized to first index

        int end = nums.length - 1;
        // end pointer initialized to last index

        // Binary search loop
        while (start <= end) {

            int mid = start + (end - start) / 2;
            // Calculate mid safely to avoid overflow

            // Case 1: mid element is smaller than previous element
            // That means mid itself is the minimum element
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            // Case 2: mid element is greater than next element
            // That means the next element is the minimum
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // Case 3: Left part is sorted
            // Minimum must be in the right part
            if (nums[mid] >= nums[start]) {
                start = mid + 1;
            }
            // Case 4: Right part is sorted
            // Minimum must be in the left part
            else {
                end = mid - 1;
            }
        }

        // If the array is not rotated at all
        // The first element is the minimum
        return nums[0];
    }
}
