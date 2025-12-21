package com.example.DSA_JAVA.BinarySearch;

public class DuplicatesInRotatedArray {
    public static void main (String[] args){
        int[] arr = {1,2,2,2,5,6,7,0,1,2,2} ;
        int target = 6 ;
        int result = search(arr,target) ;
        System.out.println(result) ;
    }

    static int search(int[] arr , int target) {
        int pivot = Rotate(arr) ;
        if(arr[pivot] == target){
            return pivot ;
        }
        if(pivot == -1){
            return Binary(arr,target , 0, arr.length-1) ;
        }
        if(target >= arr[0]){
            return Binary(arr ,target , 0 , pivot-1) ;
        }else{
            return Binary(arr , target , pivot+1 , arr.length - 1) ;
        }
    }

    static int Binary(int[] arr , int target , int start, int end){
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

    static int Rotate(int[] arr) {
        int start = 0;
        int end = arr.length - 1 ;

        while(start<=end){
            int mid = start + (end - start) / 2 ;
            if(mid < end && arr[mid] > arr[mid+1]){
                return mid ;
            }
            if(mid > start && arr[mid] < arr[mid-1]){
                return mid - 1 ;
            }

            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
                if(arr[start] > arr[start+1]){
                    return start ;
                }
                start++ ;

                if(arr[end] < arr[end-1]){
                    return end-1 ;
                }
                end-- ;
            }else if(arr[mid] > arr[start] || arr[mid] == arr[start] && arr[mid] > arr[end]){
                start = mid + 1 ;
            }else{
                end = mid - 1 ;
            }

        }
        return -1 ;
    }

}
// in this same like a Search In Rotated Array but in this we find the duplicates that means if the mid == start and mid == end in that condition we dont skip the easily to check if the start is pivot or not to check that we use arr[start] > arr[start+1} retur start if it is not pivot we refuse that using start++.
// same as the end if arr[end] < arr[end-1] return end - 1 if it is not pivot we refuse the end by using end--.
// then we move to the left it is common that if arr[mid] > arr[start] or arr[mid] == arr[start] and arr[mid] > arr[end]  if the mid is greater then use start = mid + 1. else end = mid - 1.
// in the pivot finding we use that if the target is greater than or equal we use 0  to pivot-1 else pivot + 1 , arr.length - 1.
