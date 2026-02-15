package com.example.DSA_JAVA.Recursion;

import java.util.Arrays;

/*
===============================================================================
PROBLEM EXPLANATION
===============================================================================

This program prints ALL possible paths from (0,0) to (2,2) in a 3x3 grid.

We can move:
D → Down
R → Right
U → Up
L → Left

We use BACKTRACKING.

Backtracking Rule:
1. Mark the current cell as visited.
2. Explore all possible directions.
3. Unmark the cell before returning (important step).

We use:
board[][] → to track visited cells
path[][]  → to store step numbers
step      → current step number in path

===============================================================================
VISUAL BOARD INDEXES
===============================================================================

(0,0) (0,1) (0,2)
(1,0) (1,1) (1,2)
(2,0) (2,1) (2,2)

===============================================================================
RECURSION TREE (SIMPLIFIED STRUCTURE)
===============================================================================

(0,0)
 ├── D → (1,0)
 │    ├── D → (2,0)
 │    │    └── R → (2,1)
 │    │         └── R → (2,2) ✅
 │    └── R → (1,1)
 │         ├── D → (2,1)
 │         └── R → (1,2)
 │              └── D → (2,2) ✅
 └── R → (0,1)
      ├── D → (1,1)
      └── R → (0,2)

And so on...

===============================================================================
DRY RUN (FIRST PATH ONLY)
===============================================================================

Step 1 → (0,0)
[1 0 0]
[0 0 0]
[0 0 0]

Step 2 → Down → (1,0)
[1 0 0]
[2 0 0]
[0 0 0]

Step 3 → Down → (2,0)
[1 0 0]
[2 0 0]
[3 0 0]

Step 4 → Right → (2,1)
[1 0 0]
[2 0 0]
[3 4 0]

Step 5 → Right → (2,2)
[1 0 0]
[2 0 0]
[3 4 5]

Path printed: DDRR

Then backtracking happens:
(2,2) reset
(2,1) reset
(2,0) reset
...

===============================================================================
IMPORTANT BACKTRACKING STEP
===============================================================================

board[r][c] = true;
path[r][c] = 0;

Why?
Because once recursion returns,
that cell should be available for other paths.

===============================================================================
TIME & SPACE COMPLEXITY
===============================================================================

Time Complexity:
O(4^(n*m))

Because at each cell we try 4 directions.

Space Complexity:
O(n*m)

Because:
- Recursion stack can go maximum n*m deep.
- path[][] uses n*m space.

===============================================================================
*/

public class IncludingAllPaths {

    public static void main(String[] args) {

        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        int[][] path = new int[board.length][board[0].length];

        maze("", board, 0, 0, path, 1);
    }

    static void maze(String p, boolean[][] board,
                     int r, int c,
                     int[][] path,
                     int step) {

        // =============================
        // BASE CONDITION
        // =============================
        // If we reach bottom-right cell
        if (r == board.length - 1 && c == board[0].length - 1) {

            path[r][c] = step;

            // Print path matrix
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }

            // Print direction string
            System.out.println("Path: " + p);
            System.out.println();

            return;
        }

        // =============================
        // BLOCK CONDITION
        // =============================
        // If already visited, stop
        if (!board[r][c]) {
            return;
        }

        // =============================
        // MARK STEP (CHOOSING)
        // =============================
        board[r][c] = false;
        path[r][c] = step;

        // =============================
        // MOVE DOWN
        // =============================
        if (r < board.length - 1) {
            maze(p + "D", board, r + 1, c, path, step + 1);
        }

        // =============================
        // MOVE RIGHT
        // =============================
        if (c < board[0].length - 1) {
            maze(p + "R", board, r, c + 1, path, step + 1);
        }

        // =============================
        // MOVE UP
        // =============================
        if (r > 0) {
            maze(p + "U", board, r - 1, c, path, step + 1);
        }

        // =============================
        // MOVE LEFT
        // =============================
        if (c > 0) {
            maze(p + "L", board, r, c - 1, path, step + 1);
        }

        // =============================
        // BACKTRACKING (UNDO STEP)
        // =============================
        board[r][c] = true;
        path[r][c] = 0;
    }
}
