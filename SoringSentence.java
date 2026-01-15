class Solution {
    public String sortSentence(String s) {
        // Step 1: Split the sentence into individual words
        // "is2 sentence4 This1 a3" -> ["is2", "sentence4", "This1", "a3"]
        String[] words = s.split(" ");
        
        // Step 2: Create an array to hold the words in sorted order
        // The size is same as number of words in the sentence
        String[] result = new String[words.length];

        // Step 3: Iterate over each word
        for (String word : words) {
            // Step 4: Iterate over each character in the word
            for (char c : word.toCharArray()) {
                // Step 5: Check if the character is a digit
                if (Character.isDigit(c)) {
                    // Step 6: Convert the character digit to integer
                    // Example: '2' -> 2
                    int index = c - '0';
                    
                    // Step 7: Place the word (without the number) in the correct position
                    // Arrays are 0-based, but numbers in words are 1-based, so subtract 1
                    result[index - 1] = word.replaceAll("\\d", "");  // remove the number from the word

                    // Step 8: Stop checking other characters because each word has only 1 number
                    break;
                }
            }
        }

        // Step 9: Join the words back into a sentence separated by spaces
        return String.join(" ", result);
    }
}
