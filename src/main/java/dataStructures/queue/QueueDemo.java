package dataStructures.queue;

public class QueueDemo {

    public Node first;
    public Node last;
    public int length;

    /**
     * Constructor to create an empty queue.
     *
     * @param value - the first value to be added to the queue
     */
    public QueueDemo(int value) {
        Node node = new Node(value);
        first = node;
        last = node;
        length = 1;
    }

    public static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Method to enqueue an element from the queue.
     *
     * @param value - the value to be enqueued
     */
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (first == null) {
            first = newNode;
            last = newNode;
            return;
        }
        last.next = newNode;
        last = newNode;
        length++;
    }

    /**
     * Method to dequeue an element from the queue.
     */
    public void peek() {
        if (first == null) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("First Node : " + first.value);
    }

    /**
     * Method to check if the queue is empty.
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * Method to dequeue an element from the queue.
     *
     * @return - the dequeued node
     */
    public Node dequeue() {
        if (first == null) {
            System.out.println("Queue is empty");
            return null;
        }
        Node dequeuedNode = first;
        if (first == last) {
            first = null;
            last = null;
        } else {
            first = first.next;
            dequeuedNode.next = null;
        }
        length--;
        return dequeuedNode;
    }

    /**
     * Method to insert an element at the front of the queue.
     *
     * @param value - the value to be inserted
     */
    public void insertAtFront(int value) {
        Node newNode = new Node(value);
        if (first == null) {
            first = newNode;
            last = newNode;
            return;
        }
        newNode.next = first;
        first = newNode;
        length++;
    }

    /**
     * Method to delete an element from the rear of the queue.
     *
     * @return - the deleted node
     */
    public Node deleteAtRear() {
        if (first == null) {
            System.out.println("Queue is empty");
            return null;
        }
        Node nodeRemoved = first;
        Node previous = null;
        while (nodeRemoved.next != null) {
            previous = nodeRemoved;
            nodeRemoved = nodeRemoved.next;
        }
        if (previous != null) {
            previous.next = null;
            last = previous;
        } else {
            first = null;
            last = null;
        }
        length--;
        return nodeRemoved;
    }

    public static void main(String[] args) {
        QueueDemo queue = new QueueDemo(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.printQueue();

        System.out.println("Dequeued Node : " + queue.dequeue().value);
        queue.printQueue();

        queue.insertAtFront(0);
        queue.printQueue();

        System.out.println("Deleted Node at Rear : " + queue.deleteAtRear().value);
        queue.printQueue();
    }

    public void printQueue() {
        Node current = first;
        System.out.print("Queue : ");
        while (current.next != null) {
            System.out.print(current.value + " --- ");
            current = current.next;
        }
        System.out.print(current.value);
        System.out.println();
    }
}
