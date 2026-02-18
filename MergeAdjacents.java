package com.example.DSA_JAVA;

import java.util.*;

/**
 * Solution class to merge adjacent equal numbers in an array.
 * 
 * Problem:
 * Given an integer array nums, repeatedly merge adjacent equal numbers by
 * replacing them with their sum. Return the final array as a List<Long>.
 * 
 * Approach:
 * 1. Use a Deque (double-ended queue) as a stack to keep track of merged numbers.
 * 2. Iterate through each number in nums.
 * 3. If the current number is equal to the top of the stack, pop from stack and
 *    add to current number (merge).
 * 4. Push the merged/current number back to the stack.
 * 5. After processing all numbers, return the stack as a list.
 *
 * Time Complexity: O(n) - Each element is pushed/popped at most once.
 * Space Complexity: O(n) - Stack can hold all elements in the worst case.
 *
 * ---------------- Explanation Paragraph ----------------
 * The mergeAdjacent method merges adjacent equal numbers in a single pass
 * using a stack (Deque). For each number in the array, it checks the top of
 * the stack. If it is equal, the numbers are merged by summing, and this
 * process repeats until the top of the stack is different or the stack is empty.
 * After processing all elements, the stack contains the final merged sequence.
 * This approach guarantees O(n) time complexity because each number is pushed
 * and popped at most once, and O(n) space complexity for the stack.
 *
 * ---------------- Dry Run Example ----------------
 * Example Input: nums = [2, 2, 4, 8, 8, 8]
 *
 * Step by Step:
 * 1. Initialize empty stack: []
 * 2. Process first element: 2 → Stack empty → push 2 → Stack: [2]
 * 3. Process second element: 2 → Top == curr → merge 2+2=4 → Stack: [4]
 * 4. Process third element: 4 → Top == curr → merge 4+4=8 → Stack: [8]
 * 5. Process fourth element: 8 → Top == curr → merge 8+8=16 → Stack: [16]
 * 6. Process fifth element: 8 → Top != curr → push 8 → Stack: [16, 8]
 * 7. Process sixth element: 8 → Top == curr → merge 8+8=16 → Stack: [16,16]
 * Final Stack → [16,16] → Return List<Long>: [16,16]
 */
public class Solution {

    public List<Long> mergeAdjacent(int[] nums) {
        // Initialize a deque as a stack to store merged numbers
        Deque<Long> stack = new ArrayDeque<>();

        // Iterate through each number in the array
        for (int num : nums) {
            long curr = num; // Current number to process

            // Merge with stack top if it's equal
            while (!stack.isEmpty() && stack.peekLast() == curr) {
                curr += stack.pollLast(); // Remove last element and merge
            }

            // Push the current (merged) number to the stack
            stack.addLast(curr);
        }

        // Convert deque to list and return
        return new ArrayList<>(stack);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2, 2, 4, 8, 8, 8};

        List<Long> result = sol.mergeAdjacent(nums);

        System.out.println("Merged Result: " + result);
    }
}
