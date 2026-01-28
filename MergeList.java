// =======================
// MERGE TWO SORTED LINKED LISTS
// =======================

// Definition of a singly linked list node
class ListNode {
    int val;        // The value stored in this node
    ListNode next;  // Pointer to the next node in the list

    // Constructors
    ListNode() {}                     // Default constructor
    ListNode(int val) { this.val = val; }                  // Constructor with value
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }  // Constructor with value + next pointer
}

// Solution class containing merge logic
class Solution {

    /**
     * Function to merge two sorted linked lists
     * @param l1 - first sorted linked list
     * @param l2 - second sorted linked list
     * @return merged sorted linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // -----------------------------
        // Step 0: Create a dummy node
        // -----------------------------
        // Dummy node is a placeholder to simplify merging.
        // -1 is arbitrary, it is not part of the final list.
        ListNode dummy = new ListNode(-1);

        // Temp pointer is used to build the merged list dynamically
        ListNode temp = dummy;

        // -----------------------------
        // Step 1: Traverse both lists while neither is empty
        // -----------------------------
        while (l1 != null && l2 != null) {

            // Compare current nodes of both lists
            if (l1.val < l2.val) {
                temp.next = l1;  // Attach the smaller node (from l1) to merged list
                l1 = l1.next;    // Move pointer in l1 forward
            } else {
                temp.next = l2;  // Attach the smaller node (from l2) to merged list
                l2 = l2.next;    // Move pointer in l2 forward
            }

            temp = temp.next;    // Move temp forward to next position
        }

        // -----------------------------
        // Step 2: Attach remaining nodes from l1 (if any)
        // -----------------------------
        while (l1 != null) {
            temp.next = l1;  // Attach remaining nodes from l1
            l1 = l1.next;    // Move l1 forward
            temp = temp.next; // Move temp forward
        }

        // -----------------------------
        // Step 3: Attach remaining nodes from l2 (if any)
        // -----------------------------
        while (l2 != null) {
            temp.next = l2;  // Attach remaining nodes from l2
            l2 = l2.next;    // Move l2 forward
            temp = temp.next; // Move temp forward
        }

        // -----------------------------
        // Step 4: Return the merged list
        // -----------------------------
        // We return dummy.next because dummy is just a placeholder (-1)
        return dummy.next;
    }

    /**
     * Helper function to print a linked list
     * @param head - head of the linked list
     */
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null"); // End of the list
    }

    // ================================
    // MAIN FUNCTION (for testing)
    // ================================
    public static void main(String[] args) {
        Solution solution = new Solution();

        // -----------------------------
        // Create first list: l1 = 1 -> 3 -> 5
        // -----------------------------
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        // -----------------------------
        // Create second list: l2 = 2 -> 4 -> 6
        // -----------------------------
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        // -----------------------------
        // Print both lists before merging
        // -----------------------------
        System.out.print("List 1: ");
        solution.printList(l1);

        System.out.print("List 2: ");
        solution.printList(l2);

        // -----------------------------
        // Merge the two sorted lists
        // -----------------------------
        ListNode merged = solution.mergeTwoLists(l1, l2);

        // -----------------------------
        // Print the merged list
        // -----------------------------
        System.out.print("Merged List: ");
        solution.printList(merged);

        // ================================
        // DRY RUN EXPLANATION
        // ================================
        /*
            Initial lists:
            l1: 1 -> 3 -> 5
            l2: 2 -> 4 -> 6

            Step 0: Create dummy node (-1)
            dummy -> null
            temp -> dummy

            Step 1: Compare 1 and 2
            1 < 2 -> attach l1
            dummy(-1) -> 1
            temp -> 1
            l1 -> 3
            l2 -> 2

            Step 2: Compare 3 and 2
            3 > 2 -> attach l2
            dummy(-1) -> 1 -> 2
            temp -> 2
            l1 -> 3
            l2 -> 4

            Step 3: Compare 3 and 4
            3 < 4 -> attach l1
            dummy(-1) -> 1 -> 2 -> 3
            temp -> 3
            l1 -> 5
            l2 -> 4

            Step 4: Compare 5 and 4
            5 > 4 -> attach l2
            dummy(-1) -> 1 -> 2 -> 3 -> 4
            temp -> 4
            l1 -> 5
            l2 -> 6

            Step 5: Compare 5 and 6
            5 < 6 -> attach l1
            dummy(-1) -> 1 -> 2 -> 3 -> 4 -> 5
            temp -> 5
            l1 -> null
            l2 -> 6

            Step 6: l1 is null, attach remaining l2
            dummy(-1) -> 1 -> 2 -> 3 -> 4 -> 5 -> 6
            temp -> 6
            l2 -> null

            Step 7: Return dummy.next
            Result: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
        */
    }
}
