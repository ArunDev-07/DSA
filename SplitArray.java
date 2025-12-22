class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0;
        int sum = 0 ;

        for(int num : nums){
            max = Math.max(max,num) ;
            sum+= num ;
        }

        int low = max ;
        int high = sum ;

        while(low < high){
            int mid = low + (high - low) / 2 ;

            if(canSplit(nums,mid,k)){
                high = mid ;
            }else{
                low = mid + 1 ;
            }
        }
        return low ;
    }

    public boolean canSplit(int[] nums, int maxvalue , int k) {
        int count = 1 ;
        int currentsum = 0 ;

        for(int num : nums){
            if(currentsum + num > maxvalue){
                count++ ;
                currentsum = num ;

            if(count > k){
                return false ;
            }
         }else{
            currentsum+= num ;
         }
           
        }
        return true ;
    }
}
