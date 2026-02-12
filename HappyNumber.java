/*
===========================================
LeetCode 202 - Happy Number (Recursive)
===========================================

Concept:
A number is called a Happy Number if:

1. Replace the number with the sum of squares of its digits.
2. Repeat the process.
3. If the number becomes 1 → it is Happy.
4. If it becomes a single digit other than 1 or 7 → it is NOT Happy.

Important Mathematical Fact:
- All happy numbers eventually reach 1.
- If the number becomes 7, it will eventually reach 1.
- All unhappy numbers eventually fall into a cycle that includes 4.
- Single digit unhappy numbers are: 2,3,4,5,6,8,9

So:
If n == 1 or n == 7 → return true.
If n < 10 (and not 1 or 7) → return false.

===========================================
*/

class Solution {

    public boolean isHappy(int n) {

        // Base Case 1:
        // If number becomes 1 or 7 → it is happy
        if(n == 1 || n == 7){
            return true;
        }

        // Base Case 2:
        // If number becomes single digit (but not 1 or 7)
        // Then it is not happy
        if(n < 10){
            return false;
        }

        // Compute sum of squares of digits
        int ans = 0;

        while(n > 0){
            int d = n % 10;     // extract last digit
            ans += d * d;       // add square of digit
            n = n / 10;        // remove last digit
        }

        // Recursive call with new value
        return isHappy(ans);
    }
}


/*
===========================================
EXPLANATION PARAGRAPH
===========================================

This solution checks whether a number is a Happy Number using recursion.

First, it checks base cases:
- If the number becomes 1 or 7, we immediately return true.
- If the number becomes a single digit less than 10 (but not 1 or 7), 
  it is guaranteed to be an unhappy number, so we return false.

If neither condition is met, we calculate the sum of squares of its digits.
Then we recursively call the same function with this new value.

The recursion continues until it reaches either 1 (happy)
or a single-digit unhappy number.

This avoids using HashSet or cycle detection
by using mathematical properties of happy numbers.

===========================================
DRY RUN WITH VISUAL EXAMPLE
===========================================

Example 1: n = 19

Step 1:
n = 19
1² + 9² = 1 + 81 = 82
Call isHappy(82)

Step 2:
n = 82
8² + 2² = 64 + 4 = 68
Call isHappy(68)

Step 3:
n = 68
6² + 8² = 36 + 64 = 100
Call isHappy(100)

Step 4:
n = 100
1² + 0² + 0² = 1
Call isHappy(1)

Step 5:
n == 1 → return true

Final Answer:
19 is a Happy Number.


-------------------------------------------

Example 2: n = 2

n = 2

Check:
n == 1 or 7? → No
n < 10? → Yes

Return false.

So 2 is NOT a Happy Number.


-------------------------------------------

Visual Flow for 19:

19
 ↓
82
 ↓
68
 ↓
100
 ↓
1  → HAPPY

-------------------------------------------

Time Complexity:
O(log n) per recursion level

Space Complexity:
O(log n) due to recursion stack

===========================================
*/
