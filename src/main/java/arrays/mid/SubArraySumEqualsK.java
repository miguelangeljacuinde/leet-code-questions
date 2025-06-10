package arrays.mid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    #560
    Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

    A subarray is a contiguous non-empty sequence of elements within an array.

    - Example 1:
        Input: nums = [1,1,1], k = 2
        Output: 2

    - Example 2:
        Input: nums = [1,2,3], k = 3
        Output: 2

    - Constraints:
        1 <= nums.length <= 2 * 104
        -1000 <= nums[i] <= 1000
        -107 <= k <= 107
*/

public class SubArraySumEqualsK {

    /**
     * Finds the total number of subarrays whose sum equals to k.
     *
     * @param nums - the array of integers
     * @param k    - the target sum
     * @return - the total number of subarrays whose sum equals to k
     */
    public static int subarraySumBruteForce(int[] nums, int k) {
        int frequency = 0;
        int sum = 0;

        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i + 1] = sum;
        }

        for (int i = 0; i < prefixSum.length; i++) {
            for (int j = i + 1; j < prefixSum.length; j++) {
                if (prefixSum[j] - prefixSum[i] == k) {
                    frequency++;
                }
            }
        }
        return frequency;
    }

    /**
     * Finds the total number of subarrays whose sum equals to k using a HashMap.
     *
     * @param nums - the array of integers
     * @param k    - the target sum
     * @return - the total number of subarrays whose sum equals to k
     */
    public static int subarraySumWithHashMap(int[] nums, int k) {
        int frequency = 0;
        int currentSum = 0;

        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);

        for (int num : nums) {
            currentSum += num;
            int diff = currentSum - k;

            if (sumMap.containsKey(diff)) {
                frequency += sumMap.get(diff);
            }
            sumMap.put(currentSum, sumMap.getOrDefault(currentSum, 0) + 1);
        }
        return frequency;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println("Array: " + Arrays.toString(nums) + ", k: " + k);
        System.out.println(subarraySumBruteForce(nums, k));
    }

}

/*
    Brute Force:
    O(n^2) time | O(n) space
        n = length of the input array.
    1. Initialize a frequency counter to 0 and a sum variable to 0.
    2. Create a prefix sum array to store cumulative sums (Should be the size of input array + 1).
    3. Iterate through the input array to fill the prefix sum array.
    4. Use two nested loops to check all possible subarrays by comparing the difference of prefix sums.
        a. If the difference equals k, increment the frequency counter.
    5. Return the frequency counter.

    With HashMap:
    O(n) time | O(n) space
        n = length of the input array.
    1. Initialize a frequency counter to 0 and a current sum variable to 0.
    2. Create a HashMap to store the cumulative sums and their frequencies, initializing it with {0: 1}.
    3. Iterate through the input array:
        a. Update the current sum with the current element.
        b. Calculate the difference between the current sum and k.
        c. If the difference exists in the HashMap, add its frequency to the total frequency.
        d. Update the HashMap with the current sum, incrementing its frequency.
    4. Return the total frequency.
*/
