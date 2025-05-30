package linkedlists.mid;

/*
    #19
    Given the head of a linked list, remove the nth node from the end of the list and return its head.

    - Example 1:
        Input: head = [1,2,3,4,5], n = 2
        Output: [1,2,3,5]

    - Example 2:
        Input: head = [1], n = 1
        Output: []

    - Example 3:
        Input: head = [1,2], n = 1
        Output: [1]

   - Constraints:
       The number of nodes in the list is sz.
       1 <= sz <= 30
       0 <= Node.val <= 100
       1 <= n <= sz
*/

public class RemoveNthNodeFromEndOfList {

    /**
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

    /*
     * Removes the Nth node from the end of the list.
     *
     * @param head - the head node
     * @param n    - the Nth node to remove
     * @return - modified linked list
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        int n = 2;

        System.out.println("Original Linked List: ");
        printList(head);
        System.out.println("Modified Linked List: ");
        ListNode finalList = removeNthFromEnd(head, n);
        printList(finalList);


        ListNode head2 = new ListNode(1);

        int n2 = 1;

        System.out.println("Original Linked List: ");
        printList(head2);
        System.out.println("Modified Linked List: ");
        ListNode finalList2 = removeNthFromEnd(head2, n2);
        printList(finalList2);


        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);

        int n3 = 1;

        System.out.println("Original Linked List: ");
        printList(head3);
        System.out.println("Modified Linked List: ");
        ListNode finalList3 = removeNthFromEnd(head3, n3);
        printList(finalList3);
    }

    /**
     * Prints the Linked List
     *
     * @param head - the head node
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
    1. Create a dummy node and set its next to the head. (This covers edge case scenario when the head is removed. In
        other words, n = sz)
    2. Create two pointers, first and second, and set them to the dummy node.
    3. Move the first pointer n+1 steps ahead.
    4. Move both pointers until the first pointer points to null (the end of the list).
    5. The second pointer will be at the node before the one we want to remove. So we set the next of the second pointer
        to the next of the next of the second pointer; second.next = second.next.next.
    6. Return the next of the dummy node (first actual node in original list or null if head is removed).
*/