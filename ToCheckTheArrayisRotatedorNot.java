// ===============================
// CHECK IF TWO ARRAYS ARE ROTATIONS
// ===============================
//
// Problem:
// Check whether arr2 is a rotation of arr1.
//
// Example:
// arr1 = [1, 2, 3, 4, 5]
// arr2 = [3, 4, 5, 1, 2]  --> YES (Rotation)
//
// arr2 = [5, 4, 3, 2, 1]  --> NO (Reverse, not rotation)
//
// ------------------------------------------------
// IDEA (VERY IMPORTANT):
// ------------------------------------------------
// We do NOT rotate the array physically.
// Instead, we simulate rotation using circular indexing.
//
// Circular index formula:
//     (i + j) % n
//
// where:
// i = how much rotation we try
// j = current index comparison
// n = length of array
//
// ------------------------------------------------
// LOGIC:
// ------------------------------------------------
// 1. Try all possible rotations (i = 0 to n-1)
// 2. For each rotation, compare arr1 with rotated arr2
// 3. If all elements match → Rotation found
// 4. Else → Not a rotation
//
// Time Complexity: O(n^2)
// Space Complexity: O(1)
// ------------------------------------------------

import java.util.*;

class Main {
    public static void main(String[] args) {

        // Original array
        int[] arr1 = {1, 2, 3, 4, 5};

        // Possible rotation of arr1
        int[] arr2 = {3, 4, 5, 1, 2};

        // Function call
        if (isRotate(arr1, arr2)) {
            System.out.println("Rotation");
        } else {
            System.out.println("Not Rotation");
        }
    }

    // ------------------------------------------------
    // FUNCTION: Check rotation
    // ------------------------------------------------
    static boolean isRotate(int[] arr1, int[] arr2) {

        int n = arr1.length;

        // Try every possible rotation
        for (int i = 0; i < n; i++) {

            boolean match = true;

            // Compare each element
            for (int j = 0; j < n; j++) {

                // Circular comparison
                // (i + j) % n wraps index around the array
                if (arr1[j] != arr2[(i + j) % n]) {
                    match = false;
                    break;
                }
            }

            // If one full rotation matches
            if (match) {
                return true;
            }
        }

        // No rotation matched
        return false;
    }
}

/*
==============================
DRY RUN (STEP BY STEP)
==============================

arr1 = [1, 2, 3, 4, 5]
arr2 = [3, 4, 5, 1, 2]
n = 5

------------------------------
Rotation i = 0
------------------------------
Compare:
arr1[0] vs arr2[0] → 1 vs 3 ❌
→ Not match

------------------------------
Rotation i = 1
------------------------------
arr2 view: [4, 5, 1, 2, 3]
arr1[0] vs arr2[1] → 1 vs 4 ❌

------------------------------
Rotation i = 2
------------------------------
arr2 view: [5, 1, 2, 3, 4]
arr1[0] vs arr2[2] → 1 vs 5 ❌

------------------------------
Rotation i = 3
------------------------------
arr2 view: [1, 2, 3, 4, 5]

j=0 → 1 == 1 ✅
j=1 → 2 == 2 ✅
j=2 → 3 == 3 ✅
j=3 → 4 == 4 ✅
j=4 → 5 == 5 ✅

MATCH FOUND ✔
return true

OUTPUT:
Rotation

==============================
VISUAL UNDERSTANDING
==============================

arr2 circularly:
Index:  0 1 2 3 4
Value:  3 4 5 1 2

Rotation i = 3:
(3+0)%5 = 3 → 1
(3+1)%5 = 4 → 2
(3+2)%5 = 0 → 3
(3+3)%5 = 1 → 4
(3+4)%5 = 2 → 5

Matches arr1 exactly ✔

==============================
IMPORTANT NOTE
==============================
Reverse ≠ Rotation

[5,4,3,2,1] ❌ (reverse)
[3,4,5,1,2] ✅ (rotation)
*/
