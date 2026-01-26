package com.example.DSA_JAVA.MergeSort;

import java.util.Arrays;

/*
Merge Sort Explanation:

Merge Sort is a Divide & Conquer algorithm:
1. Divide the array into two halves until each subarray has one element.
2. Base case: a single-element array is already sorted.
3. Merge the sorted left and right halves into a sorted array.

Time Complexity: O(n log n) in all cases
Space Complexity: O(n log n) due to temporary arrays created during merging
Stable: Yes (preserves order of equal elements)

Dry Run Example:
Array: [10, 9, 8]

Step 1: Divide
mergesort([10,9,8], 0, 2)
mid = 1
Left: mergesort([10,9,8], 0, 1)
Right: mergesort([10,9,8], 2, 2)

Step 2: Left Subarray
mergesort([10,9,8], 0, 1)
mid = 0
Left Left: mergesort([10,9,8], 0, 0) → returns [10]
Left Right: mergesort([10,9,8], 1, 1) → returns [9]
Merge([10],[9]) → [9,10]

Step 3: Right Subarray
mergesort([10,9,8], 2, 2) → returns [8]

Step 4: Merge Left & Right
Merge([9,10],[8]) → [8,9,10]
*/

public class MergeSort {

    public static void main(String[] args){
        // Original unsorted array
        int[] arr = {10,9,8,7,6,5,4,3,2,1} ;

        // Call mergesort on the full array (from index 0 to arr.length-1)
        arr = mergesort(arr , 0 , arr.length-1) ;

        // Print the sorted array
        System.out.println(Arrays.toString(arr)) ;
    }

    // Recursive Merge Sort function
    static int[] mergesort(int[] arr , int s , int e){
        // Base case: if subarray has 1 element, return it as a new array
        if(s >= e){
            return new int[]{arr[s]} ;
        }

        // Find middle index to divide array
        int mid = (s + e) / 2 ;

        // Recursively sort left subarray (from start to mid)
        int[] left = mergesort(arr , s , mid);

        // Recursively sort right subarray (from mid+1 to end)
        int[] right = mergesort(arr, mid + 1 , e) ;

        // Merge the sorted left and right arrays
        return merge(left , right) ;
    }

    // Merge function to combine two sorted arrays into one sorted array
    private static int[] merge(int[] left, int[] right) {
        int i = 0; // pointer for left array
        int j = 0; // pointer for right array
        int k = 0; // pointer for merged array

        int[] mix = new int[left.length + right.length] ; // result array

        // Compare elements from left and right arrays and put smaller one into mix
        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                mix[k] = left[i] ;
                i++ ;
            } else {
                mix[k] = right[j] ;
                j++ ;
            }
            k++ ;
        }

        // Copy any remaining elements from left array
        while(i < left.length){
            mix[k] = left[i] ;
            i++;
            k++ ;
        }

        // Copy any remaining elements from right array
        while(j < right.length){
            mix[k] = right[j] ;
            j++ ;
            k++ ;
        }

        // Return merged sorted array
        return mix ;
    }
}

/*
Dry Run Summary:

Input: [10,9,8,7,6,5,4,3,2,1]

Step 1: Divide array into halves until single elements:
[10,9,8,7,6] and [5,4,3,2,1]
... keep dividing ...
[10],[9],[8],[7],[6],[5],[4],[3],[2],[1]

Step 2: Merge single elements:
[10] + [9] → [9,10]
[8] + [7] → [7,8]
[6] remains

Step 3: Merge next level:
[9,10] + [7,8] → [7,8,9,10]
[6] + [5,4,3,2,1] ... continue merging

Final Output: [1,2,3,4,5,6,7,8,9,10]
*/
