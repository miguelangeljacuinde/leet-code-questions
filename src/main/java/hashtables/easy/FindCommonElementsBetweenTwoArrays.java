package hashtables.easy;

import java.util.ArrayList;
import java.util.HashSet;

/*
    Given two integer arrays nums1 and nums2, return a list of all common elements.

    - Example 1:
        Sample Input: nums1 = [1,2,3,4,5], nums2 = [4,5,6,7,8]
        Sample Output: [4,5]

    - Example 2:
        Sample Input: nums1 = [1,1,2,2,3], nums2 = [2,2,3,3,4]
        Sample Output: [2,3]

    - Constraints:
        1 <= nums1.length, nums2.length <= 1000
        1 <= nums1[i], nums2[i] <= 1000
*/

public class FindCommonElementsBetweenTwoArrays {

    public static ArrayList<Integer> findCommonElementsBetweenTwoArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> commonElements = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                commonElements.add(num);
                set.remove(num);
            }
        }
        return commonElements;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 5, 6, 7, 8};

        ArrayList<Integer> commonValues = findCommonElementsBetweenTwoArrays(arr1, arr2);
        printList(commonValues);

        int[] arr3 = {1, 1, 2, 2, 3};
        int[] arr4 = {2, 2, 3, 3, 4};
        ArrayList<Integer> commonValues2 = findCommonElementsBetweenTwoArrays(arr3, arr4);
        printList(commonValues2);

        int[] arr5 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9 , 10};
        int[] arr6 = {0, 2, 4, 6, 8, 10};
        ArrayList<Integer> commonValues3 = findCommonElementsBetweenTwoArrays(arr5, arr6);
        printList(commonValues3);

    }

    /**
     * This method prints the elements of the list.
     *
     * @param list - the input list of integers
     */
    public static void printList(ArrayList<Integer> list) {
        System.out.print("Common elements : ");
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                System.out.print(list.get(i) + ", ");
            } else {
                System.out.print(list.get(i));
            }
        }
        System.out.println();
    }

}

/*
    O(n + m) time | O(n) space
        n = length of nums1, m = length of nums2.
    1. We create a HashSet to store the elements of nums1.
    2. We iterate through nums2 and check if each element is present in the HashSet.
    3. If it is, we add it to the result list and remove it from the HashSet to avoid duplicates.
    4. Finally, we return the result list containing the common elements.
*/