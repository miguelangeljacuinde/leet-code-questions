package demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Practice {

    public static void main(String[] args) {
        System.out.println(removeElement(new int[] {3, 2, 2, 3}, 3));
    }

    public static int removeElement(int[] nums, int val) {
        List<Integer> elementsLeft = new ArrayList<>();
        for (int num : nums) {
            if (val != num) {
                elementsLeft.add(num);
            }
        }
        System.out.print("Array: [ ");
        elementsLeft.forEach(num -> System.out.print(num + ", "));
        System.out.println(" ]");
        return elementsLeft.size();
    }

    /**
     * Initializes a reader to read and decode a message from a file
     */
    public static void decodingAMessageFromAFile() {
        try {
            File file = new File("/Users/migueljacuinde/Downloads/coding_qual_input.txt");
            Scanner myReader = new Scanner(file);
            HashMap<Integer, String> pyramid = initializeHashMapWithValuesFromFile(myReader);
            printSecretMessage(pyramid);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }

    /**
     * Prints the secret message
     *
     * @param pyramid - the "pyramid" HashMap
     */
    private static void printSecretMessage(HashMap<Integer, String> pyramid) {
        System.out.println(pyramid.get(1));
        int nextNum = 1;
        int i = 2;
        while (pyramid.get(nextNum) != null) {
            nextNum = nextNum + i;
            i++;
            System.out.println(pyramid.get(nextNum));
        }
    }

    /**
     * Initializes the HashMap with the values from the file
     *
     * @param myReader - the reader
     * @return - HashMap with file data
     */
    private static HashMap<Integer, String> initializeHashMapWithValuesFromFile(Scanner myReader) {
        HashMap<Integer, String> pyramid = new HashMap<>();
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            int lineNumber = Integer.parseInt(data.substring(0, data.indexOf(' ')));
            pyramid.put(lineNumber, data);
        }
        myReader.close();
        return pyramid;
    }

}
