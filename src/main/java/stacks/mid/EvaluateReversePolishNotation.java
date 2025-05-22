package stacks.mid;

/*
    #150
    You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

    Evaluate the expression. Return an integer that represents the value of the expression.

    Note that:
        1. The valid operators are '+', '-', '*', and '/'.
        2. Each operand may be an integer or another expression.
        3. The division between two integers always truncates toward zero.
        4. There will not be any division by zero.
        5. The input represents a valid arithmetic expression in a reverse polish notation.
        6. The answer and all the intermediate calculations can be represented in a 32-bit integer.

    - Example 1:
        Sample Input: tokens = ["2","1","+","3","*"]
        Sample Output: 9

        Explanation: ((2 + 1) * 3) = 9

    - Example 2:
        Sample Input: tokens = ["4","13","5","/","+"]
        Sample Output: 6

        Explanation: (4 + (13 / 5)) = 6

    - Example 3:
        Sample Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
        Sample Output: 22

        Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
            = ((10 * (6 / (12 * -11))) + 17) + 5
            = ((10 * (6 / -132)) + 17) + 5
            = ((10 * 0) + 17) + 5
            = (0 + 17) + 5
            = 17 + 5
            = 22

    - Constraints:
        1 <= tokens.length <= 104
        tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
*/

import java.util.Objects;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    /**
     * This method evaluates the expression in Reverse Polish Notation.
     *
     * @param tokens - the input array of tokens representing the expression
     * @return - the evaluated result of the expression
     */
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        String[] operators = {"+", "-", "*", "/"};

        for (String token : tokens) {
            if (isOperator(token , operators)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = 0;

                switch (token) {
                    case "+" -> result = a + b;
                    case "-" -> result = a - b;
                    case "*" -> result = a * b;
                    case "/" -> result = a / b;
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    /**
     * This method checks if the given token is an operator.
     *
     * @param token - the input token
     * @param operators - the array of valid operators
     * @return - true if the token is an operator, false otherwise
     */
    public static boolean isOperator(String token, String[] operators) {
        for (String operator : operators) {
            if (token.equals(operator)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println("Original tokens: ");
        printArray(tokens);
        int result = evalRPN(tokens);
        System.out.println("Result: " + result);

        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println("Original tokens: ");
        printArray(tokens2);
        int result2 = evalRPN(tokens2);
        System.out.println("Result: " + result2);

        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println("Original tokens: ");
        printArray(tokens3);
        int result3 = evalRPN(tokens3);
        System.out.println("Result: " + result3);
    }

    /**
     * This method prints the elements of the array.
     *
     * @param tokens - the input array of tokens
     */
    public static void printArray(String[] tokens) {
        for (String token : tokens) {
            System.out.print(token + " ");
        }
        System.out.println();

    }

}

/*
    O(n) time | O(n) space
        n = length of the input tokens.
    1. Initialize a stack to hold the operands.
    2. Initialize a String array of valid operators.
    3. Traverse each token in the input array.
        a. If the token is an operator, pop the top two elements from the stack.
            i. Perform the operation based on the operator and push the result back to the stack.
        b. Else, parse the token as an integer and push it to the stack.
    4. If the stack is not empty, pop the top element and return it as the result.
*/