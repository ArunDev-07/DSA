package com.example.DSA_JAVA.MergeSort;

import java.util.Arrays;

/*
========================================================
IN-PLACE MERGE SORT (USING TEMP ARRAY)
========================================================

🔹 WHAT THIS PROGRAM DOES
-------------------------
This program sorts an integer array using Merge Sort.
It uses:
- Recursion for divide step
- A single temporary array for merging
- Index-based merging (NO copyOfRange)

This is called "in-place merge sort" in interviews
(because original array is modified).

--------------------------------------------------------
TIME & SPACE COMPLEXITY
--------------------------------------------------------
Time Complexity  : O(n log n)
Space Complexity : O(n)  -> temp array

--------------------------------------------------------
WHY THIS VERSION IS IMPORTANT FOR INTERVIEWS
--------------------------------------------------------
✔ No extra subarrays created
✔ Memory efficient
✔ Shows strong understanding of recursion
✔ Preferred answer in product-based companies
========================================================
*/

public class ProductMergeSort {

    public static void main(String[] args) {

        // Input array
        int[] arr = {5, 4, 3, 2, 1};

        // Temporary array (created once)
        int[] temp = new int[arr.length];

        // Call merge sort
        mergeSort(arr, 0, arr.length - 1, temp);

        // Print sorted array
        System.out.println(Arrays.toString(arr));
    }

    /*
    --------------------------------------------------------
    mergeSort FUNCTION (DIVIDE STEP)
    --------------------------------------------------------
    arr  -> original array
    s    -> start index
    e    -> end index
    temp -> helper array
    */
    static void mergeSort(int[] arr, int s, int e, int[] temp) {

        // BASE CASE
        // If only one element, it is already sorted
        if (s >= e) {
            return;
        }

        // Find middle index safely
        int mid = s + (e - s) / 2;

        // Recursively sort left half
        mergeSort(arr, s, mid, temp);

        // Recursively sort right half
        mergeSort(arr, mid + 1, e, temp);

        // Merge the two sorted halves
        merge(arr, s, mid, e, temp);
    }

    /*
    --------------------------------------------------------
    merge FUNCTION (CONQUER STEP)
    --------------------------------------------------------
    arr  -> original array
    s    -> start index
    mid  -> middle index
    e    -> end index
    temp -> helper array
    */
    static void merge(int[] arr, int s, int mid, int e, int[] temp) {

        // Pointer for left subarray
        int i = s;

        // Pointer for right subarray
        int j = mid + 1;

        // Pointer for temp array
        int k = s;

        // Compare elements from both halves
        while (i <= mid && j <= e) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from left half
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        // Copy remaining elements from right half
        while (j <= e) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        // Copy sorted data back to original array
        for (int index = s; index <= e; index++) {
            arr[index] = temp[index];
        }
    }
}

/*
========================================================
DRY RUN (STEP BY STEP)
========================================================

Input:
arr = [5, 4, 3, 2, 1]

STEP 1:
mergeSort(arr, 0, 4)
mid = 2

Left  -> mergeSort(0, 2)
Right -> mergeSort(3, 4)

--------------------------------------------------------
STEP 2: Sort Left Half (0 → 2)
--------------------------------------------------------
mergeSort(0,2)
mid = 1

Left  -> mergeSort(0,1)
Right -> mergeSort(2,2)

mergeSort(0,1):
mid = 0
Left  -> (0,0) return
Right -> (1,1) return

Merge [5] and [4]
temp = [4,5]
arr  = [4,5,3,2,1]

mergeSort(2,2) → return

Merge [4,5] and [3]
temp = [3,4,5]
arr  = [3,4,5,2,1]

--------------------------------------------------------
STEP 3: Sort Right Half (3 → 4)
--------------------------------------------------------
mergeSort(3,4)
mid = 3

Merge [2] and [1]
temp = [1,2]
arr  = [3,4,5,1,2]

--------------------------------------------------------
STEP 4: FINAL MERGE
--------------------------------------------------------
Merge [3,4,5] and [1,2]

Comparisons:
1 → temp
2 → temp
3 → temp
4 → temp
5 → temp

Final:
arr = [1,2,3,4,5]

========================================================
FINAL OUTPUT
========================================================
[1, 2, 3, 4, 5]
========================================================
*/
