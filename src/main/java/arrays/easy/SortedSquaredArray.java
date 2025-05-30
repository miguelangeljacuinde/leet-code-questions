package arrays.easy;

import java.util.Arrays;


/*
    Write a function that takes in a non-empty array of integers that are sorted in ascending
    order and returns a new array of the same length with the squares of the original
    integers also sorted in ascending order.

    Input: array = [1, 2, 3, 5, 6, 8, 9]

    Output: new array = [1, 4, 9, 25, 36, 64, 81]
*/

public class SortedSquaredArray {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 5, 6, 8, 9};
        int[] edgeCase1 = new int[]{1};
        int[] edgeCase2 = new int[]{-4, -2, 1, 2, 3};

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(sortedSquaredArrayBruteForce(array)));
        System.out.println();
        System.out.println(Arrays.toString(edgeCase1));
        System.out.println(Arrays.toString(sortedSquaredArray(edgeCase1)));
        System.out.println();
        System.out.println(Arrays.toString(edgeCase2));
        System.out.println(Arrays.toString(sortedSquaredArray(edgeCase2)));
    }

    /**
     * @param array - the input array
     * @return - a sorted squared array
     */
    public static int[] sortedSquaredArrayBruteForce(int[] array) {
        int[] sortedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            sortedArray[i] = value * value;
        }
        Arrays.sort(sortedArray);
        return sortedArray;
    }

    /**
     * @param array - the input array
     * @return - a sorted squared array
     */
    public static int[] sortedSquaredArray(int[] array) {
        int[] sortedArray = new int[array.length];
        int startIdx = 0;
        int endIdx = array.length - 1;

        for (int i = array.length - 1; i >= 0; i--) {
            if (Math.abs(array[startIdx]) > Math.abs(array[endIdx])) {
                sortedArray[i] = array[startIdx] * array[startIdx];
                startIdx++;
            } else {
                sortedArray[i] = array[endIdx] * array[endIdx];
                endIdx--;
            }
        }
        return sortedArray;
    }

}

/*
    Brute Force Approach : O(n*log(n)) time | O(n) space
    1. Init. new array of same size.
    2. Traverse array squaring the integer at each index.
    3. Sort the array and return it.

    Optimal Approach : O(n) time | O(n) space
    1. Init. new array of same size.
    2. Init. start index and end index.
    3. Traverse array from right to left since we will be sorting from big to small.
    4. Check the abs() value of the start and end indexes.
        a. If the start index > end index, Square the start index and place at the end of
           the new array. start index ++.
        b. Else, square the end index and place at the end of the new array.
            end index --.
    5. Return the sorted array.
*/