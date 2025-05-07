package arrays.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    #1
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to
    target. You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    - Example 1:
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]

        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

    - Example 2:
        Input: nums = [3,2,4], target = 6
        Output: [1,2]

    - Example 3:
        Input: nums = [3,3], target = 6
        Output: [0,1]

    - Constraints:
        2 <= nums.length <= 104
        -109 <= nums[i] <= 109
        -109 <= target <= 109
        Only one valid answer exists.
*/

public class TwoSum {

    public static void main(String[] args) {
        int[] array = new int[]{3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum = 10;

        System.out.println(Arrays.toString(twoSum(array, targetSum)));
    }

    /**
     * Finds two numbers whose sum is equal to the parameter target
     *
     * @param nums   - the array of numbers
     * @param target - the target sum
     * @return - indices of numbers whose sum is equal to the target.
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> twoSumMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int targetPair = target - nums[i];
            if (twoSumMap.containsKey(targetPair)) {
                return new int[]{twoSumMap.get(targetPair), i};
            }
            twoSumMap.put(nums[i], i);
        }
        return new int[]{};
    }

}

/*
    O(n) time | O(n) space
    1. Init. a hash map for storing the numbers we have already looked up as well as the index.
    2. Traverse the array.
        a. Find the targetPair we need by subtracting the current number with from the target.
        b. If the map contains this current targetPair, return a new array with the current index and the current
            targetPair's index (in any order).
        c. Add the current number and it's index to the map.
    3. Return an empty array if none are found.
*/