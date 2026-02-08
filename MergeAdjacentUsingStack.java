import java.util.*;

/*
===========================================================
PROBLEM:
Merge adjacent equal numbers by adding them.

INPUT EXAMPLE:
nums = [3, 1, 1, 2]

OUTPUT:
[3, 2, 2]

===========================================================
CORE IDEA:
- We use a Deque (stack-like behavior)
- Compare current number with the LAST element
- If equal:
    - remove last
    - add both
- Repeat until not equal
===========================================================
*/

class Solution {

    public List<Long> mergeAdjacent(int[] nums) {

        // Deque is used as a stack (add/remove from last)
        Deque<Long> stack = new ArrayDeque<>();

        // Loop through each number in array
        for (int num : nums) {

            // curr holds current number (converted to long)
            long curr = num;

            /*
            ---------------------------------------------------
            WHILE CONDITION EXPLANATION:
            1) stack is not empty
            2) last element == curr

            peekLast() → checks last element (does NOT remove)
            pollLast() → removes AND returns last element
            ---------------------------------------------------
            */
            while (!stack.isEmpty() && stack.peekLast() == curr) {

                // Remove last element and add to curr
                curr += stack.pollLast();
            }

            // Push final merged value into stack
            stack.addLast(curr);
        }

        // Convert stack to List and return
        return new ArrayList<>(stack);
    }
}

/*
===========================================================
COMMAND EXPLANATION
===========================================================

peekLast()  → looks at last element (no removal)
pollLast()  → removes last element AND returns it
addLast(x)  → adds element at the end

IMPORTANT RULE:
pollLast() = RETURN + REMOVE
===========================================================
*/

/*
===========================================================
FULL VISUAL DRY RUN (nums = [3, 1, 1, 2])
===========================================================

INITIAL:
stack = []

-----------------------------------------------------------
STEP 1: num = 3
curr = 3
stack empty → no merge

stack.addLast(3)

STACK:
[3]

-----------------------------------------------------------
STEP 2: num = 1
curr = 1
peekLast() = 3 ≠ 1 → no merge

stack.addLast(1)

STACK:
[3, 1]

-----------------------------------------------------------
STEP 3: num = 1
curr = 1
peekLast() = 1 == curr → MERGE

pollLast() returns 1 and removes it

curr = 1 + 1 = 2

stack now:
[3]

addLast(2)

STACK:
[3, 2]

-----------------------------------------------------------
STEP 4: num = 2
curr = 2
peekLast() = 2 == curr → MERGE

pollLast() returns 2 and removes it

curr = 2 + 2 = 4

stack now:
[3]

addLast(4)

STACK:
[3, 4]

-----------------------------------------------------------
FINAL OUTPUT:
[3, 4]
===========================================================
*/

/*
===========================================================
EXPLANATION PARAGRAPH (INTERVIEW READY)
===========================================================

This algorithm uses a Deque to simulate stack behavior for
merging adjacent equal values. For each number, we compare
it with the last inserted value. If they are equal, the last
value is removed and added to the current value. This process
repeats until the last element is different. The final merged
value is then pushed back into the stack. This ensures correct
adjacent merging while maintaining order.
===========================================================
*/
