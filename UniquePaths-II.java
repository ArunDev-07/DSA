/*
============================================================
Unique Paths II with Obstacles - Memoization Approach
============================================================

Command Explanation:
--------------------
1. Integer[][] dp; 
   // Declare a 2D array to store memoization results.
   // dp[r][c] will store number of unique paths from cell (r,c) to destination.

2. public int uniquePathsWithObstacles(int[][] maze)
   // Main function called by LeetCode.
   // Initializes dp array and calls recursive function from (0,0).

3. if(maze[r][c] == 1) return 0;
   // If current cell is an obstacle, no path is possible.

4. if(r == maze.length-1 && c == maze[0].length-1) return 1;
   // If we reached destination, there is exactly 1 path.

5. if(dp[r][c] != null) return dp[r][c];
   // If we already calculated paths from this cell, return stored value.

6. count+= obstacles(maze, r+1, c);
   // Recursively move down (if inside bounds) and add paths.

7. count+= obstacles(maze, r, c+1);
   // Recursively move right (if inside bounds) and add paths.

8. dp[r][c] = count;
   // Store the computed number of paths for memoization.
   // Return the count.

Time Complexity:
----------------
- Each cell (r,c) is visited **at most once** because we store the result in dp[r][c].
- So the total time complexity is **O(m * n)** where m = number of rows, n = number of columns.

Space Complexity:
-----------------
- **DP array:** O(m * n) to store computed results.
- **Recursion stack:** O(m + n) in the worst case (max path length from top-left to bottom-right).
- So overall space complexity is **O(m * n)**.

============================================================
*/

class Solution {
    Integer[][] dp ;  // Memoization table

    public int uniquePathsWithObstacles(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
        dp = new Integer[m][n];  // Initialize DP table
        return obstacles(maze, 0, 0);  // Start recursion from top-left
    }

    public int obstacles(int[][] maze, int r , int c){
        // 1️⃣ Check if current cell is an obstacle
        if(maze[r][c] == 1){
            return 0;
        }

        // 2️⃣ Check if reached destination
        if(r == maze.length-1 && c == maze[0].length-1){
            return 1 ;
        }

        // 3️⃣ Check if this cell is already computed
        if(dp[r][c] != null){
            return dp[r][c] ;
        }

        int count = 0 ;

        // 4️⃣ Move down
        if(r < maze.length-1){
            count += obstacles(maze , r+1 ,c) ;
        }

        // 5️⃣ Move right
        if(c < maze[0].length-1){
            count += obstacles(maze , r ,c+1) ;
        }

        // 6️⃣ Store result in DP table and return
        return dp[r][c] = count ;
    }
}

/*
============================================================
Explanation Paragraph:
----------------------
This solution uses **recursive DFS** combined with **memoization** to calculate the number of unique paths
from the top-left corner (0,0) to the bottom-right corner (m-1,n-1) in a grid with obstacles. 
Each cell can only move **down or right**. 

- If the current cell is an obstacle (1), it cannot be part of any path, so return 0. 
- If the destination is reached, return 1 as a valid path is found. 
- For each cell, the function recursively calculates paths by moving down and right.
- Memoization is used to **store previously computed paths** for a cell in the `dp` array, 
  which prevents recalculating the same cell multiple times. 
- This reduces the exponential time complexity of pure recursion to **O(m*n)**.

============================================================
Dry Run with Visual Example:
----------------------------

Input grid:
maze = [[0,0,0],
        [0,1,0],
        [0,0,0]]

Visual representation:
(0,0) (0,1) (0,2)
(1,0) (1,1) (1,2)
(2,0) (2,1) (2,2)

- Start at (0,0)

Step 1: obstacles(0,0)
  - Not obstacle, not destination
  - Move down: obstacles(1,0)
  - Move right: obstacles(0,1)

Step 2: obstacles(1,0)
  - Not obstacle, not destination
  - Move down: obstacles(2,0)
  - Move right: obstacles(1,1) → Obstacle, return 0

Step 3: obstacles(2,0)
  - Move down: out of bounds → 0
  - Move right: obstacles(2,1)

Step 4: obstacles(2,1)
  - Move down: out of bounds → 0
  - Move right: obstacles(2,2) → Destination, return 1

Backtracking:
- obstacles(2,1) = 1
- obstacles(2,0) = 1
- obstacles(1,0) = 1 + 0 = 1

Step 5: obstacles(0,1)
  - Move down: obstacles(1,1) → Obstacle → 0
  - Move right: obstacles(0,2)

Step 6: obstacles(0,2)
  - Move down: obstacles(1,2)
  - Move right: out of bounds → 0

Step 7: obstacles(1,2)
  - Move down: obstacles(2,2) → Destination → 1
  - Move right: out of bounds → 0
  - obstacles(1,2) = 1

Backtracking:
- obstacles(0,2) = 1
- obstacles(0,1) = 0 + 1 = 1
- obstacles(0,0) = 1 + 1 = 2 ✅

Answer: 2 unique paths
============================================================
*/
