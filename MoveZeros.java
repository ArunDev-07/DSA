import java.util.* ;
class Solution {
    public void moveZeroes(int[] nums) {

        // index is used to track where the next non-zero element should be placed
        // initially it starts at 0 (beginning of the array)
        int index = 0;

        // loop through the entire array
        for(int i = 0; i < nums.length; i++){

            // if the current element is NOT zero
            if(nums[i] != 0){

                // place the non-zero element at the index position
                // this shifts all non-zero values to the front
                nums[index] = nums[i];

                // move index forward to store the next non-zero element
                index++;
            }
        }

        // after placing all non-zero elements,
        // the remaining positions should be filled with zeros
        while(index < nums.length){

            // set the remaining elements as zero
            nums[index] = 0;

            // move index forward
            index++;
        }
    }
}
