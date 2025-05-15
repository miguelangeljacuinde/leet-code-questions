package linkedlists.mid;

/*
    #2
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
    order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    - Example 1:
        Sample Input: l1 = [2,4,3], l2 = [5,6,4]
        Sample Output: [7,0,8]
        Explanation: 342 + 465 = 807.

    - Example 2:
        Sample Input: l1 = [0], l2 = [0]
        Sample Output: [0]

    - Example 3:
        Sample Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        Sample Output: [8,9,9,9,0,0,0,1]

    - Constraints:
        The number of nodes in each linked list is in the range [1, 100].
        0 <= Node.val <= 9
        It is guaranteed that the list represents a number that does not have leading zeros.
*/

public class AddTwoNumbers {

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
     * Adds two numbers represented by linked lists.
     *
     * @param l1 - first linked list
     * @param l2 - second linked list
     * @return - the sum of the two numbers as a linked list
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = addTwoNumbers(l1, l2);
        printList(result);
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
    O(n) time | O(1) space:
        n = maximum length of the two linked lists.
    1. We create a dummy node to simplify the code and keep track of the head of the result linked list.
    2. We initialize a current pointer to the dummy node and a carry variable to 0.
    3. While either l1 or l2 is not null:
        a. Get the values of the current nodes of l1 and l2 (if they exist, or else 0).
        b. Calculate the sum of the two values and the carry.
        c. Update the carry for the next iteration.
        d. Create a new node with the value of sum % 10 and set it as the next node of current.
        e. Move current to its next node.
        f. Move l1 and l2 to their next nodes (if they exist, else stay at the end of the list).
    4. If there is still a carry left after processing both lists, create a new node with the carry value and set it as
        the next node of current.
    5. Finally, return the next node of the dummy node, which is the head of the result linked list.
*/