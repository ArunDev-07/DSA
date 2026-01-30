// ===============================
// PROBLEM:
// Find the LENGTH of the LARGEST CONTIGUOUS SUBARRAY
// whose SUM is exactly equal to k
//
// Array can contain POSITIVE & NEGATIVE numbers
// ===============================

import java.util.*;

class Main {
    public static void main(String[] args) {

        // Given array
        int[] arr = {3, 2, 4, -2, 4, 1, 1};

        // Target sum
        int k = 6;

        // max will store the maximum length found
        int max = 0;

        // Outer loop decides the STARTING index of subarray
        for (int i = 0; i < arr.length; i++) {

            // sum starts from 0 for every new starting index
            int sum = 0;

            // Inner loop decides the ENDING index of subarray
            for (int j = i; j < arr.length; j++) {

                // Add current element to sum
                sum += arr[j];

                // If sum becomes equal to k
                if (sum == k) {

                    // Length of current subarray
                    int len = j - i + 1;

                    // Update maximum length
                    max = Math.max(len, max);
                }
            }
        }

        // Final answer
        System.out.println("Length of largest contiguous subarray = " + max);
    }
}

/*
====================================================
EXPLANATION (PARAGRAPH):

We use two nested loops to generate all possible
contiguous subarrays. The outer loop selects the
starting index, and the inner loop extends the
subarray by adding elements one by one. For each
subarray, we calculate the sum. If the sum becomes
equal to k, we calculate the length of that subarray
using (end - start + 1) and update the maximum
length found so far.

This approach works for both positive and negative
numbers but has O(n²) time complexity.
====================================================

DRY RUN:

arr = {3, 2, 4, -2, 4, 1, 1}
k = 6

i = 0
sum = 0
j=0 → sum = 3
j=1 → sum = 5
j=2 → sum = 9
j=3 → sum = 7
j=4 → sum = 11
j=5 → sum = 12
j=6 → sum = 13
(no match)

i = 1
sum = 0
j=1 → sum = 2
j=2 → sum = 6  ✅
length = 2 (indexes 1 to 2)
max = 2

i = 2
sum = 0
j=2 → sum = 4
j=3 → sum = 2
j=4 → sum = 6  ✅
length = 3 (indexes 2 to 4)
max = 3

i = 3
sum = 0
j=3 → sum = -2
j=4 → sum = 2
j=5 → sum = 3
j=6 → sum = 4
(no match)

i = 4
sum = 0
j=4 → sum = 4
j=5 → sum = 5
j=6 → sum = 6  ✅
length = 3 (indexes 4 to 6)
max = 3

Final Answer = 3
====================================================

VISUAL EXAMPLE:

Indexes:  0  1  2   3  4  5  6
Array:   [3, 2, 4, -2, 4, 1, 1]

Valid subarrays with sum = 6:

[2, 4]          → length = 2
[4, -2, 4]      → length = 3
[4, 1, 1]       → length = 3

Largest length = 3
====================================================

TIME COMPLEXITY:  O(n²)
SPACE COMPLEXITY: O(1)

NOTE:
This solution is ACCEPTABLE for learning,
but LeetCode expects O(n) using Prefix Sum + HashMap.
====================================================
*/
