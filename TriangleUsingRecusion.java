package com.example.DSA_JAVA.Recursion;

public class Triangle1 {

    public static void main(String[] args) {
        triangle(4, 0);
    }

    /*
     =====================================================
     DRY RUN + RECURSION EXPLANATION
     =====================================================

     Function call starts from:
     triangle(4, 0)

     -----------------------------------
     PHASE 1: GOING DOWN (NO PRINTING)
     -----------------------------------
     Java first completes ALL recursive calls.
     Nothing is printed while going down.

     triangle(4,0)
       triangle(4,1)
         triangle(4,2)
           triangle(4,3)
             triangle(4,4)   -> c < r is false
               triangle(3,0)
                 triangle(3,1)
                   triangle(3,2)
                     triangle(3,3)
                       triangle(2,0)
                         triangle(2,1)
                           triangle(2,2)
                             triangle(1,0)
                               triangle(1,1)
                                 triangle(0,0)  <-- BASE CASE (stop)

     Up to this point:
     - Only function calls happened
     - ZERO stars were printed

     -----------------------------------
     PHASE 2: COMING UP (PRINTING STARTS)
     -----------------------------------
     Now Java returns back ONE BY ONE.
     Printing happens while returning.

     Return to triangle(1,1):
       println();        -> new line (no star)

     Return to triangle(1,0):
       print("* ");      -> *
       
     Return to triangle(2,2):
       println();

     Return to triangle(2,1):
       print("* ");      -> *
     Return to triangle(2,0):
       print("* ");      -> *
       Output so far:
       *
       * *

     Return to triangle(3,3):
       println();

     Return to triangle(3,2):
       print("* ");
     Return to triangle(3,1):
       print("* ");
     Return to triangle(3,0):
       print("* ");
       Output:
       *
       * *
       * * *

     Return to triangle(4,4):
       println();

     Return to triangle(4,3):
       print("* ");
     Return to triangle(4,2):
       print("* ");
     Return to triangle(4,1):
       print("* ");
     Return to triangle(4,0):
       print("* ");

     FINAL OUTPUT:
     *
     * *
     * * *
     * * * *

     -----------------------------------
     SIMPLE RECURSION EXPLANATION
     -----------------------------------
     Recursion works in two steps:
     1) First, the function keeps calling itself until the base case is reached.
        (This builds the call stack and prints NOTHING.)
     2) After reaching the base case, the function starts returning.
        While returning, the statements after the recursive call execute.
        That is when stars are printed.

     In short:
     - Going DOWN = only function calls
     - Coming UP  = actual printing
     =====================================================
    */

    static void triangle(int r, int c) {
        if (r == 0) {
            return;
        }

        if (c < r) {
            triangle(r, c + 1);      // go deeper first
            System.out.print("* ");  // print while returning
        } else {
            triangle(r - 1, 0);      // move to next row
            System.out.println();    // new line
        }
    }
}
