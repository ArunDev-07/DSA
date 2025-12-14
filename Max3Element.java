public class MaxArray {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5} ;
        int first = arr[0] ;
        int second = 0 ;
        int third = 0 ;

        for(int value : arr){
            if(first<value){
                third = second ;
                second = first ;
                first = value;

            }else if(second<value){
                third = second ;
                second = value ;
            }else if(third<value){
                third = value ;
            }
        }
        System.out.println(first) ;
        System.out.println(second) ;
        System.out.println(third) ;

    }
}


//in this problem we find first three elements in the array . we take first , second, third and we take each value and check with the conditions then we assign the values to the each variable then we print that.

