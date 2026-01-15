class Solution {
    public boolean isPowerOfFour(int n) {

        // Step 1: Negative numbers and 0 cannot be powers of 4
        if (n < 1) {
            return false;
        }

        // Step 2: Keep dividing n by 4 as long as it is divisible by 4
        while (n % 4 == 0) {  // the condtion runs until while the n % 4 == 0  if it is n = n / 4 then again we get the n like that it runs until the n == 1 if it is 1 it is true otherwise it is false.
            n = n / 4;          //like this the powerof2 and powerof3
        }

        // Step 3: If after divisions n becomes exactly 1,
        // then n is a power of 4
        return n == 1;
    }
}
