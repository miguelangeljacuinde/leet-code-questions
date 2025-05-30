package hashtables.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    You are given a list of integer where some of the elements may be repeated. Your task is to write a method that
    removes all duplicate elements from the list and returns a new list containing only the unique elements.

    - Example 1:
        Input: [1, 2, 3, 2, 4, 5, 1]
        Output: [1, 2, 3, 4, 5]

    - Example 2:
        Input: [5, 5, 5, 5, 5]
        Output: [5]

    - Example 3:
        Input: []
        Output: []

    - Example 4:
        Input: [1, 2, 3, 4, 5]
        Output: [1, 2, 3, 4, 5]

    - Constraints:
        0 <= nums.length <= 10^5
        -10^9 <= nums[i] <= 10^9
*/
public class RemoveDuplicates {

    /**
     * Removes duplicates from the given array of integers.
     *
     * @param nums - the input array of integers
     * @return - a new array containing only unique elements
     */
    public static List<Integer> removeDuplicates(List<Integer> nums) {
        Set<Integer> uniqueElements = new HashSet<>(nums);
        return new ArrayList<>(uniqueElements);
    }

    public static void main(String[] args) {
        List<Integer> inputList1 = List.of(1, 2, 3, 2, 4, 5, 1);
        System.out.println("Input: " + inputList1);
        System.out.println("Removed Duplicates: " + removeDuplicates(inputList1));

        List<Integer> inputList2 = List.of(5, 5, 5, 5, 5);
        System.out.println("\nInput: " + inputList2);
        System.out.println("Removed Duplicates: " + removeDuplicates(inputList2));

        List<Integer> inputList3 = List.of();
        System.out.println("\nInput: " + inputList3);
        System.out.println("Removed Duplicates: " + removeDuplicates(inputList3));

        List<Integer> inputList4 = List.of(1, 2, 3, 4, 5);
        System.out.println("\nInput: " + inputList4);
        System.out.println("Removed Duplicates: " + removeDuplicates(inputList4));
    }
}

/*
    O(n) time | O(n) space
        n = length of the input list nums.
    1. Initializes a HashSet to store unique elements by passing the input list to its constructor.
    2. Return a new ArrayList created from the HashSet, which contains only unique elements by passing in the HashSet
        to the ArrayList constructor.
*/