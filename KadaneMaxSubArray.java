class Main {
    public static void main(String[] args) {

        // Input array
        int[] arr = {1, 2, 3, 4, 5, 6};

        // maxin → maximum subarray sum ending at current index
        int maxin = arr[0];

        // maxsofar → maximum subarray sum found so far
        int maxsofar = arr[0];

        // Start loop from index 1 because index 0 is already used
        for (int i = 1; i < arr.length; i++) {

            // Decide:
            // 1) Start new subarray from current element
            // 2) OR extend previous subarray
            maxin = Math.max(arr[i], maxin + arr[i]);

            // Update the overall maximum sum if needed
            maxsofar = Math.max(maxsofar, maxin);
        }

        // Print the maximum subarray sum
        System.out.println(maxsofar);
    }
}
