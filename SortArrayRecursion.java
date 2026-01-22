package com.example.DSA_JAVA.Recursion;

public class SortedRecursionArray {

    public static void main(String[] args){
        int[] arr = {1,2,4,3,6,5};
        System.out.println(isSorted(arr, 0));
    }

    static boolean isSorted(int[] arr, int i){
        // Base case: if we reach the last element, array is sorted
        if(i == arr.length - 1){
            return true;
        }

        // If current element > next element → array is not sorted
        if(arr[i] > arr[i + 1]){
            return false;
        }

        // Recurse for the rest of the array
        return isSorted(arr, i + 1);
    }
}
