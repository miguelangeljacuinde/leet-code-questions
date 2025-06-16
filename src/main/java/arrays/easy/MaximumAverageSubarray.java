package arrays.easy;

/*
    #643
    You are given an integer array nums consisting of n elements, and an integer k.

    Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
    Any answer with a calculation error less than 10-5 will be accepted.

    - Example 1:
        Input: nums = [1,12,-5,-6,50,3], k = 4
        Output: 12.75000
        Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

    - Example 2:
        Input: nums = [5], k = 1
        Output: 5.00000

    - Constraints:
        n == nums.length
        1 <= k <= n <= 105
        -104 <= nums[i] <= 104
*/

public class MaximumAverageSubarray {

    /**
     * Finds the maximum average of a contiguous subarray of length k.
     *
     * @param nums - the array of integers
     * @param k    - the length of the subarray
     * @return - the maximum average value
     */
    public static double findMaxAverage(int[] nums, int k) {
        double currentSum = 0.0;

        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        double maxAverage = currentSum / k;

        for (int i = k; i < nums.length; i++) {
            currentSum += nums[i] - nums[i - k];
            maxAverage = Math.max(maxAverage, currentSum / k);
        }
        return maxAverage;
    }

    /**
     * Finds the maximum average of a contiguous subarray of length k using a sliding window approach.
     *
     * @param nums - the array of integers
     * @param k    - the length of the subarray
     * @return - the maximum average value
     */
    public static double findMaxAverage2(int[] nums, int k) {
        int currentSum = 0;

        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        int maxSum = currentSum;

        for (int i = k; i < nums.length; i++) {
            currentSum = currentSum + nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(findMaxAverage(nums, k));

        nums = new int[]{5};
        k = 1;
        System.out.println(findMaxAverage2(nums, k));
    }

}

/*
    Solution 1 : O(n) time | O(1) space : (focuses on getting the maximum average at each iteration)
        n = length of the nums array.
    1. Initialize currentSum to 0.
    2. Calculate the currentSum and then get the maxAverage of the first k elements.
    3. Iterate through the rest of array starting from index k.
        a. Add the current element to currentSum and subtract the element at index i - k.
        b. Update maxAverage if currentSum / k is greater than maxAverage.
    4. Return maxAverage.

    Solution 2 : O(n) time | O(1) space : (focuses on getting the maximum sum at each iteration and finds the maximum
        average at the end making for a faster runtime solution)
            n = length of the nums array.
    1. Initialize currentSum to 0.
    2. Calculate the currentSum of the first k elements and initialize maxSum to currentSum.
    3. Iterate through the rest of the array starting from index k.
        a. Update currentSum by adding the current element and subtracting the element at index i - k.
        b. Update maxSum if currentSum is greater than maxSum.
    4. Return maxSum / k to get the maximum average.
*/
