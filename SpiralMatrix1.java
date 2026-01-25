import java.util.*;

class Solution {
    /*
     * Function to return all elements of a 2D matrix in spiral order.
     *
     * Single-paragraph explanation (based on your understanding):
     * The algorithm traverses the matrix in a clockwise spiral using four boundaries: top, bottom, left, and right. 
     * In each iteration of the while loop, it first adds the top row from left to right, then the rightmost column from top to bottom. 
     * Next, if any rows remain, it adds the bottom row from right to left, and if any columns remain, it adds the leftmost column from top to bottom. 
     * After each step, the respective boundary is adjusted (top++, bottom--, left++, right--) to shrink the spiral inward. 
     * The while loop continues until the boundaries cross. This ensures that all elements, including the center for odd-sized matrices, are added correctly.
     *
     * Example for matrix = [[1,2,3],[4,5,6],[7,8,9]]:
     * Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;       // Number of rows
        int col = matrix[0].length;    // Number of columns
        int top = 0, bottom = row - 1; // Initial top and bottom boundaries
        int left = 0, right = col - 1; // Initial left and right boundaries

        List<Integer> list = new ArrayList<>();

        // Loop until the spiral boundaries cross
        while (top <= bottom && left <= right) {

            // 1️⃣ Traverse the top row from left to right
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++; // Move top boundary down

            // 2️⃣ Traverse the rightmost column from top to bottom
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--; // Move right boundary left

            // 3️⃣ Traverse the bottom row from right to left (if rows remain)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--; // Move bottom boundary up
            }

            // 4️⃣ Traverse the leftmost column from top to bottom (if columns remain)
            if (left <= right) {
                for (int i = top; i <= bottom; i++) {
                    list.add(matrix[i][left]);
                }
                left++; // Move left boundary right
            }
        }

        return list; // Return the elements in spiral order
    }

    // Optional main function to test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        List<Integer> result = sol.spiralOrder(matrix);
        System.out.println(result); // Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }
}
