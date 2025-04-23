package linkedlists.easy;

/*
    # 206
    Given the head of a singly linked list, reverse the list, and return the reversed list.

    - Example 1:
        Input: head = [1,2,3,4,5]
        Output: [5,4,3,2,1]

    - Example 2:
        Input: head = [1,2]
        Output: [2,1]

    - Example 3:
        Input: head = []
        Output: []

    - Constraints:
        The number of nodes in the list is the range [0, 5000].
        -5000 <= Node.val <= 5000
*/

public class ReverseLinkedList {

    /**
     * List Node class
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    /**
     * Reverses the Linked List.
     *
     * @param head - the head node
     * @return - reversed linked list
     */
    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5)))));

        System.out.print("Original Linked List: ");
        printList(head);
        ListNode reversedNode = reverseList(head);
        System.out.print("Reversed Linked List: ");
        printList(reversedNode);
    }

    /**
     * Prints the Linked List
     *
     * @param head - the head node
     */
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            if (current.next == null) {
                System.out.println(current.val);
                break;
            }
            System.out.print(current.val + " -> ");
            current = current.next;
        }
    }

}

/*
    O(n) time | O(1) space:
        n = number of nodes in linked list.
    1. Initialize a current node pointing to head and a prev node pointing to null.
    2. While the current node is not null, traverse the linked list.
        a. Initialize a temp node to store the next node's value.
        b. The next node will now point to the prev node.
        c. The prev node will now point to the current node.
        d. The current node will now point to the temp node (node after current -> current.next). This will allow us
            to continue traversing the linked list.
    3. Return the prev node as the new head.
*/