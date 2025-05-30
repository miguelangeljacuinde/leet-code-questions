package graphs.easy;

import java.util.ArrayList;
import java.util.List;

/*
    You're given a Node class that has the same name and an array of optional children nodes.
    When put together, nodes form an acyclic tree-like structure.

    Implement the depthFirstSearch method on the Node class, which takes in an empty array, traverses the tree using
    the Depth-First Search approach (specifically navigating the tree from left to right), stores all the nodes'
    names in the array, and returns it.

    Input:   graph =     A
                            /   |   \
                           B    C    D
                         /  \       /  \
                        E    F     G    H
                           /  \     \
                          I    J     K

    Output: ["A", "B", "E", "F", "I", "J", "C", "D", "G", "K", "H"]

*/
public class DepthFirstSearch {

    public static void main(String[] args) {
        System.out.println();
    }

    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        /**
         * @param array - the input array
         * @return - string using depth-first search
         */
        public List<String> depthFirstSearch(List<String> array) {
            array.add(name);
            for (Node child : children) {
                child.depthFirstSearch(array);
            }
            return array;
        }

        /**
         * @param name - the name of the current node's child
         * @return - this node
         */
        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

}

/*
    O(n) time | O(1) space
        n = number of nodes in a linked list
    1. Add the initial node's name.
    2. Traverse every child node of the current node.
        a. For each child node, traverse its children as well in a recursive manner.
    3. Return the final array sorted using depth-first search.
*/
