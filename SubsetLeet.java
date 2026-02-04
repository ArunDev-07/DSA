import java.util.*;

/*
 ============================================================================
 SUBSETS WITH DUPLICATES (LeetCode 90)
 ----------------------------------------------------------------------------
 Problem:
 Given an integer array that may contain duplicates, return all possible
 unique subsets (the power set).

 Input  : [1,2,2]
 Output : [[],[1],[1,2],[1,2,2],[2],[2,2]]

 Key Ideas:
 ----------
 1) Sort the array → duplicates come together
 2) At every index, we have TWO choices:
      - Include the element
      - Exclude the element (and skip all its duplicates)
 3) Backtracking ensures we explore all paths
 4) Skipping duplicates avoids repeated subsets

 ----------------------------------------------------------------------------
 VERY IMPORTANT RULE:
 ----------------------------------------------------------------------------
 ✔ INCLUDE  → duplicates are allowed
 ✔ EXCLUDE  → duplicates are SKIPPED
 ----------------------------------------------------------------------------
*/

class Solution {

    // Main function
    public List<List<Integer>> subsetsWithDup(int[] arr) {

        // Step 1: Sort to group duplicates
        Arrays.sort(arr);

        // Step 2: Result list
        List<List<Integer>> ans = new ArrayList<>();

        // Step 3: Temporary list (current subset)
        List<Integer> current = new ArrayList<>();

        // Step 4: Start recursion
        subset(arr, 0, current, ans);

        return ans;
    }

    /*
     ------------------------------------------------------------------------
     Recursive function
     ------------------------------------------------------------------------
     arr     → input array
     index   → current position in array
     current → subset being built
     ans     → final answer list
     ------------------------------------------------------------------------
    */
    private void subset(int[] arr, int index, List<Integer> current, List<List<Integer>> ans) {

        // BASE CASE:
        // If we reached the end of the array, store the subset
        if (index == arr.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // ============================================================
        // CHOICE 1: INCLUDE current element
        // ============================================================
        current.add(arr[index]);              // take element
        subset(arr, index + 1, current, ans); // move forward
        current.remove(current.size() - 1);   // BACKTRACK

        // ============================================================
        // CHOICE 2: EXCLUDE current element
        // Skip all duplicates of this element
        // ============================================================
        int next = index + 1;
        while (next < arr.length && arr[next] == arr[index]) {
            next++;
        }
        subset(arr, next, current, ans);
    }
}

/*
 ============================================================================
 DRY RUN (Input: [1,2,2])
 ----------------------------------------------------------------------------
 Sorted Array: [1,2,2]
 ----------------------------------------------------------------------------

 Recursion Tree (INCLUDE on left, EXCLUDE on right):

                             []
                  /--------------------------\
               [1]                            []
          /--------------\              /-------------\
      [1,2]              [1]          [2]             []
    /-------\              |        /-------\            |
[1,2,2]   [1,2]          [1]     [2,2]     [2]          []

 ----------------------------------------------------------------------------
 STEP-BY-STEP FLOW:
 ----------------------------------------------------------------------------

 Start: index=0, current=[]

 Include 1 → [1]
   Include 2 → [1,2]
     Include 2 → [1,2,2]  ✅ add
     Exclude 2 → [1,2]    ✅ add
   Exclude 2 (skip duplicates) → [1]  ✅ add

 Exclude 1 → []
   Include 2 → [2]
     Include 2 → [2,2]    ✅ add
     Exclude 2 → [2]      ✅ add
   Exclude 2 (skip duplicates) → []   ✅ add

 ----------------------------------------------------------------------------
 FINAL OUTPUT:
 ----------------------------------------------------------------------------
 [
   [1,2,2],
   [1,2],
   [1],
   [2,2],
   [2],
   []
 ]
 ----------------------------------------------------------------------------

 WHY [2,2] IS ALLOWED?
 --------------------
 Because duplicates are allowed when INCLUDING elements.
 We only skip duplicates when EXCLUDING to prevent repeated subsets.

 ONE-LINE SUMMARY:
 -----------------
 "Include builds subsets, Exclude skips duplicate starting points."

 ============================================================================
*/


// ---------------------------------------------------------------------------
// MAIN CLASS FOR TESTING
// ---------------------------------------------------------------------------
class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();
        int[] arr = {1, 2, 2};

        List<List<Integer>> result = sol.subsetsWithDup(arr);

        System.out.println("All unique subsets:");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
