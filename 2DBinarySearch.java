package com.example.DSA_JAVA.BinarySearch;

import java.util.Arrays;

public class TwoDBinarySearch {
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

        int row = 0;                     // we start from the first row
        int col = arr[0].length - 1;     // we start from the last column (top-right corner)

        // loop runs until we go out of matrix boundaries
        while (row < arr.length && col >= 0) {

            // if the current element is equal to target
            if (arr[row][col] == target) {
                return new int[]{row, col};   // target found → return position
            }

            // if current element is smaller than target
            else if (arr[row][col] < target) {
                row++;    // move down because values increase downward
            }

            // if current element is greater than target
            else {
                col--;    // move left because values decrease leftward
            }
        }

        // if target not found in the matrix
        return new int[]{-1, -1};
    }
}
