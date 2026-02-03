/*
=====================================================
PROBLEM: Two Sum II (Sorted Array)
=====================================================

Given a sorted array `arr` and a target value,
find two numbers such that they add up to target
and return their 1-based indices.

APPROACH: Two Pointer Technique
=====================================================
*/

class Solution {

    /*
    -------------------------------------------------
    METHOD: twoSum
    -------------------------------------------------
    arr    -> sorted integer array
    target-> sum we want to find
    return -> 1-based indices of two numbers
    */
    public int[] twoSum(int[] arr, int target) {

        // Left pointer starts from beginning
        int l = 0;

        // Right pointer starts from end
        int r = arr.length - 1;

        // Continue until both pointers meet
        while (l < r) {

            // Calculate current sum
            int sum = arr[l] + arr[r];

            /*
            If sum is greater than target:
            Since array is sorted,
            moving right pointer left will reduce sum
            */
            if (sum > target) {
                r--;
            }

            /*
            If sum is smaller than target:
            moving left pointer right will increase sum
            */
            else if (sum < target) {
                l++;
            }

            /*
            If sum equals target:
            return indices (1-based indexing)
            */
            else {
                return new int[]{l + 1, r + 1};
            }
        }

        // If no valid pair found
        return new int[]{-1, -1};
    }
}

/*
=====================================================
DRY RUN WITH VISUAL EXAMPLE
=====================================================

Input:
arr = [2, 7, 11, 15]
target = 9

Index:  0   1   2   3
Array: [2,  7, 11, 15]

Initial:
l = 0  → arr[l] = 2
r = 3  → arr[r] = 15

-----------------------------------------------------
STEP 1:
sum = 2 + 15 = 17  > 9
→ sum too big
→ move r left

l = 0, r = 2

Array:
[2, 7, 11, 15]
 ↑        ↑
 l        r

-----------------------------------------------------
STEP 2:
sum = 2 + 11 = 13 > 9
→ sum too big
→ move r left

l = 0, r = 1

Array:
[2, 7, 11, 15]
 ↑  ↑
 l  r

-----------------------------------------------------
STEP 3:
sum = 2 + 7 = 9 == target
→ FOUND ANSWER

Return:
[l+1, r+1] = [1, 2]

-----------------------------------------------------
OUTPUT:
[1, 2]

=====================================================
WHY THIS WORKS?
=====================================================

• Array is sorted
• If sum is too large → decrease right pointer
• If sum is too small → increase left pointer
• Time Complexity: O(n)
• Space Complexity: O(1)

=====================================================
INTERVIEW TIP
=====================================================
Always mention:
"Since the array is sorted, I used the two-pointer approach
to achieve O(n) time complexity."

=====================================================
*/
