class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7} ;
        int target = 3 ;
        int result = BinarySearch(arr , target) ;
        System.out.println(result);
        }
        static int BinarySearch(int[] arr , int target){
            int start = 0 ;
            int end = arr.length-1;
            
            while(start<=end){
                int  mid = start + (end - start) / 2 ;
                
                if(target == arr[mid]){
                    return mid ;
                }else if(target < arr[mid]){
                    end = mid - 1 ;
                }else{
                    start = mid + 1 ;
                }
            }
            return -1 ;
         }
}


//in this problem we solve the binary search in this we have array we find the target using binary search .
//first we set the method binary search in that we add our array and target .
// by using that we assign the starting and ending points of the array to find the middle.
//then we use while loop it loops until the start is smaller than the end .
//then we find the middle value by using this formula mid = start + (end - start) / 2.
//if the arr[mid] value is equal to target then it print the index .
// if the target is smaller than the mid then we decrease the end by using mid - 1 .
// if the target is greater than the mid value we increase mid + 1 .
// that means if the target is big move right side that means high level if it is small move left side that means low level .
// in this code our target is 3 start  0 end 6 then the mid is 3 lets check arr[3] = 4 the 3 < 4 the target is small.
//so we move left end = mid -1 . now we find mid 0 + (2 - 0 ) /2  = 1 . then we checks arr[1] = 2 .  so 3>2 so we move right side.
// start = mid + 1 . so the mid is 2 + (2 - 2) / 2 = 2. so arr[2] = 3 .
//now the target is equal to the arr[mid] 3==3 then print the mid 2.





