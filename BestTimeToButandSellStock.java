class Solution {
    public int maxProfit(int[] prices) {

        // Step 1: Initialize min to a very large value
        // This will store the lowest price seen so far (best day to buy)
        int min = Integer.MAX_VALUE;

        // Step 2: Initialize MaxProfit to 0
        // This will store the maximum profit we can achieve
        int MaxProfit = 0;

        // Step 3: Loop through each day's price
        for (int i = 0; i < prices.length; i++) {

            // If current price is lower than min,
            // update min (we found a better day to buy)
            if (prices[i] < min) {
                min = prices[i];
            } 
            // Else, calculate profit if we sell today
            else {
                int temp = prices[i] - min; // profit = today price - best buy price

                // If this profit is greater than maxProfit so far, update it
                if (MaxProfit < temp) {
                    MaxProfit = temp;
                }
            }

            /* 
             Example to understand:

             Suppose prices = [7, 1, 5, 3, 6, 4]

             Day 0: price = 7
             min = 7 (buy at 7)
             MaxProfit = 0 (no profit yet)

             Day 1: price = 1
             min = 1 (buy at 1, cheaper than 7)
             MaxProfit = 0

             Day 2: price = 5
             Profit if sell today = 5 - 1 = 4
             MaxProfit = 4

             Day 3: price = 3
             Profit if sell today = 3 - 1 = 2
             MaxProfit = 4 (no change)

             Day 4: price = 6
             Profit if sell today = 6 - 1 = 5
             MaxProfit = 5 ✅ (best profit so far)

             Day 5: price = 4
             Profit if sell today = 4 - 1 = 3
             MaxProfit = 5 (no change)

             Final Answer: 5 (buy at 1, sell at 6)
            */
        }

        // Step 4: Return the maximum profit
        return MaxProfit;
    }
}
