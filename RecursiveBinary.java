package com.example.DSA_JAVA.Recursion;

public class RecursiveBS {

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};   // Descending sorted array
        int target = 7;

        // Calling recursive binary search
        int result = Binary(arr, target, 0, 6);

        // Printing index of target
        System.out.println(result);
    }

    static int Binary(int[] arr, int target, int s, int e){

        // Base case: element not found
        if(s > e){
            return -1;
        }

        // Find middle index safely
        int m = s + (e - s) / 2;

        // If middle element is target
        if(arr[m] == target){
            return m;
        }

        // Recursive calls
        if(target > arr[m]){
            return Binary(arr, target, m + 1, e);
        } else {
            return Binary(arr, target, s, m - 1);
        }
    }
}
