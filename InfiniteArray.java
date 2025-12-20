package com.example.DSA_JAVA.BinarySearch;

public class InfiniteArray {
    public static void main (String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16} ;
        int target  = 7 ;
        int result = ans(arr , target) ;
        System.out.println (result) ;
    }
    static int ans (int[] arr , int target) {
        int start = 0 ;
        int end = 1 ;

        while(target >= arr[end]) {

            int newstart = end  + 1 ;
            end = end + (end - start  + 1) * 2 ;
            start = newstart ;
        }

        return Binary(arr , target , start , end) ;
    }

    static int Binary(int[] arr , int target , int start , int end) {
        while(start<=end){
            int mid = start + (end - start) / 2 ;
            if(arr[mid] == target){
                return mid ;
            }else if(target < arr[mid]){
                end = mid - 1 ;
            }else {
                start = mid + 1 ;
            }
        }
        return -1 ;
    }
}
