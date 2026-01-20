class Solution {
    
    // ----------------- Approach 1: Single-pass flip + invert -----------------
    public int[][] flipAndInvertImageSinglePass(int[][] image) {
        // Iterate over each row in the image
        for(int[] row : image){
            int n = row.length;  // Number of columns in this row
            
            // Loop only to the middle of the row
            // i <= (n-1)/2 ensures we swap each pair only once
            for(int i = 0; i <= (n-1) / 2; i++){
                
                // temp = left element after inverting it (0 -> 1, 1 -> 0)
                int temp = row[i] ^ 1;
                
                // row[i] = right element inverted
                row[i] = row[n - i - 1] ^ 1;
                
                // row[n-i-1] = original left element (already inverted in temp)
                row[n - i - 1] = temp;
            }
        }
        
        // Return the modified image
        return image;
    }

    
    // ----------------- Approach 2: Two-pass flip then invert -----------------
    public int[][] flipAndInvertImageTwoPass(int[][] image) {
        
        // ---- 1st pass: Flip each row ----
        for(int row = 0; row < image.length; row++){
            int left = 0;  // Start of row
            int right = image[row].length - 1;  // End of row
            
            // Swap elements from left to right until the pointers meet
            while(left < right){
                int temp = image[row][left];       // Store left element temporarily
                image[row][left] = image[row][right]; // Move right element to left
                image[row][right] = temp;             // Move original left element to right
                left++;                               // Move left pointer forward
                right--;                              // Move right pointer backward
            }
        }
        
        // ---- 2nd pass: Invert each element ----
        for(int row = 0; row < image.length; row++){
            for(int col = 0; col < image[row].length; col++){
                // Flip 0 -> 1, 1 -> 0 using XOR
                image[row][col] = image[row][col] ^ 1;
            }
        }
        
        // Return the modified image
        return image;
    }
}
