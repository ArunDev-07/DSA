package com.example.DSA_JAVA.Recursion;

/**
 * This program solves the problem:
 * "Number of ways to roll `n` dice (each 1..k) to reach sum = target".
 *
 * Concepts used:
 * 1. Recursion: Try all possibilities of dice values.
 * 2. Backtracking: Explore all paths by trying 1..k at each dice.
 * 3. DP / Memoization: Store results of subproblems to avoid recomputation.
 * 4. Modulus: Prevent integer overflow for large counts.
 */

public class DiceWithDP {

    // MOD value to prevent integer overflow
    int M = 1_000_000_007;

    // dp[n][target] stores number of ways to get `target` using `n` dice
    Integer[][] dp;

    public static void main(String[] args) {
        DiceWithDP solution = new DiceWithDP();

        int n = 2;      // number of dice
        int k = 6;      // faces on each dice (1 to k)
        int target = 7; // target sum

        // Call the main function
        System.out.println("Number of ways: " + solution.numRollsToTarget(n, k, target));
    }

    /**
     * Entry function: initializes DP table and calls recursive Dice function
     */
    public int numRollsToTarget(int n, int k, int target) {
        dp = new Integer[n + 1][target + 1];
        return Dice(n, k, target);
    }

    /**
     * Recursive function to find number of ways
     */
    public int Dice(int n, int k, int target) {

        // Base case 1: No dice left
        if (n == 0) return target == 0 ? 1 : 0;

        // Base case 2: target became negative
        if (target < 0) return 0;

        // DP memoization
        if (dp[n][target] != null) return dp[n][target];

        int count = 0;

        // Loop through all possible dice faces
        for (int i = 1; i <= k; i++) {
            if (target - i >= 0) {
                count += Dice(n - 1, k, target - i);
                count %= M; // modulus to prevent overflow
            }
        }

        dp[n][target] = count; // store result in DP table
        return count;
    }
}

/*
==================== FULL DRY RUN (n=2, k=6, target=7) ====================

Goal: Number of ways to roll 2 dice to sum = 7

States are in form Dice(n, target)

1️⃣ Initial call:
   Dice(2, 7)
   Loop i=1 to 6

   i=1 → Dice(1, 6)
   i=2 → Dice(1, 5)
   i=3 → Dice(1, 4)
   i=4 → Dice(1, 3)
   i=5 → Dice(1, 2)
   i=6 → Dice(1, 1)

------------------------------------------
2️⃣ Dice(1, 6) → 1 die left, target 6
   Loop i=1 to 6

   i=1 → Dice(0, 5) → 0 (target != 0)
   i=2 → Dice(0, 4) → 0
   i=3 → Dice(0, 3) → 0
   i=4 → Dice(0, 2) → 0
   i=5 → Dice(0, 1) → 0
   i=6 → Dice(0, 0) → 1 ✅
   Total for Dice(1,6) = 1
   Store dp[1][6] = 1

------------------------------------------
3️⃣ Dice(1, 5)
   i=1 → Dice(0,4) → 0
   i=2 → Dice(0,3) → 0
   i=3 → Dice(0,2) → 0
   i=4 → Dice(0,1) → 0
   i=5 → Dice(0,0) → 1 ✅
   i=6 → Dice(0,-1) → 0
   Total = 1
   Store dp[1][5] = 1

------------------------------------------
4️⃣ Dice(1, 4)
   i=1 → Dice(0,3) → 0
   i=2 → Dice(0,2) → 0
   i=3 → Dice(0,1) → 0
   i=4 → Dice(0,0) → 1 ✅
   i=5 → Dice(0,-1) → 0
   i=6 → Dice(0,-2) → 0
   Total = 1
   Store dp[1][4] = 1

------------------------------------------
5️⃣ Dice(1, 3)
   i=1 → Dice(0,2) → 0
   i=2 → Dice(0,1) → 0
   i=3 → Dice(0,0) → 1 ✅
   i=4 → Dice(0,-1) → 0
   i=5 → Dice(0,-2) → 0
   i=6 → Dice(0,-3) → 0
   Total = 1
   Store dp[1][3] = 1

------------------------------------------
6️⃣ Dice(1, 2)
   i=1 → Dice(0,1) → 0
   i=2 → Dice(0,0) → 1 ✅
   i=3 → Dice(0,-1) → 0
   ...
   Total = 1
   Store dp[1][2] = 1

------------------------------------------
7️⃣ Dice(1, 1)
   i=1 → Dice(0,0) → 1 ✅
   i=2 → Dice(0,-1) → 0
   ...
   Total = 1
   Store dp[1][1] = 1

------------------------------------------
8️⃣ Back to Dice(2,7)
   count = sum of all Dice(1, target-i):
   Dice(1,6) + Dice(1,5) + Dice(1,4) + Dice(1,3) + Dice(1,2) + Dice(1,1)
   = 1 + 1 + 1 + 1 + 1 + 1 = 6 ✅

dp table after execution:

dp[1][1] = 1
dp[1][2] = 1
dp[1][3] = 1
dp[1][4] = 1
dp[1][5] = 1
dp[1][6] = 1

dp[2][7] = 6  // final answer

============================================
✅ Key DP Insight:

- Dice(1,3) etc. are stored in dp[1][*]
- If another recursion needs Dice(1,3), it will instantly return 1
- This avoids recomputation
- Complexity reduced from O(k^n) → O(n*k*target)
- Modulus ensures numbers stay within int range

*/
