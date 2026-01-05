package com.example.DSA_JAVA.CyclicSort;

import java.util.Arrays;

public class CyclicSort {

    public static void main(String[] args) {

        // Input array containing numbers from 1 to N in unsorted order
        int[] arr = {1, 3, 4, 2, 5};

        // Call cyclic sort method to sort the array in-place
        Cyclic(arr);

        // Print the sorted array
        System.out.println(Arrays.toString(arr));
    }

    static void Cyclic(int[] arr) {

        int i = 0; // pointer to track current index

        // Loop until the pointer reaches the end of the array
        while (i < arr.length) {

            // Calculate the correct index for the current value
            // If value is x, its correct index is x - 1
            int correct = arr[i] - 1;

            // If the current value is NOT in its correct position
            if (arr[i] != arr[correct]) {

                // Swap the current element with the element at its correct index
                Swap(arr, i, correct);

                // Do NOT increment i here
                // After swap, a new element comes to index i
                // That new element must be checked again
            } else {

                // If the element is already in the correct position
                // Move to the next index
                i++;
            }
        }
    }

    static void Swap(int[] arr, int i, int correct) {

        // Store current element in a temporary variable
        int temp = arr[i];

        // Place the correct element at index i
        arr[i] = arr[correct];

        // Place the temp value at its correct index
        arr[correct] = temp;
    }
}
