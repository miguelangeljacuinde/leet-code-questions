package heaps.mid;

/*
    #215
    Given an integer array nums and an integer k, return the kth largest element in the array.
    Note that it is the kth largest element in the sorted order, not the kth distinct element.
    Can you solve it without sorting?

    - Example 1:
        Input: nums = [3,2,1,5,6,4], k = 2
        Output: 5

    - Example 2:
        Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
        Output: 4

    - Constraints:
        1 <= k <= nums.length <= 105
        -104 <= nums[i] <= 104
*/

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {

    /**
     * Finds the kth largest element in an array by sorting the array.
     *
     * @param nums - the input array of integers
     * @param k    - the kth position to find the largest element
     * @return - the kth largest element in the array
     */
    public static int findKthLargestWithSort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * Finds the kth largest element in an array using a min-heap.
     *
     * @param nums - the input array of integers
     * @param k    - the kth position to find the largest element
     * @return - the kth largest element in the array
     */
    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        return minHeap.remove();
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println("Input Array : " + Arrays.toString(nums1));
        System.out.println("The " + k1 + "th largest element is: " + findKthLargestWithSort(nums1, k1));

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println("\nInput Array : " + Arrays.toString(nums2));
        System.out.println("The " + k2 + "th largest element is: " + findKthLargest(nums2, k2));
    }

}

/*
    With sorting:
    O(n log n) time | O(1) space
        n = length of the input array.
    1. Sort the array in ascending order.
    2. Return the element at the index `length - k`.

    With Min-Heap:
    O(n log k) time | O(k) space
        n = length of the input array.
    1. Create a min-heap of size k.
    2. Iterate through the array:
        a. Add each element to the min-heap.
        b. If the size of the min-heap exceeds k, remove the smallest element (this ensures that the heap contains the
            k largest elements).
    3. After processing all elements, the root of the min-heap will be the kth largest element. Return the root of the
        min-heap.
*/
