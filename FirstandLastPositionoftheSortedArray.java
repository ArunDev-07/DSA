class Solution {
     public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1} ;
        int start  = search(nums , target , true ) ;
        int end  = search(nums , target , false ) ;
        ans[0] = start ;
        ans[1] = end ;
        return ans ;


    }

    int search (int[] arr ,int target , boolean FindStart){
        int ans = -1 ;
        int start = 0 ;
        int end = arr.length - 1 ;
        while(start<=end){
            int mid = start + (end - start) / 2 ;
            if(arr[mid] == target){
                ans = mid ;
                if(FindStart){
                    end = mid - 1 ;
                }else {
                    start  = mid + 1 ;
                }
            }else if(target < arr[mid]){
                end = mid - 1 ;
            }else {
                start = mid + 1 ;
            }
        }
        return ans ;

    }
}

// We need to find the first and last index of the target in a sorted array,
// even if duplicates exist.
//
// We use binary search twice using the same search() method.
// search(arr, target, true)  -> finds the first index
// search(arr, target, false) -> finds the last index
//
// Inside search():
// - We do normal binary search
// - When arr[mid] == target, we store mid in ans
// - But we don't stop there
//    If FindStart is true: move left (end = mid - 1)
//    Else: move right (start = mid + 1)
//
// This way, we push the boundary until we reach the first or last position.
// If target never matches, ans remains -1.
//
// Example: [2,4,4,4,5,6,7], target = 4
// First search (FindStart=true) will return index 1
// Second search (FindStart=false) will return index 3
// Final output = [1,3]
