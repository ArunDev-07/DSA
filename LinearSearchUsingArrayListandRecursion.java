import java.util.ArrayList;

public class RecursiveListSearch {

    public static void main(String[] args) {

        // Example array
        int[] arr = {1, 2, 3, 3, 5, 6};
        int target = 3;

        // Call recursive function starting from index 0
        ArrayList<Integer> result = listsearch(arr, target, 0);

        // Final output
        System.out.println(result); // Output: [2, 3]
    }

    static ArrayList<Integer> listsearch(int[] arr, int t, int i) {

        // Create a new list for THIS recursive call
        ArrayList<Integer> list = new ArrayList<>();

        // BASE CASE:
        // When index reaches last element, stop recursion
        if (i == arr.length - 1) {
            return list; // returns empty list []
        }

        // STEP 1: Check current index
        if (arr[i] == t) {
            // If current element equals target,
            // add current index to list
            list.add(i);
        }

        // STEP 2: Recursive call for next index
        // This gives the list of matches AFTER current index
        ArrayList<Integer> ansList = listsearch(arr, t, i + 1);

        // STEP 3: Merge future answers with current list
        list.addAll(ansList);

        // STEP 4: Return combined result
        return list;
    }
}
