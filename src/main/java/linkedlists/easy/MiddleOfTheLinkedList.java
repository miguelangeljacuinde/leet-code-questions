package linkedlists.easy;

/*
    #876
    Given the head of a singly linked list, return the middle node of the linked list.

    If there are two middle nodes, return the second middle node.

    Example 1:
        Sample Input: head = [1,2,3,4,5]
        Sample Output: [3,4,5]
        Explanation: The middle node of the list is node 3.

    Example 2:
        Sample Input: head = [1,2,3,4,5,6]
        Sample Output: [4,5,6]
        Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

    Constraints:
        The number of nodes in the list is in the range [1, 100].
        1 <= Node.val <= 100
*/

public class MiddleOfTheLinkedList {

    public static class ListNode {
        public int val;
        public ListNode next;

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
     * @param linkedList - the input linked list
     * @return - The modified linked list
     */
    public static ListNode middleNode(ListNode linkedList) {
        ListNode slowNode = linkedList;
        ListNode fastNode = linkedList;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode node2 = new ListNode(7);
        ListNode node3 = new ListNode(3);
        ListNode tail = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = tail;
        tail.next = null;

        System.out.println("Original Linked List: ");
        printLinkedList(head);
        System.out.println();
        System.out.println("Middle Node: ");
        ListNode finalLinkedList = middleNode(head);
        printLinkedList(finalLinkedList);
        System.out.println();

        ListNode headTest2 = new ListNode(1);
        ListNode node2Test2 = new ListNode(2);
        ListNode tailTest2 = new ListNode(3);

        headTest2.next = node2Test2;
        node2Test2.next = tailTest2;
        tailTest2.next = null;

        System.out.println("Original Linked List: ");
        printLinkedList(headTest2);
        System.out.println();
        System.out.println("Middle Node : ");
        ListNode finalLinkedList2 = middleNode(headTest2);
        printLinkedList(finalLinkedList2);
    }

    /**
     * @param linkedList - the linked list
     */
    public static void printLinkedList(ListNode linkedList) {
        while (linkedList != null) {
            if (linkedList.next != null) {
                System.out.print(linkedList.val + " -> ");
            } else {
                System.out.print(linkedList.val);
            }
            linkedList = linkedList.next;
        }
    }

}

/*
    O(n) time | O(1) space:
        n = number of nodes in linked list.
    1. Initialize a slow linked list and a fast linked list.
    2. While the fast linked list is not null and the fast linked list next pointer is also not null, traverse:
        a. slow node = slow node.next (the next node)
        b. fast node = fast node.next.next (the node after the next node; moving twice as fast as the slow node)
    3. Return the slow node (since it is moving at half speed, once the fast node has traversed the entire linked list,
        the slow node will be right in the middle).
*/