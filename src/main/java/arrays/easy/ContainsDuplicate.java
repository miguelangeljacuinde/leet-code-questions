package arrays.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    #217
    Given an integer array nums, return true if any value appears at least twice in the array, and return false if
    every element is distinct.

    - Example 1:
        Sample Input: nums = [1,2,3,1]
        Sample Output: true

        Explanation: The element 1 occurs at the indices 0 and 3.

    - Example 2:
        Sample Input: nums = [1,2,3,4]
        Sample Output: false

        Explanation: All elements are distinct.

    - Example 3:
        Sample Input: nums = [1,1,1,3,3,4,3,2,4,2]
        Sample Output: true

    - Constraints:
        1 <= nums.length <= 105
        -109 <= nums[i] <= 109
*/

public class ContainsDuplicate {

    /**
     * Sorts the array and then checks to see if every element is unique.
     *
     * @param nums - the array of numbers
     * @return - true if every element in the array is unique.
     */
    public static boolean containsDuplicateWithSorting(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks to see if every element is unique using a hash set.
     *
     * @param nums - the array of numbers
     * @return - true if every element in the array is unique.
     */
    public static boolean containsDuplicateWithHashSet(int[] nums) {
        Set<Integer> uniqueElements = new HashSet<>();

        for (int num : nums) {
            if (!uniqueElements.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nonUniqueArray = new int[]{1, 2, 3, 3, 3, 4, 5, 6, 6, 7};
        System.out.println("Array : " + Arrays.toString(nonUniqueArray));
        System.out.println("Is every num in array unique : " + containsDuplicateWithSorting(nonUniqueArray));

        int[] uniqueArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println("Array: " + Arrays.toString(uniqueArray));
        System.out.println("Is every num in array unique : " + containsDuplicateWithHashSet(uniqueArray));
    }

}

/*
    With Sorting : O(n*log(n)) time | O(1) space
    1. Sort the array in place.
    2. Traverse the array.
        a. If the element at index i = element at index i-1, return true.
        b. Else continue traversing.
    3. Return false if we traversed the entire array.

    With HashSet : O(n) time | O(n) space
    1. Traverse the array.
        a. If the set contains the element, return true.
        b. Else, add the element to the hash set, then continue traversing.
    3. Return false if we traversed the entire array.
*/
