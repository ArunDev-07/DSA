// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
      int n = 5 ;
      int a = 0 , b=1 ;
      if(n==0){
         System.out.print(0) ;
      } 
      if(n==1){
         System.out.print(1) ;
      }
      for(int i=2 ; i<=n ; i++){
          int c = a+b ; // 0+1  1+1  1+2 2+3
          a = b ;  // 1  1  2  3
          b = c ;  // 1  2  3  5
      }
      System.out.print(b) ;
    }
}


//in this problem we did fibonacci series by using 3 variables in the fibonacci 0 = 0 and 1 = 1 . by using for loop we made this it checks from 2 because 0=0,1=1.
//for loop from 2 to n and then a=0 , b=1 . c = a + b , a=b, b=c ;by using this assignment it works and then we return b . because b contains c .

