package hashtables.easy;

/*
    Given two integer arrays arr1 and arr2, and an integer target, write a method named findPairs that finds all pairs
    of integers such that one integer is from arr1, the other is from arr2, and their sum equals the target value.

    - Example 1:
        Input: arr1 = [1, 2, 3], arr2 = [4, 5, 6], target = 7
        Output: [[1, 6], [2, 5], [3, 4]]

    - Example 2:
        Input: arr1 = [0, 1, 2], arr2 = [3, 4, 5], target = 5
        Output: [[0, 5], [1, 4], [2, 3]]

    - Example 3:
        Input: arr1 = [1, 2, 3, 4, 5], arr2 = [2, 4, 6, 8, 10], target = 7
        Output: [[5, 2], [1, 6], [3, 4]]

    - Constraints:
        1 <= arr1.length, arr2.length <= 10^5
        -10^9 <= arr1[i], arr2[i] <= 10^9
        -10^9 <= target <= 10^9
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPairs {

    /**
     * Finds all pairs of integers from arr1 and arr2 such that their sum equals the target.
     *
     * @param arr1   - the first array of integers
     * @param arr2   - the second array of integers
     * @param target - the target sum
     * @return - a list of integer arrays, where each array contains a pair of integers that sum to the target
     */
    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        Set<Integer> set = new HashSet<>();
        List<int[]> result = new ArrayList<>();

        for (int num : arr1) {
            set.add(num);
        }

        for (int num : arr2) {
            int complement = target - num;
            if (set.contains(complement)) {
                result.add(new int[]{num, complement});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};
        int target = 7;
        System.out.println("Array 1 : " + java.util.Arrays.toString(arr1));
        System.out.println("Array 2 : " + java.util.Arrays.toString(arr2));
        System.out.println("Pairs between both arrays adding to the target : " + target);
        findPairs(arr1, arr2, target)
                .forEach(pair ->
                        System.out.println("[" + pair[0] + ", " + pair[1] + "]"));

        arr1 = new int[]{0, 1, 2};
        arr2 = new int[]{3, 4, 5};
        target = 5;
        System.out.println("\nArray 1 : " + java.util.Arrays.toString(arr1));
        System.out.println("Array 2 : " + java.util.Arrays.toString(arr2));
        System.out.println("Pairs between both arrays adding to the target : " + target);
        findPairs(arr1, arr2, target)
                .forEach(pair ->
                        System.out.println("[" + pair[0] + ", " + pair[1] + "]"));

        arr1 = new int[]{1, 2, 3, 4, 5};
        arr2 = new int[]{2, 4, 6, 8, 10};
        target = 7;
        System.out.println("\nArray 1 : " + java.util.Arrays.toString(arr1));
        System.out.println("Array 2 : " + java.util.Arrays.toString(arr2));
        System.out.println("Pairs between both arrays adding to the target : " + target);
        findPairs(arr1, arr2, target)
                .forEach(pair ->
                        System.out.println("[" + pair[0] + ", " + pair[1] + "]"));
    }
}

/*
    O(n + m) time | O(m) space
        n = the length of arr1 and m is the length of arr2.
    1. Create a set to store elements of arr2.
    2. Iterate through arr2 and add each element to the set.
    3. Iterate through arr1, calculate the complement for each element, and check if it exists in the set.
    4. If it exists, add the pair to the result list.
    5. Return the list of pairs.
*/