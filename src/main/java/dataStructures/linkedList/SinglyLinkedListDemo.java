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
     * Creates a singly linked list.
     *
     * @param nodeValue - the input node value
     * @return - Created node for singly linked list
     */
    public Node createSinglyLinkedList(int nodeValue) {
        Node node = new Node();
        node.value = nodeValue;
        node.next = null;

        head = node;
        tail = null;

        size++;

        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedListDemo linkedList = new SinglyLinkedListDemo();
        linkedList.createSinglyLinkedList(5);
        System.out.println(linkedList.head.value);
    }

}
