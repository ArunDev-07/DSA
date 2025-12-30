package com.example.DSA_JAVA.BinarySearch;

import java.util.Arrays;

public class TwoDBinarySearch1D {
    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        int target = 7;
        int[] result = search(arr, target);
        System.out.println(Arrays.toString(result));
    }

    static int[] search(int[][] arr, int target) {

        int rows = arr.length;           // total number of rows
        int cols = arr[0].length;        // total number of columns

        int start = 0;                   // start index of virtual 1D array
        int end = rows * cols - 1;       // end index of virtual 1D array

        // binary search loop
        while (start <= end) {

            int mid = start + (end - start) / 2;

            // convert 1D index to 2D row and column
            int row = mid / cols;
            int col = mid % cols;

            // if target found
            if (arr[row][col] == target) {
                return new int[]{row, col};
            }

            // if current value is smaller than target
            else if (arr[row][col] < target) {
                start = mid + 1;         // move right in 1D array
            }

            // if current value is greater than target
            else {
                end = mid - 1;           // move left in 1D array
            }
        }

        // target not found
        return new int[]{-1, -1};
    }
}
