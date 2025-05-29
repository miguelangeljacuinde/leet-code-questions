package dataStructures.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTreeDemo {

    private Node root;

    /**
     * This class represents a binary tree node.
     */
    public static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    /**
     * This method inserts a new value into the binary search tree.
     *
     * @param value - the value to be inserted into the tree
     * @return - true if the insertion is successful, false otherwise
     */
    public boolean insertRec(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            System.out.println("Inserted " + newNode.value + " as root node.");
            return true;
        } else {
            return insertRec(root, newNode);
        }
    }

    /**
     * This method inserts a new node into the binary search tree.
     *
     * @param current - the current node in the tree
     * @param newNode - the new node to be inserted
     * @return - true if the insertion is successful, false otherwise
     */
    public boolean insertRec(Node current, Node newNode) {
        if (current.value == newNode.value) {
            System.out.println("Value already exists in the tree: " + newNode.value);
            return false;
        }
        if (newNode.value < current.value) {
            if (current.left == null) {
                current.left = newNode;
                System.out.println("Inserted " + newNode.value + " to the left of " + current.value);
                return true;
            } else {
                return insertRec(current.left, newNode);
            }
        } else {
            if (current.right == null) {
                current.right = newNode;
                System.out.println("Inserted " + newNode.value + " to the right of " + current.value);
                return true;
            } else {
                return insertRec(current.right, newNode);
            }
        }
    }

    /**
     * This method inserts a new value into the binary search tree using an iterative approach.
     *
     * @param value - the value to be inserted into the tree
     * @return - true if the insertion is successful, false otherwise
     */
    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node current = root;
        while (true) {
            if (value == current.value) {
                System.out.println("Value already exists in the tree: " + value);
                return false;
            }
            if (value < current.value) {
                if (current.left == null) {
                    current.left = newNode;
                    return true;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    return true;
                }
                current = current.right;
            }
        }
    }

    /**
     * This method checks if a value exists in the binary search tree.
     *
     * @param value - the value to be searched in the tree
     * @return - true if the value exists, false otherwise
     */
    public boolean containsRec(int value) {
        if (root == null) {
            return false;
        } else {
            return containsRec(root, value);
        }
    }

    /**
     * This method checks if a value exists in the binary search tree starting from the current node.
     *
     * @param current - the current node in the tree
     * @param value   - the value to be searched
     * @return - true if the value exists, false otherwise
     */
    public boolean containsRec(Node current, int value) {
        if (value < current.left.value) {
            return containsRec(current.left, value);
        } else if (value > current.right.value) {
            return containsRec(current.right, value);
        } else if (value == current.value) {
            System.out.println("Value " + value + " found in the tree.");
            return true;
        } else {
            System.out.println("Value " + value + " not found in the tree.");
            return false;
        }
    }

    /**
     * This method checks if a value exists in the binary search tree using an iterative approach.
     *
     * @param value - the value to be searched in the tree
     * @return - true if the value exists, false otherwise
     */
    public boolean contains(int value) {
        Node current = root;
        while (current != null) {
            if (value < current.value) {
                current = current.left;
            } else if (value > current.value) {
                current = current.right;
            } else {
                System.out.println("Value " + value + " found in the tree.");
                return true;
            }
        }
        System.out.println("Value " + value + " not found in the tree.");
        return false;
    }

    public static void main(String[] args) {
        BinarySearchTreeDemo treeDemo = new BinarySearchTreeDemo();

        treeDemo.insertRec(10);
        treeDemo.insertRec(4);
        treeDemo.insertRec(2);
        treeDemo.insertRec(5);
        treeDemo.insertRec(12);
        treeDemo.insertRec(11);
        treeDemo.insertRec(15);
        treeDemo.insertRec(14);
        treeDemo.insertRec(3);
        treeDemo.insertRec(16);

        printTree(treeDemo.root);

        treeDemo.containsRec(10);
        treeDemo.containsRec(6);
    }

    /**
     * This method prints the binary tree in a structured format.
     *
     * @param root - the root node of the binary tree
     */
    public static void printTree(Node root) {
        int maxLevel = maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    /**
     * This method prints the binary tree in a structured format.
     *
     * @param nodes    - the list of nodes to be printed
     * @param level    - the current level in the tree
     * @param maxLevel - the maximum level of the tree
     */
    private static void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes)) {
            return;
        }

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
        int firstSpaces = (int) Math.pow(2, floor) - 1;
        int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

        printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.value);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }
            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= edgeLines; i++) {
            for (Node node : nodes) {
                printWhitespaces(firstSpaces - i);
                if (node == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (node.left != null) {
                    System.out.print("/");
                } else {
                    printWhitespaces(1);
                }

                printWhitespaces(i + i - 1);

                if (node.right != null) {
                    System.out.print("\\");
                } else {
                    printWhitespaces(1);
                }
                printWhitespaces(edgeLines + edgeLines - i);
            }
            System.out.println();
        }
        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    /**
     * This method prints the specified number of whitespaces.
     *
     * @param count - the number of whitespaces to print
     */
    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    /**
     * This method calculates the maximum level of the binary tree.
     *
     * @param node - the root node of the tree
     * @return - the maximum level of the tree
     */
    private static int maxLevel(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    /**
     * This method checks if all elements in the list are null.
     *
     * @param list - the input list of nodes
     * @return - true if all elements are null, false otherwise
     */
    private static boolean isAllElementsNull(List<Node> list) {
        for (Object object : list) {
            if (object != null) {
                return false;
            }
        }
        return true;
    }

}
