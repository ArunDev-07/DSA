// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.* ;
class Main {
    public static void main(String[] args) {
        // int[][] arr = {
        //     {1,2,3},
        //     {4,5,6},
        //     {7,8,9}
        // };
        // StringBuilder result = new StringBuilder() ;
        // int top = 0 , bottom = arr.length - 1 , left = 0 , right = arr[0].length - 1;
        // while(top <= bottom && left <= right){
        //     for(int i = left ; i <=right ; i++){
        //         result.append(arr[top][i]).append(" ") ;
        //     }
        //     top++ ;
        //     for(int i = top ; i<=bottom ; i++){
        //         result.append(arr[i][right]).append(" ") ;
        //     }
        //     right-- ;
            
        //     if(top <= bottom){
        //         for(int i = right ; i >= left ; i--){
        //             result.append(arr[bottom][i]).append(" ") ;
        //         }
        //         bottom-- ;
        //     }
        //     if(left<= right){
        //         for(int i = bottom ; i >= top ; i--){
        //             result.append(arr[i][left]).append(" ") ;
        //         }
        //         left++ ;
        //     }
        // }
        // System.out.println(result.toString()) ;
        // String s = "hello" ;
        // HashMap<Character , Integer> map = new LinkedHashMap<>() ;
        // for(char c : s.toCharArray()){
        //     map.put(c , map.getOrDefault(c , 0) + 1) ;
        // }
        // for(Map.Entry<Character , Integer> entry : map.entrySet()) {
        //     System.out.println(entry.getKey()+ " " + entry.getValue()) ;
        // }
        
        // int last = arr[arr.length-1] ;
        // for(int i = arr.length-1 ; i > 0 ; i--){
        //     arr[i] = arr[i-1] ;
        // }
        // arr[0] = last ; 
        // System.out.println(Arrays.toString(arr)) ;
        // int n = arr.length ; 
        // int k = 3 ; 
        // k = k % n ;
        // int[] result = new int[n] ;
        // for(int i = 0 ; i < n ; i++){
        //     result[(i+k) % n] = arr[i] ;
        // }
        // System.out.println(Arrays.toString(result)) ;
        int[][] arr = {
    {1, 2, 3},
    {4, 5, 6}
};

int[][] arr2 = {
    {1, 2},
    {3, 4},
    {5, 6}
};
        int[][] result = new int[arr.length][arr2[0].length] ;
       for(int i = 0 ; i < arr.length ; i++){
           for(int j = 0 ; j < arr2[0].length ; j++){
               for(int k = 0 ; k < arr[0].length ; k++){
                   result[i][j]+= arr[i][k] * arr2[k][j] ;
               }
           }
       }
        for(int[] row : result){
        System.out.println(Arrays.toString(row)) ;
        }
        // String one = "Arun is a Developer";
        // String string = one.trim() ;
        // int count = 1 ;
        // for(char c : string.toCharArray()){
        //     if(c == ' '){
        //         count++ ;
        //     }
        // }
        // System.out.println(count) ;
        
        // int[] freq = new int[26] ;
       
        // for(char c  : one.toCharArray()){
        //     freq[c - 'a']++ ;
        // }
        // for(char c  : two.toCharArray()){
        //     freq[c - 'a']-- ;
        // }
        // boolean anagram = true ;
        // for(int i = 0 ; i < freq.length; i++){
        //     if(freq[i] != 0){
        //         anagram = false ;
        //         break ;
        //     }
        // }
        // System.out.println(anagram ? "True" : "False") ;
        
        // int ans = 0 ; 
        // int y =  2024;
        // if(y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)){
        //     System.out.println("Yes") ;
        // }else{
        //     System.out.println("No") ;
        // }
        // int[] arr = {1,2,3,5,4} ;
        // for(int i = 0 ; i < arr.length-1 ; i++){
        //     for(int j = 0 ; j< arr.length -1 - i ; j++){
        //         if(arr[j] > arr[j+1]){
        //             int t = arr[j] ;
        //             arr[j] = arr[j+1] ;
        //             arr[j+1] = t ;
        //         }
        //     }
        // }
        // System.out.println(Arrays.toString(arr)) ;
        
        // int target = 3 ;
        // int s = 0 ; 
        // int e = arr.length-1 ;
        // while(s <= e){
        //     int mid = s + (e-s) / 2 ;
        //     if(arr[mid] == target){
        //         System.out.println(mid) ;
        //         break;
        //     }else if(arr[mid] < target){
        //         s = mid + 1 ;
        //     }else{
        //         e = mid - 1 ;
        //     }
        // }
    //   String word = "Hello" ;
    //   int v = 0 ; 
    //   int con = 0 ;
    //   for(int i = 0 ; i < word.length() ; i++){
    //       char c = word.charAt(i) ;
    //       if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'|| c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
    //           v++ ;
    //       }else{
    //           con++ ;
    //       }
    //   }
    //   System.out.println(v + " " + con) ;
    // int l = 0 ; int r = word.length()-1 ;
    // boolean p = true ;
    // while(l < r){
    //     if(word.charAt(l) != word.charAt(r)){
    //         p = false ;
    //         break ;
    //     }
    //     l++;
    //     r-- ;
    // }
    // if(p){
    //     System.out.println("True") ;
    // }else{
    //     System.out.println("False") ;
    // }
        
    //     boolean[] prime = new boolean[n+1] ;
    //     Arrays.fill(prime , true) ;
    //     // int n = 153 ; 
    //     // int o = 153 ;
    //     // while(n > 0){
    //     //     int d = n % 10 ;
    //     //     ans+= d * d * d ;
    //     //     n = n/10 ;
    //     // }
    //     // if(o == ans){
    //     //     System.out.println("Yes") ;
    //     // }else{
    //     //     System.out.println("No") ;
    //     // }
        
    //     // for(int i = 1 ; i <=n ;i++){
    //     //     ans = ans * i ;
    //     // }
         
    //     prime[0] = false ;
    //     prime[1] = false ;
    //   for(int i = 2 ; i * i <=n ; i++){
    //      if(prime[i]){
    //          for(int j = i * i ; j <= n ; j+=i){
    //              prime[j] = false ;
    //          }
    //      }
    //   }
    //   for(int i = 2 ; i <= n ; i++){
    //       if(prime[i]){
    //           System.out.print(i + " ");
    //       }
    //   }
    // while(b != 0){
    //     int temp = b ; 
    //     b = a % b ; 
    //     a = temp ;
    // }
    //  int gcd = a ;
    //  int lcm = o * ob / gcd ;
    //  System.out.println(gcd + " " + lcm) ;
      
        // System.out.println(isPrime ?  "True"  : "False") ;
        
        // for(int i = 1 ; i <=5 ; i++){
        //     for(int j = 1 ; j <=i ; j++){
        //         System.out.print("*" + " ") ;
        //     }
        //     System.out.println() ;
        // }
    }
}
