class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans = 0 ;

        for(int row = 0 ; row<accounts.length ; row++){
            int sum = 0 ;
            for(int col =0 ; col<accounts[row].length ; col++){
                sum+= accounts[row][col] ;

            }
            if(sum>ans){
                ans = sum ;
            }
        }
        return ans ;
    }
}

// Example 1:

Input: accounts = [[1,2,3],[3,2,1]]
Output: 6
Explanation:
1st customer has wealth = 1 + 2 + 3 = 6
2nd customer has wealth = 3 + 2 + 1 = 6
Both customers are considered the richest with a wealth of 6 each, so return 6.
Example 2:

Input: accounts = [[1,5],[7,3],[3,5]]
Output: 10
Explanation: 
1st customer has wealth = 6
2nd customer has wealth = 10 
3rd customer has wealth = 8
The 2nd customer is the richest with a wealth of 10.
Example 3:

Input: accounts = [[2,8,7],[7,1,3],[1,9,5]]
Output: 17

//in this problem we solve the richest customer wealth by using 2D array in this we add the row and col values by using 2 loops and add it in the sum .
  //the sum asigned in the top of the col loop because it add the col values and ans in the top beacuse it return the whole ans. and then the if condition is put after the col loop because it checks each sum.

 
