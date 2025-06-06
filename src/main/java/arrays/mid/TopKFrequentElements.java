package arrays.mid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
    #347
    Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in
    any order.

    - Example 1:
        Input: nums = [1,1,1,2,2,3], k = 2
        Output: [1,2]

    - Example 2:
        Input: nums = [1], k = 1
        Output: [1]

    - Constraints:
        1 <= nums.length <= 105
        -104 <= nums[i] <= 104
        k is in the range [1, the number of unique elements in the array].
        It is guaranteed that the answer is unique.

    Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

public class TopKFrequentElements {

    /**
     * Finds the k most frequent elements in an array using a max-heap (priority queue).
     *
     * @param nums - the input array of integers
     * @param k    - the number of top frequent elements to return
     * @return - an array containing the k most frequent elements
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) ->
                frequencyMap.get(b) - frequencyMap.get(a));
        maxHeap.addAll(frequencyMap.keySet());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.remove();
        }
        return result;
    }

    public static void main(String[] args) {
        // Example to understand comparator in PriorityQueue
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 5);
        map.put(3, 8);
        map.put(2, 4);
        map.put(4, 7);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());
        System.out.println("Demo Output : " + maxHeap);    // Output: [3, 4, 1, 2] because 3 has the highest frequency (8),
        // followed by 4 (7), then 1 (5), and finally 2 (4).

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequent(nums, k);
        System.out.println("\nInput Array: " + Arrays.toString(nums));
        System.out.println("Max k elements in array : " + Arrays.toString(result));

        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = topKFrequent(nums2, k2);
        System.out.println("\nInput Array: " + Arrays.toString(nums2));
        System.out.println("Max k elements in array : " + Arrays.toString(result2));
    }

}

/*
    O(n log k) time | O(n) space
        n = the number of elements in the input array.
    1. Initialize a frequency map to count occurrences of each element.
        a. Iterate through the input array and populate the frequency map.
    2. Create a max-heap (priority queue) to store the elements based on their frequency (Use a custom comparator).
        a. The comparator should order elements by their frequency in descending order.
            i. If (a,b) -> map.get(b) - map.get(a) - It will start adding elements with their freq in decreasing order
                (in this case, it will be 3 2 1 (freq)).
            ii. If (a,b) -> map.get(a) - map.get(b) - It will start adding elements with their freq in increasing order
                (in this case, it will be 1 2 3 (freq)).
        b. Add all unique elements from the frequency map to the max-heap.
    3. Initialize an array to store the k most frequent elements.
    4. Extract the top k elements from the max-heap and store them in the result array.
    5. Return the result array.
*/
