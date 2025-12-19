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

// in this we need to find the first and last index of the array even if there any duplicates in the array and then in this  we use the search the new method used to find the first and last index.
// now the normal binary condition but we didnt return the mid value instead of we take the mid value and put it in the ans variable and then the important is if the value is not found we need to return [-1,-1].
// we need to check using the boolean firstindex that checks if it is true start = mid + 1 it moves to the left side otherwise end = mid -1.
// in the above main method we assign two variables in that 2 variables we assign 3 parameters search method inside we have 3 parameters ( array , target  , firstindex = true / false )
// by using that we find the first and last index .
// example : arr = [2,4,4,4,5,6,7]
target = 4
// in this the mid value is 3 so the third value is arr[3] = 4 the value is equal to the target if it is equal to the target we assign that in the variable ans.
// now we use the search method to find end . if the firstIndex = false we use start = mid + 1. so start is 4 and end is 6 so we now find the mid 4 + 6  =10 / 2  => 5 .
     // arr[5] = 6 so we check 6 > 4 the target is low so we use end = mid -1. start  =4 , end = 4 . so the mid is 4 .arr[4] = 5 so the target is low.
     // we use the end = mid - 1 . start = 4 and end 3 the while loop stops then the end value is the last value .
     // now we find the first value firstIndex = true it means we use the end = mid - 1 . end is same like a start 0 + 6 = 3 . arr[3] = 4 so the arr[mid == target .
     // now we store the mid in the ans . now the firstIndex is true so we use the end = mid - 1 . start = 0 , end = 2 . arr[1] = 4 so again same we store the value in ans ans we again use the end = mid - 1 .
     // start = 0  , end = 0 now we checks 2 < 4 so we use the start = mid + 1. now start = 1 , and end = 0 the while loop stops .
     // now we get the start and end then assign in the search method and move the answers on the ans array 0 , 1 .
