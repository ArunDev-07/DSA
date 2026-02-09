package com.example.DSA_JAVA.Recursion;

/**
 * MazeKunal.java
 *
 * This program does two things:
 * 1. Counts the number of paths in a r x c maze from top-left to bottom-right.
 * 2. Prints all possible paths as strings consisting of "D" (Down) and "R" (Right).
 *
 * Rules:
 * - You can only move Down or Right.
 * - Starting point: top-left (r, c)
 * - Ending point: bottom-right (1,1)
 */
public class MazeKunal {
    public static void main(String[] args){
        // Uncomment to see number of paths
        // System.out.println("Total paths: " + maze(3,3));

        // Print all possible paths in a 3x3 maze
        path("", 3, 3);
    }

    /**
     * Counts number of paths in r x c maze recursively
     * @param r remaining rows
     * @param c remaining columns
     * @return number of possible paths
     */
    static int maze(int r , int c){
        // Base case: if we are in the first row or first column,
        // there's only one way to reach the destination (straight line)
        if(r == 1 || c == 1){
            return 1 ;
        }

        // Recursive calls:
        int left = maze(r-1, c); // move down
        int right = maze(r, c-1); // move right

        // Total paths = paths by moving down + paths by moving right
        return left  + right ;
    }

    /**
     * Prints all possible paths in the maze using recursion and backtracking
     * @param p current path as string
     * @param r remaining rows
     * @param c remaining columns
     */
    static void path(String p , int r , int c){
        // Base case: reached destination (1,1)
        if(r==1 && c == 1){
            System.out.println(p);
            return;
        }

        // If possible, move down and add "D" to path
        if(r > 1){
            path(p + "D" , r -1  , c);
        }

        // If possible, move right and add "R" to path
        if(c > 1){
            path(p + "R" , r , c-1) ;
        }
    }
}

/*
----------------------------------------------------------
EXPLANATION:

1️⃣ Function maze(r, c):
- Counts number of paths in a r x c maze.
- Base case: r == 1 or c == 1 → only 1 path possible.
- Recursive case:
    - Move down: maze(r-1, c)
    - Move right: maze(r, c-1)
- Total paths = down + right

2️⃣ Function path(p, r, c):
- Prints all possible paths as strings "D" (down) and "R" (right)
- Base case: r==1 && c==1 → print path
- Recursive case:
    - If r>1 → move down, add "D" to path
    - If c>1 → move right, add "R" to path
- Recursion + backtracking automatically explores all possibilities

----------------------------------------------------------
DRY RUN FOR 3x3 MAZE (Printing all paths):

Call: path("",3,3)

1. Start at r=3, c=3, p=""
   - Move down: path("D",2,3)
       - Move down: path("DD",1,3)
           - Move right: path("DDR",1,2)
               - Move right: path("DDRR",1,1) → print "DDRR"
       - Move right: path("DR",2,2)
           - Move down: path("DRD",1,2)
               - Move right: path("DRDR",1,1) → print "DRDR"
           - Move right: path("DRR",2,1)
               - Move down: path("DRRD",1,1) → print "DRRD"
   - Move right: path("R",3,2)
       - Move down: path("RD",2,2)
           - Move down: path("RDD",1,2)
               - Move right: path("RDDR",1,1) → print "RDDR"
           - Move right: path("RDR",2,1)
               - Move down: path("RDRD",1,1) → print "RDRD"
       - Move right: path("RR",3,1)
           - Move down: path("RRD",2,1)
               - Move down: path("RRDD",1,1) → print "RRDD"

All possible paths (Top-left to Bottom-right) in 3x3 maze:
1. DDRR
2. DRDR
3. DRRD
4. RDDR
5. RDRD
6. RRDD

----------------------------------------------------------
VISUAL RECURSION TREE (3x3):

Start: ""
 ├─ "D"
 │   ├─ "DD"
 │   │   └─ "DDR" → "DDRR"
 │   └─ "DR"
 │       ├─ "DRD" → "DRDR"
 │       └─ "DRR" → "DRRD"
 └─ "R"
     ├─ "RD"
     │   ├─ "RDD" → "RDDR"
     │   └─ "RDR" → "RDRD"
     └─ "RR"
         └─ "RRD" → "RRDD"

- Each node = current path-so-far
- Each branch = choosing Down "D" or Right "R"
- Base case prints path
- Backtracking ensures all combinations are explored
*/
