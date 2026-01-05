class Solution {

    public int missingNumber(int[] arr) {

        int i = 0; 
        // Pointer used for cyclic sort traversal

        // Step 1: Place each number at its correct index
        // Number x should be placed at index x
        while (i < arr.length) {

            int correct = arr[i];
            // Correct index for current value is the value itself

            // Check:
            // 1) arr[i] < arr.length → ignore numbers equal to n
            // 2) arr[i] != arr[correct] → value not in correct position
            if (arr[i] < arr.length && arr[i] != arr[correct]) {

                // Swap current element with the element at its correct index
                Swap(arr, i, correct);

                // Do NOT increment i here
                // After swap, a new value comes to index i
                // That value must be checked again
            } else {

                // If element is already in correct position
                // OR element equals n
                // Move to the next index
                i++;
            }
        }

        // Step 2: Find the missing number
        // If index != value, that index is missing
        for (int index = 0; index < arr.length; index++) {

            if (index != arr[index]) {
                // First index where value is not equal to index
                // That index is the missing number
                return index;
            }
        }

        // Step 3:
        // If all indices match their values,
        // then the missing number is n
        return arr.length;
    }

    public void Swap(int[] arr, int i, int j) {

        // Temporary variable to store value at index i
        int temp = arr[i];

        // Place value of index j at index i
        arr[i] = arr[j];

        // Place temp value at index j
        arr[j] = temp;
    }
}
