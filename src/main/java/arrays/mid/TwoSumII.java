package arrays.mid;

/*
    #167
    Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such
    that they add up to a specific target number.
    Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

    Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2]
    of length 2.

    The tests are generated such that there is exactly one solution. You may not use the same element twice.

    Your solution must use only constant extra space.

    - Example 1:
        Input: numbers = [2,7,11,15], target = 9
        Output: [1,2]
        Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

    - Example 2:
        Input: numbers = [2,3,4], target = 6
        Output: [1,3]
        Explanation: The sum of 2 and 4 is 6, therefore index1 = 1, index2 = 3. We return [1, 3].

    - Example 3:
        Input: numbers = [-1,0], target = -1
        Output: [1,2]
        Explanation: The sum of -1 and 0 is -1, therefore index1 = 1, index2 = 2. We return [1, 2].

    - Constraints:
        2 <= numbers.length <= 3 * 104
        -1000 <= numbers[i] <= 1000
        numbers is sorted in non-decreasing order.
        -1000 <= target <= 1000
        The tests are generated such that there is exactly one solution.
*/

import java.util.Arrays;

public class TwoSumII {

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println("Input: " + Arrays.toString(numbers) + ", target = " + target);
        System.out.println("Indices summing up to target (1-indexed based) : " + Arrays.toString(twoSum(numbers, target)));

        numbers = new int[]{2, 3, 4};
        target = 6;
        System.out.println("\nInput: " + Arrays.toString(numbers) + ", target = " + target);
        System.out.println("Indices summing up to target (1-indexed based) : " + Arrays.toString(twoSum(numbers, target)));

        numbers = new int[]{-1, 0};
        target = -1;
        System.out.println("\nInput: " + Arrays.toString(numbers) + ", target = " + target);
        System.out.println("Indices summing up to target (1-indexed based) : " + Arrays.toString(twoSum(numbers, target)));
    }

}

/*
    O(n) time | O(1) space
        n = length of the numbers array.
    1. Initialize two pointers, left at the start and right at the end of the array.
    2. While left is less than right:
        a. Calculate the sum of the elements at the left and right pointers.
            i. If the sum equals the target, return the indices (left + 1, right + 1).
            ii. Else if the sum is less than the target, increment the left pointer.
            iii. Else the sum is greater than the target, decrement the right pointer.
    3. If no such pair is found, return an empty array.
*/
