/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
 * Problem: Reverse a singly linked list recursively.
 * Example:
 * Input:  1 -> 2 -> 3 -> 4 -> null
 * Output: 4 -> 3 -> 2 -> 1 -> null
 *
 * Approach (Recursive):
 * 1. Base case: If the list is empty (head == null) or has only one node (head.next == null),
 *    return head. This node will be the new head of the reversed list.
 * 2. Recursively reverse the rest of the list: newHead = Reverse(head.next)
 * 3. Reverse the link of the current node:
 *      head.next.next = head;  // Next node points back to current node
 *      head.next = null;       // Current node should point to null
 * 4. Return newHead (head of reversed list)
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        // Call the recursive helper method
        return Reverse(head);
    }

    public ListNode Reverse(ListNode head) {
        // -------------------------------
        // BASE CASE:
        // If list is empty or has only one node, return head
        // -------------------------------
        if (head == null || head.next == null) {
            return head;
        }

        // -------------------------------
        // RECURSIVE STEP:
        // Reverse the rest of the list starting from head.next
        // -------------------------------
        ListNode newHead = Reverse(head.next);

        // -------------------------------
        // REVERSE CURRENT NODE LINKS:
        // Suppose head = 3, head.next = 4
        // After reversing, newHead points to 4 -> ... -> 3
        // We need 4.next = 3 to complete reversal
        // -------------------------------
        head.next.next = head;  // Make next node point to current node
        head.next = null;       // Current node points to null

        // -------------------------------
        // RETURN new head of reversed list
        // -------------------------------
        return newHead;
    }
}

/*
 * -------------------------------
 * DRY RUN EXAMPLE
 * Original List: 1 -> 2 -> 3 -> 4 -> null
 *
 * Step 1: Call stack formation
 * reverseList(1) → calls reverseList(2)
 * reverseList(2) → calls reverseList(3)
 * reverseList(3) → calls reverseList(4)
 * reverseList(4) → base case → returns 4
 *
 * Step 2: Backtracking and reversing
 *
 * Backtracking node 3:
 * head = 3
 * head.next = 4
 * head.next.next = head → 4.next = 3
 * head.next = null → 3.next = null
 * Result: 4 -> 3 -> null
 *
 * Backtracking node 2:
 * head = 2
 * head.next = 3
 * head.next.next = head → 3.next = 2
 * head.next = null → 2.next = null
 * Result: 4 -> 3 -> 2 -> null
 *
 * Backtracking node 1:
 * head = 1
 * head.next = 2
 * head.next.next = head → 2.next = 1
 * head.next = null → 1.next = null
 * Result: 4 -> 3 -> 2 -> 1 -> null
 *
 * -------------------------------
 * VISUAL DIAGRAM (ARROWS SHOW LINKS)
 *
 * ORIGINAL:
 * 1 -> 2 -> 3 -> 4 -> null
 *
 * RECURSION CALL STACK:
 * reverseList(1)
 * reverseList(2)
 * reverseList(3)
 * reverseList(4) → base case returns 4
 *
 * BACKTRACKING LINKS:
 * Step 1: 4 -> 3 -> null
 * Step 2: 4 -> 3 -> 2 -> null
 * Step 3: 4 -> 3 -> 2 -> 1 -> null
 *
 * FINAL OUTPUT:
 * 4 -> 3 -> 2 -> 1 -> null
 *
 * -------------------------------
 * COMPLEXITY:
 * Time: O(n) – each node is visited once
 * Space: O(n) – recursion stack
 */
