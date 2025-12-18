public class CeilingNumber {
    public static void main (String[] args){
        int[] arr = {1,2,4,5,6,7,8} ;
        int target = 3 ;
        int result = Ceiling(arr  , target) ;
        System.out.println(result) ;
    }
    static int Ceiling(int[] arr , int target) {
        int start = 0;
        int end = arr.length - 1;

        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return mid;
            }
            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        if(start < arr.length){
            return arr[start] ;
        }
        return -1 ;

    }
}


// in this problem the concept is simple the answer is in the while loop because we need to find the greater then equal to my target that means i have an array {1,2,4,5,6} the target is 3 so i need to print 4 because it is the greater than equal to a target.
// in this while loop the condition runs until the start is smaller than the end . in the method we find the mid  in first the mid is 3. the arr[3] is 5 our target is 3 so 3 < 5.
// our target is small so we use the end = mid -1 . now we checks 0 + (2-0) / 2 = 1 . arr[1] = 2 so 3>2 in this we use start = mid + 1 . 2 + (2-2) / 2 = 2 . arr[2] = 4 . so 3 < 4.
// now we use the end = mid - 1 . our while loop exists because it checks until the start is smaller than the end now start =  2 and end =  1 . so the last if condition checks that start < arr.length because if start greater than arr.lenght then there is no element then the start value so it returns -1.
// if start < arr.length return the arr[start] .
