import java.util.Arrays;

class Solution {

    /*
     * =========================================
     * INTERSECTION OF TWO ARRAYS II (WITH COUNT)
     * =========================================
     *
     * This method finds the intersection of two arrays
     * where each element in the result should appear
     * as many times as it appears in BOTH arrays.
     *
     * Approach used:
     * 1) Sort both arrays
     * 2) Use two pointers to compare elements
     * 3) Store common elements in result array
     */

    public int[] intersect(int[] nums1, int[] nums2) {

        // Step 1: Sort both arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // Step 2: Create result array with max possible size
        int[] ans = new int[Math.min(nums1.length, nums2.length)];

        // Step 3: Initialize pointers
        int i = 0; // pointer for nums1
        int j = 0; // pointer for nums2
        int k = 0; // pointer for ans array

        // Step 4: Traverse both arrays
        while (i < nums1.length && j < nums2.length) {

            // If elements are equal, add to result
            if (nums1[i] == nums2[j]) {
                ans[k] = nums1[i]; // store common element
                i++;  // move nums1 pointer
                j++;  // move nums2 pointer
                k++;  // move result pointer
            }

            // If nums1 element is smaller, move i
            else if (nums1[i] < nums2[j]) {
                i++;
            }

            // If nums2 element is smaller, move j
            else {
                j++;
            }
        }

        // Step 5: Return only the filled portion of ans
        return Arrays.copyOf(ans, k);
    }

    /*
     * ============================
     * PARAGRAPH EXPLANATION
     * ============================
     *
     * To count duplicates in the intersection, both arrays
     * are first sorted so that equal elements appear together.
     * Two pointers are used to traverse the arrays. When both
     * pointers point to the same value, that value is added
     * to the result and both pointers are moved forward.
     * If the values are different, the pointer pointing to
     * the smaller value is moved. This ensures that each
     * element is compared efficiently and duplicates are
     * counted correctly. The result array may not be fully
     * filled, so Arrays.copyOf is used to return only the
     * valid elements.
     */

    /*
     * ============================
     * DRY RUN EXAMPLE
     * ============================
     *
     * Input:
     * nums1 = [1, 2, 2, 3]
     * nums2 = [2, 2]
     *
     * After sorting:
     * nums1 = [1, 2, 2, 3]
     * nums2 = [2, 2]
     *
     * i=0, j=0 → 1 < 2 → i++
     * i=1, j=0 → 2 == 2 → ans[0]=2 → i++, j++, k++
     * i=2, j=1 → 2 == 2 → ans[1]=2 → i++, j++, k++
     *
     * ans = [2, 2, 0, 0]
     * k = 2
     *
     * Returned array:
     * Arrays.copyOf(ans, 2) → [2, 2]
     *
     * Final Output:
     * [2, 2]
     */

}
