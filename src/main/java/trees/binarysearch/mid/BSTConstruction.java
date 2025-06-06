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

    public static class BST {

        private int value;
        private BST left;
        private BST right;

        public BST(int value) {
            this.value = value;
        }

        /**
         * Inserts a value into the BST.
         *
         * @param value - the value to be inserted
         * @return - the current node after insertion
         */
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

        /**
         * Checks if the BST contains a value.
         *
         * @param value - the value to be searched for
         * @return - true if the value is found, false otherwise
         */
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

        /**
         * Removes a value from the BST.
         *
         * @param value - the value to be removed
         * @return - the current node after removal
         */
        public BST remove(int value) {
            remove(value, null);
            return this;
        }

        /**
         * Helper method to remove a value from the BST.
         *
         * @param value      - the value to be removed
         * @param parentNode - the parent node of the current node
         */
        private void remove(int value, BST parentNode) {
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
                        }
                    } else if (parentNode.left == currentNode)
                        parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;
                    else if (parentNode.right == currentNode)
                        parentNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
                    break;
                }
            }
        }

        /**
         * Gets the minimum value in the BST.
         *
         * @return - the minimum value in the BST
         */
        private int getMinValue() {
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
    1. Grab current node and parent node.
    2. If value we are removing is less than the current node’s value,
        check if current node has a left child and recursively call remove method on left child
        (left child will now be the current node).
    3. Else if value we are removing is greater than the current node’s value,
        check if current node has a right child and recursively call remove method on right child
        (right child will now be the current node).
    4. Else the value we are removing is equal to the current node’s value, check :
        a. If current node has both left and right children, replace current node’s value with the minimum value
           from the right subtree, then recursively call remove method on the right child with the new value.
        b. If current node does not have a parent node (i.e., it is the root), check if it has a left or right child,
           and replace its value with that child’s value.
        c. If current node has a parent node, check if it is a left or right child of the parent and replace it with
           its left or right child (if it exists).
    5. If current node does not have any children, simply remove it by setting the parent's left or right child to null.
    6. If current node has only one child, replace it with that child.
    7. Return the current node (BST tree).
    8. If the current node is a single-node tree, do nothing.
    9. If the current node is null, do nothing.
    10. If the current node is the root, handle it separately to ensure the tree remains valid.
    11. If the current node has no children, simply remove it.
    12. If the current node has one child, replace it with that child.
    13. If the current node has two children, find the minimum value in the right subtree,
        replace the current node's value with that minimum value, and recursively remove that minimum value from the right subtree.
    14. If the current node is not found, do nothing.
*/