class Solution {
    public int reverse(int x) {
       int rev = 0 ;
       while (x!=0){
        int digit = x%10 ;
        if(rev>Integer.MAX_VALUE/10 || rev<Integer.MIN_VALUE/10){
            return 0 ;
        }
        rev = rev * 10 + digit ;
        x = x/10 ;
       }
       return rev ;
    }
}


//For reverse integer we need to add the rev int for store the ans. we use while loop for this it loops until the x==0.it is used for positive and negative numbers and then first int for x%10 
// remainder finding if the x is 123 the remainder is 3 we get the last value and then the if condition for java has limited values for integer it checks the rev is greater than or smaller then the min and max value it return 0 , 
// rev is used for add the digit values from reverse in the first looping rev is 0 so 0 * 10 + 3 = 3 and then next loop rev is 3 like that it run . x is used for to use the x in next loop so it reduce the last digit by dividing with 10 ex : 123/10 = 12 so in next loop the while takes 12 only like this we find the reverse integer.
