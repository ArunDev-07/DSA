package com.example.DSA_JAVA.Recursion;

/*
====================================================================
INCLUDING ALL PATHS – COMPLETE MASTER FILE (FULL THEORY + DRY RUN)
====================================================================

🧠 PROBLEM STATEMENT
--------------------------------------------------------------------
Find ALL possible paths from (0,0) to (2,2) in a 3×3 grid.

Allowed Moves:
    D = Down
    R = Right
    U = Up
    L = Left

Condition:
    ❌ Cannot revisit same cell
    ✔ Must explore all possible paths

--------------------------------------------------------------------
🌍 VISUAL GRID

    (0,0)  (0,1)  (0,2)
    (1,0)  (1,1)  (1,2)
    (2,0)  (2,1)  (2,2)  ← DESTINATION

--------------------------------------------------------------------
🧠 WHAT IS BACKTRACKING?

Backtracking means:

1️⃣ Enter a cell → Mark visited (false)
2️⃣ Explore all possible directions
3️⃣ When finished → Restore cell (true)
4️⃣ Return to previous cell

Golden Rule:
    ENTER → false
    EXIT  → true

This ensures:
    ✔ No infinite loops
    ✔ No revisiting
    ✔ All paths explored

--------------------------------------------------------------------
🌳 FULL RECURSION TREE (3×3)

(0,0)
├── (1,0)
│   ├── (2,0)
│   │   └── (2,1)
│   │       ├── (2,2) ✅
│   │       └── (1,1)
│   │           ├── (1,2)
│   │           │   └── (2,2) ✅
│   │           └── (0,1)
│   │               └── (0,2)
│   │                   └── (1,2)
│   │                       └── (2,2) ✅
│   └── (1,1)
│       ├── (2,1)
│       │   └── (2,2) ✅
│       ├── (1,2)
│       │   └── (2,2) ✅
│       └── (0,1)
│           └── (0,2)
│               └── (1,2)
│                   └── (2,2) ✅
└── (0,1)
    ├── (1,1)
    │   ├── (2,1)
    │   │   └── (2,2) ✅
    │   └── (1,2)
    │       └── (2,2) ✅
    └── (0,2)
        └── (1,2)
            └── (2,2) ✅

Total Paths Printed = 15

--------------------------------------------------------------------
🔍 FULL DRY RUN (STEP-BY-STEP EXECUTION TRACE)

Initial Board:
    T T T
    T T T
    T T T

-------------------------------------------------
CALL 1 → maze("",0,0)
Mark (0,0) = false

Board:
    F T T
    T T T
    T T T

-------------------------------------------------
CALL 2 → maze("D",1,0)
Mark (1,0) = false

Board:
    F T T
    F T T
    T T T

-------------------------------------------------
CALL 3 → maze("DD",2,0)
Mark (2,0) = false

Board:
    F T T
    F T T
    F T T

-------------------------------------------------
CALL 4 → maze("DDR",2,1)
Mark (2,1) = false

Board:
    F T T
    F T T
    F F T

-------------------------------------------------
CALL 5 → maze("DDRR",2,2)
DESTINATION REACHED
PRINT → DDRR
Return

-------------------------------------------------
Back to (2,1)
Try UP

CALL 6 → maze("DDRU",1,1)
Mark (1,1) = false

Board:
    F T T
    F F T
    F F T

-------------------------------------------------
CALL 7 → maze("DDRUR",1,2)
Mark (1,2) = false

Board:
    F T T
    F F F
    F F T

-------------------------------------------------
CALL 8 → maze("DDRURD",2,2)
PRINT → DDRURD

-------------------------------------------------
Backtracking Happens:

(1,2) → true
(1,1) → true
(2,1) → true
(2,0) → true
(1,0) → true
(0,0) → true

Board restored fully to:

    T T T
    T T T
    T T T

-------------------------------------------------
Program continues exploring Right branch from (0,0)

Eventually prints total 15 paths.

--------------------------------------------------------------------
📦 CALL STACK VISUAL (PUSH / POP)

Push:
(0,0)
(1,0)
(2,0)
(2,1)
(2,2)

Pop:
(2,2)
(2,1)
(2,0)
(1,0)
(0,0)

This is how recursion works internally.

--------------------------------------------------------------------
⏱ TIME COMPLEXITY

Worst Case:
    O(4^(n*m))

Because each cell can branch in 4 directions.

--------------------------------------------------------------------
📦 SPACE COMPLEXITY

Recursion depth:
    O(n*m)

Board storage:
    O(n*m)

--------------------------------------------------------------------
🔥 FINAL UNDERSTANDING

Backtracking is:

Push → Explore → Pop
Mark → Explore → Unmark

Without:
    board[r][c] = true;

Other paths would never work.

====================================================================
*/

public class IncludingAllPaths {

    public static void main(String[] args) {

        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        maze("", board, 0, 0);
    }

    /*
    PARAMETERS:
    p      → Path string
    board  → Visited tracking grid
    r      → Current row
    c      → Current column
    */

    static void maze(String p, boolean[][] board, int r, int c) {

        // BASE CONDITION
        if (r == board.length - 1 && c == board[0].length - 1) {
            System.out.println(p);
            return;
        }

        // BLOCK CHECK
        if (!board[r][c]) {
            return;
        }

        // MARK VISITED
        board[r][c] = false;

        // MOVE DOWN
        if (r < board.length - 1) {
            maze(p + "D", board, r + 1, c);
        }

        // MOVE RIGHT
        if (c < board[0].length - 1) {
            maze(p + "R", board, r, c + 1);
        }

        // MOVE UP
        if (r > 0) {
            maze(p + "U", board, r - 1, c);
        }

        // MOVE LEFT
        if (c > 0) {
            maze(p + "L", board, r, c - 1);
        }

        // BACKTRACK (UNMARK)
        board[r][c] = true;
    }
}
