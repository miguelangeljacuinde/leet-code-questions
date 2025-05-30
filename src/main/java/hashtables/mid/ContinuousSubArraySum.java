package hashtables.mid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    #523
    Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.

    A good subarray is a subarray where:
        1. Its length is at least two
        2. The sum of the elements of the subarray is a multiple of k.

    Note : A subarray is a contiguous part of the array. An integer x is a multiple of k if there exists an integer n
    such that x = n * k. 0 is always a multiple of k.

    - Example 1:
        Input: nums = [23,2,4,6,7], k = 6
        Output: true
        Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.

    - Example 2:
        Input: nums = [23,2,6,4,7], k = 6
        Output: true
        Explanation: [23, 2, 6, 4, 7] is a continuous subarray of size 5 whose elements sum up to 42.
        42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.

    - Example 3:
        Input: nums = [23,2,6,4,7], k = 13
        Output: false

    - Constraints:
        1 <= nums.length <= 105
        0 <= nums[i] <= 109
        0 <= sum(nums[i]) <= 231 - 1
        1 <= k <= 231 - 1
*/

public class ContinuousSubArraySum {

    /**
     * Checks if there is a good subarray in the given array of integers.
     *
     * @param nums - the input array of integers
     * @param k    - the integer to check for multiples
     * @return - true if a good subarray exists, false otherwise
     */
    public static boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;

            if (remainderMap.containsKey(remainder)) {
                if (i - remainderMap.get(remainder) > 1) {
                    return true;
                }
            } else {
                remainderMap.put(remainder, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {23, 2, 4, 6, 7};
        int k1 = 6;
        System.out.println("Input: " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Output: " + checkSubarraySum(nums1, k1));

        int[] nums2 = {23, 2, 6, 4, 7};
        int k2 = 6;
        System.out.println("Input: " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Output: " + checkSubarraySum(nums2, k2));

        int[] nums3 = {23, 2, 6, 4, 7};
        int k3 = 13;
        System.out.println("Input: " + Arrays.toString(nums3) + ", k = " + k3);
        System.out.println("Output: " + checkSubarraySum(nums3, k3));
    }
}

/*
    O(n) time | O(n) space:
        n = length of the input array.
    1. Check if the length of the array is less than 2. If so, return false.
    2. Initialize a HashMap to store the remainders and their corresponding indices.
        a. Put the initial remainder 0 with index -1 in the map. This is to handle cases where the sum is a multiple
            of k from the start.
    3. Initialize a variable to keep track of the cumulative sum.
    4. Iterate through the array:
        a. Add the current element to the cumulative sum.
        b. Calculate the remainder of the cumulative sum when divided by k.
        c. If the remainder is already in the map:
            i. Check if the distance between the current index and the index stored in the map is greater than 1.
                If so, return true.
        d. If the remainder is not in the map, add it with the current index.
    5. If no good subarray is found, return false.
*/
