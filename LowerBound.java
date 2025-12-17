class Main {
    public static void main(String[] args) {
      int[] arr = {1,2,3,4,5,6} ;
      int target = 6 ;
      int result = LowerBound(arr ,target) ;
      System.out.println(result) ;
    }
    
    static int LowerBound(int[] arr ,int target) {
        
       for(int i =0 ;i<arr.length ; i++){
           if(arr[i] >= target){
               return i ;
           }
       }
       return arr.length ;
    }
      
}

//<= means it checks that is the arr[i] value is smaller than target  it prints the 1 .
//so we use the >= that means it checks that greater values nearby target if it is equal it returns.
