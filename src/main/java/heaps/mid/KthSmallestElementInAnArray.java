package heaps.mid;

/*
    Given an integer array nums and an integer k, return the kth smallest element in the array.
    Note that it is the kth smallest element in the sorted order, not the kth distinct element.
    Can you solve it without sorting?

    - Example 1:
        Input: nums = [3,2,1,5,6,4], k = 2
        Output: 2

    - Example 2:
        Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
        Output: 3

    - Constraints:
        1 <= k <= nums.length <= 105
        -104 <= nums[i] <= 104
*/

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementInAnArray {

    /**
     * Finds the kth smallest element in an array by sorting the array.
     *
     * @param nums - the input array of integers
     * @param k    - the kth position to find the smallest element
     * @return - the kth smallest element in the array
     */
    public static int findKthSmallestWithSort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[k - 1];
    }

    /**
     * Finds the kth smallest element in an array using a min-heap.
     *
     * @param nums - the input array of integers
     * @param k    - the kth position to find the smallest element
     * @return - the kth smallest element in the array
     */
    public static int findKthSmallest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
        }
        int kthSmallest = 0;
        for (int i = 0; i < k; i++) {
            kthSmallest = minHeap.remove();
        }
        return kthSmallest;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println("Input Array : " + Arrays.toString(nums1));
        System.out.println("The " + k1 + "th largest element is: " + findKthSmallest(nums1, k1));

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println("\nInput Array : " + Arrays.toString(nums2));
        System.out.println("The " + k2 + "th largest element is: " + findKthSmallest(nums2, k2));
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
