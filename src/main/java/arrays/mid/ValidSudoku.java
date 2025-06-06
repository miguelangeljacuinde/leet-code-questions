package arrays.mid;

import java.util.HashSet;
import java.util.Set;

/*
    #36
    Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following
    rules:

        1. Each row must contain the digits 1-9 without repetition.
        2. Each column must contain the digits 1-9 without repetition.
        3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

    Note: A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.

    - Example 1:
        Input: board =
        [["5","3",".",".","7",".",".",".","."]
        ,["6",".",".","1","9","5",".",".","."]
        ,[".","9","8",".",".",".",".","6","."]
        ,["8",".",".",".","6",".",".",".","3"]
        ,["4",".",".","8",".","3",".",".","1"]
        ,["7",".",".",".","2",".",".",".","6"]
        ,[".","6",".",".",".",".","2","8","."]
        ,[".",".",".","4","1","9",".",".","5"]
        ,[".",".",".",".","8",".",".","7","9"]]
        Output: true

    - Example 2:
        Input: board =
        [["8","3",".",".","7",".",".",".","."]
        ,["6",".",".","1","9","5",".",".","."]
        ,[".","9","8",".",".",".",".","6","."]
        ,["8",".",".",".","6",".",".",".","3"]
        ,["4",".",".","8",".","3",".",".","1"]
        ,["7",".",".",".","2",".",".",".","6"]
        ,[".","6",".",".",".",".","2","8","."]
        ,[".",".",".","4","1","9",".",".","5"]
        ,[".",".",".",".","8",".",".","7","9"]]
        Output: false
        Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are
        two 8's in the top left 3x3 sub-box, it is invalid.

    - Constraints:
        board.length == 9
        board[i].length == 9
        board[i][j] is a digit 1-9 or '.'.
*/

public class ValidSudoku {

    /**
     * This method checks if a given Sudoku board is valid according to the Sudoku rules.
     * It uses a HashSet to track the presence of numbers in rows, columns, and 3x3 boxes.
     *
     * @param board A 2D character array representing the Sudoku board.
     * @return true if the board is valid, false otherwise.
     */
    public static boolean isValidSudokuWithHashSet(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                if (number != '.') {
                    if (!seen.add(number + " in row " + i) ||
                        !seen.add(number + " in column " + j) ||
                        !seen.add(number + " in box " + (i / 3) + "-" + (j / 3))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * This method checks if a given Sudoku board is valid according to the Sudoku rules.
     * It uses boolean arrays to track the presence of numbers in rows, columns, and 3x3 boxes.
     *
     * @param board A 2D character array representing the Sudoku board.
     * @return true if the board is valid, false otherwise.
     */
    public static boolean isValidSudokuWithArrays(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') {
                    continue;
                }
                int n = num - '1';
                int boxIndex = (i / 3) * 3 + (j / 3);
                if (rows[i][n] || cols[j][n] || boxes[boxIndex][n]) {
                    return false;
                }
                rows[i][n] = true;
                cols[j][n] = true;
                boxes[boxIndex][n] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudokuWithHashSet(board));

        char[][] invalidBoard = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'1', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudokuWithArrays(invalidBoard));
    }
}

/*
    With HashSet:
    O(n^2) time | O(n^2) space
        n = 9 (fixed size for Sudoku board)
    1. Initialize a HashSet to keep track of seen numbers.
    2. Iterate through each cell in the board.
        a. If the cell is not empty (not '.'), check if the number has already been seen in the current row, column,
            or 3x3 box.
        b. If it has been seen, return false.
        c. Otherwise, add the number to the HashSet with its row, column, and box context.
    3. If no conflicts are found, return true.

    With Arrays:
    O(n^2) time | O(n^2) space
        n = 9 (fixed size for Sudoku board)
    1. Initialize three boolean arrays to track seen numbers in rows, columns, and boxes.
    2. Iterate through each cell in the board.
        a. If the cell is empty ('.'), continue to the next cell.
        b. Convert the character to an index (0-8).
        c. Calculate the box index using the formula (i / 3) * 3 + (j / 3).
        d. Check if the number has already been seen in the current row, column, or box.
        e. If it has been seen, return false.
        f. Otherwise, mark the number as seen in the respective row, column, and box arrays.
    3. If no conflicts are found, return true.
*/