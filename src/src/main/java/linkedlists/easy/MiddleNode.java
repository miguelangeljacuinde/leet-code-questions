package linkedlists.easy;

/*
    You're given a linked list with at least one node.
    Write a function that returns the middle node of the linked list.
    If there are two middle nodes (i.e. an even length list), your function should return the second of these nodes.

    Note: Each LinkedList node has an integer value as well as a next node pointing to the next node in the list or
    to None/null if it's the tail of the list.

    Sample Input: linkedList = 2 -> 7 -> 3 -> 5

    Sample Output: 3 -> 5   // the middle could be 7 or 3, so we return the second node which is 3.
*/

public class MiddleNode {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(2);
        LinkedList node2 = new LinkedList(7);
        LinkedList node3 = new LinkedList(3);
        LinkedList tail = new LinkedList(5);

        head.next = node2;
        node2.next = node3;
        node3.next = tail;
        tail.next = null;

        System.out.println("Original Linked List: ");
        printLinkedList(head);
        System.out.println();
        System.out.println("Middle Node: ");
        LinkedList finalLinkedList = middleNode(head);
        printLinkedList(finalLinkedList);
        System.out.println();


        LinkedList headTest2 = new LinkedList(1);
        LinkedList node2Test2 = new LinkedList(2);
        LinkedList tailTest2 = new LinkedList(3);

        headTest2.next = node2Test2;
        node2Test2.next = tailTest2;
        tailTest2.next = null;

        System.out.println("Original Linked List: ");
        printLinkedList(headTest2);
        System.out.println();
        System.out.println("Middle Node: ");
        LinkedList finalLinkedList2 = middleNode(headTest2);
        printLinkedList(finalLinkedList2);
    }

    /**
     * @param linkedList - the input linked list
     * @return - The modified linked list
     */
    public static LinkedList middleNode(LinkedList linkedList) {
        LinkedList slowNode = linkedList;
        LinkedList fastNode = linkedList;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }

    /**
     * @param linkedList - the linked list
     */
    public static void printLinkedList(LinkedList linkedList) {
        while (linkedList != null) {
            if (linkedList.next != null) {
                System.out.print(linkedList.value + " -> ");
            } else {
                System.out.print(linkedList.value);
            }
            linkedList = linkedList.next;
        }
    }
}

/*
    O(n) time | O(1) space :
        n = number of nodes in linked list.
    1. Initialize a slow linked list and a fast linked list.
    2. While the fast linked list is not null and the fast linked list next pointer is also not null, traverse:
        a. slow node = slow node.next (the next node)
        b. fast node = fast node.next.next (the node after the next node; moving twice as fast as the slow node)
    3. Return the slow node (since it is moving at half speed, once the fast node has traversed the entire linked list,
        the slow node will be right in the middle).
*/