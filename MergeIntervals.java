import java.util.* ;

class Solution {

    /**
     * Problem: Merge overlapping intervals
     * Example:
     * Input:  [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     *
     * Approach:
     * 1. Sort the intervals based on starting time.
     * 2. Create a list to store merged intervals.
     * 3. For each interval:
     *      - If the list is empty or current interval does not overlap with last merged interval,
     *        add current interval to merged list.
     *      - Else, overlap exists: merge by updating the end of last interval to max(end of last, end of current).
     * 4. Convert the list back to array and return.
     */

    public int[][] merge(int[][] intervals) {
        // -------------------------------
        // Edge case: if list has 0 or 1 interval, return as is
        // -------------------------------
        if(intervals.length <= 1){
            return intervals ;
        }

        // -------------------------------
        // Step 1: Sort intervals by start time
        // -------------------------------
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        // -------------------------------
        // Step 2: Initialize list to store merged intervals
        // -------------------------------
        List<int[]> merged = new ArrayList<>();

        // -------------------------------
        // Step 3: Iterate over each interval
        // -------------------------------
        for(int[] interval : intervals){
            // If list empty or no overlap
            if(merged.isEmpty() || merged.get(merged.size()-1)[1] < interval[0]){
                merged.add(interval);
            } else {
                // Overlap exists, merge intervals by updating the end
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1], interval[1]);
            }
        }

        // -------------------------------
        // Step 4: Convert merged list to array and return
        // -------------------------------
        return merged.toArray(new int[merged.size()][]);
    }
}

/*
 * -------------------------------
 * DRY RUN EXAMPLE
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 *
 * Step 1: Sort by start time:
 * [[1,3],[2,6],[8,10],[15,18]]
 *
 * Step 2: Initialize merged list empty
 *
 * Step 3: Iterate:
 * - interval = [1,3], merged empty → add [1,3] → merged = [[1,3]]
 * - interval = [2,6], merged last = [1,3], 3 >= 2 → overlap → merge → new end = max(3,6)=6 → merged = [[1,6]]
 * - interval = [8,10], merged last = [1,6], 6 < 8 → no overlap → add → merged = [[1,6],[8,10]]
 * - interval = [15,18], merged last = [8,10], 10 < 15 → no overlap → add → merged = [[1,6],[8,10],[15,18]]
 *
 * Step 4: Return merged as array: [[1,6],[8,10],[15,18]]
 *
 * -------------------------------
 * VISUAL DIAGRAM
 * Original intervals (sorted):
 * [1,3], [2,6], [8,10], [15,18]
 *
 * Iteration 1: merged = [[1,3]]
 * Iteration 2: merge [2,6] with [1,3] → [1,6]
 * Iteration 3: [8,10] → no overlap → merged = [[1,6],[8,10]]
 * Iteration 4: [15,18] → no overlap → merged = [[1,6],[8,10],[15,18]]
 *
 * Final Output: [[1,6],[8,10],[15,18]]
 *
 * -------------------------------
 * COMPLEXITY:
 * Time: O(n log n) – sorting + O(n) iteration
 * Space: O(n) – merged list
 */
