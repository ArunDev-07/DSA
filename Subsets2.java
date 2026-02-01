import java.util.*;

// Class to generate all unique subsets of an array that may contain duplicates
class Solution {

    // Main function that initiates the subset generation
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        // Step 1: Sort the array to bring duplicates together
        Arrays.sort(arr);

        // Step 2: Initialize the answer list to store all subsets
        List<List<Integer>> ans = new ArrayList<>();

        // Step 3: Temporary list to store the current subset
        List<Integer> c = new ArrayList<>();

        // Step 4: Start recursive backtracking from index 0
        subset(arr, 0, c, ans);

        // Step 5: Return the final list of subsets
        return ans;
    }

    // Recursive function to generate subsets
    public void subset(int[] arr, int index, List<Integer> c, List<List<Integer>> ans) {
        // Base case: if index reaches the end of array, add current subset to ans
        if (index == arr.length) {
            ans.add(new ArrayList<>(c)); // Add a copy of current subset
            return;
        }

        // Choice 1: Include the current element in the subset
        c.add(arr[index]);
        subset(arr, index + 1, c, ans); // Recurse for the next index

        // Backtrack: remove the last element to explore the next choice
        c.remove(c.size() - 1);

        // Choice 2: Exclude the current element and skip duplicates
        int next = index + 1;
        while (next < arr.length && arr[next] == arr[index]) {
            next++; // Skip all duplicates
        }
        subset(arr, next, c, ans); // Recurse with the next distinct element
    }

    // ----------------------
    // DRY RUN EXAMPLE
    // Input: arr = [1,2,2]
    // Sorted: [1,2,2]
    // ----------------------
    // Step-by-step subsets generated:
    //
    // index=0, c=[]
    // ├─ Include 1 → c=[1], index=1
    // │  ├─ Include 2 → c=[1,2], index=2
    // │  │  ├─ Include 2 → c=[1,2,2], index=3 → add [1,2,2]
    // │  │  └─ Exclude 2 → skip duplicates → index=3 → add [1,2]
    // │  └─ Exclude 2 → skip duplicates → index=3 → add [1]
    // └─ Exclude 1 → index=1
    //    ├─ Include 2 → c=[2], index=2
    //    │  ├─ Include 2 → c=[2,2], index=3 → add [2,2]
    //    │  └─ Exclude 2 → skip duplicates → index=3 → add [2]
    //    └─ Exclude 2 → skip duplicates → index=3 → add []
    //
    // Final output: [ [1,2,2], [1,2], [1], [2,2], [2], [] ]
    // ----------------------
    
    // This dry run shows exactly how recursion + backtracking + skipping duplicates works
    // Each element has two choices: include or skip
    // Skip duplicates ensures no repeated subsets are added
}

// ----------------------
// MAIN FUNCTION TO TEST
// ----------------------
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
