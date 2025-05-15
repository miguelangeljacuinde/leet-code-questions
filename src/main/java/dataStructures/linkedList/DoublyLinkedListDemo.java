package dataStructures.linkedList;

public class DoublyLinkedListDemo {

    public Node head;
    public Node tail;
    public int size;

    /*
     * Doubly Linked List Node
     */
    public static class Node {
        public int value;
        public Node next;
        public Node prev;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * Creates a Doubly Linked List.
     *
     * @param value - the input node value
     * @return - created node for doubly linked list
     */
    public Node createDoublyLinkedListDemo(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        size = 1;
        return head;
    }

    /**
     * Inserts new value in Linked List.
     *
     * @param value - the value of the node to append
     */
    public void append(int value) {
        if (head == null) {
            createDoublyLinkedListDemo(value);
        } else {
            Node newNode = new Node(value);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }
    }

    /**
     * Prepends new value in Linked List.
     *
     * @param value - the value of the node to prepend
     */
    public void prepend(int value) {
        if (head == null) {
            createDoublyLinkedListDemo(value);
        } else {
            Node newNode = new Node(value);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
        }
    }

    /**
     * Removes the last value in Linked List.
     */
    public Node removeLast() {
        Node nodeRemoved;
        if (head == null) {
            return null;
        } else if (head == tail) {
            nodeRemoved = head;
            head = null;
            tail = null;
        } else {
            nodeRemoved = tail;
            tail = tail.prev;
            tail.next = null;
            nodeRemoved.prev = null;
        }
        size--;
        return nodeRemoved;
    }

    /**
     * Removes the first value in Linked List.
     */
    public Node removeFirst() {
        Node nodeRemoved = head;
        if (head == null) {
            return null;
        } else if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            nodeRemoved.next = null;
        }
        size--;
        return nodeRemoved;
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
        if (index < size / 2) {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    /**
     * Sets the value of the node at the given index.
     *
     * @param index - the input index
     * @param value - the new value to set
     */
    public boolean set(int index, int value) {
        if (index < 0 || index >= size) {
            return false;
        }
        Node current = get(index);
        current.value = value;
        return true;
    }

    /**
     * Creates a new node with the given value.
     *
     * @param index - the index at which to insert the new node
     * @param value - the value of the new node
     * @return - the new node
     */
    public boolean insert(int index, int value) {
        if (index < 0 || index > size) {
            return false;
        }
        if (index == 0) {
            prepend(value);
        } else if (index == size) {
            append(value);
        } else {
            Node newNode = new Node(value);
            Node current = get(index);

            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
        return true;
    }

    /**
     * Removes the node at the given index.
     *
     * @param index - the index of the node to remove
     * @return - true if the node was removed, false otherwise
     */
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node current = get(index);
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current.next = null;
            current.prev = null;
            size--;
        }
        return true;
    }

    public static void main(String[] args) {
        DoublyLinkedListDemo linkedList = new DoublyLinkedListDemo();

        linkedList.createDoublyLinkedListDemo(1);
        printList(linkedList.head);

        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        printList(linkedList.head);

        System.out.println("Removed node : " + linkedList.removeLast().value);
        printList(linkedList.head);

        linkedList.prepend(0);
        printList(linkedList.head);

        System.out.println("Removed head node : " + linkedList.removeFirst().value);
        printList(linkedList.head);

        System.out.println("Node at index 0 : " + linkedList.get(0).value);
        System.out.println("Node at index 1 : " + linkedList.get(1).value);
        System.out.println("Node at index 2 : " + linkedList.get(2).value);
        System.out.println("Node at index 3 : " + linkedList.get(3).value);

        linkedList.set(0, 10);
        linkedList.set(1, 20);
        linkedList.set(2, 30);
        linkedList.set(3, 40);
        printList(linkedList.head);

        linkedList.insert(0, 0);
        printList(linkedList.head);
        linkedList.insert(5, 50);
        printList(linkedList.head);

        linkedList.remove(0);
        printList(linkedList.head);
        linkedList.remove(1);
        printList(linkedList.head);
        linkedList.remove(2);
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
