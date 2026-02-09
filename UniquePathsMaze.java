/*
===============================================================================
LEETCODE 62 – UNIQUE PATHS
GRID SIZE: 3 x 7
START     : (0,0)
END       : (2,6)
MOVES     : DOWN or RIGHT
===============================================================================

PROBLEM IDEA:
-------------
We are standing at the top-left of a grid.
We want to reach the bottom-right.
We can only move:
1) Down  -> (r+1, c)
2) Right -> (r, c+1)

Question:
How many DIFFERENT paths can reach the destination?

===============================================================================
IMPORTANT RULE (MOST IMPORTANT):
--------------------------------
ONLY ONE PLACE RETURNS 1:

    if (r == rows-1 && c == cols-1) return 1;

This means:
- ONLY destination CREATES 1
- All other cells GET values from their children

===============================================================================
RECURSION MEANING:
------------------
maze(r, c) = number of ways to reach destination from (r, c)

===============================================================================
WHY DP?
-------
Same cell is reached many times via different paths.
DP stores the result so we don't recompute.

===============================================================================
GRID (0-based indexing):
-----------------------
(0,0) (0,1) (0,2) (0,3) (0,4) (0,5) (0,6)
(1,0) (1,1) (1,2) (1,3) (1,4) (1,5) (1,6)
(2,0) (2,1) (2,2) (2,3) (2,4) (2,5) (2,6)  <- DESTINATION

===============================================================================
FULL DRY RUN FOR (3,7)
===============================================================================

STEP 1: START
-------------
maze(0,0)
= maze(1,0) + maze(0,1)

STEP 2: EXPAND FIRST LEVEL
--------------------------
maze(1,0) -> maze(2,0) + maze(1,1)
maze(0,1) -> maze(1,1) + maze(0,2)

Notice:
maze(1,1) appears TWICE → DP needed

===============================================================================
DESTINATION LOGIC (WHERE 1 IS CREATED)
--------------------------------------
maze(2,6) = 1   // ONLY PLACE THAT CREATES 1

===============================================================================
BACKTRACKING (VALUES FLOW BACK)
--------------------------------

LAST ROW (only RIGHT moves possible):

maze(2,6) = 1
maze(2,5) = maze(2,6) = 1
maze(2,4) = maze(2,5) = 1
maze(2,3) = maze(2,4) = 1
maze(2,2) = maze(2,3) = 1
maze(2,1) = maze(2,2) = 1
maze(2,0) = maze(2,1) = 1

IMPORTANT:
(2,1) DOES NOT CREATE 1
It GETS 1 from (2,2)

===============================================================================
MIDDLE ROW (row = 1)
-------------------
maze(1,6) = maze(2,6) = 1
maze(1,5) = maze(2,5) + maze(1,6) = 1 + 1 = 2
maze(1,4) = 1 + 2 = 3
maze(1,3) = 1 + 3 = 4
maze(1,2) = 1 + 4 = 5
maze(1,1) = 1 + 5 = 6
maze(1,0) = 1 + 6 = 7

===============================================================================
FIRST ROW (row = 0)
------------------
maze(0,6) = 1
maze(0,5) = 1 + 1 = 2
maze(0,4) = 2 + 2 = 4
maze(0,3) = 4 + 4 = 8
maze(0,2) = 8 + 5 = 13
maze(0,1) = 13 + 6 = 19
maze(0,0) = 19 + 7 = 28

===============================================================================
FINAL DP TABLE
--------------
28  19  13  8  4  2  1
7   6   5   4  3  2  1
1   1   1   1  1  1  1

ANSWER:
-------
uniquePaths(3,7) = 28

===============================================================================
KEY TAKEAWAYS (MEMORIZE THIS):
-----------------------------
1) ONLY destination returns 1
2) All cells = down + right
3) DP prevents recomputation
4) Recursion goes DOWN, values come UP
===============================================================================
*/

class Solution {

    int rows;
    int cols;
    Integer[][] dp;

    public int uniquePaths(int m, int n) {
        rows = m;
        cols = n;
        dp = new Integer[rows][cols];
        return maze(0, 0);
    }

    public int maze(int r, int c) {

        // BASE CASE: destination
        if (r == rows - 1 && c == cols - 1) {
            return 1;
        }

        // DP check
        if (dp[r][c] != null) {
            return dp[r][c];
        }

        int count = 0;

        // Move Down
        if (r < rows - 1) {
            count += maze(r + 1, c);
        }

        // Move Right
        if (c < cols - 1) {
            count += maze(r, c + 1);
        }

        // Store result
        dp[r][c] = count;
        return count;
    }
}
