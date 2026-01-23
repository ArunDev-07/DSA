package com.example.DSA_JAVA.Recursion;

public class RotatedBinaryUsingRecursion {

    public static void main(String[] args) {

        /*
         Example Rotated Sorted Array:
         Index:  0  1  2  3  4  5  6  7
         Array: {5, 6, 7, 8, 9, 1, 2, 3}

         This array was originally sorted:
         {1, 2, 3, 5, 6, 7, 8, 9}
         and then rotated.

         Target = 9
         Expected Output Index = 4
        */

        int[] arr = {5, 6, 7, 8, 9, 1, 2, 3};
        int target = 9;

        System.out.println(RotateRec(arr, target, 0, arr.length - 1));
    }

    static int RotateRec(int[] arr, int target, int s, int e) {

        /*
         BASE CASE:
         If start index goes beyond end index,
         it means target is not present.
        */
        if (s > e) {
            return -1;
        }

        // Find middle index
        int mid = s + (e - s) / 2;

        /*
         Example:
         First call → s=0, e=7
         mid = 3 → arr[mid] = 8
        */

        // If target found at mid
        if (arr[mid] == target) {
            return mid;
        }

        /*
         CHECK WHICH HALF IS SORTED
         --------------------------------
         If arr[s] <= arr[mid], then LEFT HALF is sorted
        */
        if (arr[s] <= arr[mid]) {

            /*
             Left half sorted example:
             arr[s]=5, arr[mid]=8  → sorted
            */

            // Check if target lies in left half range
            if (target >= arr[s] && target < arr[mid]) {

                /*
                 Target lies between arr[s] and arr[mid]
                 So search LEFT HALF
                */
                return RotateRec(arr, target, s, mid - 1);

            } else {

                /*
                 Target NOT in left half
                 So search RIGHT HALF
                */
                return RotateRec(arr, target, mid + 1, e);
            }

        }
        /*
         ELSE → RIGHT HALF IS SORTED
        */
        else {

            /*
             Right half sorted example:
             arr[mid]=1, arr[e]=3 → sorted
            */

            // Check if target lies in right half range
            if (target > arr[mid] && target <= arr[e]) {

                /*
                 Target lies between arr[mid] and arr[e]
                 So search RIGHT HALF
                */
                return RotateRec(arr, target, mid + 1, e);

            } else {

                /*
                 Target NOT in right half
                 So search LEFT HALF
                */
                return RotateRec(arr, target, s, mid - 1);
            }
        }
    }
}
