package com.example.DSA_JAVA.Insertion;

import java.util.Arrays;

public class Insertion {

    public static void main(String[] args) {
        // Step 1: Create an array to sort
        int[] arr = {1, 4, 5, 3, 2};

        // Step 2: Call the insertion sort method
        insertionSort(arr);

        // Step 3: Print the sorted array
        System.out.println(Arrays.toString(arr)); // Output: [1, 2, 3, 4, 5]
    }

    // Step 4: Insertion Sort Method
    static void insertionSort(int[] arr) {
        // Loop through the array, starting from index 0 to second last
        for (int i = 0; i < arr.length - 1; i++) {
            // Step 4a: Pick the element at i+1 to insert it into the sorted portion
            for (int j = i + 1; j > 0; j--) {
                // Step 4b: Compare current element with previous
                if (arr[j] < arr[j - 1]) {
                    // Step 4c: Swap if current element is smaller than previous
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;

                    // Step 4d: Now element has moved one position left, j-- continues
                } else {
                    // Step 4e: Stop moving left if element >= previous element
                    break;
                }
            }
        }
    }
}
