package com.example.DSA_JAVA.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: Combination Sum II
 *
 * Given an array of integers (may contain duplicates) and a target value,
 * find all unique combinations where the numbers sum up to the target.
 * Each number can only be used once.
 *
 * Solution Approach:
 * - Sort the array first to handle duplicates easily.
 * - Use backtracking recursion to explore two choices at each step:
 *   1. Include the current number in the combination
 *   2. Exclude the current number and skip duplicates
 * - Keep track of remaining target.
 * - When target == 0, add the current combination to the answer.
 * - When target < 0 or index reaches end of array, stop the recursion (dead end).
 *
 * Key Points:
 * - Backtracking helps to explore all possibilities.
 * - Sorting + skipping duplicates ensures unique combinations only.
 */

public class CombinationSumII {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Arrays.sort(arr); // Step 1: sort the array
        int target = 8;

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int index = 0;

        combination(arr, index, target, current, ans);

        System.out.println("All unique combinations that sum to " + target + ":");
        for (List<Integer> combo : ans) {
            System.out.println(combo);
        }
    }

    /**
     * Recursive backtracking function to generate combinations
     *
     * @param arr   Sorted input array
     * @param i     Current index
     * @param target Remaining target to achieve
     * @param c     Current combination being formed
     * @param ans   List of all valid combinations
     */
    static void combination(int[] arr, int i, int target, List<Integer> c, List<List<Integer>> ans) {
        // Base Case 1: Target reached → valid combination
        if (target == 0) {
            ans.add(new ArrayList<>(c)); // Add a copy of current combination
            return;
        }

        // Base Case 2: Target negative or index out of bounds → dead end
        if (target < 0 || i == arr.length) {
            return;
        }

        // Choice 1: Include the current element
        c.add(arr[i]);
        combination(arr, i + 1, target - arr[i], c, ans); // Move to next index
        c.remove(c.size() - 1); // Backtrack

        // Choice 2: Exclude the current element and skip duplicates
        int next = i + 1;
        while (next < arr.length && arr[next] == arr[i]) { // Skip duplicates
            next++;
        }
        combination(arr, next, target, c, ans);
    }

    /*
     * -----------------------------
     * DRY RUN WITH VISUAL RECURSION TREE
     * Input: arr = [1,2,3,4,5], target = 8
     *
     * Recursion Tree (Include / Exclude):
     *
     * []
     * ├── Include 1 → [1], target=7
     * │   ├── Include 2 → [1,2], target=5
     * │   │   ├── Include 3 → [1,2,3], target=2
     * │   │   │   ├── Include 4 → [1,2,3,4], target=-2 ❌
     * │   │   │   └── Exclude 4 → [1,2,3], try 5 → [1,2,3,5], target=-3 ❌
     * │   │   └── Exclude 3 → [1,2]
     * │   │       ├── Include 4 → [1,2,4], target=1 ❌
     * │   │       └── Include 5 → [1,2,5], target=0 ✅
     * │   │
     * │   └── Exclude 2 → [1]
     * │       ├── Include 3 → [1,3], target=4
     * │       │   ├── Include 4 → [1,3,4], target=0 ✅
     * │       │   └── Include 5 → [1,3,5], target=-1 ❌
     * │       ├── Include 4 → [1,4], target=3 ❌
     * │       └── Include 5 → [1,5], target=2 ❌
     * │
     * └── Exclude 1 → [], target=8
     *     ├── Include 2 → [2], target=6
     *     │   ├── Include 3 → [2,3], target=3 ❌
     *     │   ├── Include 4 → [2,4], target=2 ❌
     *     │   └── Include 5 → [2,5], target=1 ❌
     *     ├── Include 3 → [3], target=5
     *     │   ├── Include 4 → [3,4], target=1 ❌
     *     │   └── Include 5 → [3,5], target=0 ✅
     *     ├── Include 4 → [4], target=4
     *     │   └── Include 5 → [4,5], target=-1 ❌
     *     └── Include 5 → [5], target=3 ❌
     *
     * ✅ Leaf Nodes (Valid Combinations):
     * [1,2,5]
     * [1,3,4]
     * [3,5]
     *
     * -----------------------------
     *
     * Explanation:
     * - Each node represents a choice: include or exclude current element.
     * - Left child = Include element, Right child = Exclude element (skip duplicates if any)
     * - Backtracking is used to remove the last element after exploring the include path.
     * - Sorting + skipping duplicates ensures no repeated combinations.
     */
}
