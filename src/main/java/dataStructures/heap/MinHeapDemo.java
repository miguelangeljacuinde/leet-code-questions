package dataStructures.heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeapDemo {

    private final List<Integer> heap;

    public MinHeapDemo() {
        this.heap = new ArrayList<>();
    }

    /**
     * Gets the left child index of a given index in the heap.
     *
     * @param index - the index of the parent node
     */
    private int leftChild(int index) {
        return 2 * index + 1; // Assuming the root is at index 0
        // return 2 * index; // If using 1-based indexing
    }

    /**
     * Gets the parent index of a given index in the heap.
     *
     * @param index - the index of the current child node
     */
    private int parent(int index) {
        return (index - 1) / 2; // Assuming the root is at index 0
        // return index / 2; // If using 1-based indexing
    }

    /**
     * Gets the right child index of a given index in the heap.
     *
     * @param index - the index of the parent node
     */
    private int rightChild(int index) {
        return 2 * index + 2; // Assuming the root is at index 0
        // return 2 * index + 1; // If using 1-based indexing
    }

    /**
     * Swaps two elements in the heap at the specified indices.
     *
     * @param index1 - the index of the first element
     * @param index2 - the index of the second element
     */
    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    /**
     * Inserts a new value into the max-heap.
     * The new value is added at the end of the heap and then "bubbled up" to maintain the max-heap property.
     *
     * @param value - the value to be inserted into the heap
     */
    public void insert(int value) {
        heap.add(value);
        int currentIndex = heap.size() - 1;

        while (currentIndex >= 0 && heap.get(currentIndex) < heap.get(parent(currentIndex))) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

    /**
     * Removes the maximum element (the root) from the heap and returns it.
     * If the heap is empty, returns null.
     *
     * @return the maximum element or null if the heap is empty
     */
    public Integer remove() {
        if (heap.isEmpty()) {
            return null;
        }
        if (heap.size() == 1) {
            return heap.remove(0);
        } else {
            int minValue = heap.get(0);
            heap.set(0, heap.remove(heap.size() - 1));
            sinkDown(0);
            return minValue;
        }
    }

    /**
     * Sinks down the element at the specified index to maintain the max-heap property.
     *
     * @param index - the index of the element to sink down
     */
    private void sinkDown(int index) {
        int minIndex = index;

        while (true) {
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);

            if (leftIndex < heap.size() && heap.get(leftIndex) < heap.get(minIndex)) {
                minIndex = leftIndex;
            }
            if (rightIndex < heap.size() && heap.get(rightIndex) < heap.get(minIndex)) {
                minIndex = rightIndex;
            }
            if (minIndex != index) {
                swap(index, minIndex);
                index = minIndex;
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        MinHeapDemo heap = new MinHeapDemo();

        heap.insert(95);
        heap.insert(75);
        heap.insert(80);
        heap.insert(55);
        heap.insert(60);
        heap.insert(50);
        heap.insert(65);
        heap.printHeap();

        heap.remove();
        heap.printHeap();

        heap.remove();
        heap.printHeap();
    }

    /**
     * Prints the elements of the heap in a structured format.
     * If the heap is empty, it prints a message indicating that the heap is empty.
     */
    public void printHeap() {
        if (heap.isEmpty()) {
            System.out.println("\nHeap is empty.");
            return;
        }
        System.out.println("\nHeap elements : ");
        List<Integer> nodes = new ArrayList<>(heap);
        int maxLevel = (int) (Math.log(heap.size()) / Math.log(2)) + 1;
        printHeapInternal(nodes, 0, maxLevel);
    }

    /**
     * Recursively prints the heap in a structured format.
     *
     * @param nodes    - the list of nodes to be printed at the current level
     * @param level    - the current level in the heap
     * @param maxLevel - the maximum level of the heap
     */
    private void printHeapInternal(List<Integer> nodes, int level, int maxLevel) {
        if (nodes.isEmpty()) return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
        int firstSpaces = (int) Math.pow(2, floor) - 1;
        int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

        printWhitespaces(firstSpaces);

        int levelStart = (int) Math.pow(2, level) - 1;
        int levelEnd = Math.min(levelStart + (int) Math.pow(2, level), heap.size());
        List<Integer> nextNodes = new ArrayList<>();

        for (int i = levelStart; i < levelEnd; i++) {
            System.out.print(heap.get(i));
            if (leftChild(i) < heap.size()) nextNodes.add(heap.get(leftChild(i)));
            if (rightChild(i) < heap.size()) nextNodes.add(heap.get(rightChild(i)));
            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        if (levelStart < heap.size() && level < maxLevel - 1) {
            for (int i = 1; i <= edgeLines; i++) {
                for (int j = levelStart; j < levelEnd; j++) {
                    printWhitespaces(firstSpaces - i);
                    if (leftChild(j) < heap.size()) System.out.print("/");
                    else printWhitespaces(1);

                    printWhitespaces(i + i);

                    if (rightChild(j) < heap.size()) System.out.print("\\");
                    else printWhitespaces(1);

                    printWhitespaces(edgeLines + edgeLines - i);
                }
                System.out.println();
            }
        }

        printHeapInternal(nextNodes, level + 1, maxLevel);
    }

    /**
     * Prints the specified number of whitespaces.
     *
     * @param count - the number of whitespaces to print
     */
    private void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

}
