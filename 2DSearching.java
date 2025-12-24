class Solution { 
    // LeetCode requires the solution inside a class named Solution

    public boolean searchMatrix(int[][] matrix, int target) {
        // Method to search for 'target' in a 2D matrix
        // Returns true if target is found, otherwise false

        for(int row = 0 ; row < matrix.length ; row++){
            // Loop through each row of the matrix
            // matrix.length gives number of rows

            for(int col = 0; col < matrix[row].length ; col ++ ){
                // Loop through each column in the current row
                // matrix[row].length gives number of columns in that row

                if(matrix[row][col] == target){
                    // Check if current element is equal to target

                    return true ;
                    // If target is found, immediately return true
                }
            }
            // Inner loop ends after checking all columns of the current row
        }
        // Outer loop ends after checking all rows of the matrix

        return false ;
        // If target is not found anywhere in the matrix, return false
    }
}
