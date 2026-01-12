class Solution {
    public int thirdMax(int[] nums) {

        // Use long to safely initialize with the smallest possible value
        long first  = Long.MIN_VALUE;   // stores the largest number
        long second = Long.MIN_VALUE;   // stores the 2nd largest number
        long third  = Long.MIN_VALUE;   // stores the 3rd largest number

        // Traverse each number in the array
        for (int num : nums) {

            // Case 1: current number is greater than the largest
            if (num > first) {
                // shift values down
                third = second;     // old 2nd max becomes 3rd max
                second = first;     // old max becomes 2nd max
                first = num;        // current number becomes max
            }

            // Case 2: current number is between first and second
            // num != first avoids duplicate values
            else if (num > second && num != first) {
                third = second;     // old 2nd max becomes 3rd max
                second = num;       // current number becomes 2nd max
            }

            // Case 3: current number is between second and third
            // num != first and num != second avoid duplicates
            else if (num > third && num != first && num != second) {
                third = num;        // current number becomes 3rd max
            }
        }

        // If third max exists, return it
        // Otherwise return the maximum number
        // Explicit cast is required because variables are long
        return (int)(third != Long.MIN_VALUE ? third : first);
    }
}
