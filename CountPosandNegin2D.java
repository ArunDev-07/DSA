package com.example.DSA_JAVA.BinarySearch; 
// Package declaration – groups related classes together

public class MaxPosNegCount {
    // Main class

    public static void main(String []args){
        // Main method – program execution starts here

        int[] arr = {-2,-1,-1,1,2,3};
        // Input array containing negative and positive numbers

        int pos = 0;
        // Variable to count positive numbers

        int neg = 0;
        // Variable to count negative numbers

        for(int i = 0; i < arr.length; i++){
            // Loop through each element of the array

            if(arr[i] < 0){
                // If current element is negative
                neg++;
                // Increment negative count
            }
            else if(arr[i] > 0){
                // If current element is positive
                pos++;
                // Increment positive count
            }
            // Zero is ignored because it is neither positive nor negative
        }

        System.out.println(Math.max(pos, neg));
        // Print the maximum count between positive and negative numbers
    }
}
