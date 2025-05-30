package linkedlists.mid;

/*
    Write a function that takes in a linked list and two integers, startIdx and endIdx, and reverses the nodes of the
    linked list from startIdx to endIdx (inclusive).

    The function should return the head of the modified linked list.

    - Example 1:
        Input: head = [1,2,3,4,5], startIdx = 1, endIdx = 3
        Output: [1,3,2,4,5]
        Explanation: The nodes from index 1 to 3 (inclusive) are reversed, resulting in the linked list [1,3,2,4,5].

    - Example 2:
        Input: head = [1,2,3,4,5], startIdx = 0, endIdx = 2
        Sample Output: [3,2,1,4,5]
        Explanation: The nodes from index 0 to 2 (inclusive) are reversed, resulting in the linked list [3,2,1,4,5].

    - Example 3:
        Sample Input: head = [1,2,3,4,5], startIdx = 0, endIdx = 4
        Sample Output: [5,4,3,2,1]
        Explanation: The nodes from index 2 to 4 (inclusive) are reversed, resulting in the linked list [5,4,3,2,1].

    - Constraints:
        The number of nodes in the linked list is in the range [1, 1000].
        0 <= startIdx <= endIdx < number of nodes in the linked list.
        The values of the nodes are integers between -1000 and 1000.
*/

public class ReverseBetween {

    /*
     * List Node class
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Reverses the linked list between the start and end indices.
     *
     * @param head     - the head of the linked list
     * @param startIndex - the starting index
     * @param endIndex - the ending index
     * @return - the head of the modified linked list
     */
    public static ListNode reverseBetween(ListNode head, int startIndex, int endIndex) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 0; i < startIndex; i++) {
            prev = prev.next;
        }

        ListNode current = prev.next;

        for (int i = 0; i < endIndex - startIndex; i++) {
            ListNode toMove = current.next;
            current.next = toMove.next;
            toMove.next = prev.next;
            prev.next = toMove;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        int left = 2;
        int right = 4;

        System.out.print("Original Linked List: ");
        printList(head);
        ListNode reversedNode = reverseBetween(head, left, right);
        System.out.print("Reversed Linked List: ");
        printList(reversedNode);
    }

    /**
     * Prints evey node in the list
     *
     * @param head - the current node to start traversing
     */
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

}

/*
    O(n) time | O(1) space
        n = the number of nodes in the linked list.
    1. Create a dummy node and set its next pointer to the head of the linked list.
    2. Initiate prev node and traverse the linked list to the node just before the start index.
    3. Set current node to the node at the start index (current = prev.next).
    4. For each node from start index to end index:
        a. Store the node after current in the toMove temp node (toMove = current.next).
        b. Update current's next pointer to point to the node after the toMove node (current.next = toMove.next).
        c. Update toMove's next pointer to point to the node after the prev node (toMove.next = prev.next).
        d. Update prev's next pointer to point to the toMove temp node (prev.next = toMove).
    5. Return the modified linked list starting from dummy.next.
*/
