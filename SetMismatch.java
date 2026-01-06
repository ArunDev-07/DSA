class Solution {

    public int[] findErrorNums(int[] arr) {

        int i = 0;

        // CYCLIC SORT
        // Place each number at its correct index
        // Correct index for value x is (x - 1)
        while (i < arr.length) {

            int correct = arr[i] - 1;

            // If the current element is NOT at its correct position
            // then swap it with the element at its correct index
            if (arr[i] != arr[correct]) {
                Swap(arr, i, correct);
            } else {
                // If already in correct position
                // OR duplicate is found, move to next index
                i++;
            }
        }

        // After cyclic sort:
        // The index where arr[index] != index + 1
        // tells us:
        // arr[index]  -> duplicate number
        // index + 1   -> missing number
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1) {
                return new int[] { arr[index], index + 1 };
            }
        }

        // This line will never execute for valid input
        return new int[] { -1, -1 };
    }

    // Swap function to exchange two elements in the array
    public void Swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
