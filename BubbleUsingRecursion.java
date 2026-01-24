package com.example.DSA_JAVA.Recursion;

import java.util.Arrays;

public class BubbleUsingRecusion {

    public static void main(String[] args) {

        /*
         * Initial Array:
         * [3, 4, 2, 1, 5, 6, 7, 8, 9]
         */
        int[] arr = {3, 4, 2, 1, 5, 6, 7, 8, 9};

        /*
         * Function Call Explanation:
         * r = arr.length - 1  → last index of unsorted part
         * c = 0               → starting index
         */
        Bubble(arr, arr.length - 1, 0);

        // Final sorted array
        System.out.println(Arrays.toString(arr));
    }

    static void Bubble(int[] arr, int r, int c) {

        /*
         * BASE CASE:
         * When r == 0, only one element is left.
         * An array with one element is already sorted.
         */
        if (r == 0) {
            return;
        }

        /*
         * INNER LOOP LOGIC (using recursion)
         * Compare adjacent elements while c < r
         */
        if (c < r) {

            /*
             * Compare arr[c] and arr[c+1]
             * If left element is greater, swap them
             */
            if (arr[c] > arr[c + 1]) {
                int temp = arr[c];
                arr[c] = arr[c + 1];
                arr[c + 1] = temp;
            }

            /*
             * Move to next index (c + 1)
             * Same pass continues
             */
            Bubble(arr, r, c + 1);

        } else {

            /*
             * ONE FULL PASS COMPLETED
             *
             * After this pass:
             * - The largest element is placed at index r
             * - So the last index is now in correct position
             *
             * Reduce the problem size:
             * r = r - 1
             * Start next pass from index 0
             */
            Bubble(arr, r - 1, 0);
        }
    }
}

/*
====================== DRY RUN ======================

Initial Array:
[3, 4, 2, 1, 5, 6, 7, 8, 9]

Call: Bubble(arr, 8, 0)

PASS 1 (r = 8):
c=0 → 3 vs 4 → no swap
c=1 → 4 vs 2 → swap → [3,2,4,1,5,6,7,8,9]
c=2 → 4 vs 1 → swap → [3,2,1,4,5,6,7,8,9]
c=3 → 4 vs 5 → no swap
c=4..7 → already sorted

Largest element 9 fixed at index 8

PASS 2 (r = 7):
c=0 → 3 vs 2 → swap → [2,3,1,4,5,6,7,8,9]
c=1 → 3 vs 1 → swap → [2,1,3,4,5,6,7,8,9]
c=2..6 → no swaps

Largest element 8 fixed at index 7

PASS 3 (r = 6):
c=0 → 2 vs 1 → swap → [1,2,3,4,5,6,7,8,9]

Array is now sorted

Remaining passes:
r = 5,4,3,2,1 → no swaps

Base case reached:
Bubble(arr, 0, 0) → return

Final Output:
[1, 2, 3, 4, 5, 6, 7, 8, 9]

====================================================
*/

/*
================== KEY POINTS ==================

1. r represents the outer loop (number of passes)
2. c represents the inner loop (adjacent comparison)
3. Each pass places the largest element at the end
4. After each pass, r is reduced
5. Recursion replaces both for-loops
6. Time Complexity: O(n^2)
7. Space Complexity: O(n) due to recursion stack

===============================================
*/
