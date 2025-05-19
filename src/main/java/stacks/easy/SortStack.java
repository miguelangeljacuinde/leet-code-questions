package stacks.easy;

import java.util.Stack;

/*
      The method should sort the elements in the stack in ascending order.
      The lowest value will be at the top of the stack using only one additional stack.

        - Example 1:
            Sample Input: stack = [2, 4, 1, 5, 3]
            Sample Output: stack = [1, 2, 3, 4, 5]

        - Example 2:
            Sample Input: stack = [5, 4, 3, 2, 1]
            Sample Output: stack = [1, 2, 3, 4, 5]

        - Example 3:
            Sample Input: stack = [1]
            Sample Output: stack = [1]

        - Constraints:
            1 <= stack.length <= 10^5
            1 <= stack[i] <= 10^5
            stack consists of integers.
*/

public class SortStack {

    /**
     * This method sorts a stack in ascending order using an additional stack.
     *
     * @param stack - the stack to be sorted
     */
    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            int currentNumber = stack.pop();
            while (!tempStack.isEmpty() && tempStack.peek() > currentNumber) {
                stack.push(tempStack.pop());
            }
            tempStack.push(currentNumber);
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(5);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);

        System.out.println();

        Stack<Integer> stack2 = new Stack<>();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(4);
        stack2.push(5);
        System.out.println("Original Stack: " + stack2);
        sortStack(stack2);
        System.out.println("Sorted Stack: " + stack2);

        System.out.println();

        Stack<Integer> stack3 = new Stack<>();
        stack3.push(1);
        System.out.println("Original Stack: " + stack3);
        sortStack(stack3);
    }

}

/*
    O(n^2) time | O(n) space
        n = the number of elements in the stack.
    1. Initialize a temporary stack to hold the sorted elements.
    2. While the original stack is not empty:
        a. Pop the top element from the original stack.
        b. While the temporary stack is not empty and the top element of the temporary stack is greater than the
            current number:
            i. Pop the top element from the temporary stack and push it back to the original stack.
        c. Push the current number onto the temporary stack.
    3. While the temporary stack is not empty:
        a. Pop the top element from the temporary stack and push it back to the original stack to get the correct
            sorted order.
*/
