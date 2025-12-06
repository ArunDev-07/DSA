class Main {
    public static void main(String[] args) {
        int[] arr = {2,3,7,6} ;
        int target = 9 ; 
     
       for(int i=0 ; i<arr.length ;i++){
           for(int j=i+1 ; j<arr.length ; j++){
               if(arr[i] + arr[j] == target){
                 System.out.println(arr[i] + " " + arr[j]); 
               }
           }
       }
      
    }
}
