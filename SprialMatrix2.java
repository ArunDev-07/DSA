class Solution {
    /*
     * Function to generate an n x n spiral matrix
     *
     * Single-paragraph explanation (based on your understanding):
     * The algorithm fills an n x n matrix in a clockwise spiral using four boundaries: top, bottom, left, and right. 
     * In each iteration of the while loop, it fills the top row from left to right, then the right column from top to bottom, 
     * then the bottom row from right to left (if still within boundaries), and finally the left column from bottom to top (if still within boundaries). 
     * After filling each side, the corresponding boundary is moved inward (top++, bottom--, left++, right--), shrinking the spiral. 
     * The while loop continues until the boundaries cross. When only the center cell remains (like [1][1] in a 3×3 matrix), 
     * the top row loop fills it, top is incremented, and in the next while check the condition fails, stopping the loop. 
     * This ensures all numbers are filled in perfect spiral order.
     *
     * Example for n = 3:
     * Output:
     * 1 2 3
     * 8 9 4
     * 7 6 5
     *
     * Dry Run for n = 3:
     * Initial state:
     * ans = [
     *   [0,0,0],
     *   [0,0,0],
     *   [0,0,0]
     * ]
     * top = 0, bottom = 2, left = 0, right = 2, value = 1
     *
     * Iteration 1:
     * 1️⃣ Fill top row (left→right): ans[0][0..2] = 1,2,3
     * ans =
     * [1, 2, 3]
     * [0, 0, 0]
     * [0, 0, 0]
     * top++ → top = 1
     *
     * 2️⃣ Fill right column (top→bottom): ans[1..2][2] = 4,5
     * ans =
     * [1, 2, 3]
     * [0, 0, 4]
     * [0, 0, 5]
     * right-- → right = 1
     *
     * 3️⃣ Fill bottom row (right→left): ans[2][1..0] = 6,7
     * ans =
     * [1, 2, 3]
     * [0, 0, 4]
     * [7, 6, 5]
     * bottom-- → bottom = 1
     *
     * 4️⃣ Fill left column (bottom→top): ans[1..1][0] = 8
     * ans =
     * [1, 2, 3]
     * [8, 0, 4]
     * [7, 6, 5]
     * left++ → left = 1
     *
     * Iteration 2 (center):
     * 1️⃣ Fill top row (left→right): ans[1][1] = 9
     * ans =
     * [1, 2, 3]
     * [8, 9, 4]
     * [7, 6, 5]
     * top++ → top = 2
     *
     * While loop condition fails (top=2 > bottom=1, left=1 <= right=1), loop stops.
     * Final spiral matrix complete.
     */
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];

        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int value = 1;

        while (top <= bottom && left <= right) {

            // Fill top row
            for (int i = left; i <= right; i++) {
                ans[top][i] = value++;
            }
            top++;

            // Fill right column
            for (int i = top; i <= bottom; i++) {
                ans[i][right] = value++;
            }
            right--;

            // Fill bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans[bottom][i] = value++;
                }
                bottom--;
            }

            // Fill left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans[i][left] = value++;
                }
                left++;
            }
        }

        return ans;
    }
}
