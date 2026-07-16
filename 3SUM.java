# 3SUM (LeetCode 15)

===============================================================================

**Platform** : LeetCode (15)
**Approach** : Sorting + Two Pointers
**Language** : Java

===============================================================================

# PROBLEM SUMMARY

Given an integer array `nums`.

Return all unique triplets such that:

```
nums[i] + nums[j] + nums[k] == 0
```

* `i`, `j`, and `k` must be different indices.
* Duplicate triplets are not allowed.

---

# EXAMPLE

### Input

```
[-1,0,1,2,-1,-4]
```

### After Sorting

```
[-4,-1,-1,0,1,2]
```

### Output

```
[
 [-1,-1,2],
 [-1,0,1]
]
```

===============================================================================

# BRUTE FORCE

Check every possible triplet.

```java
for(i)
    for(j)
        for(k)
```

Time Complexity:

```
O(n³)
```

Not efficient.

===============================================================================

# OPTIMAL APPROACH

**Sorting + Two Pointers**

Instead of checking every triplet:

1. Sort the array.
2. Fix one element.
3. Find the remaining two numbers using two pointers.

Overall Complexity:

```
O(n²)
```

===============================================================================

# WHY SORTING?

Sorting allows us to move pointers efficiently.

If

```
sum < 0
```

Move

```
left++
```

because we need a bigger number.

If

```
sum > 0
```

Move

```
right--
```

because we need a smaller number.

===============================================================================

# ALGORITHM

### Step 1

Sort the array.

```java
Arrays.sort(nums);
```

---

### Step 2

Loop through every index.

```java
for(int i=0;i<n-2;i++)
```

Treat `nums[i]` as the first number.

---

### Step 3

Skip duplicate first elements.

```java
if(i>0 && nums[i]==nums[i-1])
    continue;
```

---

### Step 4

Initialize two pointers.

```java
left = i + 1;
right = n - 1;
```

---

### Step 5

While

```
left < right
```

calculate

```java
sum = nums[i] + nums[left] + nums[right];
```

---

### Case 1

If

```
sum == 0
```

Store answer.

Move both pointers.

Skip duplicates.

---

### Case 2

If

```
sum < 0
```

```
left++
```

---

### Case 3

If

```
sum > 0
```

```
right--
```

===============================================================================

# DRY RUN

Input

```
[-1,0,1,2,-1,-4]
```

Sorted

```
[-4,-1,-1,0,1,2]
```

---

## i = 0

```
nums[i] = -4

left = 1
right = 5
```

```
sum = -4 + (-1) + 2 = -3
```

Too small

```
left++
```

Again

```
sum = -4 + (-1) + 2 = -3
```

```
left++
```

Again

```
sum = -4 + 0 + 2 = -2
```

```
left++
```

Again

```
sum = -4 + 1 + 2 = -1
```

```
left++
```

Stop.

No triplet.

---

## i = 1

```
nums[i] = -1

left = 2
right = 5
```

```
sum = -1 + (-1) + 2 = 0
```

Found

```
[-1,-1,2]
```

Move

```
left++
right--
```

Now

```
left = 3
right = 4
```

```
sum = -1 + 0 + 1 = 0
```

Found

```
[-1,0,1]
```

Move

```
left++
right--
```

Stop.

---

## i = 2

Duplicate

```
-1
```

Skip.

---

Final Answer

```
[
 [-1,-1,2],
 [-1,0,1]
]
```

===============================================================================

# COMPLETE JAVA CODE

```java
import java.util.*;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        int n = nums.length;

        for(int i=0;i<n-2;i++){

            // Skip duplicate first element
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int left = i+1;
            int right = n-1;

            while(left<right){

                int sum = nums[i] + nums[left] + nums[right];

                if(sum==0){

                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    left++;
                    right--;

                    // Skip duplicate left values
                    while(left<right && nums[left]==nums[left-1]){
                        left++;
                    }

                    // Skip duplicate right values
                    while(left<right && nums[right]==nums[right+1]){
                        right--;
                    }

                }
                else if(sum<0){
                    left++;
                }
                else{
                    right--;
                }

            }

        }

        return ans;
    }

}
```

===============================================================================

# CODE EXPLANATION

### Create answer list

```java
List<List<Integer>> ans = new ArrayList<>();
```

Stores all valid triplets.

---

### Sort array

```java
Arrays.sort(nums);
```

Required for two pointers.

---

### Loop

```java
for(int i=0;i<n-2;i++)
```

Fix one element.

---

### Skip duplicate first element

```java
if(i>0 && nums[i]==nums[i-1])
    continue;
```

Avoid duplicate triplets.

---

### Two pointers

```java
left = i+1;
right = n-1;
```

---

### Calculate sum

```java
int sum = nums[i] + nums[left] + nums[right];
```

---

### Sum == 0

```java
ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
```

Store answer.

Move both pointers.

---

### Skip duplicate left

```java
while(left<right && nums[left]==nums[left-1])
    left++;
```

---

### Skip duplicate right

```java
while(left<right && nums[right]==nums[right+1])
    right--;
```

---

### Sum < 0

```java
left++;
```

Need a larger number.

---

### Sum > 0

```java
right--;
```

Need a smaller number.

===============================================================================

# TIME COMPLEXITY

Sorting

```
O(n log n)
```

Outer Loop

```
O(n)
```

Two Pointers

```
O(n)
```

Overall

```
O(n²)
```

===============================================================================

# SPACE COMPLEXITY

```
O(1)
```

Ignoring the output list.

===============================================================================

# INTERVIEW TIPS

✔ Sort the array first.

✔ Fix one element.

✔ Use two pointers.

✔ Skip duplicate values for:

* `i`
* `left`
* `right`

Pointer Movement:

```
sum < 0  → left++
sum > 0  → right--
sum == 0 → Save answer, move both pointers, skip duplicates
```

===============================================================================

# PATTERN LEARNED

**Sorting + Two Pointers**

Used in:

* LeetCode 15 – 3Sum
* LeetCode 18 – 4Sum
* LeetCode 167 – Two Sum II
* LeetCode 11 – Container With Most Water
