/*
    PROBLEM:
    --------
    Given a 2D board and a word,
    check if the word exists in the board.

    Rules:
    - You can move Up, Down, Left, Right
    - You cannot use the same cell twice in one path

    Example:
    board =
    A B C E
    S F C S
    A D E E

    word = "ABCCED"

    Output: true

    This problem is from:
    LeetCode 79 - Word Search
*/

class Solution {

    /*
        visited[i][j] = true  → this cell is already used in current path
        visited[i][j] = false → this cell is free to use

        Why we need visited?
        --------------------
        To prevent:
        - Reusing same cell twice
        - Infinite loops
    */
    boolean visited[][];

    public boolean exist(char[][] board, String word) {

        int rows = board.length;      // total rows
        int cols = board[0].length;   // total columns

        // Create visited matrix (initially all false)
        visited = new boolean[rows][cols];

        /*
            Try starting DFS from every cell in the board.
            Because the word can start anywhere.
        */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                /*
                    Start only if first letter matches.
                    Example:
                    If word = "ABCCED"
                    We only start from cells containing 'A'
                */
                if (board[i][j] == word.charAt(0)) {

                    // Start DFS search from this cell
                    if (search(i, j, 0, board, word)) {
                        return true;  // word found
                    }
                }
            }
        }

        // If no path found
        return false;
    }


    /*
        Recursive DFS + Backtracking

        Parameters:
        i, j  → current position in board
        index → current character position in word
    */
    public boolean search(int i, int j, int index,
                          char[][] board, String word) {

        /*
            BASE CASE
            ----------
            If index equals word length,
            it means all characters matched successfully.
        */
        if (index == word.length()) {
            return true;
        }

        /*
            INVALID CONDITIONS
            -------------------
            1. Out of bounds
            2. Already visited
            3. Character mismatch
        */
        if (i < 0 || i >= board.length ||
            j < 0 || j >= board[0].length ||
            visited[i][j] ||
            board[i][j] != word.charAt(index)) {

            return false;
        }

        /*
            STEP 1: Mark current cell as visited
            So we don't reuse it in this path.
        */
        visited[i][j] = true;

        /*
            STEP 2: Explore 4 directions
            Down, Right, Up, Left
            If any one direction returns true,
            we return true.
        */
        boolean found =
                search(i + 1, j, index + 1, board, word) ||  // Down
                search(i, j + 1, index + 1, board, word) ||  // Right
                search(i - 1, j, index + 1, board, word) ||  // Up
                search(i, j - 1, index + 1, board, word);    // Left

        /*
            STEP 3: Backtrack
            --------------
            Unmark visited before returning.
            This allows other paths to use this cell.
        */
        visited[i][j] = false;

        return found;
    }
}


/*
=========================================================
                VISUAL DRY RUN EXAMPLE
=========================================================

Board:

A B C E
S F C S
A D E E

Word = "ABCCED"

Step 1:
Start at (0,0) → 'A' matches word[0]

Step 2:
Move Right → (0,1) → 'B' matches word[1]

Step 3:
Move Right → (0,2) → 'C' matches word[2]

Step 4:
Move Down → (1,2) → 'C' matches word[3]

Step 5:
Move Down → (2,2) → 'E' matches word[4]

Step 6:
Move Left → (2,1) → 'D' matches word[5]

Now index == word.length()
→ return true

Path followed:

(0,0) A
(0,1) B
(0,2) C
(1,2) C
(2,2) E
(2,1) D


Visual shape:

A → B → C
        ↓
        C
        ↓
        E ← D


=========================================================
            BACKTRACKING CONCEPT SUMMARY
=========================================================

Every recursive call does:

1. Check validity
2. Mark visited
3. Explore neighbors
4. Unmark visited (backtrack)

This is the standard DFS + Backtracking template.

=========================================================
TIME COMPLEXITY
=========================================================

Worst case:
O(rows * cols * 4^L)

L = length of word

=========================================================
END OF COMPLETE FILE
=========================================================
*/
