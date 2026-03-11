package com.example.DSA_JAVA.Recursion;

/*
========================================================
N-Knights Problem (Backtracking)

Problem:
Place N knights on an N×N chessboard such that
no knight can attack another knight.

Knight Move (L Shape):
2 up + 1 left
2 up + 1 right
1 up + 2 right
1 down + 2 left
(and the other mirrored moves)

Example for N = 4

Goal:
Place 4 knights on a 4x4 board safely.

Approach:
We use BACKTRACKING.

At every cell we have two choices:
1) Place a knight
2) Skip the cell

Before placing a knight we check if it is SAFE.

========================================================
Time Complexity: Exponential
Space Complexity: O(N²) for the board
========================================================
*/

public class NKnights {

    public static void main(String[] args) {

        // board size
        int n = 4;

        // create chess board
        boolean[][] board = new boolean[n][n];

        // start placing knights
        Knights(board, 0, 0, 4);
    }


    /*
    --------------------------------------------------------
    Knights Function (Recursive Backtracking)

    Parameters:
    board   -> chess board
    row     -> current row
    col     -> current column
    knights -> number of knights left to place

    Logic:
    1) If knights == 0 → solution found
    2) If column ends → move to next row
    3) Check if safe → place knight
    4) Backtrack
    --------------------------------------------------------
    */

    static void Knights(boolean[][] board, int row, int col, int knights) {

        // BASE CASE
        // If all knights placed -> print board
        if (knights == 0) {
            display(board);
            System.out.println();
            return;
        }

        // If column exceeds board -> move to next row
        if (col == board.length) {
            Knights(board, row + 1, 0, knights);
            return;
        }

        // If board finished -> stop
        if (row == board.length) {
            return;
        }

        // CHECK IF KNIGHT CAN BE PLACED
        if (isSafe(board, row, col)) {

            // place knight
            board[row][col] = true;

            // move to next column
            Knights(board, row, col + 1, knights - 1);

            // BACKTRACK
            board[row][col] = false;
        }

        // SKIP THIS CELL
        Knights(board, row, col + 1, knights);
    }


    /*
    --------------------------------------------------------
    isSafe()

    Checks whether a knight can be placed safely.

    We only check positions where a previous knight
    could already exist.

    Knight attack positions checked:

    (row-2 , col-1)
    (row-2 , col+1)
    (row-1 , col+2)
    (row+1 , col-2)

    Why only these 4?

    Because we fill the board LEFT → RIGHT
    and TOP → BOTTOM.

    So future cells don't contain knights yet.
    --------------------------------------------------------
    */

    public static boolean isSafe(boolean[][] board, int row, int col) {

        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }

        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }

        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }

        if (isValid(board, row + 1, col - 2)) {
            if (board[row + 1][col - 2]) {
                return false;
            }
        }

        return true;
    }


    /*
    --------------------------------------------------------
    isValid()

    Checks if the position is inside the board.
    Prevents ArrayIndexOutOfBoundsException.
    --------------------------------------------------------
    */

    public static boolean isValid(boolean[][] board, int row, int col) {

        return row >= 0 && row < board.length &&
               col >= 0 && col < board.length;
    }


    /*
    --------------------------------------------------------
    display()

    Prints the chess board.

    K -> Knight
    X -> Empty cell
    --------------------------------------------------------
    */

    public static void display(boolean[][] board) {

        for (boolean[] row : board) {

            for (boolean element : row) {

                if (element) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }

            System.out.println();
        }
    }
}


/*
========================================================
DRY RUN (Example)

Board = 4x4
Knights = 4

Step 1
Place knight at (0,0)

K X X X
X X X X
X X X X
X X X X


Step 2
Try next cell (0,1)

K K X X
X X X X
X X X X
X X X X


Step 3
Continue recursion until 4 knights placed.

Example solution:

K K K K
X X X X
X X X X
X X X X


Another solution:

K X K X
X K X K
X X X X
X X X X


Backtracking explores every valid placement.

========================================================
*/
