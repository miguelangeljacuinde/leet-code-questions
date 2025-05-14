package linkedlists.mid;

import dataStructures.linkedList.DoublyLinkedListDemo;

/*
    Write a function that partitions a doubly linked list around a value x, such that all nodes less than x come before
    nodes greater than or equal to x.

    - Example 1:
        Sample Input:
            x = 5,
            3 <-> 5 <-> 8 <-> 5 <-> 10 <-> 2 <-> 1
        Sample Output:
            3 <-> 2 <-> 1 <-> 5 <-> 8 <-> 5 <-> 10
        Explanation: The partition value is 5.
        The nodes less than 5 (3, 2, 1) come before the nodes greater than or equal.

    - Example 2:
        Sample Input:
            x = 3,
            1 <-> 4 <-> 2 <-> 5 <-> 3
        Sample Output:
            1 <-> 2 <-> 3 <-> 4 <-> 5
        Explanation: The partition value is 3.
        The nodes less than 3 (1, 2) come before the nodes greater than or equal.

    - Constraints:
        The list can be empty.
        The list can contain up to 10^5 nodes.
        The values of the nodes can be any integer.
*/

public class PartitionListDLL {

    /**
     * Partitions a doubly linked list around a value x.
     *
     * @param head - the head of the doubly linked list
     * @param x    - the partition value
     */
    public static void partition(DoublyLinkedListDemo.Node head, int x) {
        if (head == null) {
            return;
        }

        DoublyLinkedListDemo.Node dummy1 = new DoublyLinkedListDemo.Node(0);
        DoublyLinkedListDemo.Node dummy2 = new DoublyLinkedListDemo.Node(0);

        DoublyLinkedListDemo.Node prev1 = dummy1;
        DoublyLinkedListDemo.Node prev2 = dummy2;

        while (head != null) {
            if (head.value < x) {
                prev1.next = head;
                head.prev = prev1;
                prev1 = head;
            } else {
                prev2.next = head;
                head.prev = prev2;
                prev2 = head;
            }
            head = head.next;
        }

        prev1.next = dummy2.next;
        prev2.next = null;

        if (dummy2.next != null) {
            dummy2.next.prev = prev2;
        }

        head = dummy1.next;

        if (head != null) {
            head.prev = null;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedListDemo dll = new DoublyLinkedListDemo();
        dll.createDoublyLinkedListDemo(3);
        dll.append(5);
        dll.append(8);
        dll.append(5);
        dll.append(10);
        dll.append(2);
        dll.append(1);
        System.out.print("DLL : ");
        int x = 5;
        partition(dll.head, x);
        printList(dll.head);

        dll = new DoublyLinkedListDemo();
        dll.createDoublyLinkedListDemo(1);
        dll.append(4);
        dll.append(2);
        dll.append(5);
        dll.append(3);
        System.out.print("DLL : ");
        x = 3;
        partition(dll.head, x);
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
    O(n) time | O(1) space
        n = number of nodes in the list
    1. Create two dummy nodes to hold the two partitions.
    2. Initialize two pointers, prev1 and prev2, to the dummy nodes.
    3. Traverse the list and for each node:
        a. If the node's value is less than x, add it to the first partition.
            i. Set prev1's next pointer to the current node.
            ii. Set the current node's prev pointer to prev1.
            iii. Move prev1 to the current node.
        b. Otherwise, add it to the second partition.
            i. Set prev2's next pointer to the current node.
            ii. Set the current node's prev pointer to prev2.
            iii. Move prev2 to the current node.
    4. Connect the two partitions (prev1's next pointer should point to the first actual node in dummy2 partition).
    5. Set the next pointer of the last node in the second partition to null (prev2's next pointer should point to null).
    6. If dummy2's next pointer is not null, set its prev pointer to prev2.
    7. Set the head to the first node in the first partition (dummy1's next pointer).
    8. If head is not null, set the prev pointer of the head to null.
*/