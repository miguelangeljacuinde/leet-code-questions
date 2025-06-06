package strings.mid;

import java.util.ArrayList;
import java.util.List;

/*
    #22
     Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    - Example 1:
        Input: n = 3
        Output: ["((()))","(()())","(())()","()(())","()()()"]

    - Example 2:
        Input: n = 1
        Output: ["()"]

    - Constraints:
        1 <= n <= 8
*/

public class GenerateParentheses {

    /**
     * This method generates all combinations of well-formed parentheses for a given number of pairs.
     *
     * @param n The number of pairs of parentheses.
     * @return A list of strings representing all combinations of well-formed parentheses.
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper("", 0, 0, n, result);
        return result;
    }

    /**
     * Helper method to generate parentheses recursively.
     *
     * @param current The current string being built.
     * @param open The number of open parentheses used.
     * @param close The number of close parentheses used.
     * @param max The maximum number of pairs of parentheses.
     * @param result The list to store the valid combinations.
     */
    private static void generateParenthesisHelper(String current, int open, int close, int max, List<String> result) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        if (open < max) {
            generateParenthesisHelper(current + "(", open + 1, close, max, result);
        }
        if (close < open) {
            generateParenthesisHelper(current + ")", open, close + 1, max, result);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateParenthesis(n);
        System.out.println(result);

        n = 1;
        result = generateParenthesis(n);
        System.out.println(result);
    }

}

/*
    O(n * 2^n) time | O(2^n) space
        n = the number of pairs of parentheses.
    1. Initializes an empty list to store the results.
    2. Calls the helper function to generate combinations recursively (The helper function builds the current string
        of parentheses).
        a. If the current string length equals 2 * n, it adds the string to the result list.
        b. If the number of open parentheses is less than n, it adds an open parenthesis and recurses.
        c. If the number of close parentheses is less than the number of open parentheses, it adds a close parenthesis
            and recurses.
*/