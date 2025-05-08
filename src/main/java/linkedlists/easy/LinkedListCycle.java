package linkedlists.easy;

/*
    #141
    Given head, the head of a linked list, determine if the linked list has a cycle in it. There is a cycle in a linked
    list if there is some node in the list that can be reached again by continuously following the next pointer.
    Internally, pos is used to denote the index of the node that tail's next pointer is connected to.

    Note that pos is not passed as a parameter.

    Return true if there is a cycle in the linked list. Otherwise, return false.

    - Example 1:
        Sample Input: head = [3,2,0,-4], pos = 1
        Sample Output: true
        Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

    - Example 2:
        Sample Input: head = [1,2], pos = 0
        Sample Output: true
        Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

    - Example 3:
        Sample Input: head = [1], pos = -1
        Sample Output: false
        Explanation: There is no cycle in the linked list.

    - Constraints:
        The number of the nodes in the list is in the range [0, 104].
        -105 <= Node.val <= 105
        pos is -1 or a valid index in the linked-list.
*/

public class LinkedListCycle {

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
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(hasCycle(head));

        ListNode head2 = new ListNode(1);
        ListNode node5 = new ListNode(2);
        head2.next = node5;
        node5.next = head2;
        System.out.println(hasCycle(head2));


        ListNode head3 = new ListNode(3);
        System.out.println(hasCycle(head3));
    }

    /**
     * Determines if the linked list has a cycle.
     *
     * @param head - the head of the linked list
     * @return - true if there is a cycle, false otherwise
     */
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}

/*
    O(n) time | O(1) space:
        n = number of nodes in the linked list
    1. Create a slow pointer and a fast pointer, both pointing to the head of the linked list.
    2. While the fast pointer and the next node of the fast pointer are not null, traverse the linked list.
        a. Move the slow pointer one step at a time (slow = slow.next).
        b. Move the fast pointer two steps at a time (fast = fast.next.next).
        c. Compare: if the slow pointer and the fast pointer are equal return true (cycle detected).
    3. If the fast pointer reaches the end of the linked list (null), return false (no cycle detected).
*/