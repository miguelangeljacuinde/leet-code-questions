package dataStructures.arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) {
        // Create an Arraylist with initialized integers.
        // O(1) time | O(n) space
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(numbers);

        // Add new integers to the Arraylist.
        // O(1) time | O(1) space amortized
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        System.out.println(numbers);

        // Add new element with index specified.
        // O(n) time | O(1) space
        numbers.add(10);
        System.out.println(numbers);

        // This will shift element 10 to the right and insert 9 at index 8.
        numbers.add(8, 9);
        System.out.println(numbers);

        // This will throw IndexOutOfBoundsException since there is no element at index 10. This gap is not allowed.
        // You cannot insert at an index that is greater than the arraylist's size.
        try {
            numbers.add(11, 11);
        } catch(IndexOutOfBoundsException e) {
            System.out.println(e);
        }

        numbers.add(10, 11);
        System.out.println(numbers);

        // Access elements in an Arraylist.
        // O(1) time | O(1) space
        System.out.println("Element at index 10 : " + numbers.get(10));
        System.out.println("Element at index 0 : " + numbers.get(0));

        // Traversal of Arraylist
        // O(n) time | O(1) space
        System.out.println("Standard for-loop:");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();
        System.out.println("Enhanced for each loop:");
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
        System.out.println("Using an iterator:");
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // Search for elements in an Arraylist.
        // O(n) time | O(1) space
        for (Integer number : numbers) {
            if (number.equals(3)) {
                System.out.println("Element 3 is found!");
                break;
            }
        }
        // Using indexOf()
        int index = numbers.indexOf(5);
        System.out.println("The number 5 was found at index " + index);

        // Remove an element from an Arraylist
        // O(n) time | O(1) space
        numbers.add(12);
        System.out.println(numbers);
        numbers.remove(11);
        System.out.println(numbers);
        numbers.remove(numbers.indexOf(11));
        System.out.println(numbers);
    }

}
