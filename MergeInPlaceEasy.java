package com.example.DSA_JAVA.MergeSort;

import java.util.Arrays;

public class ProductMergeSort {

    public static void main(String[] args){
        // Original array to sort
        int[] arr = {5,4,3,2,1};

        // Call merge sort on the whole array (0 to length)
        mergsort(arr , 0 , arr.length);

        // Print the sorted array
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Merge Sort function
     * @param arr -> array to sort
     * @param s   -> start index (inclusive)
     * @param e   -> end index (exclusive)
     *
     * Explanation:
     * Merge sort works recursively:
     * 1. If the subarray has 1 or 0 elements, it's already sorted (base case)
     * 2. Otherwise, split the array into two halves
     * 3. Sort each half recursively
     * 4. Merge the two sorted halves
     */
    static void mergsort(int[] arr, int s, int e) {
        // Base case: if subarray has 1 element, return
        if((e - s) <= 1){
            return;
        }

        // Find middle index
        int mid = (s + e) / 2;

        // Recursively sort left half
        mergsort(arr , s , mid);

        // Recursively sort right half
        mergsort(arr , mid, e);

        // Merge the two sorted halves
        merge(arr , s , e , mid);
    }

    /**
     * Merge function
     * @param arr -> original array
     * @param s   -> start index of subarray
     * @param e   -> end index of subarray (exclusive)
     * @param mid -> middle index to split subarray
     *
     * Explanation:
     * - Two pointers i and j traverse the left and right subarrays
     * - Compare elements and put the smaller one into a temporary array "mix"
     * - After one subarray is exhausted, copy the remaining elements from the other
     * - Finally, copy "mix" back into the original array at the correct position
     */
    static void merge(int[] arr , int s , int e , int mid){
        int i = s;      // pointer for left subarray
        int j = mid;    // pointer for right subarray
        int k = 0;      // pointer for temporary array
        int[] mix = new int[e - s]; // temporary array to hold merged elements

        // Merge elements from left and right subarrays
        while(i < mid && j < e){
            if(arr[i] < arr[j]){
                mix[k++] = arr[i++];
            } else {
                mix[k++] = arr[j++];
            }
        }

        // Copy remaining elements from left subarray (if any)
        while(i < mid){
            mix[k++] = arr[i++];
        }

        // Copy remaining elements from right subarray (if any)
        while(j < e){
            mix[k++] = arr[j++];
        }

        // Copy the merged sorted elements back into the original array
        System.arraycopy(mix, 0, arr, s, mix.length);
        // Equivalent to:
        // for(int a = 0; a < mix.length; a++){
        //     arr[s + a] = mix[a];
        // }
    }

    /**
     * Example Dry Run for arr = [5,4,3,2,1]
     *
     * Step 1: Split [5,4,3,2,1] -> left [5,4] and right [3,2,1]
     *
     * Step 2: Sort left [5,4]
     *   - Split [5,4] -> [5] and [4]
     *   - Merge [5] and [4] -> mix = [4,5]
     *   - Copy back -> arr[0..1] = [4,5]
     *   - Array now: [4,5,3,2,1]
     *
     * Step 3: Sort right [3,2,1]
     *   - Split [3,2,1] -> left [3] and right [2,1]
     *   - Sort [2,1] -> mix = [1,2], copy back -> arr[3..4] = [1,2]
     *   - Merge [3] and [1,2] -> mix = [1,2,3], copy back -> arr[2..4] = [1,2,3]
     *   - Array now: [4,5,1,2,3]
     *
     * Step 4: Merge [4,5] and [1,2,3]
     *   - Compare 4 vs 1 -> pick 1
     *   - Compare 4 vs 2 -> pick 2
     *   - Compare 4 vs 3 -> pick 3
     *   - Compare 4 vs end -> pick 4
     *   - Compare 5 vs end -> pick 5
     *   - Copy back -> arr[0..4] = [1,2,3,4,5]
     *
     * ✅ Final sorted array: [1,2,3,4,5]
     */
//     s comes from the array index.
// When we do s + a, the values are placed starting from index s up to e - 1,
// NOT from index 0.
}
