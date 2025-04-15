package dataStructures.arrays;

import java.util.Arrays;

public class OneDimensionalArrays {

    public static void main(String[] args) {
        OneDimensionalArrays oneDimensionalArray = new OneDimensionalArrays(6);

        oneDimensionalArray.traverseArray();

        oneDimensionalArray.insert(0, 10);
        oneDimensionalArray.insert(1, 20);
        oneDimensionalArray.insert(2, 30);
        oneDimensionalArray.insert(3, 40);
        oneDimensionalArray.insert(4, 50);

        oneDimensionalArray.traverseArray();

        oneDimensionalArray.searchInArray(20);
        oneDimensionalArray.searchInArray(60);

        oneDimensionalArray.deleteValueAtIndex(3);
        oneDimensionalArray.deleteValueAtIndex(4);

        oneDimensionalArray.traverseArray();
    }

    int[] array;

    /**
     * Initializes the one dimension array with value Integer.MIN_VALUE
     *
     * @param sizeOfArray - size of array to be initialized
     */
    public OneDimensionalArrays(int sizeOfArray) {
        array = new int[sizeOfArray];
        Arrays.fill(array, Integer.MIN_VALUE);
    }

    /**
     * Inserts a value at a given index
     *
     * @param index             - the index
     * @param valueToBeInserted - the value to be inserted
     */
    public void insert(int index, int valueToBeInserted) {
        try {
            if (array[index] == Integer.MIN_VALUE) {
                array[index] = valueToBeInserted;
                System.out.println("Inserted value " + valueToBeInserted + " successfully.");
            } else {
                System.out.println("Index " + index + " is already occupied.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access array!");
        }
    }

    /**
     * Traverses the array
     */
    public void traverseArray() {
        try {
            System.out.print("[ ");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println("]");
        } catch(Exception e) {
            System.out.println("Array no longer exists!");
        }
    }

    /**
     * Searches for a given value in the array
     *
     * @param valueToSearch - the value to search for in the array
     */
    public void searchInArray(int valueToSearch) {
        for (int num : array) {
            if (num == valueToSearch) {
                System.out.println(valueToSearch + " has been found in the array.");
                return;
            }
        }
        System.out.println(valueToSearch + " was not found in the array...");
    }

    /**
     * Deletes a value at the given index
     *
     * @param index - the index
     */
    public void deleteValueAtIndex(int index) {
        try {
            array[index] = Integer.MIN_VALUE;
            System.out.println("Value at index " + index + " has been deleted.");
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access array!");
        }
    }

}
