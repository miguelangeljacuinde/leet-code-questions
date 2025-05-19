package stacks.easy;

import dataStructures.stack.StackArrayListDemo;

/*
    The reverseString method takes a single parameter String, which is the string you want to reverse. Return a new
    String with the letters in reverse order.

    Note : This will use the Stack class we created in the Data Structures module.

    - Example 1:
        Sample Input: "hello"
        Sample Output: "olleh"

    - Example 2:
        Sample Input: "world"
        Sample Output: "dlrow"

    - Constraints:
        1 <= string.length <= 10^5
        string consists of printable ASCII characters.
*/

public class ReverseString {

    /**
     * This method reverses a given string.
     *
     * @param string - the string to be reversed
     * @return - the reversed string
     */
    public static String reverse(String string) {
        StackArrayListDemo<Character> stack = new StackArrayListDemo<>();
        StringBuilder reversedString = new StringBuilder();

        char [] charArray = string.toCharArray();
        for (char c : charArray) {
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }
        return reversedString.toString();
    }

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "world";

        System.out.println("Original String : " + str1);
        System.out.println("Reversed String : " + reverse(str1));

        System.out.println();

        System.out.println("Original String : " + str2);
        System.out.println("Reversed String : " + reverse(str2));
    }
}

/*
    O(n) time | O(n) space
        n = the length of the string.
    1. Initialize a stack to hold the characters of the string.
    2. Initialize a StringBuilder to hold the reversed string.
    3. Convert the string to a character array.
    4. Push each character of the string onto the stack.
    5. While the stack is not empty, pop each character from the stack and append it to the StringBuilder.
    6. Convert the StringBuilder to a string and return it.
*/
