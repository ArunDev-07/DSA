import java.util.*;

/*
=====================================================
PROBLEM NAME:
-----------------------------------------------------
LeetCode 78 – Subsets

TASK:
-----------------------------------------------------
Given an integer array, generate ALL possible subsets
(power set).

Example:
arr = [1,2,3]

Output:
[
 [], [1], [2], [3],
 [1,2], [1,3], [2,3], [1,2,3]
]

=====================================================
*/

class Solution {

    /*
    -------------------------------------------------
    MAIN FUNCTION
    -------------------------------------------------
    This function initializes:
    - list : stores all subsets
    - curr : stores the current subset being formed
    Then it starts recursion from index 0.
    -------------------------------------------------
    */
    public List<List<Integer>> subsets(int[] arr) {

        // This list will store all subsets
        List<List<Integer>> list = new ArrayList<>();

        // This list stores the current subset
        List<Integer> curr = new ArrayList<>();

        // Start recursive subset generation
        subset(arr, 0, curr, list);

        return list;
    }

    /*
    -------------------------------------------------
    RECURSIVE FUNCTION: subset()
    -------------------------------------------------
    Parameters:
    - arr   : input array
    - index : current position in array
    - c     : current subset
    - ans   : list of all subsets

    LOGIC:
    At every index, we have TWO choices:
    1) TAKE the element
    2) DO NOT TAKE the element

    This creates a binary decision tree.
    -------------------------------------------------
    */
    public void subset(int[] arr, int index, List<Integer> c, List<List<Integer>> ans) {

        /*
        ---------------------------------------------
        BASE CONDITION
        ---------------------------------------------
        When index reaches array length,
        one complete subset is formed.
        ---------------------------------------------
        */
        if (index == arr.length) {
            ans.add(new ArrayList<>(c)); // copy current subset
            return;
        }

        /*
        ---------------------------------------------
        CHOICE 1: TAKE the current element
        ---------------------------------------------
        */
        c.add(arr[index]);                 // add element
        subset(arr, index + 1, c, ans);    // move to next index

        /*
        ---------------------------------------------
        BACKTRACK
        ---------------------------------------------
        Remove last added element so that
        we can explore the "not take" path.
        ---------------------------------------------
        */
        c.remove(c.size() - 1);

        /*
        ---------------------------------------------
        CHOICE 2: DO NOT TAKE the element
        ---------------------------------------------
        */
        subset(arr, index + 1, c, ans);
    }
}

/*
=====================================================
EXPLANATION PARAGRAPH
-----------------------------------------------------
This solution uses recursion and backtracking to
generate all subsets. At each index, the algorithm
decides whether to include or exclude the current
element. When the index reaches the end of the array,
the current subset is complete and added to the result.
Backtracking ensures that previous choices are undone
before exploring new paths.

Total subsets generated = 2^n
=====================================================
*/

/*
=====================================================
DRY RUN (STEP BY STEP)
-----------------------------------------------------
Input:
arr = [1, 2, 3]

Start:
index = 0, curr = []

index=0 → element=1
  Take 1 → [1]
    index=1 → element=2
      Take 2 → [1,2]
        index=2 → element=3
          Take 3 → [1,2,3]  ✅
          Not Take 3 → [1,2] ✅
      Not Take 2 → [1]
        Take 3 → [1,3] ✅
        Not Take 3 → [1] ✅

index=0 → Not Take 1 → []
  index=1 → element=2
    Take 2 → [2]
      Take 3 → [2,3] ✅
      Not Take 3 → [2] ✅
    Not Take 2 → []
      Take 3 → [3] ✅
      Not Take 3 → [] ✅

=====================================================
*/

/*
=====================================================
VISUAL RECURSION TREE
-----------------------------------------------------

                    []
              /             \
           [1]               []
        /       \         /        \
     [1,2]      [1]     [2]         []
    /    \     /   \   /   \       /   \
[1,2,3][1,2][1,3][1][2,3][2]     [3]   []

=====================================================
*/

/*
=====================================================
TIME & SPACE COMPLEXITY
-----------------------------------------------------
Time Complexity  : O(2^n)
Space Complexity : O(n) recursion stack
=====================================================
*/

/*
=====================================================
INTERVIEW ONE-LINER
-----------------------------------------------------
"I generate subsets using recursion and backtracking
by making take and not-take decisions at each index."
=====================================================
*/
