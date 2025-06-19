package arrays.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    #15
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that
    i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

    Notice that the solution set must not contain duplicate triplets.

    - Example 1:
        Input: nums = [-1,0,1,2,-1,-4]
        Output: [[-1,-1,2],[-1,0,1]]

        Explanation:
        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
        The distinct triplets are [-1,0,1] and [-1,-1,2].

        Notice that the order of the output and the order of the triplets does not matter.

    - Example 2:
        Input: nums = [0,1,1]
        Output: []

        Explanation: The only possible triplet does not sum up to 0.

    - Example 3:
        Input: nums = [0,0,0]
        Output: [[0,0,0]]

        Explanation: The only possible triplet sums up to 0.

    - Constraints:
        3 <= nums.length <= 3000
        -105 <= nums[i] <= 105
*/

public class ThreeSum {

    /**
     * Finds all unique triplets in the array that sum to zero.
     *
     * @param nums the input array of integers
     * @return a list of lists containing the unique triplets
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }
}

/*
    O(n^2) time | O(n) space
        n = the length of the input array nums.
    1. Sort the input array nums.
    2. Iterate through the array (from 0 to nums.length - 2, as we will be checking pairs using left and right pointers) :
        a. If the current element is the same as the previous one, skip it to avoid duplicates.
        b. Initialize two pointers: left (next element) and right (last element).
        c. While left < right:
            i. Calculate the sum of the current element, nums[left], and nums[right].
            ii. If the sum is zero, add the triplet to the result list.
                - Skip duplicates for both left and right pointers.
                - Move both pointers inward.
            iii. If the sum is less than zero, increment the left pointer to increase the sum.
            iv. If the sum is greater than zero, decrement the right pointer to decrease the sum.
    3. Return the list of unique triplets.
*/
