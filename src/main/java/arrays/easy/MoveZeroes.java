package arrays.easy;

import java.util.Arrays;

/*
    #283
    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero
    elements.

    Note that you must do this in-place without making a copy of the array.

    - Example 1:
        Input: nums = [0,1,0,3,12]
        Output: [1,3,12,0,0]

    - Example 2:
        Input: nums = [0]
        Output: [0]

    - Constraints:
        1 <= nums.length <= 104
        -231 <= nums[i] <= 231 - 1

    - Follow up: Could you minimize the total number of operations done?
*/

public class MoveZeroes {

    /**
     * Moves all 0's to the end of the array while maintaining the relative order of non-zero elements.
     *
     * @param nums - the array of integers
     */
    public static void moveZeroes(int[] nums) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 0, 3, 12};
        moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {0};
        moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2));
    }

}

/*
    O(n) time | O(1) space
        n = length of the nums array.
    1. Initialize a variable k = 0 to keep track of the position to place the next non-zero element.
    2. Iterate through the array:
        a. If the current element is not zero, place it at index k and increment k.
    3. After the loop, fill the remaining elements from index k to the end of the array with zeros.
*/
