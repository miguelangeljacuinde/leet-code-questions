package leetcode;

import java.util.Arrays;


/*
    #755

*/
public class PourWater {

    public static void main(String[] args) {
        String pourWater = "Pour water ";
        String rightToLeft = "right to left : ";
        String leftToRight = "left to right : ";

        int[] heights1 = new int[]{2, 1, 1, 2, 1, 2, 2};
        int volume1 = 4;
        int k1 = 3;

        System.out.println(pourWater + leftToRight + Arrays.toString(pourWaterLeftToRight(heights1, volume1, k1)));
        System.out.println(pourWater + rightToLeft + Arrays.toString(pourWaterRightToLeft(heights1, volume1, k1)));

        int[] heights2 = new int[]{3, 1, 3};
        int volume2 = 5;
        int k2 = 1;

        System.out.println(pourWater + leftToRight + Arrays.toString(pourWaterLeftToRight(heights2, volume2, k2)));
        System.out.println(pourWater + rightToLeft + Arrays.toString(pourWaterRightToLeft(heights2, volume2, k2)));

        int[] heights3 = new int[]{1, 3, 2};
        int volume3 = 7;
        int k3 = 0;

        System.out.println(pourWater + leftToRight + Arrays.toString(pourWaterLeftToRight(heights3, volume3, k3)));
        System.out.println(pourWater + rightToLeft + Arrays.toString(pourWaterRightToLeft(heights3, volume3, k3)));
    }

    /**
     * @param heights          - the heights of the bricks
     * @param volume           - the volume of water (amount of water being poured i.e. fills one spot)
     * @param startingPosition - the starting position
     * @return - final heights array after water is poured right to left
     */
    public static int[] pourWaterRightToLeft(int[] heights, int volume, int startingPosition) {
        int currentIndex = startingPosition;
        int leftWall = 0;
        int rightWall = heights.length-1;

        while (volume > 0) {
            while (currentIndex < rightWall && heights[currentIndex] >= heights[currentIndex + 1]) {
                currentIndex++;
            }
            while (currentIndex > leftWall && heights[currentIndex] >= heights[currentIndex - 1]) {
                currentIndex--;
            }
            while (currentIndex < startingPosition  && heights[currentIndex] == heights[currentIndex + 1]) {
                currentIndex++;
            }
            heights[currentIndex]++;
            volume--;
        }
        return heights;
    }

    /**
     * @param heights          - the heights of the bricks
     * @param volume           - the volume of water (amount of water being poured i.e. fills one spot)
     * @param startingPosition - the starting position
     * @return - final heights array after water is poured left to right
     */
    public static int[] pourWaterLeftToRight(int[] heights, int volume, int startingPosition) {
        int currentIndex = startingPosition;
        int leftWall = 0;
        int rightWall = heights.length-1;

        while (volume > 0) {
            while (currentIndex > leftWall && heights[currentIndex] >= heights[currentIndex - 1])
                currentIndex--;
            while (currentIndex < rightWall && heights[currentIndex] >= heights[currentIndex + 1])
                currentIndex++;
            while (currentIndex > startingPosition && heights[currentIndex] == heights[currentIndex - 1])
                currentIndex--;
            heights[currentIndex]++;
            volume--;
        }
        return heights;
    }

}

/*
    O(V + k) time | O(1) space
        V = volume,
        k = starting position.

    1. Init. current position. (Init. left wall and right wall for better clarity.)
    2. While volume > 0 :
        a. While current position > left wall and the height at current position >= current position - 1,
            move current position to the left.
        b. While current position < right wall and the height at current position >= current position + 1,
            move current position to the right.
        c. While current position > starting position and height at current position == height at current position - 1,
            move current position to the left to get back where we started.
    3. Increase height at the current position.
    4. Decrease volume count.
    5. Return the final heights array.
*/