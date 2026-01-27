import java.util.HashSet;

class Solution {

    /*
     * =========================================
     * INTERSECTION OF TWO ARRAYS (UNIQUE ONLY)
     * =========================================
     *
     * This solution finds the intersection of two arrays
     * such that each element appears ONLY ONCE in the result.
     *
     * Approach used:
     * - HashSet to store elements of first array
     * - HashSet to store intersection result (avoids duplicates)
     */

    public int[] intersection(int[] nums1, int[] nums2) {

        // Step 1: Create a HashSet to store elements of nums1
        HashSet<Integer> set = new HashSet<>();

        // Step 2: Create another HashSet to store intersection result
        HashSet<Integer> result = new HashSet<>();

        // Step 3: Add all elements of nums1 into set
        for (int num : nums1) {
            set.add(num);   // duplicates automatically ignored
        }

        // Step 4: Check elements of nums2
        for (int num : nums2) {
            // If element exists in nums1 set, add to result
            if (set.contains(num)) {
                result.add(num);  // ensures uniqueness
            }
        }

        // Step 5: Convert result HashSet to array
        int[] ans = new int[result.size()];
        int i = 0;

        for (int num : result) {
            ans[i++] = num;
        }

        // Step 6: Return the result array
        return ans;
    }

    /*
     * ============================
     * PARAGRAPH EXPLANATION
     * ============================
     *
     * A HashSet is used because it allows fast lookup and
     * automatically removes duplicate values. First, all
     * elements from the first array are stored in a set.
     * Then, each element of the second array is checked
     * against this set. If it exists, it is added to the
     * result set. Since the result is also a HashSet, it
     * ensures that each common element appears only once.
     * Finally, the HashSet is converted into an array for
     * returning the result.
     */

    /*
     * ============================
     * DRY RUN EXAMPLE
     * ============================
     *
     * Input:
     * nums1 = [1, 2, 2, 1]
     * nums2 = [2, 2]
     *
     * Step 1: set = {1, 2}
     *
     * Step 2: Traverse nums2
     * num = 2 → set.contains(2) → true → result = {2}
     * num = 2 → set.contains(2) → true → result = {2}
     *
     * Step 3: Convert result to array
     * ans = [2]
     *
     * Final Output:
     * [2]
     */

}
