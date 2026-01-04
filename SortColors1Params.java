class Solution {

    public void sortColors(int[] nums) {

        // low  -> boundary for 0s
        // mid  -> current element being checked
        // high -> boundary for 2s
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        // Process elements until all are placed correctly
        while (mid <= high) {

            // If current element is 0,
            // swap it with the element at 'low'
            // and expand the 0s region
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            }

            // If current element is 1,
            // it is already in the correct middle position
            else if (nums[mid] == 1) {
                mid++;
            }

            // If current element is 2,
            // swap it with the element at 'high'
            // and shrink the 2s region
            // (do NOT increment mid here)
            else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    // Utility method to swap two elements in the array
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
