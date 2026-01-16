class Solution {
    public int maxArea(int[] height) {

        // l → left pointer starting from the first index
        int l = 0;

        // r → right pointer starting from the last index
        int r = height.length - 1;

        // max → stores the maximum water area found so far
        int max = -1;

        // Loop until both pointers meet
        while (l < r) {

            // width = distance between left and right pointers
            // height = minimum of the two line heights
            // area = width × height
            int area = (r - l) * Math.min(height[l], height[r]);

            // Update max if current area is greater
            max = Math.max(max, area);

            // If left height is smaller,
            // move left pointer to try a taller line
            if (height[l] < height[r]) {
                l++;
            }
            // Else move right pointer
            else {
                r--;
            }
        }

        // Return the maximum water that can be stored
        return max;
    }
}
