import java.util.* ;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in) ;
        System.out.println("Enter the row size") ;
        int a = scan.nextInt() ;
         System.out.println("Enter the column size") ;
        int b = scan.nextInt() ;
        int[][] arr = new int[a][b];
        for(int row = 0 ; row<arr.length ; row++){
            for(int col = 0 ; col<arr[row].length ; col++){
                arr[row][col] = scan.nextInt() ;
            }
        }
        for(int[] array : arr){
            System.out.println(Arrays.toString(array));
        }
        
    }
}


//in this problem we use 2 array so we use int[][] arr = new int [][] ; first one is row and another is column we get the input from the user.
//by using loops the row is based on the array length the column is based on the array inside row length based on that we get the input if the input of the row is 3 and input of the col is 3.
//means arr[row][col] 3*3  = scan.nextInt() ; 3 row 3 column based on that we get the arrays by using enhanced for loop int[] array : arr that means we get each array in the arr and then we print it by using Arrays.toString(array) ;.
