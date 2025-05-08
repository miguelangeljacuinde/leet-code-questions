package linkedlists.easy;

/*
    You're given the head of a singly linked list whose nodes are in sorted order with respect to their values.
    Write a function that returns a modified version of the linked list that doesn't contain any nodes with duplicate
    values.

    The linked list should be modified in place (i.e. you should not create a new list), and the modified
    linked list should still have its nodes sorted with respect to their values.

    Note: Every LinkedList node has an integer value as well as a next node pointing to the next node in the list or
    to None/null if it's the tail of the list.

    Sample Input: linkedList = 1 -> 1 -> 3 -> 4 -> 4 -> 4 -> 5 -> 6 -> 6    // the head node with value 1
    Sample Output: 1 -> 3 -> 4 -> 5 -> 6    // the head node with value 1
 */

public class RemoveDuplicates {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(1);
        LinkedList node2 = new LinkedList(1);
        LinkedList node3 = new LinkedList(3);
        LinkedList node4 = new LinkedList(4);
        LinkedList node5 = new LinkedList(4);
        LinkedList node6 = new LinkedList(4);
        LinkedList node7 = new LinkedList(5);
        LinkedList node8 = new LinkedList(6);
        LinkedList tail = new LinkedList(6);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = tail;
        tail.next = null;

        System.out.println("Original Linked List: ");
        printLinkedList(head);

        System.out.println();
        System.out.println();

        System.out.println("Modified Linked List: ");
        LinkedList finalList = removeDuplicatesFromLinkedList(head);
        printLinkedList(finalList);
    }

    /**
     * @param linkedList - the input linked list
     * @return - The modified linked list
     */
    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList currentNode = linkedList;
        while (currentNode != null) {
            LinkedList nextNode = currentNode.next;
            while (nextNode != null && nextNode.value == currentNode.value) {
                nextNode = nextNode.next;
            }
            currentNode.next = nextNode;
            currentNode = nextNode;
        }
        return linkedList;
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
    1. Traverse linked list starting with the head node while currentNode != null.
    2. Assign nextNode as currentNode.next. While nextNode != null and nextNode.value = currentNode.value,
        keep traversing by reassigning nextNode = nextNode.next.
    3. Once nextNode and currentNode are not the same value, point currentNode's next to nextNode. And reassign
        currentNode as the nextNode to continue traversing.
    4. Return the modified linked list.
*/
