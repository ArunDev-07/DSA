class Solution {

    // Main function to check whether the target exists in the rotated sorted array
    public boolean search(int[] nums, int target) {

        int peak = Search(nums); 
        // Find the pivot index (largest element) using modified binary search

        if (peak == -1) {
            // If peak is -1, the array is not rotated
            return Binary(nums, target, 0, nums.length - 1);
            // Apply normal binary search on the entire array
        }

        if (nums[peak] == target) {
            // If the pivot element itself is equal to target
            return true;
        }

        boolean result = Binary(nums, target, 0, peak);
        // Perform binary search on the left sorted part (from index 0 to pivot)

        if (result != false) {
            // If target is found in the left part
            return result;
        } else {
            // Otherwise, search in the right sorted part (pivot+1 to end)
            return Binary(nums, target, peak + 1, nums.length - 1);
        }
    }

    // Standard binary search function for sorted arrays
    public boolean Binary(int[] arr, int target, int start, int end) {

        while (start <= end) {
            // Continue searching while valid range exists

            int mid = start + (end - start) / 2;
            // Calculate mid safely to avoid integer overflow

            if (arr[mid] == target) {
                // If target is found at mid index
                return true;
            } else if (target < arr[mid]) {
                // If target is smaller, search in the left half
                end = mid - 1;
            } else {
                // If target is greater, search in the right half
                start = mid + 1;
            }
        }

        return false;
        // Target not found in this sorted section
    }

    // Function to find the pivot (largest element) in rotated array with duplicates
    public int Search(int[] arr) {

        int start = 0;
        int end = arr.length - 1;
        // Initialize binary search boundaries

        while (start <= end) {
            // Continue binary search until search space is valid

            int mid = start + (end - start) / 2;
            // Calculate mid index

            if (mid < end && arr[mid] > arr[mid + 1]) {
                // If current element is greater than the next element,
                // then mid is the pivot
                return mid;
            }

            if (mid > start && arr[mid] < arr[mid - 1]) {
                // If current element is smaller than previous element,
                // then mid-1 is the pivot
                return mid - 1;
            }

            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // If start, mid, and end elements are equal,
                // duplicates exist and sorted half cannot be determined

                if (start < end && arr[start] > arr[start + 1]) {
                    // Check if start itself is pivot
                    return start;
                }

                start++;
                // Skip duplicate element from start

                if (end > start && arr[end] < arr[end - 1]) {
                    // Check if end-1 is pivot
                    return end - 1;
                }

                end--;
                // Skip duplicate element from end

            } else if (arr[mid] > arr[start] || arr[mid] > arr[end]) {
                // If left side is sorted, pivot must be on right side
                start = mid + 1;
            } else {
                // Otherwise, pivot must be on left side
                end = mid - 1;
            }
        }

        return -1;
        // If no pivot is found, the array is not rotated
    }
}
