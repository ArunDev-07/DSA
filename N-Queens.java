/*
===============================================================================
                                N - QUEENS
===============================================================================

Platform  : LeetCode (Problem 51)
Approach  : Backtracking
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============================================================================

Place N queens on an N x N chessboard such that:
1) No two queens share same column
2) No two queens share same left diagonal
3) No two queens share same right diagonal

Return all valid board configurations.

===============================================================================
CORE IDEA - BACKTRACKING
===============================================================================

We place queens ROW BY ROW.

For each row:
    Try every column.
    If safe:
        Place queen
        Move to next row (recursion)
        Remove queen (backtrack)

Base Case:
    If row == n → All queens placed successfully.

===============================================================================
WHY SAFETY CHECK ONLY LOOKS UPWARDS?
===============================================================================

Because:
We fill board from row 0 → row n-1.
So rows below current row are empty.
Only previously filled rows (above) need checking.

===============================================================================
TIME COMPLEXITY
===============================================================================

Worst Case:

    O(N! * N)

Explanation:

- There are approximately N! possible queen placements.
- For each placement, isSafe() takes O(N).
- So total = O(N! * N)

===============================================================================
SPACE COMPLEXITY
===============================================================================

Board storage        : O(N^2)
Recursion stack      : O(N)
Result storage       : Depends on number of solutions

Total Auxiliary Space: O(N^2)

===============================================================================
FULL DRY RUN (n = 4)
===============================================================================

Initial Board:
. . . .
. . . .
. . . .
. . . .

---------------------------------------------------------
Step 1: row = 0

Try col = 0 → SAFE
Place Q at (0,0)

Q . . .
. . . .
. . . .
. . . .

---------------------------------------------------------
Step 2: row = 1

Try col = 0 → ❌ same column
Try col = 1 → ❌ left diagonal
Try col = 2 → ✅ SAFE

Board:
Q . . .
. . Q .
. . . .
. . . .

---------------------------------------------------------
Step 3: row = 2

Try col = 0 → ❌ same column
Try col = 1 → ❌ right diagonal
Try col = 2 → ❌ same column
Try col = 3 → ❌ left diagonal

No valid placement → BACKTRACK

Remove queen from (1,2)

---------------------------------------------------------
Step 4: row = 1

Try col = 3 → ✅ SAFE

Q . . .
. . . Q
. . . .
. . . .

---------------------------------------------------------
Step 5: row = 2

Try col = 0 → ❌ same column
Try col = 1 → ✅ SAFE

Q . . .
. . . Q
. Q . .
. . . .

---------------------------------------------------------
Step 6: row = 3

Try col = 0 → ❌ same column
Try col = 1 → ❌ same column
Try col = 2 → ❌ left diagonal
Try col = 3 → ❌ same column

No valid → BACKTRACK

Remove (2,1)

Continue exploration...

---------------------------------------------------------
FINAL SOLUTIONS FOR n = 4

Solution 1:
. Q . .
. . . Q
Q . . .
. . Q .

Solution 2:
. . Q .
Q . . .
. . . Q
. Q . .

Total Solutions = 2

===============================================================================
INTERVIEW NOTES
===============================================================================

If interviewer asks:

Q) Why is complexity N! ?
A) Because each row tries all columns and branches recursively.

Q) Can we optimize?
A) Yes. By using 3 boolean arrays for O(1) safety check.

===============================================================================
*/

import java.util.*;

class Solution {

    /*
    Main function called by LeetCode.
    */
    public List<List<String>> solveNQueens(int n) {

        // Create chessboard
        boolean[][] board = new boolean[n][n];

        // Stores all valid solutions
        List<List<String>> result = new ArrayList<>();

        // Start recursion from row 0
        queens(board, 0, result);

        return result;
    }

    /*
    BACKTRACKING FUNCTION

    board  → current board state
    row    → current row to place queen
    result → stores final solutions
    */
    public void queens(boolean[][] board, int row, List<List<String>> result) {

        int n = board.length;

        // BASE CASE
        if (row == n) {
            result.add(display(board));
            return;
        }

        // Try each column in current row
        for (int col = 0; col < n; col++) {

            if (isSafe(board, row, col)) {

                // PLACE
                board[row][col] = true;

                // RECURSE
                queens(board, row + 1, result);

                // BACKTRACK
                board[row][col] = false;
            }
        }
    }

    /*
    SAFETY CHECK

    Checks:
    - Same column
    - Left diagonal
    - Right diagonal
    */
    public boolean isSafe(boolean[][] board, int row, int col) {

        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }

        // Check left diagonal
        int minLeft = Math.min(row, col);
        for (int i = 1; i <= minLeft; i++) {
            if (board[row - i][col - i]) return false;
        }

        // Check right diagonal
        int minRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= minRight; i++) {
            if (board[row - i][col + i]) return false;
        }

        return true;
    }

    /*
    CONVERT BOARD TO OUTPUT FORMAT

    true  → 'Q'
    false → '.'
    */
    public List<String> display(boolean[][] board) {

        List<String> list = new ArrayList<>();

        for (boolean[] row : board) {

            char[] arr = new char[row.length];

            for (int i = 0; i < row.length; i++) {
                arr[i] = row[i] ? 'Q' : '.';
            }

            list.add(new String(arr));
        }

        return list;
    }
}
