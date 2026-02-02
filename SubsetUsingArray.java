package com.example.DSA_JAVA.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * This class demonstrates how to generate all subsets (power set)
 * of a given integer array using an iterative approach.
 *
 * Key Idea:
 * 1. Start with an empty subset: [[]]
 * 2. For each element in the array:
 *    - Take all existing subsets in 'outer'
 *    - Create a new subset by adding the current element to each existing subset
 *    - Add these new subsets to 'outer'
 * 3. Continue until all elements are processed
 *
 * Example:
 * Input: [1, 2, 3]
 * Output: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
 */
public class SubsetUsingArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        // Call function to generate all subsets
        List<List<Integer>> ans = Arrsub(arr);

        // Print the resulting list of subsets
        System.out.println(ans);
    }

    /**
     * Function to generate all subsets of an array iteratively
     *
     * @param arr Input integer array
     * @return List of all subsets
     */
    static List<List<Integer>> Arrsub(int[] arr) {
        // 'outer' stores all subsets
        List<List<Integer>> outer = new ArrayList<>();

        // Step 1: Start with empty subset
        outer.add(new ArrayList<>());

        // Step 2: Iterate over each element in the array
        for (int num : arr) {
            int n = outer.size(); // Number of subsets already present

            // Step 3: For each existing subset, create a new subset including current number
            for (int i = 0; i < n; i++) {
                // Copy existing subset
                List<Integer> internal = new ArrayList<>(outer.get(i));

                // Add current number to the new subset
                internal.add(num);

                // Add the new subset to 'outer'
                outer.add(internal);
            }
        }

        // Step 4: Return all subsets
        return outer;
    }
}

/*
==========================
EXPLANATION:

We are generating all subsets of [1, 2, 3] iteratively.

Step-by-step dry run:

Initial:
outer = [[]]  // only empty subset

Processing num = 1:
- Copy existing subsets: [[]]
- Add 1 to each copy:
  [] + 1 → [1]
- Add new subsets:
outer = [[], [1]]

Processing num = 2:
- Copy existing subsets: [[], [1]]
- Add 2 to each copy:
  [] + 2 → [2]
  [1] + 2 → [1, 2]
- Add new subsets:
outer = [[], [1], [2], [1, 2]]

Processing num = 3:
- Copy existing subsets: [[], [1], [2], [1, 2]]
- Add 3 to each copy:
  [] + 3 → [3]
  [1] + 3 → [1, 3]
  [2] + 3 → [2, 3]
  [1, 2] + 3 → [1, 2, 3]
- Add new subsets:
outer = [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]

==========================
VISUAL REPRESENTATION:

Start: outer = [[]]

Step 1: Add 1
[] → [1]
outer = [[], [1]]

Step 2: Add 2
[] → [2]
[1] → [1, 2]
outer = [[], [1], [2], [1, 2]]

Step 3: Add 3
[] → [3]
[1] → [1, 3]
[2] → [2, 3]
[1, 2] → [1, 2, 3]
outer = [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]

==========================
KEY POINTS:
1. Iterative method, no recursion needed.
2. For each number, we double the subsets: existing subsets + new subsets with current number.
3. Works for arrays of any size.
*/
