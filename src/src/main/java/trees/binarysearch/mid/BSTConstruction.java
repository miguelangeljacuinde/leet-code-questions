package trees.binarysearch.mid;

/*
    Write a BST class for a Binary Search Tree. The class should support:
        - Inserting values with the insert method.
        - Removing values with the remove method; this method should only remove the first instance of a given value.
        - Searching for values with the contain method.

    Note: you cannot remove values from a single-node tree. In other words, calling remove method on a single-node tree
    should simply not do anything.

    Each BST node has an integer value, a left child node, and a right child node. A node is said to be a valid BST node
    if and only if it satisfies the BST property: its value is strictly greater than the values of every node to its
    left; its value is strictly less than or equal to the values of every node to its right; and its children nodes are
    either valid BST nodes themselves or None/null.
*/

public class BSTConstruction {

    public class BST {

        private int value;
        private BST left;
        private BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            BST currentNode = this;
            while (true) {
                if (value < currentNode.value) {
                    if (currentNode.left == null) {
                        currentNode.left = new BST(value);
                        break;
                    } else
                        currentNode = currentNode.left;
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = new BST(value);
                        break;
                    } else
                        currentNode = currentNode.right;
                }
            }
            return currentNode;
        }

        public boolean contains(int value) {
            BST currentNode = this;
            while (currentNode != null) {
                if (value < currentNode.value) {
                    currentNode = currentNode.left;
                } else if (value > currentNode.value) {
                    currentNode = currentNode.right;
                } else {
                    return true;
                }
            }
            return false;
        }

        public BST remove(int value) {
            remove(value, null);
            return this;
        }

        public void remove(int value, BST parentNode) {
            BST currentNode = this;
            while (currentNode != null) {
                if (value < currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.left;
                } else if (value > currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.right;
                } else {
                    if (currentNode.left != null && currentNode.right != null) {
                        currentNode.value = currentNode.right.getMinValue();
                        currentNode.right.remove(currentNode.value, currentNode);
                    } else if (parentNode == null) {
                        if (currentNode.left != null) {
                            currentNode.value = currentNode.left.value;
                            currentNode.right = currentNode.left.right;
                            currentNode.left = currentNode.left.left;
                        } else if (currentNode.right != null) {
                            currentNode.value = currentNode.right.value;
                            currentNode.left = currentNode.right.left;
                            currentNode.right = currentNode.right.right;
                        } else {
                            // do nothing; empty tree
                        }
                    } else if (parentNode.left == currentNode)
                        parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;
                    else if (parentNode.right == currentNode)
                        parentNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
                    break;
                }
            }
        }

        public int getMinValue() {
            if (left == null) {
                return value;
            } else {
                return left.getMinValue();
            }
        }

    }
}

/*
    Insertion:
    1. Grab current node.
    2. If value we are inserting is less than the current node’s value, check :
        a. If current node does not have a left child, create new BST node here.
        b. Else, recursively call insert method on this left child with the value we are trying to insert.
    3. Else, value we are inserting is greater than or equal to current node’s value, check :
        a. If current node does not have a right child, create new BST node here.
        b. Else, recursively call insert method on this right child with the value we are trying to insert.
    4. Return current node (BST tree).

    Contains:
    1. Grab current node.
    2. If the value we are searching for is less than the current node’s value,
        check if current node has a left child and recursively call contains method on left child
        (left child will now be the current node).
    3. Else if the value we are searching for is greater than the current node’s value,
        check if current node has a right child and recursively call contains method on right child
        (right child will now be the current node).
    4. Else the value we are searching for is equal to the current node’s value.

    Removal:
    1.

*/