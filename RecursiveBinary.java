class Main {
    public static void main(String[] args) {
      int[] arr = {1,2,3,4,5,6} ;
      int target = 6 ;
      int result = Binary(arr , target , 0 , 6) ;
      System.out.println(result) ;
    }
    
    static int Binary(int[] arr , int target , int start , int end){
        if(start>end){
            return -1 ;
        }
        int mid = start + (end - start) / 2 ;
        if(target == arr[mid]){
            return mid ;
        }
        if(target < arr[mid]){
            return Binary(arr , target , start , mid-1) ;
        }
       
        return Binary(arr , target , mid + 1 , end) ;
       
    }
      
}



//same like a binary search but it uses if condition instead of while and then it uses the start and end .
