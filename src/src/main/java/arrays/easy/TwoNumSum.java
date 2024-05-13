package arrays.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    # 1
    Write a function that takes in a non-empty array of distinct integers and an integer
    representing a target sum. If any two numbers in the input array sum up the target sum,
    the function should return them in an array, in any order. If no two numbers sum up
    the target sum, return an empty array.

    Note: The target sum has to be obtained by two different integers; you can't add a single
    integer to itself in order to obtain the sum.

    You can also assume that there will be at most one pair of numbers summing up to the
    target sum.

    Sample Input: array = [3, 5, -4, 8, 11, 1, -1, 6]
                  targetSum = 10

    Sample Output: [-1, 11]
 */

public class TwoNumSum {
    public static void main(String[] args) {
        int[] array = new int[]{3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum = 10;

        System.out.println(Arrays.toString(twoNumberSumWithHashset(array, targetSum)));
        System.out.println(Arrays.toString(twoNumberSumWithPointers(array, targetSum)));
    }

    /**
     * @param array     - the input array
     * @param targetSum - the target sum
     * @return - array of two num sum pairs | empty array
     */
    public static int[] twoNumberSumWithHashset(int[] array, int targetSum) {
        Set<Integer> numbersWeHaveLookedThrough = new HashSet<>();

        for (int currentNum : array) {
            int targetPair = targetSum - currentNum;

            if (numbersWeHaveLookedThrough.contains(targetPair)) {
                return new int[]{targetPair, currentNum};
            } else {
                numbersWeHaveLookedThrough.add(currentNum);
            }
        }
        return new int[0];
    }

    /**
     * @param array     - the input array
     * @param targetSum - the target sum
     * @return - array of two num sum pairs | empty array
     */
    public static int[] twoNumberSumWithPointers(int[] array, int targetSum) {
        Arrays.sort(array);
        int leftPointer = 0;
        int rightPointer = array.length - 1;

        while (leftPointer < rightPointer) {
            int currentTarget = array[leftPointer] + array[rightPointer];

            if (currentTarget == targetSum) {
                return new int[]{array[leftPointer], array[rightPointer]};
            } else if (currentTarget < targetSum) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }

        return new int[0];
    }

}

/*
    With HashSet : O(n) time | O(n) space

    1. Init. a hashSet for storing the numbers we have already looked up (won't store duplicates).
    2. Traverse the array.
    3. Init. the targetPair we are searching for (targetSum - currentNum).
    4. Check if the hashSet contains the targetPair we just initialized.
        a. If it contains the targetPair, return an array of {targetPair, currentNum}.
        b. Else, add the currentNum to the hashSet.
    5. If we are done traversing the array, there was no two num sum. Return an empty array.

    With Pointers : O(n*log(n)) time | O(1) space

    1. Sort the array in place.
    2. Init. left and right pointers.
    3. Traverse the array while left pointer < right pointer.
    4. Init. the currentTarget (leftPointer + rightPointer).
    5. Check if the currentTarget = targetSum.
        a. If they are equal, return new array {leftPointer, rightPointer}.
        b. Else if the currentTarget < targetSum, leftPointer ++.
        c. Else if the currentTarget > targetSum, rightPointer --.
    6. If we are done traversing the array, there was no two num sum. Return an empty array.
*/