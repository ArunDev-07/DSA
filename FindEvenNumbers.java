class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0 ;
        for(int i =0 ; i<nums.length ; i++){
            if(String.valueOf(nums[i]).length()%2==0){
                ans++ ;
            }
        }
        return ans ;
    }
}

//in this problem we solve that count even digit numbers in the array.in this we count the values that has even digit numbers.so we assign the value for store the count of the even digit numbers.
// in the loop we check all the numbers.an int didnt have the length or length() so we change the int length to string by using String.valueOf(nums[i]).length() it get the int length and store in the string .
// the if condition checks if the length is %2==0 the ans++ increases then we return the ans.
