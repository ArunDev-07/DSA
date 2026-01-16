class Solution {

    public int[] countBits(int n) {

        // Create an array to store count of 1s for numbers 0 to n
        // Size is n+1 because we need indices from 0 to n
        int[] ans = new int[n + 1];

        // Start from 1 because ans[0] is already 0 by default
        for (int i = 1; i <= n; i++) {

            /*
             i >> 1  : Right shift removes the last binary bit of i
                       (same as dividing i by 2)

             ans[i >> 1] :
                       Number of 1s in the binary representation of i/2
                       (already computed earlier)

             i & 1   : Bitwise AND checks the last binary bit of i
                       - returns 1 if i is odd
                       - returns 0 if i is even

             ans[i]  : Total number of 1s in i
                       = number of 1s in i/2 + last bit of i
            */
            ans[i] = ans[i >> 1] + (i & 1);
        }

        // Return the result array
        return ans;
    }
}
