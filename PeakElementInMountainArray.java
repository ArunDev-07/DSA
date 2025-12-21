class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0 ;
        int end = arr.length - 1  ;

        while(start < end){
            int mid = start + (end - start) / 2 ;

            if(arr[mid] > arr[mid+1]){
                end = mid ;
            }else{
                start = mid + 1 ;
            }
        }
        return start ;
        
    }
}

// in this we find the peak element in the mountain array.
// in this the normal binary search we use start and end .
// in the while we checks that if start ==  end we stop the loop because we didnt find the greatest element smaller than the target or smaller element greater than the target we need to find the exact element so we stop the loop that the start == end.
// in this we checks that if arr[mid] > arr[mid + 1] we find the the end so end = mid. dont use the end = mid  - 1 if the mid is > than the arr[mid+1]  that is the peak element we stop the end in that mid.
// if arr[mid] < arr[mid+1] we use start = mid + 1.
// example  : in our array {1,2,3,4,3,2,1}  so the mid = 0 + 6 = 3. arr[3] = 4 the 4 is greater than the next element we stop the end = mid.
// now start = 0 end = 3 now the mid is 1 arr[1] = 2 it is smaller than the next so we use start = mid  + 1. now start = 2 end = 3 .now the mid is 2.arr[2] = 3 < 4 so start = mid + 1.
// start = 3 and end = 3 now the loop stops and return start. start = 3 now the arr[3] = 4 . we find the Peak element in the mountain Array.
