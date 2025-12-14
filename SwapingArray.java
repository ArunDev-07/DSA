
import java.util.* ;
class Main {
    public static void main(String[] args) {
       int[] arr = {1,2,3,4,5};
       swap(arr , 1 , 4) ;
       System.out.print(Arrays.toString(arr)) ;
    }
    static void swap(int[] arr , int index1 , int index2){
        int temp = arr[index1] ;
        arr[index1] = arr[index2] ;
        arr[index2] = temp ;
    }
}


//in this problem we swap the values in the array using swap method in that we get the array and swapping indices , then we swap it using temp variable.
