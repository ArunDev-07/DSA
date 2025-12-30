static int countNegatives(int[][] arr) {

    // start from the first row
    int row = 0;

    // start from the last column (top-right corner)
    int col = arr[0].length - 1;

    // to store total negative numbers count
    int count = 0;

    // loop until we go outside the matrix
    while (row < arr.length && col >= 0) {

        // if current element is negative
        if (arr[row][col] < 0) {

            // if one negative is found at (row, col),
            // then all elements below it in the same column are also negative
            // because the column is sorted
            count += arr.length - row;

            // move left to check the next column
            col--;

        } else {

            // current element is positive or zero
            // so negatives cannot be on the left side
            // they must be in the next rows
            row++;
        }
    }

    // return total number of negative elements
    return count;
}




// class Main {
//     public static void main(String[] args) {
//         int[][] arr = {
//                 {4,3,2,-1},
//                 {3,2,1,-1},
//                 {1,1,-1,-2},
//                 {-1,-1,-2,-3}
//         };
//         int result = NBinary(arr) ;
//         System.out.println(result) ;
//     }
//     static int NBinary(int[][] arr){
//         int count = 0 ;
//         for(int i = 0 ; i< arr.length ; i++){
//             for(int j = 0 ; j<arr[i].length ; j++){
//                 if(arr[i][j] < 0){
//                     count++ ;
//                 }
//             }
//         }
//         return count ;
//     }
// }

