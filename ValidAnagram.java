class Solution {
    public boolean isAnagram(String s, String t) {

        // Create an array of size 26 to store frequency of letters a–z
        // Index 0 -> 'a', 1 -> 'b', ..., 25 -> 'z'
        int[] count = new int[26];

        // Step 1: Count each character in string s
        // For every character, increase its corresponding index
        for (char c : s.toCharArray()) {
            count[c - 'a']++;   // convert char to index and increment
        }

        // Step 2: Reduce count using characters from string t
        // For every character, decrease its corresponding index
        for (char c : t.toCharArray()) {
            count[c - 'a']--;   // convert char to index and decrement
        }

        // Step 3: Check if all values in count array are zero
        // If any value is not zero, frequencies don't match
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;  // mismatch found → not an anagram
            }
        }

        // Step 4: All values are zero → strings are anagrams
        return true;
    }
}


//in java System.out.println("a" + 1 + new ArrayList<>()) if we add anything using String it we concatenate all.

//if we add the character 'a' + 2 it returns c because in unicode a char = 97 c = 99 so it returns c
