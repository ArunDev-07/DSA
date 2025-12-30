class Solution {
    public int maximumCount(int[] nums) {

        // to store count of positive numbers
        int positive = 0;

        // to store count of negative numbers
        int negative = 0; 

        // loop through all elements in the array
        for (int i = 0; i < nums.length; i++) {

            // if current number is less than 0
            // then it is a negative number
            if (nums[i] < 0) {
                negative++;   // increase negative count
            }

            // if current number is greater than 0
            // then it is a positive number
            else if (nums[i] > 0) {
                positive++;   // increase positive count
            }

            // if number is 0
            // do nothing because 0 is neither positive nor negative
        }

        // return the maximum count between positive and negative
        return Math.max(positive, negative);
    }
}
