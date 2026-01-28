class Solution {

    /*
     * ===============================
     * PROBLEM:
     * Find the kth largest element in an array
     * WITHOUT fully sorting the array.
     *
     * APPROACH:
     * We use QUICK SELECT (based on Quick Sort partition).
     * Instead of sorting both sides, we recurse only on
     * the side that contains the target index.
     *
     * kth largest → (n - k)th index in sorted order
     * ===============================
     */

    public int findKthLargest(int[] arr, int k) {

        // Convert kth largest to target index
        // Example: n = 5, k = 2 → target = 3
        int target = arr.length - k;

        // Call Quick Select
        int ans = QuickSort(arr, 0, arr.length - 1, target);

        return ans;
    }

    /*
     * QuickSort here is actually QUICK SELECT
     *
     * arr → input array
     * l   → left index
     * h   → right index
     * t   → target index (arr.length - k)
     */
    public int QuickSort(int[] arr, int l, int h, int t) {

        // Base case:
        // Only one element left → that must be the answer
        if (l >= h) {
            return arr[l];
        }

        // Two pointers for partition
        int s = l;
        int e = h;

        // Choose pivot (middle element)
        int mid = s + (e - s) / 2;
        int pivot = arr[mid];

        /*
         * ===============================
         * PARTITION LOGIC
         *
         * After this loop:
         * l -------- e | s -------- h
         *
         * Left side  → elements <= pivot
         * Right side → elements >= pivot
         * ===============================
         */
        while (s <= e) {

            // Move s until we find element >= pivot
            while (arr[s] < pivot) {
                s++;
            }

            // Move e until we find element <= pivot
            while (arr[e] > pivot) {
                e--;
            }

            // Swap if pointers have not crossed
            if (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }

        /*
         * ===============================
         * DECISION STEP (MOST IMPORTANT)
         *
         * Compare TARGET INDEX with PARTITION BOUNDARIES
         *
         * If t <= e → target is in LEFT partition
         * If t >= s → target is in RIGHT partition
         * Else      → arr[t] is already correct
         * ===============================
         */

        if (t >= s) {
            // Search in right partition
            return QuickSort(arr, s, h, t);
        }
        else if (t <= e) {
            // Search in left partition
            return QuickSort(arr, l, e, t);
        }
        else {
            // Target index lies between e and s
            return arr[t];
        }
    }

    /*
     * ===============================
     * DRY RUN EXAMPLE
     *
     * Input:
     * arr = [5,4,3,2,1]
     * k = 2
     *
     * Step 1:
     * target = 5 - 2 = 3
     *
     * Step 2: First partition
     * pivot = 3
     *
     * After partition:
     * [2,1 | 3 | 5,4]
     *       ↑
     *      index 2
     *
     * s = 3, e = 1
     *
     * Step 3:
     * target (3) >= s (3)
     * → recurse RIGHT side
     *
     * Right side = [5,4]
     *
     * Step 4: Partition [5,4]
     * pivot = 5
     *
     * After partition:
     * [4 | 5]
     *
     * target index = 3
     * → arr[3] = 4
     *
     * ANSWER = 4
     * ===============================
     */

}
