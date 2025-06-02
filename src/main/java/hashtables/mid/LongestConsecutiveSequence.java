package hashtables.mid;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    #128
    Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
    You must write an algorithm that runs in O(n) time.

    - Example 1:
        Input: nums = [100, 4, 200, 1, 3, 2]
        Output: 4
        Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore, its length is 4.

    - Example 2:
        Input: nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
        Output: 9

    - Example 3:
        Input: nums = [1, 0, 1, 2]
        Output: 3

    - Constraints:
        0 <= nums.length <= 105
        -109 <= nums[i] <= 109
*/

public class LongestConsecutiveSequence {

    /**
     * Finds the length of the longest consecutive elements sequence in an unsorted array.
     *
     * @param nums - the input array of integers
     * @return - the length of the longest consecutive elements sequence
     */
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println(Arrays.toString(nums1));
        System.out.println(longestConsecutive(nums1));

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(Arrays.toString(nums2));
        System.out.println(longestConsecutive(nums2));

        int[] nums3 = {1, 0, 1, 2};
        System.out.println(Arrays.toString(nums3));
        System.out.println(longestConsecutive(nums3));
    }
}

/*
    O(n) time | O(n) space
        n = the number of elements in the input array.
    1. Create a HashSet to store the unique elements of the array.
    2. Add all elements of the array to the HashSet.
    3. Initialize a variable to keep track of the longest streak.
    4. Iterate through each element in the HashSet:
        a. If the current element is the start of a sequence (i.e., it does not have a predecessor in the set),
            initialize a counter for the current streak.
        b. Increment the current streak while the next consecutive number exists in the set.
        c. Update the longest streak if the current streak is longer.
    5. Return the longest streak found.
*/