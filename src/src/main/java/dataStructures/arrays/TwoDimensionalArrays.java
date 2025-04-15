package dataStructures.arrays;

public class TwoDimensionalArrays {

    public static void main(String[] args) {
        TwoDimensionalArrays twoDimensionalArray = new TwoDimensionalArrays(3, 3);

        twoDimensionalArray.traverseArray();

        twoDimensionalArray.insert(0, 0, 10);
        twoDimensionalArray.insert(0, 1, 20);
        twoDimensionalArray.insert(0, 2, 30);
        twoDimensionalArray.insert(1, 0, 40);
        twoDimensionalArray.insert(1, 1, 50);
        twoDimensionalArray.insert(1, 2, 60);
        twoDimensionalArray.insert(2, 0, 70);

        twoDimensionalArray.traverseArray();

        twoDimensionalArray.searchInArray(20);
        twoDimensionalArray.searchInArray(60);

        twoDimensionalArray.deleteValue(0, 2);
        twoDimensionalArray.deleteValue(1, 1);

        twoDimensionalArray.traverseArray();
    }

    int[][] array;

    /**
     * Initializes the two dimension array with value Integer.MIN_VALUE
     *
     * @param numberOfRows    - number of rows in the array
     * @param numberOfColumns - number of columns in the array
     */
    public TwoDimensionalArrays(int numberOfRows, int numberOfColumns) {
        array = new int[numberOfRows][numberOfColumns];
        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                array[row][column] = Integer.MIN_VALUE;
            }
        }
    }

    /**
     * Inserts a value at a given row and column pair
     *
     * @param row               - the row
     * @param column            - the column
     * @param valueToBeInserted - the value to be inserted
     */
    public void insert(int row, int column, int valueToBeInserted) {
        try {
            if (array[row][column] == Integer.MIN_VALUE) {
                array[row][column] = valueToBeInserted;
                System.out.println("Inserted value " + valueToBeInserted + " successfully.");
            } else {
                System.out.println("Row " + row + ", column " + column + ", is already occupied.");
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
            System.out.println("[");
            for (int row = 0; row < array.length; row++) {
                for (int column = 0; column < array[0].length; column++) {
                    System.out.print(array[row][column] + " ");
                }
                System.out.println();
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
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[0].length; column++) {
                if (array[row][column] == valueToSearch) {
                    System.out.println(valueToSearch + " has been found in the array.");
                    return;
                }
            }
        }
        System.out.println(valueToSearch + " was not found in the array...");
    }

    /**
     * Deletes a value at the given row and column pair
     *
     * @param row    - the row
     * @param column - the column
     */
    public void deleteValue(int row, int column) {
        try {
            array[row][column] = Integer.MIN_VALUE;
            System.out.println("Value at row " + row + ", column " + column + ", has been deleted.");
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access array!");
        }
    }

}
