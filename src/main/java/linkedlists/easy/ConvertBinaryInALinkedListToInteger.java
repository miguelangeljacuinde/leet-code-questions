package linkedlists.easy;

/*
    #1290
    Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either
    0 or 1. The linked list holds the binary representation of a number.

    Return the decimal value of the number in the linked list.

    The most significant bit is at the head of the linked list.

    - Example 1:
        Sample Input: head = [1,0,1]
        Sample Output: 5

    - Example 2:
        Sample Input: head = [0]
        Sample Output: 0

    - Constraints:
        The linked list is not empty.
        Number of nodes will not exceed 30.
        Each node's value is either 0 or 1.
*/

public class ConvertBinaryInALinkedListToInteger {

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
     * Converts the binary number represented by a linked list to its decimal value.
     *
     * @param head - the head node of the linked list
     * @return - the decimal value of the binary number
     */
    public static int getDecimalValue(ListNode head) {
        int decimal = 0;

        while (head != null) {
            decimal = decimal * 2 + head.val;
            head = head.next;
        }
        return decimal;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(0, new ListNode(1)));
        System.out.println(getDecimalValue(head));

        ListNode head2 = new ListNode(0);
        System.out.println(getDecimalValue(head2));

        ListNode head3 = new ListNode(1, new ListNode(0, new ListNode(1, new ListNode(0))));
        System.out.println(getDecimalValue(head3));
    }

}

/*
    O(n) time | O(1) space
        n = the number of nodes in the linked list.
    1. Initialize a variable decimal to 0 to keep track of the sum.
    2. Traverse the linked list:
        a. For each node, update decimal by multiplying it by 2 and adding the current node's value.
        b. Move to the next node.
    3. Return the decimal value.
*/