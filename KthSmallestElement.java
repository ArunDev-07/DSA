class Solution {

    /*
     ==========================================================
     PROBLEM:
     Find the Kth smallest element in a SORTED 2D MATRIX

     MATRIX PROPERTIES:
     - Rows are sorted
     - Columns are sorted

     APPROACH USED:
     - QuickSelect (Optimized QuickSort)
     - Treat 2D matrix as a 1D array (without extra space)

     WHY QUICKSELECT?
     - Sorting all elements = O(n log n)
     - QuickSelect (average) = O(n)
     ==========================================================
    */

    public int kthSmallest(int[][] arr, int k) {

        // Number of rows in matrix
        int row = arr.length;

        // Number of columns in matrix
        int col = arr[0].length;

        /*
         Convert k to 0-based index
         Example:
         k = 1 → index = 0
         k = 5 → index = 4
        */
        int targetIndex = k - 1;

        /*
         We treat the matrix like a 1D array
         Total elements = row * col
         Valid indices = 0 to (row*col - 1)
        */
        return Quick(arr, 0, row * col - 1, targetIndex, col);
    }


    /*
     ==========================================================
     QUICKSELECT FUNCTION
     ==========================================================

     l → left index (1D)
     h → right index (1D)
     t → target index (k-1)
     col → number of columns (needed for index mapping)

     1D INDEX → 2D INDEX:
     row = index / col
     col = index % col
    */
    public int Quick(int[][] arr, int l, int h, int t, int col) {

        /*
         BASE CASE:
         If only one element exists,
         that element is the answer
        */
        if (l >= h) {
            return arr[l / col][l % col];
        }

        // Start and end pointers
        int s = l;
        int e = h;

        /*
         Choose pivot from middle
         This reduces worst-case chances
        */
        int mid = s + (e - s) / 2;
        int pivot = arr[mid / col][mid % col];

        /*
         PARTITION LOGIC
         ----------------
         - Move s forward until element >= pivot
         - Move e backward until element <= pivot
         - Swap them
        */
        while (s <= e) {

            // Move s until element >= pivot
            while (arr[s / col][s % col] < pivot) {
                s++;
            }

            // Move e until element <= pivot
            while (arr[e / col][e % col] > pivot) {
                e--;
            }

            // Swap if pointers are valid
            if (s <= e) {
                int temp = arr[s / col][s % col];
                arr[s / col][s % col] = arr[e / col][e % col];
                arr[e / col][e % col] = temp;

                s++;
                e--;
            }
        }

        /*
         AFTER PARTITION:
         ----------------
         Left side  → elements < pivot
         Right side → elements > pivot

         Now we decide where the target index lies
        */

        // Target is in right part
        if (t >= s) {
            return Quick(arr, s, h, t, col);
        }

        // Target is in left part
        else if (t <= e) {
            return Quick(arr, l, e, t, col);
        }

        // Target lies between e and s → already correct
        else {
            return arr[t / col][t % col];
        }
    }


    /*
     ==========================================================
     DRY RUN EXAMPLE (VERY IMPORTANT)
     ==========================================================

     MATRIX:
     [
       [ 1,  5,  9 ],
       [10, 11, 13 ],
       [12, 13, 15 ]
     ]

     k = 5

     STEP 1: Convert matrix to 1D view
     ---------------------------------
     Index:  0  1  2   3   4   5   6   7   8
     Value:  1  5  9  10  11  13  12  13  15

     targetIndex = k - 1 = 4

     STEP 2: First Quick call
     ---------------------------------
     l = 0, h = 8
     mid = 4 → pivot = 11

     STEP 3: Partition
     ---------------------------------
     Elements < 11 move left
     Elements > 11 move right

     After partition (conceptually):
     [1, 5, 9, 10, 11, 13, 12, 13, 15]
                     ↑
                  index = 4

     s = 5
     e = 3

     STEP 4: Check target
     ---------------------------------
     t = 4

     t >= s ? ❌
     t <= e ? ❌

     So we directly return:
     arr[4/3][4%3] → arr[1][1] → 11

     FINAL ANSWER:
     ---------------------------------
     5th smallest element = 11
     ==========================================================
    */
}
