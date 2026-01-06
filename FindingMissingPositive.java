class Solution {

    public int firstMissingPositive(int[] arr) {

        int i = 0;

        // CYCLIC SORT PROCESS
        // Goal: place each positive number x (1 ≤ x ≤ n)
        // at index (x - 1)
        while (i < arr.length) {

            // Correct index for the current value
            int correct = arr[i] - 1;

            // We swap only when:
            // 1. Value is positive
            // 2. Value is within array length
            // 3. Value is not already at its correct position
            if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correct]) {

                // Swap current element with its correct index element
                Swap(arr, i, correct);

            } else {
                // Move forward if:
                // - value is negative or zero
                // - value is greater than array length
                // - value is already in correct position
                i++;
            }
        }

        // AFTER CYCLIC SORT
        // The first index where value != index + 1
        // gives the smallest missing positive number
        for (int index = 0; index < arr.length; index++) {

            if (arr[index] != index + 1) {
                return index + 1;
            }
        }

        // If all numbers from 1 to n are present,
        // then the smallest missing positive is n + 1
        return arr.length + 1;
    }

    // Helper method to swap two elements in the array
    public void Swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
