package arrays.mid;

import java.util.Arrays;

/*
    #11

    You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of
    the ith line are (i, 0) and (i, height[i]).

    Find two lines that together with the x-axis form a container, such that the container contains the most water.

    Return the maximum amount of water a container can store.

    Notice that you may not slant the container.

    - Example 1:
        Input: height = [1,8,6,2,5,4,8,3,7]
        Output: 49
        Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

    - Example 2:
        Input: height = [1,1]
        Output: 1

    - Constraints:
        n == height.length
        2 <= n <= 105
        0 <= height[i] <= 104
*/

public class ContainerWithMostWater {

    /**
     * Finds the maximum area of water that can be contained between two lines
     *
     * @param height - the heights of the lines
     * @return - the maximum area of water that can be contained
     */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];

            int width = right - left;
            int currentHeight = Math.min(leftHeight, rightHeight);
            int currentArea = width * currentHeight;

            maxArea = Math.max(maxArea, currentArea);

            if (leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Array : " + Arrays.toString(heights1));
        System.out.println(maxArea(heights1));

        int[] heights2 = {1, 1};
        System.out.println("Array : " + Arrays.toString(heights2));
        System.out.println(maxArea(heights2));
    }

}

/*
    O(n) time | O(1) space
        n = length of the height array.
    1. Initialize two pointers, left and right, at the beginning and end of the array respectively.
    2. Initialize maxArea to 0.
    3. While left < right:
        a. Calculate the width as right - left.
        b. Calculate the height as the minimum of height[left] and height[right].
        c. Calculate the area as width * height.
        d. Update maxArea if the current area is greater than maxArea.
        e. Update pointer according to the height:
            i. If height[left] < height[right], increment left.
            ii. Else, decrement right.
    4. Return maxArea.
*/
