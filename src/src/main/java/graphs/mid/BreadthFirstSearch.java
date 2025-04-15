package graphs.mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    You're given a Node class that has a name and an array of optional children nodes. When we put together, nodes form
    an acyclic tree-like structure.

    Implement breadthFirstSearch method on the Node class, which takes in an empty array, traverses the tree using the
    Breadth-First Search approach (specifically navigating the tree from left to right), stores all the nodes' names
    in the input array, and returns it.

    Sample Input:   graph =     A
                            /   |   \
                           B    C    D
                         /  \       /  \
                        E    F     G    H
                           /  \     \
                          I    J     K

    Sample Output: ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"]
*/

public class BreadthFirstSearch {
    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        /**
         * @param array - the input array
         * @return - the array with nodes sorted using breadth-first search
         */
        public List<String> breadthFirstSearch(List<String> array) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(this);
            while (!queue.isEmpty()) {
                Node currentNode = queue.poll();
                array.add(currentNode.name);
                queue.addAll(currentNode.children);
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }

//        public static void main(String[] args) {
//            Node treeA = new Node("A");
//            List<String> array = new LinkedList<>();
//            array.add("B");
//            array.add("C");
//            array.add("D");
//            System.out.println(treeA.breadthFirstSearch(array));
//        }
    }
}

/*
    1. Initialize a queue and add the tree to the queue.
    2. While the queue is not empty, traverse it.
    3. Initialize a current node by polling the first node.
    4. Add the current node's name to the final array, and then add all of its children to the queue.
    5. Once done traversing entire tree, return the final array sorted using breadth-first search.
*/
