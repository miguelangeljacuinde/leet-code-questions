package linkedlists.mid;

/*
    #82
    Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers
    from the original list. Return the linked list sorted as well.

    - Example 1:
        Sample Input: head = [1,2,3,3,4,4,5]
        Sample Output: [1,2,5]

    - Example 2:
        Sample Input: head = [1,1,1,2,3]
        Sample Output: [2,3]

    - Constraints:
        The number of nodes in the list is in the range [0, 300].
        -100 <= Node.val <= 100
        The list is guaranteed to be sorted in ascending order.
*/

public class RemoveDuplicatesFromSortedListII {

    /*
     * The ListNode class
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

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;
        ListNode after = current.next;

        boolean isDuplicate = false;

        while (current != null) {
            if (after != null && current.val == after.val) {
                isDuplicate = true;
            } else if (isDuplicate) {
                prev.next = after;
                isDuplicate = false;
            } else {
                prev = current;
            }
            current = after;
            if (after != null) {
                after = after.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(4,
                                                        new ListNode(5)))))));
        System.out.print("Head: ");
        printList(head);
        ListNode result = deleteDuplicates(head);
        System.out.print("Result: ");
        printList(result);

        ListNode head2 = new ListNode(1,
                new ListNode(1,
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3)))));
        System.out.print("Head 2: ");
        printList(head2);
        ListNode result2 = deleteDuplicates(head2);
        System.out.print("Result: ");
        printList(result2);
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
        n = number of nodes in the list.
    1. Initialize nodes
        a. dummy node to point to the head of the list
        b. prev node to point to the dummy node
        c. current node to point to the head of the list
        d. after node to point to the next node of current
    2. Initialize a boolean variable isDuplicate to false
    3. While the current node is not null:
        a. If the after node is not null and the value of current node is equal to the value of after node
            i. Set isDuplicate to true
        b. Else if isDuplicate is true
            i. Set prev.next to after
            ii. Set isDuplicate to false
        c. Else set prev to current
        d. Set current to after
        e. If after is not null, set after to after.next
    4. Return dummy.next
*/
