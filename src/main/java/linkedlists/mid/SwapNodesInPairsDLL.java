package linkedlists.mid;

import dataStructures.linkedList.DoublyLinkedListDemo;

/*
    Given a doubly linked list, swap every two adjacent nodes and return its head. You must solve the problem without
    modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

    - Example 1:
        Sample Input: head = [1,2,3,4]
        Sample Output: [2,1,4,3]

    - Example 2:
        Sample Input: head = []
        Sample Output: []

    - Example 3:
        Sample Input: head = [1]
        Sample Output: [1]

    - Example 4:
        Sample Input: head = [1,2,3]
        Sample Output: [2,1,3]

    - Constraints:
        The number of nodes in the list is in the range [0, 100].
        0 <= Node.val <= 100
*/

public class SwapNodesInPairsDLL {

    /**
     * Swaps every two adjacent nodes in the doubly linked list.
     *
     * @param dll - the doubly linked list to swap nodes in
     */
    public static void swapNodes(DoublyLinkedListDemo dll) {
        if (dll.head == null || dll.head.next == null) {
            return;
        }

        DoublyLinkedListDemo.Node dummy = new DoublyLinkedListDemo.Node(0);
        dummy.next = dll.head;
        DoublyLinkedListDemo.Node prev = dummy;

        while (dll.head != null && dll.head.next != null) {
            DoublyLinkedListDemo.Node first = dll.head;
            DoublyLinkedListDemo.Node second = first.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;

            if (first.next != null) {
                first.next.prev = first;
            }

            first.prev = second;
            second.prev = prev;

            dll.head = first.next;
            prev = first;
        }

        dll.head = dummy.next;
        dll.head.prev = null;
    }

    public static void main(String[] args) {
        DoublyLinkedListDemo dll = new DoublyLinkedListDemo();
        dll.createDoublyLinkedListDemo(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        printList(dll.head);
        swapNodes(dll);
        printList(dll.head);

        dll = new DoublyLinkedListDemo();
        printList(dll.head);
        swapNodes(dll);
        printList(dll.head);

        dll = new DoublyLinkedListDemo();
        dll.createDoublyLinkedListDemo(1);
        printList(dll.head);
        swapNodes(dll);
        printList(dll.head);

        dll = new DoublyLinkedListDemo();
        dll.createDoublyLinkedListDemo(1);
        dll.append(2);
        dll.append(3);
        printList(dll.head);
        swapNodes(dll);
        printList(dll.head);
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
    O(n) time | O(1) space:
        n = number of nodes in the list.
    1. Create a dummy node to simplify the swapping process.
    2. Initialize a pointer to the previous node (prev) as the dummy node.
    3. While the current node and the next node are not null:
        a. Initialize two pointers (first and second) to the current node and the next node.
        b. Swap the first and second nodes of the pair.
        c. Update the pointers accordingly.
            i. Set the next pointer of the first node to the second node's next pointer.
            ii. Set the next pointer of the second node to the first node.
            iii. Set the next pointer of the previous node to the second node.
            iv. If the first node's next pointer is not null, update its previous node to the first node.
            v. Set the previous node of the first node to the second node.
            vi. Set the previous node of the second node to the previous node.
            vii. Set the head of the list to the first node's next pointer.
    4. Update the head of the list to the new first node (dummy.next).
*/