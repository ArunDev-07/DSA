package com.example.DSA_JAVA.BinarySearch;

public class SplitArray {
    public static void main (String[] args){
        int[] arr = {7,2,5,10,8} ;
        int k = 2 ;
        int result = Split(arr, k) ;
        System.out.println(result) ;
    }

    static int Split(int[] nums , int k){   // in this problem we need to find the max value and sum bu using that we made the binary search.
        int start = 0;
        int end = 0;

        for(int num : nums){
            start  = Math.max(start , num) ; //it is used to find the max value
            end+= num ;    // used to find the sum value
        }

        while(start < end) {    //we check if start < end it checks until start == end we need accurate value so we use start < end

            int sum = 0;   // the sum is used to add the values that checks if added values greater than mid we need to add new subarray.
            int pieces = 1;
            int mid = start + (end - start) / 2;

            for (int num : nums) {
                if (sum + num > mid) {   // if the sum is bigger than the mid that means the pieces increases the next subarray create
                    pieces++;
                    sum = num;  // we need to put the new value after exceeding the mid in the new subarray
                }else{
                    sum+= num ;   // if the sum is not exceeding we can add all values ex : if the array is like this {7,2,4} the mid is 15 we can add all the value it is not exceeding no need to increases the pieces
                }
            }

            if(pieces > k){
                start = mid + 1 ;    //if the pieces exceed that means we have the low value because more pieces comes when the mid  = low.
            }else{
                end = mid ;  //if pieces  = 2 then we choose that is the mid
            }

        }
        return end ;

    }
}
