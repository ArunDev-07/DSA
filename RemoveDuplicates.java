class Solution {
    public int removeDuplicates(int[] nums) {
       
        int i = 0 ;
        if(nums.length==0){
            return 0 ;
        }
        for(int j=1 ;j<nums.length ; j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j] ;
            }
        }
        return i+1 ;
        
    }
}
//in this we are not creating new array we just check and move the values to the same array. first i=0 it starts from the nums 0 index . in the loop the j takes from the 1 index if the values
// are {1,1,2,3,4} the if condition checks that if the nums[i] != nums[j] if it is same ignore if it is not same it increase the i from 0 to 1. example in the array i[0]=1 and j[1]=1 same so no change just increase the j.
// j increses because of the loop i is not increase. next loop i[0]=1 and j[2]= 2 so it is not same i increases nums[1] = nums[2] that means i second value = 2 we did not change the nums[0] value.
//in the next loop i nums[1]= 2 and j nums[3]= 3 so it is not same i increase i nums[2] =  j nums[3] that means nums third value = 3 then last loop nums[2]!=nums[4] so i increases that means 3!=4 .
//so i increases nums[3] = nums[4] that means the 3rd index of i is 4th index of j so i 3rd index is 4. now the  
