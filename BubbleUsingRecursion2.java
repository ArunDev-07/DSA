package com.example.DSA_JAVA.Recursion;

import java.util.Arrays;

public class BubbleUsingRecursion {

    /*
     This program implements Bubble Sort using recursion.

     Explanation based on your understanding:

     - The variable 'r' represents the last unsorted index of the array.
     - The variable 'c' represents the current index used for comparison.
     - In each pass, the largest element is pushed to the end of the array.
     - Once the largest element is fixed at the last position, 'r' is reduced.
     - The process repeats until 'r' becomes 0, which means the array is fully sorted.
    */

    public static void main(String[] args) {

        // Example unsorted array
        int[] arr = {3, 4, 2, 1, 5, 6, 7, 8, 9};

        /*
         We start the recursive bubble sort:
         - r is set to arr.length - 1 (last index)
         - c is set to 0 (starting index)
        */
        bubble(arr, arr.length - 1, 0);

        // Print the sorted array
        System.out.println(Arrays.toString(arr));
    }

    static void bubble(int[] arr, int r, int c) {

        /*
         BASE CONDITION:
         When r == 0, it means sorting has completed from
         the last index up to the first index.
         All elements are now in sorted order, so recursion stops.
        */
        if (r == 0) {
            return;
        }

        /*
         If c < r, we are still inside the current pass.
         This works like the inner loop of bubble sort.

         - Compare arr[c] and arr[c + 1]
         - If they are not in correct order, swap them
         - Move to the next index by calling recursion with c + 1
        */
        if (c < r) {

            if (arr[c] > arr[c + 1]) {
                int temp = arr[c];
                arr[c] = arr[c + 1];
                arr[c + 1] = temp;
            }

            bubble(arr, r, c + 1);

        } else {

            /*
             When c reaches r, it means:
             - The largest element of this pass is placed at index r
             - The last index is now fixed and sorted

             So:
             - Reduce r by 1 (ignore the sorted element)
             - Reset c to 0 and start the next pass
            */
            bubble(arr, r - 1, 0);
        }
    }

    /*
     EXAMPLE DRY RUN:

     Initial Array: {3, 4, 2, 1}

     Pass 1 (r = 3):
     - Compare 3 and 4 -> no swap
     - Compare 4 and 2 -> swap
     - Compare 4 and 1 -> swap
     Result: {3, 2, 1, 4} -> 4 is fixed

     Pass 2 (r = 2):
     - Compare 3 and 2 -> swap
     - Compare 3 and 1 -> swap
     Result: {2, 1, 3, 4} -> 3 is fixed

     Pass 3 (r = 1):
     - Compare 2 and 1 -> swap
     Result: {1, 2, 3, 4}

     r == 0 -> recursion stops
     Array is fully sorted
    */
}
