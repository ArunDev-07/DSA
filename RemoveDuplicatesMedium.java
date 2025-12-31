class Solution {
    public int removeDuplicates(int[] nums) {

        // i represents the position where the next valid element should be placed
        // We start i = 2 because:
        // - First two elements are always allowed (at most 2 duplicates)
        int i = 2;

        // j starts from index 2 because:
        // - index 0 and 1 are already considered valid
        for (int j = 2; j < nums.length; j++) {

            // We compare current element nums[j]
            // with nums[i-2] (element two positions behind i)
            //
            // If nums[j] == nums[i-2],
            // that means this is the 3rd duplicate → we skip it
            //
            // If nums[j] != nums[i-2],
            // that means this number appeared less than 2 times → we keep it
            if (nums[j] != nums[i - 2]) {

                // Place the valid element at index i
                nums[i] = nums[j];

                // Move i forward for the next valid position
                i++;
            }
        }

        // i now represents the count of valid elements
        return i;
    }
}
