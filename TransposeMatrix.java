class Solution {

    /*
     This method returns the TRANSPOSE of a matrix.

     Meaning of transpose:
     - Rows become columns
     - Columns become rows
     - Element at position (i, j) moves to (j, i)

     Example:
     Original matrix (2 x 3):
     1  2  3
     4  5  6

     Transpose matrix (3 x 2):
     1  4
     2  5
     3  6
    */

    public int[][] transpose(int[][] matrix) {

        /*
         matrix.length gives number of rows in the original matrix
        */
        int row = matrix.length;

        /*
         matrix[0].length gives number of columns in the original matrix
        */
        int col = matrix[0].length;

        /*
         Creating a new matrix for transpose.

         Original matrix size  = row x col
         Transpose matrix size = col x row

         This is why we reverse the dimensions here.
        */
        int[][] arr = new int[col][row];

        /*
         These two loops go through EVERY element
         of the ORIGINAL matrix.

         - i represents row index of original matrix
         - j represents column index of original matrix

         Loop limits are based on ORIGINAL matrix:
         i < row
         j < col
        */
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                /*
                 Core transpose logic:

                 - matrix[i][j] → original position
                 - arr[j][i]    → transposed position

                 We swap row index and column index.
                */
                arr[j][i] = matrix[i][j];
            }
        }

        /*
         Return the transposed matrix
        */
        return arr;
    }

    /*
     DRY RUN EXAMPLE:

     Input matrix:
     matrix =
     1  2  3
     4  5  6

     row = 2, col = 3
     arr size = 3 x 2

     Loop execution:

     i=0, j=0 → arr[0][0] = 1
     i=0, j=1 → arr[1][0] = 2
     i=0, j=2 → arr[2][0] = 3

     i=1, j=0 → arr[0][1] = 4
     i=1, j=1 → arr[1][1] = 5
     i=1, j=2 → arr[2][1] = 6

     Final arr (transpose):
     1  4
     2  5
     3  6
    */

    /*
     KEY IDEA TO REMEMBER:

     - Loop limits depend on where we READ from (original matrix)
     - Index swapping happens where we WRITE to (transpose matrix)
     - Transpose always means: (i, j) → (j, i)
    */
}
