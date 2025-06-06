package arrays.mid;

import java.util.Arrays;

/*
    #238
    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements
    of nums except nums[i].

    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

    You must write an algorithm that runs in O(n) time and without using the division operation.

    - Example 1:
        Input: nums = [1,2,3,4]
        Output: [24,12,8,6]

    - Example 2:
        Input: nums = [-1,1,0,-3,3]
        Output: [0,0,9,0,0]

    - Constraints:
        2 <= nums.length <= 105
        -30 <= nums[i] <= 30
        The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.

    - Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra
        space for space complexity analysis.)
*/

public class ProductOfArrayExceptSelf {

    /**
     * This method calculates the product of all elements in the array except the current element.
     * It uses two passes: one for the left products and one for the right products.
     *
     * @param nums The input array of integers.
     * @return An array where each element is the product of all other elements in the input array.
     */
    public static int[] productExceptSelfBruteForce(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                product *= nums[j];
            }
            result[i] = product;
        }
        return result;
    }

    /**
     * This method calculates the product of all elements in the array except the current element.
     * It uses two passes: one for the left products and one for the right products.
     *
     * @param nums The input array of integers.
     * @return An array where each element is the product of all other elements in the input array.
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        Arrays.fill(result, 1);

        int currentProduct = 1;
        for (int i = 0; i < n; i++) {
            result[i] *= currentProduct;
            currentProduct *= nums[i];
        }

        currentProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= currentProduct;
            currentProduct *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = productExceptSelfBruteForce(nums1);
        System.out.println("Input array : " + Arrays.toString(nums1));
        System.out.println("Product array : " + Arrays.toString(result1));

        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = productExceptSelf(nums2);
        System.out.println("\nInput array : " + Arrays.toString(nums2));
        System.out.println("Product array : " + Arrays.toString(result2));
    }
}

/*
    Brute Force Approach:
    O(n^2) time | O(1) space
        n = length of the input array.
    1. Initialize an empty result array of the same length as the input array.
    2. For each element in the input array, calculate the product of all other elements.
        a. Initialize a product variable to 1.
        b. Loop through the input array and multiply all elements except the current one.
    3. Store the product in the result array.
    4. Return the result array.

    Optimized Approach:
    O(n) time | O(1) space
        n = length of the input array.
    1. Initialize an empty result array of the same length as the input array.
    2. Fill the result array with 1s.
    3. Calculate the left products:
        a. Initialize a variable to keep track of the current product.
        b. Loop through the input array from left to right, multiplying the current product with each element and
            storing it in the result array.
    4. Calculate the right products:
        a. Reset the current product variable.
        b. Loop through the input array from right to left, multiplying the current product with each element and
            updating the result array.
    5. Return the result array.
*/
