package linkedlists.easy;

/*
    #203
    Given the head of a linked list and an integer val, remove all the nodes of the linked list that has
    Node.val == val, and return the new head.

    - Example 1:
        Input: head = [1,2,6,3,4,5,6], val = 6
        Output: [1,2,3,4,5]

    - Example 2:
        Input: head = [], val = 1
        Output: []

    - Example 3:
        Input: head = [7,7,7,7], val = 7
        Output: []

    - Constraints:
        The number of nodes in the list is in the range [0, 104].
        1 <= Node.val <= 50
        0 <= val <= 50

*/

public class RemoveLinkedListElements {

    /**
     * The ListNode class
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Removes all the elements with the value val in the Linked List.
     *
     * @param head - the head of the linked list
     * @param val  - the value to remove from the linked list
     * @return - The updated linked list
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode current = dummy;

        while (current != null) {
            while (current.next != null && current.next.val == val) {
                current.next = current.next.next;
            }
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(6,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5,
                                                        new ListNode(6)))))));
        ListNode listNode1 = removeElements(head1, 6);
        System.out.print("Head 1 : ");
        printList(listNode1);

        ListNode listNode2 = removeElements(null, 1);
        System.out.print("Head 2 : ");
        printList(listNode2);

        ListNode head3 = new ListNode(7,
                new ListNode(7,
                        new ListNode(7,
                                new ListNode(7))));
        ListNode listNode3 = removeElements(head3, 7);
        System.out.print("Head 3 : ");
        printList(listNode3);
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
    O(n) time | O(1) space :
        n = number of nodes in linked list.
    1. Create a new dummy linked list with a placeholder value 0 and the next pointing to the input head node.
    2. Initialize a current node pointing to the newly created dummy list.
    3. Traverse while the current node is not null.
        a. In an inner while loop, traverse while the current's next node is not null and the current's next node's
            value = the input value. If the current's next node's value = input value, set current.next pointer to point
            to current.next.next (We are skipping every element whose value = input value).
        b. Else, the current node will point to the next node. (current = current.next).
    4. Return the dummy linked list head.next as the head is pointing to the placeholder value of 0.
*/
