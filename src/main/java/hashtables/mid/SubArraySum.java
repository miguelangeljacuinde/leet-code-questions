package hashtables.mid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    Given an array of integers nums and a target integer target, write a method called subarraySum that finds the
    indices of a contiguous subarray in nums that add up to the target sum using a hash table (HashMap).

    The method should return the starting and ending indices of the subarray if it exists, or an empty list.

    - Example 1:
        Input: nums = [1, 2, 3, 4, 5], target = 9
        Output: [1, 3]
        Explanation: The subarray [2, 3, 4] has a sum of 9.

    - Example 2:
        Input: nums = [1, 2, 3, 4, 5], target = 15
        Output: [0, 4]
        Explanation: The subarray [1, 2, 3, 4, 5] has a sum of 15.

    - Example 3:
        Input: nums = [1, 2, 3, 4, 5], target = 16
        Output: []
        Explanation: No subarray has a sum of 16.

    - Constraints:
        1 <= nums.length <= 10^5
        -10^9 <= nums[i] <= 10^9
        -10^9 <= target <= 10^9
*/

public class SubArraySum {

    /**
     * Finds the starting and ending indices of a contiguous subarray that sums to the target.
     *
     * @param nums   - the array of integers
     * @param target - the target sum
     * @return - an array containing the starting and ending indices of the subarray, or an empty array if no such
     *           subarray exists.
     */
    public static int[] subarraySum(int[] nums, int target) {
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        sumIndexMap.put(0, -1);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumIndexMap.containsKey(sum - target)) {
                return new int[]{sumIndexMap.get(sum - target) + 1, i};
            }
            sumIndexMap.put(sum, i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 9;
        System.out.println("Array : " + Arrays.toString(nums) + ", target = " + target);
        System.out.println("SubArray indices that add to target sum : " + Arrays.toString(subarraySum(nums, target)));

        int[] nums2 = {1, 2, 3, 4, 5};
        int target2 = 15;
        System.out.println("\nArray : " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("SubArray indices that add to target sum : " + Arrays.toString(subarraySum(nums2, target2)));

        int[] nums3 = {1, 2, 3, 4, 5};
        int target3 = 16;
        System.out.println("\nArray : " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("SubArray indices that add to target sum : " + Arrays.toString(subarraySum(nums3, target3)));
    }

}

/*
    O(n) time | O(n) space
        n = length of the input array nums.
    1. Initializes a HashMap to store the cumulative sum and its corresponding index.
        a. Puts the initial sum of 0 with index -1 to handle cases where the subarray starts from index 0.
    2. Initializes a variable to keep track of the cumulative sum.
    3. Iterates through the array nums:
        a. Adds the current element to the cumulative sum.
        b. Checks if the difference between the cumulative sum and the target exists in the map.
            i. If it does, retrieves the starting index from the map and returns an array containing the starting
               and ending indices of the subarray.
        c. If not found, adds the current cumulative sum and its index to the map.
    4. If no subarray is found, returns an empty array.
*/