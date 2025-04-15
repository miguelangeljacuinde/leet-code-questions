package arrays.easy;

import java.util.Arrays;

/*
    You're given a 2-D array of integers. Write a function that returns the transpose of the matrix.

    The transpose of a matrix is a flipped version of thew original matrix across its diagonal (which runs from
    top-left to bottom-right). It switches the row and columns indices of the original matrix.

    You can assume the input matrix always has at least one value; however, its width and height are not necessarily
    the same.

    Sample Input: matrix = [                     matrix = [
                             [1, 2]                         [1, 2],
                           ]                                [3, 4],
                                                            [5, 6]
                                                          ]

    Sample Output:         [                              [
                             [1],                           [1, 3, 5],
                             [2]                            [2, 4, 6]
                           ]                              ]
*/

public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] matrix0 = new int[1][2];
        matrix0[0][0] = 1;
        matrix0[0][1] = 2;

        System.out.println(Arrays.deepToString(matrix0));
        System.out.println(Arrays.deepToString(transposeMatrix(matrix0)));
        System.out.println();

        int[][] matrix1 = new int[3][2];
        matrix1[0][0] = 1;
        matrix1[0][1] = 2;
        matrix1[1][0] = 3;
        matrix1[1][1] = 4;
        matrix1[2][0] = 5;
        matrix1[2][1] = 6;

        System.out.println(Arrays.deepToString(matrix1));
        System.out.println(Arrays.deepToString(transposeMatrix(matrix1)));
        System.out.println();

        int[][] matrix2 = new int[3][3];
        matrix2[0][0] = 1;
        matrix2[0][1] = 2;
        matrix2[0][2] = 3;
        matrix2[1][0] = 4;
        matrix2[1][1] = 5;
        matrix2[1][2] = 6;
        matrix2[2][0] = 7;
        matrix2[2][1] = 8;
        matrix2[2][2] = 9;

        System.out.println(Arrays.deepToString(matrix2));
        System.out.println(Arrays.deepToString(transposeMatrix(matrix2)));
        System.out.println();

        int[][] edgeCase1 = new int[1][1];
        edgeCase1[0][0] = 1;

        System.out.println(Arrays.deepToString(edgeCase1));
        System.out.println(Arrays.deepToString(transposeMatrix(edgeCase1)));
    }

    /**
     * @param matrix - the input matrix
     * @return - the transposed matrix
     */
    public static int[][] transposeMatrix(int[][] matrix) {
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
        for (int row = 0; row < matrix[0].length; row++) {
            for (int column = 0; column < matrix.length; column++) {
                transposedMatrix[row][column] = matrix[column][row];
            }
        }
        return transposedMatrix;
    }

}

/*
    O(w*h) time | O(w*h) space
        w = width of matrix
        h = height of matrix
    1. Init. the transpose matrix we will be returning with matrix[0].length as row and matrix.length as column (can
        be reversed).
    2. Traverse row by row.
    3. Traverse column by column.
    4. Do the transpose by setting the transposed matrix row = input matrix column. Then set the transposed matrix
        column = input matrix row (can be reversed as mentioned but step 2 will be step 3 and step 3 will be step 2).
*/