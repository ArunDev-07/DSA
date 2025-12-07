class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length ;
        int total = n*(n+1)/2 ;
        int ans = 0 ;
        for(int num : nums){
            ans+= num ;
        }
        return total-ans ;
    }
}

// in this we find the missing number first we get the nums(array) length in the integer n. we use the formula n*n+1/2 in the total. we store the answer in the ans integer. for loop for getting the all numbers in the array.
//that sum of numbers store in the ans then in the return we minus the total - ans then we get the missing number
