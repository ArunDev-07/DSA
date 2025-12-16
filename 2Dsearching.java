import java.util.Arrays;

public class TwoDSeraching {
    public static void main(String []args){
        int[][] arr = {
                {1,2,4,5,6},
                {4,56,6,7,8},
                {34,5,6,756,7}
        };
        int target = 756 ;
        int[] ans = searching(arr , target) ;
        System.out.println(Arrays.toString(ans)) ;
    }

    static int[] searching(int[][] arr , int target){
        for(int row = 0 ; row<arr.length ; row++){
            for(int col =0 ; col<arr[row].length ; col++){
                if(arr[row][col] == target){
                    return new int[] {row , col} ;
                }
            }
        }
        return new int[]{} ;
    }

}

//in this we search the elemnt in the 2d array in this we take one 2d array and put values to the array and initiate the variable to stroe the target and then we print the ans in the array so we add ans as a arr we use Arrays.toString to print the array.
//in the method we get the array and the target we seacrh in the row and the column if the arr[row][col] == target return the new int[] {row , col} else return the empty array.
