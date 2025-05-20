package stacks.easy;

import java.util.Stack;

/*
    #232
    Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the
    functions of a normal queue (push, peek, pop, and empty).

    Implement the MyQueue class:
        1. void push(int x) Pushes element x to the back of the queue.
        2. int pop() Removes the element from the front of the queue and returns it.
        3. int peek() Returns the element at the front of the queue.
        4. boolean empty() Returns true if the queue is empty, false otherwise.

    Notes: You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and
    is empty operations are valid. Depending on your language, the stack may not be supported natively. You may simulate
    a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.

    - Example 1:
    Sample Input:
        ["MyQueue", "push", "push", "peek", "pop", "empty"]
        [[], [1], [2], [], [], []]
    Sample Output:
        [null, null, null, 1, 1, false]

    Explanation:
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false

    - Constraints:
        1 <= x <= 9
        At most 100 calls will be made to push, pop, peek, and empty.
        All the calls to pop and peek are valid.

    - Follow-up:
        Can you implement the queue such that each operation is amortized O(1) time complexity?
        In other words, performing n operations will take overall O(n) time even if one of those operations may take
        longer.
*/

public class ImplementQueueUsingStacks {

    static class MyQueue {

        private final Stack<Integer> stack1;
        private final Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /**
         * Pushes element x to the back of the queue.
         */
        public void push(int x) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(x);
        }

        /**
         * Removes the element from the front of the queue and returns it.
         */
        public int pop() {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return stack1.pop();
        }

        /**
         * Returns the element at the front of the queue.
         */
        public int peek() {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return stack1.peek();
        }

        /**
         * Returns true if the queue is empty, false otherwise.
         */
        public boolean empty() {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return stack1.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
}
