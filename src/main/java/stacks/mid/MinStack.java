package stacks.mid;

/*
    #155
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    Implement the MinStack class:
        1. MinStack() initializes the stack object.
        2. void push(int val) pushes the element val onto the stack.
        3. void pop() removes the element on the top of the stack.
        4. int top() gets the top element of the stack.
        5. int getMin() retrieves the minimum element in the stack.
        6. You must implement a solution with O(1) time complexity for each function.

    - Example 1:
        Sample Input:
            ["MinStack","push","push","push","getMin","pop","top","getMin"]
            [[],[-2],[0],[-3],[],[],[],[]]
        Sample Output:
            [null,null,null,null,-3,null,0,-2]

        Explanation
            MinStack minStack = new MinStack();
            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);
            minStack.getMin(); // return -3
            minStack.pop();
            minStack.top();    // return 0
            minStack.getMin(); // return -2

    - Constraints:
        -231 <= val <= 231 - 1
        Methods pop, top and getMin operations will always be called on non-empty stacks.
        At most 3 * 104 calls will be made to push, pop, top, and getMin.
*/

public class MinStack {

    private Node top;

    private static class Node {
        int value;
        int min;
        Node next;

        Node(int value, int min, Node next) {
            this.value = value;
            this.min = min;
            this.next = next;
        }
    }

    public MinStack() {
    }

    /**
     * Pushes element val onto the stack.
     */
    public void push(int val) {
        if (top == null) {
            top = new Node(val, val, null);
        } else {
            top = new Node(val, Math.min(val, top.min), top);
        }
    }

    /**
     * Removes the element on the top of the stack.
     */
    public void pop() {
        Node popped = top;
        top = top.next;
        popped.next = null;
    }

    /**
     * @return - the top element of the stack
     */
    public int top() {
        return top.value;
    }

    /**
     * @return - the minimum element in the stack
     */
    public int getMin() {
        return top.min;
    }

    /**
     * Prints the stack elements.
     */
    public void printStack() {
        System.out.println("-----------------");
        System.out.println("Stack : ");
        Node current = top;
        while (current != null) {
            System.out.println("        " + current.value);
            current = current.next;
        }
        System.out.println("-----------------");
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        System.out.println("Pushed Element...");
        minStack.push(0);
        System.out.println("Pushed Element...");
        minStack.push(-3);
        System.out.println("Pushed Element...");
        minStack.printStack();
        System.out.println("Min Stack : " + minStack.getMin());
        minStack.pop();
        System.out.println("Popped Top Element...");
        minStack.printStack();
        System.out.println("Stack Top : " + minStack.top());
        System.out.println("Min Stack : " + minStack.getMin());

        System.out.println("====================================");
        MinStack minStack2 = new MinStack();
        minStack2.push(1);
        System.out.println("Pushed Element...");
        minStack2.push(2);
        System.out.println("Pushed Element...");
        minStack2.printStack();
        System.out.println("Stack Top : " + minStack2.top());
        System.out.println("Min Stack : " + minStack2.getMin());
        minStack2.pop();
        System.out.println("Popped Top Element...");
        minStack2.printStack();
        System.out.println("Min Stack : " + minStack2.getMin());
        System.out.println("Stack Top : " + minStack2.top());
    }

}

/*
    All methods are O(1) time | O(n) space
        n = the number of elements in the stack.
*/
