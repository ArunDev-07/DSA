package com.example.DSA_JAVA.Recursion;

import java.util.ArrayList;

public class SortedRecusionArray {

    public static void main(String[] args) {

        // Given sorted array
        int[] arr = {1, 2, 3, 3, 5, 6};

        // Target element to search
        int target = 3;

        // 1️⃣ Recursive Linear Search (returns first index of target)
        System.out.println(Lsearch(arr, target, 0));

        // 2️⃣ Check whether the array is sorted
        System.out.println(Sort(arr, 0));

        // 3️⃣ Find all indexes where target occurs
        System.out.println(listsearch(arr, target, 0, new ArrayList<>()));
    }

    // 🔍 Recursive Linear Search
    static int Lsearch(int[] arr, int t, int i) {

        // Base condition: reached end of array, target not found
        if (i == arr.length - 1) {
            return -1;
        }

        // If current element matches target, return index
        if (arr[i] == t) {
            return i;
        }

        // Recursive call: move to next index
        return Lsearch(arr, t, i + 1);
    }

    // ✅ Check if array is sorted using recursion
    static boolean Sort(int[] arr, int i) {

        // Base condition: reached last element
        if (i == arr.length - 1) {
            return true;
        }

        // If current element is greater than next, array is not sorted
        if (arr[i] > arr[i + 1]) {
            return false;
        }

        // Recursive call: check next pair
        return Sort(arr, i + 1);
    }

    // 📋 Find all occurrences of target and store indexes in ArrayList
    static ArrayList<Integer> listsearch(int[] arr, int t, int i, ArrayList<Integer> list) {

        // Base condition: reached end of array
        if (i == arr.length - 1) {
            return list;
        }

        // If current element matches target, store index
        if (arr[i] == t) {
            list.add(i);
        }

        // Recursive call to move forward
        listsearch(arr, t, i + 1, list);

        // Return the list containing all matching indexes
        return list;
    }
}
