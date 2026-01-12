class Solution {
    public int addDigits(int num) {
        // Approach 1: Iterative sum of digits
        // Keep adding digits of num until it becomes a single-digit number
        while (num >= 10) {  // repeat as long as num has 2 or more digits
            int sum = 0;      // store sum of digits in this iteration
            int temp = num;   // use a temp variable to not destroy num immediately
            while (temp > 0) {      // extract each digit of num
                sum += temp % 10;   // add the last digit to sum
                temp = temp / 10;   // remove the last digit
            }
            num = sum;  // update num with the sum for next iteration
        }
        return num;     // now num is a single-digit number
    }
}

/*
Mathematical Approach (Digital Root):

- For a number n, the repeated sum of digits can be found in O(1) using:

    if (num == 0) return 0;
    else return 1 + (num - 1) % 9;

- Explanation:
  - This works because the repeated sum of digits is equivalent to n mod 9 (digital root)
  - Example: 38 → 3+8=11 → 1+1=2 → same as 38 % 9 = 2
  - Exception: if num % 9 == 0 and num != 0 → result is 9
- This method avoids loops entirely.
*/
