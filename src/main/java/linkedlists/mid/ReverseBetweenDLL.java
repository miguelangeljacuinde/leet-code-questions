package linkedlists.mid;

import dataStructures.linkedList.DoublyLinkedListDemo;

/*
    Write a function that reverses a doubly linked list between two indices, startIndex and endIndex (inclusive).
    The function should modify the linked list in-place.

    - Example 1:
        Sample Input: head = 1 <-> 2 <-> 3 <-> 4 <-> 5, startIndex = 1, endIndex = 3
        Sample Output: head = 1 <-> 4 <-> 3 <-> 2 <-> 5
        Explanation: The nodes from index 1 to 3 (inclusive) are reversed, resulting in the linked list [1,3,2,4,5].

    - Example 2:
        Sample Input: head = 1 <-> 2 <-> 3 <-> 4 <-> 5, startIndex = 0, endIndex = 2
        Sample Output: head = 3 <-> 2 <-> 1 <-> 4 <-> 5
        Explanation: The nodes from index 0 to 2 (inclusive) are reversed, resulting in the linked list [3,2,1,4,5].

    - Example 3:
        Sample Input: head = 1 <-> 2 <-> 3 <-> 4 <-> 5, startIndex = 0, endIndex = 4
        Sample Output: head = 5 <-> 4 <-> 3 <-> 2 <-> 1
        Explanation: The nodes from index 0 to 4 (inclusive) are reversed, resulting in the linked list [5,4,3,2,1].

    - Constraints:
        The number of nodes in the linked list is in the range [1, 1000].
        0 <= startIndex <= endIndex < number of nodes in the linked list.
        The values of the nodes are integers between -1000 and 1000.
*/

public class ReverseBetweenDLL {

    /**
     * Reverses a doubly linked list between two indices.
     *
     * @param dll        - the doubly linked list to reverse
     * @param startIndex - the starting index of the sublist to reverse
     * @param endIndex   - the ending index of the sublist to reverse
     */
    public static void reverseBetween(DoublyLinkedListDemo dll, int startIndex, int endIndex) {
        if (dll.head == null || startIndex == endIndex) {
            return;
        }
        DoublyLinkedListDemo.Node dummy = new DoublyLinkedListDemo.Node(0);
        dummy.next = dll.head;
        dll.head.prev = dummy;

        DoublyLinkedListDemo.Node prev = dummy;
        for (int i = 0; i < startIndex; i++) {
            prev = prev.next;
        }

        DoublyLinkedListDemo.Node current = prev.next;
        for (int i = 0; i < endIndex - startIndex; i++) {
            DoublyLinkedListDemo.Node toMove = current.next;
            current.next = toMove.next;

            if (toMove.next != null) {
                toMove.next.prev = current;
            }

            toMove.next = prev.next;
            current.prev = toMove;

            prev.next = toMove;
            toMove.prev = prev;
        }

        dll.head = dummy.next;
        dll.head.prev = null;

        DoublyLinkedListDemo.Node tail = dll.head;
        while (tail.next != null) {
            tail = tail.next;
        }
        dll.tail = tail;
    }

    public static void main(String[] args) {
        DoublyLinkedListDemo dll = new DoublyLinkedListDemo();
        dll.append(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);
        System.out.println("Original List:");
        printList(dll.head);
        reverseBetween(dll, 1, 3);
        System.out.println("Reversed List between indices 1 and 3:");
        printList(dll.head);

        DoublyLinkedListDemo dll2 = new DoublyLinkedListDemo();
        dll2.append(1);
        dll2.append(2);
        dll2.append(3);
        dll2.append(4);
        dll2.append(5);
        System.out.println("Original List:");
        printList(dll2.head);
        reverseBetween(dll2, 0, 2);
        System.out.println("Reversed List between indices 0 and 2:");
        printList(dll2.head);

        DoublyLinkedListDemo dll3 = new DoublyLinkedListDemo();
        dll3.append(1);
        dll3.append(2);
        dll3.append(3);
        dll3.append(4);
        dll3.append(5);
        System.out.println("Original List:");
        printList(dll3.head);
        reverseBetween(dll3, 0, 4);
        System.out.println("Reversed List between indices 0 and 4:");
        printList(dll3.head);
    }

    /**
     * Prints evey node in the list
     *
     * @param head - the current node to start traversing
     */
    public static void printList(DoublyLinkedListDemo.Node head) {
        DoublyLinkedListDemo.Node current = head;
        while (current != null) {
            System.out.print(current.value);
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
        n = number of nodes in the linked list
    1. The function first checks if the list is empty or if the start and end indices are the same.
        If so, it returns immediately.
    2. A dummy node is created to simplify the reversal process. Set the dummy node's next pointer to the head of the
        list.
    3. The function traverses the list to find the node just before the start index (prev = prev.next until we get to
        that node).
    4. The current node is set to the node at the start index (current = prev.next).
    5. For each node from start index to end index:
        a. Initialize a variable toMove to the next node of current.
        b. The node to be moved (toMove) is set to the next node of the current node (toMove = current.next).
        c. If the toMove's next node is not null, the current node's next pointer is updated to skip the toMove node
            (current.next = toMove.next).
        d. The toMove node's next pointer is updated to point to the previous node's next pointer (toMove.next = prev.next).
        e. The current node's prev pointer is updated to point to the toMove node (current.prev = toMove).
        f. The previous node's next pointer is updated to point to the toMove node (prev.next = toMove).
        g. The toMove node's prev pointer is updated to point to the previous node (toMove.prev = prev).
    6. Finally, the head of the list is updated to the dummy node's next pointer, the head's prev is set to null, and
        the tail of the list is updated.
*/
