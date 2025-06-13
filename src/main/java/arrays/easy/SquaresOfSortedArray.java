package arrays.easy;

import java.util.Arrays;

/*
    #977
    Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in
    non-decreasing order.

    - Example 1:
        Input: nums = [-4, -1, 0, 3, 10]
        Output: [0, 1, 9, 16, 100]

        Explanation: After squaring, the array becomes [16, 1, 0, 9, 100].
        After sorting, it becomes [0, 1, 9, 16, 100].

    - Example 2:
        Input: nums = [-7, -3, 2, 3, 11]
        Output: [4, 9, 9, 49, 121]

    - Constraints:
        1 <= nums.length <= 104
        -104 <= nums[i] <= 104
        nums is sorted in non-decreasing order.
*/

public class SquaresOfSortedArray {

    /**
     * @param nums - the input array
     * @return - a sorted squared array
     */
    public static int[] sortedSquaresBruteForce(int[] nums) {
        int[] sortedArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            sortedArray[i] = nums[i] * nums[i];
        }
        Arrays.sort(sortedArray);
        return sortedArray;
    }

    /**
     * @param nums - the input array
     * @return - a sorted squared array
     */
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] sortedArray = new int[n];
        int left = 0;
        int right = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                sortedArray[i] = nums[left] * nums[left];
                left++;
            } else {
                sortedArray[i] = nums[right] * nums[right];
                right--;
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        int[] nums1 = {-4, -1, 0, 3, 10};
        int[] result1 = sortedSquaresBruteForce(nums1);
        System.out.println("Input array : " + Arrays.toString(nums1));
        System.out.println("Sorted squared array : " + Arrays.toString(result1));

        int[] nums2 = {-7, -3, 2, 3, 11};
        int[] result2 = sortedSquares(nums2);
        System.out.println("\nInput array : " + Arrays.toString(nums2));
        System.out.println("Sorted squared array : " + Arrays.toString(result2));
    }

}

/*
    Brute Force Approach : O(n * log(n)) time | O(n) space
        n = length of the input array nums.
    1. Init. new array of same size.
    2. Traverse array squaring the integer at each index.
    3. Sort the array and return it.

    Optimal Approach : O(n) time | O(n) space
        n = length of the input array nums.
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
