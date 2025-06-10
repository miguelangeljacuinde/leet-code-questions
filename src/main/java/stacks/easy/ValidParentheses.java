package stacks.easy;

import java.util.Stack;

/*
    #20
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is
    valid.

    An input string is valid if:
    1. Open brackets must be closed by the same type of brackets.
    2. Open brackets must be closed in the correct order.
    3. Every close bracket has a corresponding open bracket of the same type.

    - Example 1:
        Sample Input: s = "()"
        Sample Output: true

    - Example 2:
        Sample Input: s = "()[]{}"
        Sample Output: true

    - Example 3:
        Sample Input: s = "(]"
        Sample Output: false

    - Example 4:
        Sample Input: s = "([])"
        Sample Output: true

    - Constraints:
        1 <= s.length <= 104
        s consists of parentheses only '()[]{}'.
*/

public class ValidParentheses {

    /**
     * This method checks if the given string of parentheses is valid.
     *
     * @param s - the string to be checked
     * @return - true if the string is valid, false otherwise
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([])";

        System.out.println("Is valid: " + s1 + " : " + isValid(s1));
        System.out.println("Is valid: " + s2 + " : " + isValid(s2));
        System.out.println("Is valid: " + s3 + " : " + isValid(s3));
        System.out.println("Is valid: " + s4 + " : " + isValid(s4));
    }
}

/*
    O(n) time | O(n) space
        n = the length of the string.
    1. Initialize a stack to hold the closing brackets.
    2. Convert the string to a character array.
    3. For each character in the array:
        a. If it is an opening bracket, push the corresponding closing bracket onto the stack.
        b. If it is a closing bracket, check if the stack is empty or if the top of the stack does not match the current
          character. If either condition is true, return false.
    4. After processing all characters, check if the stack is empty. If it is, return true; otherwise, return false.
*/
