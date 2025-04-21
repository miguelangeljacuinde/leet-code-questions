package arrays.easy;

/*
    Given an integer array reverse the array in-place.

    Sample Input: array = [1, 2, 3, 4, 5]

    Sample Output: [5, 4, 3, 2, 1]
*/

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2, 3, 4, 5};
        reverse(array1);
        System.out.println(Arrays.toString(array1));

        int[] array2 = new int[]{2, 3, 6, 1, 1, 0};
        reverse(array2);
        System.out.println(Arrays.toString(array2));

        int[] array3 = new int[]{1};
        reverse(array3);
        System.out.println(Arrays.toString(array3));
    }

    /**
     * Reverses the array in-place
     *
     * @param array - the input array
     */
    public static void reverse(int[] array) {
        int left = 0;
        int right = array.length-1;

        while (left < right) {
            int temp = array[left];
            array[left++] = array[right];
            array[right--] = temp;
        }
    }

}

/*
    O(n/2) -> O(n) time | O(1) space
    1. Initialize left and right pointers at each end of the array.
    2. Iterate through the array while left pointer < right pointer.
    3. Store left value in a temp variable and swap the values to reverse the array.
*/