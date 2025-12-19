class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0 ;
        int end = letters.length - 1 ;

        while(start<=end){
            int mid = start + (end - start) /2 ;
            if(letters[mid] <= target){
                start = mid + 1 ;
            }else {
                end = mid - 1 ;
            }

        }
        return letters[start % letters.length] ;
        
    }
}

// in this problem we need to find the smallest element greater than the target same like a ceiling but in this we no need to find the same elemtent as the target .
// because they asking that smallest element that greater than the target so == is not used if the target is found in the array we print the next value .
// if the next value is not there we need to print the first element . using arr[start % arr.length] .if arr[start] is 3 means then the loop stops because the 2 indices are there.
 // then start % arr.length 3 % 3 = 0 then it prints the first value if it is same it iterates with start = mid + 1 .
