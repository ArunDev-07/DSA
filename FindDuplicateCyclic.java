class Solution {

    public int findDuplicate(int[] arr) {

        int i = 0; // pointer to traverse the array

        // Step 1: Place each number at its correct index
        while (i < arr.length) {

            int correct = arr[i] - 1; // correct index for current value

            // If current value is not at correct index
            // and current value != value at its correct index
            if (arr[i] != arr[correct]) {

                // Swap to put it in correct place
                Swap(arr, i, correct);

                // Do NOT increment i here, because new value at i must be checked
            } else {

                // If already at correct index, move to next
                i++;
            }
        }

        // Step 2: After cyclic sort, find the duplicate
        for (int index = 0; index < arr.length; index++) {

            // If value at index is not what it should be
            // That means this value is duplicate
            if (arr[index] != index + 1) {

                // Return the duplicate number
                return arr[index];
            }
        }

        // If no duplicate found (just in case)
        return -1;
    }

    public void Swap(int[] arr, int i, int j) {

        // Standard swap operation
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
