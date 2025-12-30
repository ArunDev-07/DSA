package com.example.DSA_JAVA.BubbleSort;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {

        // Initialize the array
        int[] arr = {1, 3, 4, 2, 5};

        // Print original array
        System.out.println(Arrays.toString(arr));

        // Call bubble sort function
        bubble(arr);

        // Print sorted array
        System.out.println(Arrays.toString(arr));
    }

    // Bubble Sort function
    static void bubble(int[] arr) {

        boolean swap = false; // flag to check if any swap happens in a pass

        // Outer loop → for each pass
        for (int i = 0; i < arr.length; i++) {

            swap = false; // reset swap flag at the start of each pass

            // Inner loop → compare adjacent elements
            // Last i elements are already sorted, so we reduce the range
            for (int j = 1; j < arr.length - i; j++) {

                // If current element is smaller than previous, swap them
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];    // store current value
                    arr[j] = arr[j - 1];  // put previous value at current index
                    arr[j - 1] = temp;    // put stored value at previous index

                    swap = true; // mark that a swap happened
                }
            }

            // If no swap happened in this pass, array is already sorted → break early
            if (!swap) {
                break;
            }
        }
    }
}
