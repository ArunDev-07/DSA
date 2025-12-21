public class InfiniteArray {
    public static void main (String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16} ;
        int target  = 7 ;
        int result = ans(arr , target) ;
        System.out.println (result) ;
    }
    static int ans (int[] arr , int target) {
        int start = 0 ;
        int end = 1 ;

        while(target >= arr[end]) {

            int newstart = end  + 1 ;
            end = end + (end - start  + 1) * 2 ;
            start = newstart ;
        }

        return Binary(arr , target , start , end) ;
    }

    static int Binary(int[] arr , int target , int start , int end) {
        while(start<=end){
            int mid = start + (end - start) / 2 ;
            if(arr[mid] == target){
                return mid ;
            }else if(target < arr[mid]){
                end = mid - 1 ;
            }else {
                start = mid + 1 ;
            }
        }
        return -1 ;
    }
}
// in this problem we had infinte array so we didnt know the array length so we didnt have the end now we find the end first then we make the method.
// in this we find the start and end that means we first take the start as  0 and end as 1. the while loop runs until the target is greater than or equal to the end.
// newstart means start = 0 end = 1 then newstart =  end + 1 it starts from next iteration that means after the end why we didnt put start instead of newstart because we use start in the end also we need that old start.
// then end  = end + (end - start + 1 ) * 2 that means 1 + (1 - 0 + 1) * 2 = 5 then start = 2 now it checks from 2 to 5 . first it takes 2 values then it takes 4 values then it takes 8 values like that it checks until the target>=end .
// then we use that start and end in that normal binary search then we find the mid value.
