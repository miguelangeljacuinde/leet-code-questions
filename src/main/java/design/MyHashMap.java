package design;

import java.util.Arrays;

public class MyHashMap {

    private static final int SIZE = 1000;
    private final Node[] table = new Node[SIZE];

    /**
     * Node class represents a single entry in the hash map.
     * It contains the key, value, and a reference to the next node in case of collisions.
     */
    private static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    /**
     * Constructor initializes the hash map with an empty table.
     * Each entry in the table is set to null initially.
     */
    public MyHashMap() {
        Arrays.fill(table, null);
    }

    /**
     * Puts a key-value pair into the hash map.
     * If the key already exists, it updates the value.
     * If the key does not exist, it adds a new node to the appropriate index.
     *
     * @param key   the key to be added or updated
     * @param value the value associated with the key
     */
    public void put(int key, int value) {
        int index = key % SIZE;
        Node current = table[index];

        if (current == null) {
            table[index] = new Node(key, value);
            return;
        }

        while (true) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            if (current.next == null) {
                break;
            }
            current = current.next;
        }

        current.next = new Node(key, value);
    }

    /**
     * Retrieves the value associated with the given key.
     * If the key does not exist, it returns -1.
     *
     * @param key the key whose value is to be retrieved
     * @return the value associated with the key, or -1 if the key does not exist
     */
    public int get(int key) {
        int index = key % SIZE;
        Node current = table[index];

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }

    /**
     * Removes the key-value pair associated with the given key.
     * If the key does not exist, it does nothing.
     *
     * @param key the key to be removed
     */
    public void remove(int key) {
        int index = key % SIZE;
        Node current = table[index];
        Node previous = null;

        while (current != null) {
            if (current.key == key) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }

}

/*
    1. Initialize a size constant for the hash map.
    2. Create a Node class to represent each entry in the hash map.
        a. Each Node contains a key, value, and a reference to the next Node for collision handling.
    3. Create an array of Nodes to serve as the hash table.
    4. Implement the constructor to initialize the hash table with null values.

    Put Method:
    1. Calculate the index for the key using modulo operation with the size.
    2. Check if the index in the table is null.
        a. If it is, create a new Node and assign it to that index.
        b. If it is not null, traverse the linked list at that index.
            i. If the key already exists, update its value.
            ii. Else if the current.next is null break out of the loop.
            iii. Else, continue traversing.
    3. If key does not exist, add a new Node at the end of the linked list.

    Get Method:
    1. Calculate the index for the key using modulo operation with the size.
    2. Traverse the linked list at that index.
        a. If the key is found, return its value.
        b. If the end of the list is reached without finding the key, return -1.

    Remove Method:
    1. Calculate the index for the key using modulo operation with the size.
    2. Initialize two pointers: current and previous.
        a. Current points to the head of the linked list at that index.
        b. Previous is initialized to null.
    3. Traverse the linked list at that index.
        a. If the key is found:
            i. If the key is at the head (previous is null), set the head to current.next.
            ii. Else, the key is somewhere in-between or at the end; set previous.next to current.next
                (skipping current).
        b. If the key is not found, do nothing.
*/