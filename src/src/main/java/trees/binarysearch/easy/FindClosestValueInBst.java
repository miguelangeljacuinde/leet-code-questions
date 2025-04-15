package trees.binarysearch.easy;

/*
    Write a function that takes in a BST and a target integer value and returns the closest value to that target value
    contained in the BST.

    You can assume that there will only be one closest value.

    Each BST node has an integer value, a left child node, and a right child node. A node is said to be a valid BST
    node if and only if it satisfies the BST property: its value is strictly greater than tha values of every node to
    its left; its value is less than or equal to the value of every node to its right; and its children nodes are
    either valid BST nodes themselves or None/null.

    Sample Input: tree =         10
                               /    \
                             5       15
                           /  \     /   \
                          2    5  13    22
                        /           \
                       1             14
    target = 12

    Sample Output: 13
 */

public class FindClosestValueInBst {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BST tree = new BST(10);
        tree.left = new BST(5);
        tree.left.left = new BST(2);
        tree.left.left.left = new BST(1);
        tree.left.right = new BST(5);
        tree.right = new BST(15);
        tree.right.left = new BST(13);
        tree.right.left.right = new BST(14);
        tree.right.right = new BST(22);
        int target1 = 12;

        BST edgeCase1 = new BST(10);
        int target2 = 22;

        BST edgeCase2 = new BST(90);
        edgeCase2.right = new BST(92);
        edgeCase2.right.left = new BST(91);
        edgeCase2.right.right = new BST(93);
        edgeCase2.right.right.right = new BST(94);
        edgeCase2.right.right.right.right = new BST(95);
        int target3 = 100;

        System.out.println(findClosestValueInBst(tree, target1));
        System.out.println(findClosestValueInBst(edgeCase1, target2));
        System.out.println(findClosestValueInBst(edgeCase2, target3));
    }


    /**
     * @param node   - the initial tree node
     * @param target - the target
     * @return - closets value as int
     */
    public static int findClosestValueInBst(BST node, int target) {
        BST currentNode = node;
        int closestValue = currentNode.value;

        while (currentNode != null) {
            if (Math.abs(target - closestValue) > Math.abs(target - currentNode.value)) {
                closestValue = currentNode.value;
            }
            if (target < currentNode.value) {
                currentNode = currentNode.left;
            } else if (target > currentNode.value) {
                currentNode = currentNode.right;
            } else {
                break;
            }
        }
        return closestValue;
    }
}

/*
    Average : O(log(n)) time | O(1) space
    Worst: O(n) time | O(1) space
        n = number of nodes in tree
    1. Initiate a BST tree node and get the default closest value.
    2. Traverse the tree starting at the initial current node; checking it's not null.
    3. We need to keep track of the closest value by checking the absolute difference between the target and the
        closest value against the target and current node's value.
    4. Continue traversing the tree.
        a. If target is less than the current node's value, go left.
        b. Else if the target is greater than the current node's value, go right.
        c. Else, you have hit the target. Exit the loop.
    5. Return the closest value.
*/