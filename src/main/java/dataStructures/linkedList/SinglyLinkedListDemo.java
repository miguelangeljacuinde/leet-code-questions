package dataStructures.linkedList;

public class SinglyLinkedListDemo {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
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
        Node node = new Node(nodeValue);
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
        Node newNode = new Node(nodeValue);

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

    /**
     * Deletes entire Linked List.
     */
    public void deleteLinkedList() {
        head = null;
        tail = null;
        size = 0;
        System.out.println("Deleted Linked List successfully!");
    }

    /**
     * Pushes given value to the end of list.
     *
     * @param newValue - the new value to push into the end of the list.
     */
    public void push(int newValue) {
        Node newNode = new Node(newValue);

        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    /**
     * Removes the last node from the Linked List.
     */
    public void pop() {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        size--;
    }

    /**
     * Gets the Node at the given index.
     *
     * @param index - the input index
     * @return - Node at given index
     */
    public Node get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * Sets a given value at a given index.
     *
     * @param index - the index to set the new Node
     * @param value - the value we are inserting
     * @return - true if successfully sets the new value at given index
     */
    public boolean set(int index, int value) {
        if (head == null) {
            return false;
        } else if (index < 0 || index > size) {
            return false;
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
                if (current == null) {
                    return false;
                }
            }
            current.value = value;
        }
        return true;
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

        linkedList.push(10);
        linkedList.push(11);
        linkedList.push(12);
        printList(linkedList.head);
        linkedList.pop();
        printList(linkedList.head);

        System.out.println(linkedList.get(0).value);
        System.out.println(linkedList.get(1).value);
        linkedList.deleteLinkedList();

        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);
        printList(linkedList.head);
        linkedList.set(1, 10);
        printList(linkedList.head);

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
