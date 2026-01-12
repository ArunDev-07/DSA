class Solution {
    public int[] plusOne(int[] digits) {

        // Start from the last digit (rightmost)
        for (int i = digits.length - 1; i >= 0; i--) {

            // If the current digit is less than 9
            // we can safely add 1 without carry
            if (digits[i] < 9) {
                digits[i]++;        // add 1 to the digit
                return digits;      // return immediately (no more changes needed)
            }

            // If digit is 9, adding 1 makes it 0
            // carry will move to the next left digit
            digits[i] = 0;
        }

        // If we reach here, all digits were 9
        // Example: [9,9,9] -> [1,0,0,0]

        // Create a new array with one extra space
        int[] result = new int[digits.length + 1];

        // Set the first digit to 1 (carry overflow)
        result[0] = 1;

        // Remaining digits are already 0 by default
        return result;
    }
}
