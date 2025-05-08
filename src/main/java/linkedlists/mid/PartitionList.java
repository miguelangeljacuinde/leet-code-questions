package linkedlists.mid;

/*
    #86
    Given the head of a linked list and an integer x, partition it such that all nodes less than x come before nodes
    greater than or equal to x.

    You should preserve the original relative order of the nodes in each of the two partitions.

    The original list should be split into two parts: the first part contains all nodes with values less than x,
    and the second part contains all nodes with values greater than or equal to x.

    The partitioned list should be returned as a new list.

    - Example 1:
        Sample Input: head = [1,4,3,2,5,2], x = 3
        Sample Output: [1,2,2,4,3,5]

    - Example 2:
        Sample Input: head = [2,1], x = 2
        Sample Output: [1,2]

    - Constraints:
        The number of nodes in the list is in the range [0, 200].
        -100 <= Node.val <= 100
        -200 <= x <= 200
*/

import linkedlists.easy.RemoveLinkedListElements;

public class PartitionList {

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
     * Partitions the linked list around the value x.
     *
     * @param head - the head node of the linked list
     * @param x    - the partition value
     * @return - the head of the modified linked list
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);

        ListNode prev1 = dummy1;
        ListNode prev2 = dummy2;

        while (head != null) {
            if (head.val < x) {
                prev1.next = head;
                prev1 = prev1.next;
            } else {
                prev2.next = head;
                prev2 = prev2.next;
            }
            head = head.next;
        }

        prev1.next = dummy2.next;
        prev2.next = null;

        return dummy1.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(4,
                        new ListNode(3,
                                new ListNode(2,
                                        new ListNode(5,
                                                new ListNode(2))))));
        int x = 3;
        ListNode result = partition(head, x);
        printList(result);

        ListNode head2 = new ListNode(2, new ListNode(1));
        int x2 = 2;
        ListNode result2 = partition(head2, x2);
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
    O(n) time | O(1) space
        n = the number of nodes in the linked list.
    1. Create two dummy nodes, dummy1 and dummy2, to represent the two partitions.
    2. Initialize two pointers, prev1 and prev2, to point to dummy1 and dummy2 respectively.
    3. Traverse the linked list:
        a. If the current node's value is less than x, append it to the first partition (dummy1).
        b. Otherwise, append it to the second partition (dummy2).
    4. After traversing the list, connect the end of the first partition to the start of the second partition
        (prev1.next = dummy2.next).
    5. Set the next pointer of the last node in the second partition to null to avoid cycles.
    6. Return the head of the first partition (dummy1.next).
*/
