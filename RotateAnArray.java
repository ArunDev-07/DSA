class Solution {

    /*
     * ============================
     * ROTATE ARRAY – EXPLANATION
     * ============================
     *
     * This solution rotates an array to the RIGHT by k steps
     * using the "3 Reverse Technique".
     *
     * Idea:
     * 1) Reverse the entire array
     * 2) Reverse the first k elements
     * 3) Reverse the remaining elements
     *
     * This rearranges elements in-place without using extra memory.
     */

    public void rotate(int[] nums, int k) {

        // Step 1: Store array length
        int l = nums.length;

        // Step 2: Normalize k (handles k > length)
        k = k % l;

        // Step 3: Reverse the whole array
        reverse(nums, 0, l - 1);

        // Step 4: Reverse first k elements
        reverse(nums, 0, k - 1);

        // Step 5: Reverse remaining elements
        reverse(nums, k, l - 1);
    }

    /*
     * Reverse helper function
     * Reverses elements between indices l and r (inclusive)
     */
    public void reverse(int[] arr, int l, int r) {

        // Swap elements while left index is smaller than right index
        while (l < r) {

            // Swap arr[l] and arr[r]
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // Move pointers inward
            l++;
            r--;
        }
    }

    /*
     * ============================
     * PARAGRAPH EXPLANATION
     * ============================
     *
     * Rotating an array to the right by k means the last k elements
     * should come to the front, while the remaining elements shift right.
     * Instead of moving elements one by one, we reverse the entire array,
     * which places the last k elements at the front but in reverse order.
     * Then we reverse the first k elements to correct their order.
     * Finally, we reverse the remaining elements to restore their order.
     * These three reversals together achieve the rotation efficiently
     * in O(n) time and O(1) extra space.
     */

    /*
     * ============================
     * DRY RUN (EXAMPLE)
     * ============================
     *
     * nums = [1, 2, 3, 4, 5, 6, 7]
     * k = 3
     *
     * Step 1: Reverse entire array
     * [7, 6, 5, 4, 3, 2, 1]
     *
     * Step 2: Reverse first k elements (0 to 2)
     * [5, 6, 7, 4, 3, 2, 1]
     *
     * Step 3: Reverse remaining elements (3 to 6)
     * [5, 6, 7, 1, 2, 3, 4]
     *
     * Final Output:
     * [5, 6, 7, 1, 2, 3, 4]
     */

}
