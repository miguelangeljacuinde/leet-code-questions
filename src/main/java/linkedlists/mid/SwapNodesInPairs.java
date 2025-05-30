package linkedlists.mid;

/*
    #24
    Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without
    modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

    - Example 1:
        Input: head = [1,2,3,4]
        Output: [2,1,4,3]

    - Example 2:
        Sample Input: head = []
        Sample Output: []

    - Example 3:
        Sample Input: head = [1]
        Sample Output: [1]

    - Example 4:
        Sample Input: head = [1,2,3]
        Sample Output: [2,1,3]

    - Constraints:
        The number of nodes in the list is in the range [0, 100].
        0 <= Node.val <= 100
*/

public class SwapNodesInPairs {

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
     * Swaps every two adjacent nodes in the linked list.
     *
     * @param head - the head of the linked list
     * @return - the head of the modified linked list
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            first.next = second.next;
            second.next = first;

            prev.next = second;
            prev = first;

            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        printList(head);
        ListNode result = swapPairs(head);
        printList(result);

        ListNode head2 = new ListNode();
        printList(head2);
        ListNode result2 = swapPairs(head2);
        printList(result2);

        ListNode head3 = new ListNode(1);
        printList(head3);
        ListNode result3 = swapPairs(head3);
        printList(result3);

        ListNode head4 = new ListNode(1, new ListNode(2, new ListNode(3)));
        printList(head4);
        ListNode result4 = swapPairs(head4);
        printList(result4);
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
        n = number of nodes in the linked list
    1. Create a dummy node to point to the head of the linked list.
    2. Initialize a pointer prev to the dummy node.
    3. While the head and head.next are not null:
        a. Set first to head and second to head.next.
        b. Swap the nodes:
            i. Update the next pointer of first to point to second.next (first.next = second.next).
            ii. Update the next pointer of second to point to first (second.next = first).
        c. Update prev pointer:
            i. Update the next pointer of prev to point to second (prev.next = second).
            ii. Move prev to first and head to first.next (prev = first).
        d. Continue traversing by moving head to head.next (head = head.next).
    4. Return the next pointer of the dummy node (dummy.next).
*/
