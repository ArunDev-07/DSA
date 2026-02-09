import java.util.*;

// Class to solve the Palindrome Partitioning Problem
public class Solution {

    /**
     * Main function to return all palindrome partitions of the string
     * @param s Input string
     * @return List of all possible palindrome partitions
     */
    public List<List<String>> partition(String s) {
        // Result list to store all valid partitions
        List<List<String>> result = new ArrayList<>();

        // Call the recursive helper function starting at index 0
        part(s, 0, new ArrayList<>(), result);

        // Return the final list of partitions
        return result;
    }

    /**
     * Recursive function to generate palindrome partitions
     * @param s Input string
     * @param start Current index from which we want to partition
     * @param current Current list of substrings (partition being built)
     * @param result Final list of all partitions
     */
    public void part(String s, int start, List<String> current, List<List<String>> result) {

        // Base case: if start index reaches the end of string
        // then we have a complete partition
        if (start == s.length()) {
            // Add a deep copy of current partition to result
            result.add(new ArrayList<>(current));
            return;
        }

        // Loop to generate all substrings starting from 'start'
        for (int end = start; end < s.length(); end++) {
            // Java substring(start, end+1) includes characters from start to end (inclusive)
            String sub = s.substring(start, end + 1);

            // Check if the current substring is a palindrome
            if (isPalindrome(sub)) {
                // If palindrome, add it to current partition
                current.add(sub);

                // Recurse for the remaining substring starting from end+1
                part(s, end + 1, current, result);

                // Backtrack: remove the last added substring to try next possibilities
                current.remove(current.size() - 1);
            }
        }
    }

    /**
     * Helper function to check if a string is palindrome
     * @param s Input string
     * @return true if palindrome, false otherwise
     */
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        // Compare characters from start and end
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    // Main method to run the program and see an example
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "aab";

        List<List<String>> result = sol.partition(s);

        System.out.println("All Palindrome Partitions of \"" + s + "\":");
        for (List<String> partition : result) {
            System.out.println(partition);
        }

        /*
         * ------------------------------
         * FULL DRY RUN / EXPLANATION
         * ------------------------------
         *
         * Input: "aab"
         *
         * Recursive Tree:
         *
         * Start at index 0:
         * 1. end=0 -> sub="a" (palindrome)
         *    current=["a"]
         *    Recurse start=1
         *    -> end=1 -> sub="a" (palindrome)
         *       current=["a","a"]
         *       Recurse start=2
         *       -> end=2 -> sub="b" (palindrome)
         *          current=["a","a","b"]
         *          Recurse start=3 -> base case reached -> store ["a","a","b"]
         *       Backtrack -> remove "b" -> current=["a","a"]
         *    Backtrack -> remove "a" -> current=["a"]
         *    -> end=2 -> sub="ab" (not palindrome) -> skip
         * Backtrack -> remove "a" -> current=[]
         *
         * 2. end=1 -> sub="aa" (palindrome)
         *    current=["aa"]
         *    Recurse start=2
         *    -> end=2 -> sub="b" (palindrome)
         *       current=["aa","b"]
         *       Recurse start=3 -> base case reached -> store ["aa","b"]
         *    Backtrack -> remove "b" -> current=["aa"]
         * Backtrack -> remove "aa" -> current=[]
         *
         * 3. end=2 -> sub="aab" (not palindrome) -> skip
         *
         * Final result: [["a","a","b"], ["aa","b"]]
         *
         * ------------------------------
         * VISUAL RECURSION TREE
         * ------------------------------
         *
         *                      ""
         *          /                      \
         *        "a"                       "aa"
         *       /   \                      /
         *     "a"   "ab"(skip)            "b"
         *     /                              
         *   "b"  -> store ["a","a","b"]      
         *                                   
         *  "b" -> store ["aa","b"]
         *
         * Each node represents 'current' partition at that recursion level.
         * Branches represent substrings chosen for that step.
         * Palindrome check filters out invalid branches (like "ab" and "aab").
         */
    }
}
