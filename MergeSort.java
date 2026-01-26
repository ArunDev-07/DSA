package com.example.DSA_JAVA.MergeSort;

import java.util.Arrays;

/*
====================================================
MERGE SORT – FULL EXPLANATION + DRY RUN
====================================================

Merge Sort is a Divide and Conquer algorithm.

Steps:
1. Divide the array into two halves
2. Recursively sort both halves
3. Merge the two sorted halves

Time Complexity  : O(n log n)
Space Complexity: O(n)
Stable Sort     : Yes
In-place        : No
*/

public class MergeSort {

    public static void main(String[] args) {

        // Input array (unsorted)
        int[] arr = {10,9,8,7,6,5,4,3,2,1};

        // Call merge sort
        arr = mergesort(arr);

        // Print sorted array
        System.out.println(Arrays.toString(arr));
    }

    /*
    ------------------------------------------------
    mergesort() function
    ------------------------------------------------
    - Takes an array
    - Divides it into two halves
    - Recursively sorts each half
    - Merges both halves
    */
    static int[] mergesort(int[] arr){

        // BASE CONDITION:
        // If array has only one element,
        // it is already sorted
        if(arr.length == 1){
            return arr;
        }

        // Find middle index
        int mid = arr.length / 2;

        /*
        Divide the array into two parts

        Example:
        arr = [10,9,8,7,6,5,4,3,2,1]
        mid = 5

        left  = [10,9,8,7,6]
        right = [5,4,3,2,1]
        */
        int[] left  = mergesort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergesort(Arrays.copyOfRange(arr, mid, arr.length));

        // Merge the two sorted halves
        return merge(left, right);
    }

    /*
    ------------------------------------------------
    merge() function
    ------------------------------------------------
    - Takes two SORTED arrays
    - Merges them into one SORTED array
    */
    private static int[] merge(int[] left, int[] right) {

        // Pointer for left array
        int i = 0;

        // Pointer for right array
        int j = 0;

        // Pointer for merged array
        int k = 0;

        // Result array
        int[] mix = new int[left.length + right.length];

        /*
        ------------------------------------------------
        MAIN COMPARISON LOOP
        ------------------------------------------------
        Compare elements from left and right arrays
        and place the smaller one into mix[]
        */
        while(i < left.length && j < right.length){

            if(left[i] < right[j]){
                mix[k] = left[i];
                i++;        // move left pointer
            } else {
                mix[k] = right[j];
                j++;        // move right pointer
            }
            k++;            // move merged array pointer
        }

        /*
        ------------------------------------------------
        COPY REMAINING ELEMENTS FROM LEFT ARRAY
        ------------------------------------------------
        If right array is finished first
        */
        while(i < left.length){
            mix[k] = left[i];
            i++;
            k++;
        }

        /*
        ------------------------------------------------
        COPY REMAINING ELEMENTS FROM RIGHT ARRAY
        ------------------------------------------------
        If left array is finished first
        */
        while(j < right.length){
            mix[k] = right[j];
            j++;
            k++;
        }

        // Return merged sorted array
        return mix;
    }
}

/*
====================================================
FULL DRY RUN (IMPORTANT FOR EXAMS)
====================================================

Input:
[10,9,8,7,6,5,4,3,2,1]

DIVIDE PHASE:
[10,9,8,7,6]   [5,4,3,2,1]
[10,9] [8,7,6]   [5,4] [3,2,1]
[10] [9] [8] [7,6] [5] [4] [3] [2,1]
[7] [6]   [2] [1]

MERGE PHASE:
[7] + [6] → [6,7]
[8] + [6,7] → [6,7,8]
[10] + [9] → [9,10]
[9,10] + [6,7,8] → [6,7,8,9,10]

[2] + [1] → [1,2]
[3] + [1,2] → [1,2,3]
[5] + [4] → [4,5]
[4,5] + [1,2,3] → [1,2,3,4,5]

FINAL MERGE:
[6,7,8,9,10] + [1,2,3,4,5]
→ [1,2,3,4,5,6,7,8,9,10]

OUTPUT:
[1,2,3,4,5,6,7,8,9,10]
====================================================
*/
