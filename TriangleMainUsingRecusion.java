package com.example.DSA_JAVA.Recursion;

public class Triangle2 {

    public static void main(String[] args) {
        triangle(4, 0);
    }

    /*
     =====================================================
     DRY RUN + RECURSION EXPLANATION (PRINT FIRST)
     =====================================================

     Code behavior:
     - Star (*) is printed BEFORE the recursive call
     - So stars print while GOING DOWN
     - New line prints when a row finishes

     -----------------------------------
     PHASE 1: GOING DOWN (PRINTING HAPPENS)
     -----------------------------------

     triangle(4,0):
       c < r -> true
       print "* "
       call triangle(4,1)

     triangle(4,1):
       print "* "
       call triangle(4,2)

     triangle(4,2):
       print "* "
       call triangle(4,3)

     triangle(4,3):
       print "* "
       call triangle(4,4)

     triangle(4,4):
       c < r -> false
       println()
       call triangle(3,0)

     triangle(3,0):
       print "* "
       call triangle(3,1)

     triangle(3,1):
       print "* "
       call triangle(3,2)

     triangle(3,2):
       print "* "
       call triangle(3,3)

     triangle(3,3):
       println()
       call triangle(2,0)

     triangle(2,0):
       print "* "
       call triangle(2,1)

     triangle(2,1):
       print "* "
       call triangle(2,2)

     triangle(2,2):
       println()
       call triangle(1,0)

     triangle(1,0):
       print "* "
       call triangle(1,1)

     triangle(1,1):
       println()
       call triangle(0,0)

     triangle(0,0):
       return (base case)

     -----------------------------------
     OUTPUT
     -----------------------------------

     * * * *
     * * *
     * *
     *

     -----------------------------------
     SIMPLE RECURSION EXPLANATION
     -----------------------------------
     In this version, recursion prints stars while going down.
     Each recursive call prints one star before calling the next.
     When the column reaches the row limit, a new line is printed
     and recursion moves to the next row. The base case stops
     the recursion when r becomes 0.
     =====================================================
    */

    static void triangle(int r, int c) {
        if (r == 0) {
            return;
        }

        if (c < r) {
            System.out.print("* ");
            triangle(r, c + 1);
        } else {
            System.out.println();
            triangle(r - 1, 0);
        }
    }
}
Tra
