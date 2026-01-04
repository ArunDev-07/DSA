class Solution {
    public void sortColors(int[] nums) {

        // Dutch National Flag Algorithm
        // 0 = red, 1 = white, 2 = blue
        // We will use three pointers: low, mid, high

        int low = 0;                  // next position to place 0
        int mid = 0;                  // current element we are checking
        int high = nums.length - 1;   // next position to place 2

        while (mid <= high) {

            if (nums[mid] == 0) {
                // Swap current element with 'low' pointer
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                // Move both pointers forward
                low++;
                mid++;
            } 
            else if (nums[mid] == 1) {
                // 1 is in correct position, just move mid forward
                mid++;
            } 
            else { // nums[mid] == 2
                // Swap current element with 'high' pointer
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                // Move 'high' pointer backward
                high--;
                // Do not move mid forward, check the swapped value
            }

            /*
             Example to understand:

             Suppose nums = [2, 0, 2, 1, 1, 0]

             Initial: low=0, mid=0, high=5

             Step 1: nums[mid] = 2
             Swap nums[mid] with nums[high] → [0,0,2,1,1,2]
             high = 4, mid stays 0

             Step 2: nums[mid] = 0
             Swap nums[mid] with nums[low] → [0,0,2,1,1,2]
             low=1, mid=1

             Step 3: nums[mid] = 0
             Swap nums[mid] with nums[low] → [0,0,2,1,1,2]
             low=2, mid=2

             Step 4: nums[mid] = 2
             Swap nums[mid] with nums[high] → [0,0,1,1,2,2]
             high=3, mid stays 2

             Step 5: nums[mid] = 1
             mid++ → mid=3

             Step 6: nums[mid] = 1
             mid++ → mid=4 (loop ends)

             Final sorted array: [0,0,1,1,2,2]
            */
        }
    }
}
