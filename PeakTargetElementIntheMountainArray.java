/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = ans(mountainArr);
        int firstTry = Order(mountainArr , target , 0 ,peak);
        if(firstTry != -1){
            return firstTry ;
        }else{
            return Order(mountainArr , target , peak+1, mountainArr.length()-1);
        }       
    }
    int ans(MountainArray mountainArr){
         int start = 0;
        int end = mountainArr.length() -1 ;

        while(start < end){
            int mid = start + (end - start) / 2 ;
            if(mountainArr.get(mid) > mountainArr.get(mid+1)){
                end = mid ;
            }else{
                start = mid + 1 ;
            }
        }
        return start ;
    }
    int Order(MountainArray mountainArr , int target , int start , int end){
        boolean isAsc = mountainArr.get(start) < mountainArr.get(end) ;
        while(start <= end){
            int mid = start + (end- start) / 2 ;

            if(mountainArr.get(mid) == target){
                return mid ;
            }

            if(isAsc){
                if(mountainArr.get(mid) < target) {
                    start = mid + 1 ;
                }else {
                    end = mid -1 ;
                }
            }else{
                if(target < mountainArr.get(mid)){
                    start = mid + 1 ;
                }else{
                    end = mid - 1 ;
                }
            }
         }
        return -1;
    }
}




// package com.example.DSA_JAVA.BinarySearch;
//
// public class PeakTargetElementInMountainArray {
//     public static void main(String[] args){
//
//         int[] arr = {1,2,3,4,5,4,3,2,1};
//         int target = 3 ;
//
//         int peak  = ans(arr) ;
//         int firstTry = Order(arr,target,0,peak) ;
//
//         if(firstTry != -1){
//            System.out.println(firstTry) ;
//         }
//         else{
//             int another = Order(arr,target , peak+1 , arr.length-1 );
//             System.out.println(another) ;
//         }
//     }
//
//     static int ans(int[] arr){
//         int start = 0;
//         int end = arr.length -1 ;
//
//         while(start < end){
//             int mid = start + (end - start) / 2 ;
//
//             if(arr[mid] > arr[mid+1]){
//                 end = mid ;
//             }else{
//                 start = mid + 1 ;
//             }
//         }
//         return start ;
//     }
//
//     static int Order(int[] arr , int target , int start , int end){
//         boolean isAsc = arr[start] < arr[end] ;
//
//         while(start <= end){
//             int mid = start + (end- start) / 2 ;
//
//             if(arr[mid] == target){
//                 return mid ;
//             }
//
//             if(isAsc){
//                 if(arr[mid] < target) {
//                     start = mid + 1 ;
//                 }else {
//                     end = mid -1 ;
//                 }
//             }else{
//                 if(target < arr[mid]){
//                     start = mid + 1 ;
//                 }else{
//                     end = mid - 1 ;
//                 }
//             }
//          }
//         return -1;
//     }
// }



//mountainArr.get(index)
//mountainArr.length()
// only these are changes others are fine same like second one that means in the first function it finds the peak element then using that peak element as the end in the ascending.
//start =0 , end = peak , in descending start = peak + 1 , end = arr.length-1. based on the peak element it uses as the start and end then search using binary search to find the target.
// if the target is given we use while (start <= end) . in peak element that finds while(start<end) it finds until the start == end .
