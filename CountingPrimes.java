/*
LeetCode: 204. Count Primes
Algorithm: Sieve of Eratosthenes

-----------------------------------------
PROBLEM:
Count the number of prime numbers strictly less than n.

Prime number:
- Greater than 1
- Divisible only by 1 and itself
-----------------------------------------
*/

class Solution {

    public int countPrimes(int n) {

        /*
        STEP 0: Base case
        If n <= 2, there are no prime numbers less than n
        Example:
        n = 2 → no primes less than 2
        */
        if (n <= 2) {
            return 0;
        }

        /*
        STEP 1: Create boolean array
        isPrime[i] = true  → assume i is prime
        isPrime[i] = false → i is not prime
        */
        boolean[] isPrime = new boolean[n];
        //Arrays.fill(isPrime , true) ; (WE CAN USE THIS ALSO)

        /*
        STEP 2: Initially mark all numbers from 2 to n-1 as prime
        (0 and 1 are NOT prime by definition)
        */
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        /*
        STEP 3: Sieve process
        We loop from i = 2 while i * i < n
        */
        for (int i = 2; i * i < n; i++) {

            /*
            IMPORTANT:
            We only process i if it is still marked as prime.
            If isPrime[i] == false, it means:
            - i was already marked as composite
            - so we SKIP it
            */
            if (isPrime[i]) {

                /*
                Mark all multiples of i as NOT prime.

                We start from j = i * i because:
                - Smaller multiples (2*i, 3*i, ...) are already handled
                */
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        /*
        STEP 4: Count all prime numbers
        */
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }
}

/*
---------------------------------------------------
MY UNDERSTANDING (CORRECT VERSION):

1. We create a boolean array of size n and assume
   all numbers are prime (true).

2. If n <= 2, we return 0 because no primes exist.

3. We loop i from 2 while i * i < n.
   This DOES NOT mean i is prime.
   It only controls how far the loop runs.

4. We check isPrime[i]:
   - If true → i is prime → mark its multiples
   - If false → i is composite → skip

5. Inside the inner loop:
   j = i * i
   j < n
   j += i

   This marks:
   i*i, i*i+i, i*i+2*i, ... as NOT prime.

6. Finally, we count all true values in isPrime[].

---------------------------------------------------
EXAMPLE: n = 30

Initial primes assumed:
2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29

i = 2 (isPrime[2] = true)
Mark: 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28

i = 3 (isPrime[3] = true)
Mark: 9, 12, 15, 18, 21, 24, 27

i = 4
i * i < 30 → true
BUT isPrime[4] = false → skip

i = 5 (isPrime[5] = true)
Mark: 25

Final primes:
2, 3, 5, 7, 11, 13, 17, 19, 23, 29

Answer = 10
---------------------------------------------------
*/
