package arrays.easy;

import java.util.Arrays;

/*
    #27
    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique
    element appears only once. The relative order of the elements should be kept the same. Then return the number of
    unique elements in nums.

    Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
        Change the array nums such that the first k elements of nums contain the unique elements in the order they were
        present in nums initially.

    The remaining elements of nums are not important as well as the size of nums. Return k.

    Sample Input: array = [1, 2, 2, 3, 4, 4, 5]

    Sample Output: 5
*/

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2, 2, 3, 4, 4, 5};
        System.out.println(removeDuplicates(array1));
        System.out.println(Arrays.toString(array1));

        int[] array2 = new int[0];
        System.out.println(removeDuplicates(array2));
        System.out.println(Arrays.toString(array2));
    }

    /**
     * Removes the duplicates from the array in place
     *
     * @param nums - the array of numbers
     * @return - the first k elements of nums containing the unique elements in the order they were initially present.
     */
    public static int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

}

/*
    O(n) time | O(1) space
    1. Initialize k = 1 since element at index 0 will never need to be changed as it will always be unique.
    2. Iterate through the array.
        a. If the number at index i is NOT equal to the number before it (i-1), update the array in-place at position k
            to equal the number at the current index i and increment k by 1.
        b. Else, continue traversing the array.
    3. Return k (this will return the total number of unique elements in the array;
        will point to the last+1 updated element in the array).

        e.g.
            array  = [1, 2, 2, 3, 4, 4, 5]
            output = [1, 2, 3, 4, 5, 4, 5]
                                     k

            k = 5 (points at array[5] = 4) but the total number of unique elements = 5.
            All we care about are the elements before k.
*/