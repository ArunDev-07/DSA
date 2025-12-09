class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums) ;
        for(int i =1 ; i<nums.length ; i++){
            if(nums[i] == nums[i-1]){
                return true ;
            }
        }
        return false ;
    }
}

//first we sort the array if the array is {1,2,3,1} if we sort this {1,1,2,3} in the loop we take second index that means (1). starts from index 1 to last. 
//the if condition checks if the index 1 that means value 1 checks index-1 that means 0 index value 1 if it is same return true else return false. 
