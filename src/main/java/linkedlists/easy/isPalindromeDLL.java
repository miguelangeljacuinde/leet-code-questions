package linkedlists.easy;

import dataStructures.linkedList.DoublyLinkedListDemo;

/*
    Write a method to determine if a doubly linked list is a palindrome (the list reads the same forward and backward).

    - Example 1:
        Sample Input: 1 <-> 2 <-> 3 <-> 2 <-> 1
        Sample Output: true

    - Example 2:
        Sample Input: 1 <-> 2 <-> 3 <-> 4 <-> 5
        Sample Output: false

    - Example 3:
        Sample Input: 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 4 <-> 3 <-> 2 <-> 1
        Sample Output: true

    - Example 4:
        Sample Input: []
        Sample Output: true

    - Constraints:
        The list can be empty.
        The list can contain up to 10^5 nodes.
        The values of the nodes can be any integer.
*/

public class isPalindromeDLL {

    /**
     * Method to determine if a doubly linked list is a palindrome
     *
     * @param dll - the head of the doubly linked list
     * @return - true if the list is a palindrome, false otherwise
     */
    public static boolean isPalindrome(DoublyLinkedListDemo dll) {
        if (dll == null || dll.head == null || dll.tail == null || dll.head == dll.tail) {
            return true;
        }

        DoublyLinkedListDemo.Node first = dll.head;
        DoublyLinkedListDemo.Node last = dll.tail;

        while (first != last) {
            if (first.value != last.value) {
                return false;
            }
            first = first.next;
            last = last.prev;
        }
        return true;
    }

    public static void main(String[] args) {
        DoublyLinkedListDemo dll = new DoublyLinkedListDemo();
        dll.createDoublyLinkedListDemo(1);
        dll.append(2);
        dll.append(3);
        dll.append(2);
        dll.append(1);
        System.out.print("DLL : ");
        printList(dll.head);
        System.out.println("Is Palindrome ? -> " + isPalindrome(dll));

        System.out.println();

        dll = new DoublyLinkedListDemo();
        dll.createDoublyLinkedListDemo(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);
        System.out.print("DLL : ");
        printList(dll.head);
        System.out.println("Is Palindrome ? -> " + isPalindrome(dll));

        System.out.println();

        dll = new DoublyLinkedListDemo();
        dll.createDoublyLinkedListDemo(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);
        dll.append(4);
        dll.append(3);
        dll.append(2);
        dll.append(1);
        System.out.print("DLL : ");
        printList(dll.head);
        System.out.println("Is Palindrome ? -> " + isPalindrome(dll));

        System.out.println();

        dll = new DoublyLinkedListDemo();
        System.out.print("DLL : ");
        printList(dll.head);
        System.out.println("Is Palindrome ? -> " + isPalindrome(dll));
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
    1. Traverse the list from both ends (head and tail) towards the center.
    2. Compare the values of the nodes at both ends.
        a.  If the values are not equal, return false.
        b.  If the values are equal, move to the next node from both ends.
    3. If the pointers meet or cross each other, return true (the list is a palindrome).
*/
