package linkedlists.easy;

import dataStructures.linkedList.DoublyLinkedListDemo;

/*
    Write a function that reverses a doubly linked list in place.

    - Example 1:
        Sample Input: 1 <-> 2 <-> 3 <-> 4 <-> 5
        Sample Output: 5 <-> 4 <-> 3 <-> 2 <-> 1

    - Example 2:
        Sample Input: 1 <-> 2
        Sample Output: 2 <-> 1

    - Example 3:
        Sample Input: 1
        Sample Output: 1

    - Example 4:
        Sample Input: []
        Sample Output: []

    - Constraints:
        The list can be empty.
        The list can contain up to 10^5 nodes.
        The values of the nodes can be any integer.
*/

public class ReverseDLL {

    /**
     * Reverses a doubly linked list in place.
     *
     * @param dll - the head of the doubly linked list
     */
    public static void reverse(DoublyLinkedListDemo dll) {
        if (dll == null || dll.head == null || dll.tail == null || dll.head == dll.tail) {
            return;
        }

        DoublyLinkedListDemo.Node first = dll.head;
        DoublyLinkedListDemo.Node last = dll.tail;

        while (first != last && first.prev != last) {
            int temp = first.value;
            first.value = last.value;
            last.value = temp;

            first = first.next;
            last = last.prev;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedListDemo dll = new DoublyLinkedListDemo();
        dll.createDoublyLinkedListDemo(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);
        System.out.print("DLL : ");
        printList(dll.head);
        reverse(dll);
        System.out.print("Reversed DLL : ");
        printList(dll.head);

        System.out.println();

        dll = new DoublyLinkedListDemo();
        dll.createDoublyLinkedListDemo(1);
        dll.append(2);
        System.out.print("DLL : ");
        printList(dll.head);
        reverse(dll);
        System.out.print("Reversed DLL : ");
        printList(dll.head);

        System.out.println();

        dll = new DoublyLinkedListDemo();
        dll.createDoublyLinkedListDemo(1);
        System.out.print("DLL : ");
        printList(dll.head);
        reverse(dll);
        System.out.print("Reversed DLL : ");
        printList(dll.head);

        System.out.println();

        dll = new DoublyLinkedListDemo();
        System.out.print("DLL : ");
        printList(dll.head);
        reverse(dll);
        System.out.print("Reversed DLL : ");
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
        n = number of nodes in the list
    1. Create a variable first and set it to the head of the list.
    2. Create a variable last and set it to the tail of the list.
    3. While first is not equal to last and the previous node of first is not equal to last:
        a. Swap the values of first and last using a temp variable
        b. Move first to the next node (first = first.next).
        c. Move last to the previous node (last = last.prev).
*/
