class Solution {
    public int removeElement(int[] nums, int val) {

        int j = 0;   // index to place valid elements

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i]; // overwrite unwanted values
                j++;
            }
        }

        return j;    // new length of array
    }
}
