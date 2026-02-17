import java.util.*;

class Main {

    public static void main(String[] args) {

        /*
        =====================================================
        PROBLEM:
        Rotate each row of matrix by its row index.
        Row 0 -> 0 rotations
        Row 1 -> 1 rotation
        Row 2 -> 2 rotations
        =====================================================

        RIGHT ROTATION FORMULA:
            temp[(i + k) % n] = row[i];

        LEFT ROTATION FORMULA:
            temp[i] = row[(i + k) % n];

        Where:
            i = current index
            k = number of rotations
            n = row length
        */

        int[][] original = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        };

        // Make copies so original stays unchanged
        int[][] rightMatrix = deepCopy(original);
        int[][] leftMatrix  = deepCopy(original);

        // ================= RIGHT ROTATION =================
        for(int r = 0; r < rightMatrix.length; r++) {

            int[] row = rightMatrix[r];  // current row
            int n = row.length;          // row size
            int k = r % n;               // rotate equal to row index

            int[] temp = new int[n];

            for(int i = 0; i < n; i++) {

                /*
                DRY RUN (Example row: {5,6,7,8}, r=1, k=1)

                i=0 → temp[(0+1)%4] = temp[1] = 5
                i=1 → temp[(1+1)%4] = temp[2] = 6
                i=2 → temp[(2+1)%4] = temp[3] = 7
                i=3 → temp[(3+1)%4] = temp[0] = 8

                Result: {8,5,6,7}
                */

                temp[(i + k) % n] = row[i];
            }

            rightMatrix[r] = temp;
        }

        // ================= LEFT ROTATION =================
        for(int r = 0; r < leftMatrix.length; r++) {

            int[] row = leftMatrix[r];
            int n = row.length;
            int k = r % n;

            int[] temp = new int[n];

            for(int i = 0; i < n; i++) {

                /*
                DRY RUN (Example row: {5,6,7,8}, r=1, k=1)

                i=0 → temp[0] = row[(0+1)%4] = row[1] = 6
                i=1 → temp[1] = row[(1+1)%4] = row[2] = 7
                i=2 → temp[2] = row[(2+1)%4] = row[3] = 8
                i=3 → temp[3] = row[(3+1)%4] = row[0] = 5

                Result: {6,7,8,5}
                */

                temp[i] = row[(i + k) % n];
            }

            leftMatrix[r] = temp;
        }

        // ================= OUTPUT =================
        System.out.println("Original Matrix:");
        print(original);

        System.out.println("\nRight Rotation:");
        print(rightMatrix);

        System.out.println("\nLeft Rotation:");
        print(leftMatrix);
    }

    // Utility method to print matrix
    static void print(int[][] matrix) {
        for(int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    // Utility method to copy matrix
    static int[][] deepCopy(int[][] matrix) {
        int[][] copy = new int[matrix.length][];
        for(int i = 0; i < matrix.length; i++) {
            copy[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
        return copy;
    }
}
