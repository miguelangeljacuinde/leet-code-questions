package arrays.mid;

/*
    # 48
    You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise). You have to
    rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another
    2D matrix and do the rotation.

    - Example 1:
        Sample Input: matrix = [[1,2,3],
                                [4,5,6],
                                [7,8,9]]

        Sample Output: [[7,4,1],
                        [8,5,2],
                        [9,6,3]]

    - Example 2:
        Sample Input: matrix = [[5,1,9,11],
                                [2,4,8,10],
                                [13,3,6,7],
                                [15,14,12,16]]

        Sample Output: [[15,13,2,5],
                        [14,3,4,1],
                        [12,6,8,9],
                        [16,7,10,11]]


    - Constraints:
        n == matrix.length == matrix[i].length
        1 <= n <= 20
        -1000 <= matrix[i][j] <= 1000
*/

import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{{1, 2, 3},
                                      {4, 5, 6},
                                      {7, 8, 9}};
        rotate(matrix1);
        System.out.println(Arrays.deepToString(matrix1));

        int[][] matrix2 = new int[][]{{1, 2},
                                      {3, 4}};
        rotate(matrix2);
        System.out.println(Arrays.deepToString(matrix2));

        int[][] matrix3 = new int[][]{{1, 2, 3, 4},
                                      {5, 6, 7, 8},
                                      {9, 10, 11, 12},
                                      {13, 14, 15, 16}};
        rotate(matrix3);
        System.out.println(Arrays.deepToString(matrix3));
    }

    /**
     * Rotates the 2-dimensional matrix.
     *
     * @param matrix - the 2-dimensional matrix
     */
    public static void rotate(int[][] matrix) {
        int left = 0;
        int right = matrix.length - 1;

        while (left < right) {
            for (int i = 0; i < right - left; i++) {
                int top = left;
                int bottom = right;

                int topLeft = matrix[top][left + i];

                // move the bottom left into the top left
                matrix[top][left + i] = matrix[bottom - i][left];
                // move the bottom right into the bottom left
                matrix[bottom - i][left] = matrix[bottom][right - i];
                // move the top right into the bottom right
                matrix[bottom][right - i] = matrix[top + i][right];
                // move the top left into the top right
                matrix[top + i][right] = topLeft;
            }
            right -= 1;
            left += 1;
        }
    }

}

/*
    O(n^2) time | O(1) space:
    1. Initialize boundaries in matrix (left = 0 and right will be te last index in array's row)
    2. Traverse while left boundary < right boundary.
        a. Traverse index i until i < right bounds - left bounds (We only need n-1 iterations for each square in our
            matrix).
            e.g.
                Matrix: 4x4
                Outer square = 4x4 -> n = 4; i(0) < right(3) - left(0) = 3; 0 < 3 ? no -> enter for loop.
                Only need 3 iterations since the 4th element will be replaced by the 1st element for outer square.
                Inner square = 2x2 -> n = 2; i(1) < right(2) - left(1) = 1; 1 < 1 ? no -> enter for loop.
                Only need 1 iteration since the 2nd element will be replaced by the 1st element for inner square.
        b. Initialize top and bottom boundaries; top = left, bottom = right since the matrix will always be of size n*n.
        c. Store the top left value in some temporary variable.
        d. Move the bottom left into the top left.
        e. Move the bottom right into the bottom left.
        f. Move the top right into the bottom right.
        g. Move the top left into the top right.
    3. Increment the left boundary by +1 and decrement the right boundary by -1.

*/