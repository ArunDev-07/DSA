class Solution {
    public int search(int[] arr , int target) {
       int pivot = Rotate(arr) ;
       
       if(pivot == -1){
        return Binary(arr,target ,0 , arr.length-1) ;
       }

       if(arr[pivot] == target){
        return pivot ;
       } 

       if(target >= arr[0]){
        return Binary(arr,target, 0 , pivot-1) ;
       }else{
        return Binary(arr,target , pivot+1 , arr.length-1) ;
       }
    }

     public int Binary(int[] arr , int target , int start, int end){
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

    public int Rotate(int[] arr) {
      int start = 0 ;
      int end = arr.length - 1 ;

      while(start<=end){
        int mid = start + (end - start) / 2 ;
        if(mid < end && arr[mid] > arr[mid+1]){
            return mid ;
        }
        if(mid > start && arr[mid] < arr[mid-1]){
            return mid-1 ;
        }
        if(arr[mid] <= arr[start]){
            end = mid -1 ;
        }else{
            start = mid + 1 ;
        }
      }
      return -1 ;
    }

}

// in this problem there is 4 points need.
// to find the pivot 
// to check if the target is the pivot element.
//  if it is not then decide where it is right or left
// then do binary search in both.
// the pivot element means if the mid element that is greater than the next element or mid is smaller than the mid - 1 return mid - 1.the main logic is to check that in next value mid < end and then in previous value logic mid > start.
// if in the 2 conditions the pivot is not found then checks that if(mid <= arr[start]) end= mid-1 else start = mid + 1 .
// now we check the conditions that if (pivot == -1) return normal binary search .
// if(arr[pivot] == target) return pivot
// if target >=arr[0] return Binary(arr,target , 0 , pivot - 1) 
// else Binary(arr,target , pivot+1 , arr.length - 1.
