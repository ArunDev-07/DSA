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
     */
    public int[][] generateMatrix(int n) {
        // Create an empty n x n matrix
        int[][] ans = new int[n][n];

        // Initialize boundaries for spiral traversal
        int top = 0;           // top row index
        int bottom = n - 1;    // bottom row index
        int left = 0;          // left column index
        int right = n - 1;     // right column index

        int value = 1;         // Start filling the matrix with 1

        // Loop until the spiral boundaries overlap
        while (top <= bottom && left <= right) {

            // 1️⃣ Fill the top row from left to right
            for (int i = left; i <= right; i++) {
                ans[top][i] = value++;
            }
            top++;  // Move the top boundary down

            // 2️⃣ Fill the right column from top to bottom
            for (int i = top; i <= bottom; i++) {
                ans[i][right] = value++;
            }
            right--;  // Move the right boundary left

            // 3️⃣ Fill the bottom row from right to left (if still remaining)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans[bottom][i] = value++;
                }
                bottom--; // Move the bottom boundary up
            }

            // 4️⃣ Fill the left column from bottom to top (if still remaining)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans[i][left] = value++;
                }
                left++; // Move the left boundary right
            }
        }

        return ans;
    }
}
