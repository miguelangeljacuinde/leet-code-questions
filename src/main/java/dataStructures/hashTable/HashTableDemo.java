package dataStructures.hashTable;

import java.util.ArrayList;

public class HashTableDemo {

    private final int size = 17;

    private final Node[] table;

    public HashTableDemo() {
        table = new Node[size];
    }

    /**
     * The Node class represents a single entry in the hash table.
     */
    public static class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

    }

    /**
     * This hash method computes the hash value for a given key.
     *
     * @param key - the key for which the hash value is to be computed
     */
    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int asciiValue : keyChars) {
            hash = (hash + asciiValue * 23) % size;
        }
        return hash;
    }

    /**
     * This method sets a key-value pair in the hash table.
     *
     * @param key   - the key to be set in the hash table
     * @param value - the value to be associated with the key
     */
    public void put(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node current = table[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    /**
     * This method retrieves the value associated with a given key from the hash table.
     *
     * @param key - the key for which the value is to be retrieved
     * @return - the value associated with the key, or -1 if the key does not exist
     */
    public int get(String key) {
        int index = hash(key);
        Node current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }

    /**
     * This method retrieves all keys from the hash table.
     *
     * @return - an ArrayList containing all keys in the hash table
     */
    public ArrayList<String> getKeys() {
        ArrayList<String> keys = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Node current = table[i];
            while (current != null) {
                keys.add(current.key);
                current = current.next;
            }
        }
        return keys;
    }

    public static void main(String[] args) {
        HashTableDemo hashTable = new HashTableDemo();
        hashTable.put("apple", 3);
        hashTable.put("banana", 12);
        hashTable.put("orange", 5);
        hashTable.put("grape", 3);
        hashTable.put("kiwi", 15);
        hashTable.put("melon", 2);
        hashTable.put("peach", 10);
        hashTable.put("watermelon", 11);

        System.out.println("Value for 'banana': " + hashTable.get("banana"));
        System.out.println("Value for 'kiwi': " + hashTable.get("kiwi"));
        System.out.println("Value for 'pear': " + hashTable.get("pear"));

        System.out.println("\nHash Table Contents:");
        hashTable.printTable();

        ArrayList<String> keys = hashTable.getKeys();
        hashTable.printKeys(keys);
    }

    /**
     * Prints the contents of the hash table.
     */
    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            Node current = table[i];
            while (current != null) {
                System.out.print("{" + current.key + ": " + current.value + "} -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    /**
     * Prints the keys in the hash table.
     *
     * @param keys - the ArrayList containing keys to be printed
     */
    public void printKeys(ArrayList<String> keys) {
        System.out.print("\nKeys in the hash table : ");
        for (int i = 0; i < keys.size(); i++) {
            if (i != keys.size() - 1) {
                System.out.print(keys.get(i) + ", ");
            } else {
                System.out.print(table[i]);
            }
        }
        System.out.println();
    }

}
