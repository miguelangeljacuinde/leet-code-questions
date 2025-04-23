package dataStructures.linkedList;

public class SinglyLinkedListDemo {

    public static class Node {
        public int value;
        public Node next;
    }

    public Node head;
    public Node tail;
    public int size;

    /**
     * Creates a Singly Linked List.
     *
     * @param nodeValue - the input node value
     * @return - created node for singly linked list
     */
    public Node createLinkedList(int nodeValue) {
        Node node = new Node();
        node.value = nodeValue;
        node.next = null;

        head = node;
        tail = node;

        size++;

        return head;
    }

    /**
     * Inserts new value in Linked List.
     *
     * @param nodeValue - the node's value
     * @param index     - the index of newly created value
     */
    public void insertInLinkedList(int nodeValue, int index) {
        Node newNode = new Node();
        newNode.value = nodeValue;

        if (head == null) { // Case 1: List is empty
            createLinkedList(nodeValue);
            return;
        }
        if (index == 0) { // Case 2: Insert at the beginning
            newNode.next = head;
            head = newNode;
        } else if (index >= size) {  // Insert at the end
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
        } else {    // Insert in the middle
            Node current = head;
            for (int i = 0; i < index - 1; i++) {   // stop right before the index we want to insert at
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    /**
     * Traverses and prints every node value in Linked List.
     */
    public void traverseLinkedList() {
        if (head == null) {
            System.out.println("Singly Linked List does not exist!");
            return;
        }
        Node current = head;
        for (int i = 0; i < size; i++) {
            assert current != null;
            System.out.print(current.value);
            if (i != size - 1) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    /**
     * Searches for the given node value within the Linked List.
     *
     * @param valueToSearch - the node value to search for within the linked list
     */
    public boolean searchInLinkedList(int valueToSearch) {
        while (head != null) {
            Node current = head;
            for (int i = 0; i < size; i++) {
                if (current.value == valueToSearch) {
                    System.out.println("Found the value " + valueToSearch + " at index : " + i);
                    return true;
                }
                current = current.next;
            }
        }
        System.out.println("Value was not found in linked list...");
        return false;
    }

    /**
     * Deletes a given value from a Linked List.
     *
     * @param index - the index to be removed from the linked list
     */
    public void deleteNodeInLinkedList(int index) {
        if (head == null) {
            System.out.println("Linked List does not exist.");
            return;
        } else if (index < 0 || index >= size) {
            System.out.println("Index out of bounds.");
            return;
        }

        if (index == 0) {   // Delete the head node
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
            return;
        }
        // Traverse to the node just before the one to be deleted
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        // Delete the target node
        Node nodeToDelete = current.next;
        current.next = nodeToDelete.next;
        size--;
        if (current.next == null) { // If we deleted the last node, update tail
            tail = current;
        }
    }

    public void deleteLinkedList() {
        head = null;
        tail = null;
        System.out.println("Deleted Linked List successfully!");
    }

    public static void main(String[] args) {
        SinglyLinkedListDemo linkedList = new SinglyLinkedListDemo();

        linkedList.createLinkedList(1);
        printList(linkedList.head);

        linkedList.insertInLinkedList(2, 1);
        printList(linkedList.head);

        linkedList.insertInLinkedList(3, 2);
        printList(linkedList.head);

        linkedList.insertInLinkedList(4, 3);
        printList(linkedList.head);

        linkedList.insertInLinkedList(0, 0);
        printList(linkedList.head);

        System.out.print("Traversing LinkedList : ");
        linkedList.traverseLinkedList();

        if (linkedList.searchInLinkedList(3)) {
            System.out.println("Node value was found!");
        }

        linkedList.insertInLinkedList(5, 5);
        linkedList.insertInLinkedList(6, 6);
        linkedList.insertInLinkedList(7, 7);

        linkedList.deleteNodeInLinkedList(0);
        printList(linkedList.head);
        linkedList.deleteNodeInLinkedList(6);
        printList(linkedList.head);
        linkedList.deleteNodeInLinkedList(3);
        printList(linkedList.head);

        linkedList.deleteLinkedList();
        System.out.print("Linked List : ");
        printList(linkedList.head);
        linkedList.traverseLinkedList();
    }

    /**
     * Prints evey node in the list
     *
     * @param head - the current node to start traversing
     */
    public static void printList(Node head) {
        Node current = head;
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
