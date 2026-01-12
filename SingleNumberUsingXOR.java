class Solution {
    // Method to find the single number in an array
    public int singleNumber(int[] nums) {

        int xor = 0; 
        // Initialize a variable 'xor' to 0.
        // This will store the cumulative XOR of all numbers in the array.

        for(int x : nums) {
            // Enhanced for loop to iterate over each element 'x' in the array 'nums'

            xor ^= x; 
            // XOR the current value of 'xor' with the number 'x'
            // XOR properties:
            // 1. x ^ x = 0 -> duplicates cancel out
            // 2. 0 ^ x = x -> initial value starts the XOR process
            // 3. a ^ b ^ a = b -> order doesn’t matter, only the unique number remains
        }

        return xor;
        // After processing all numbers, 'xor' contains the single number
        // Return it as the result
    }
}
