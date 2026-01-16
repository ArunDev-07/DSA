class Solution {
    public int hammingWeight(int n) {
        int count = 0;   // stores number of 1s in binary representation

        while (n != 0) { // loop until all bits are processed

            // n % 2 checks whether n is odd or even
            // even number  -> last binary bit is 0
            // odd number   -> last binary bit is 1
            if (n % 2 == 0) {
                count += 0;  // last bit is 0 → do nothing
            } else {
                count += 1;  // last bit is 1 → increment count
            }

            // Right shift operator (>>)
            // removes the last binary bit of n
            // equivalent to dividing n by 2
            n >>= 1;
        }

        return count; // return total number of 1s
    }
}
//count += n & 1;
