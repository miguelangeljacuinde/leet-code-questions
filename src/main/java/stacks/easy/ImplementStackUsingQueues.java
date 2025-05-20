package stacks.easy;

import java.util.LinkedList;
import java.util.Queue;

/*
    #225
    Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the
    functions of a normal stack (push, top, pop, and empty).

    Implement the MyStack class:
        1. void push(int x) Pushes element x to the top of the stack.
        2. int pop() Removes the element on the top of the stack and returns it.
        3. int top() Returns the element on the top of the stack.
        4. boolean empty() Returns true if the stack is empty, false otherwise.

    Notes:
    You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and
    is empty operations are valid.
    Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque
    (double-ended queue) as long as you use only a queue's standard operations.

    - Example 1:
        Sample Input:
            ["MyStack", "push", "push", "top", "pop", "empty"]
            [[], [1], [2], [], [], []]
        Sample Output:
            [null, null, null, 2, 2, false]

        Explanation:
            MyStack myStack = new MyStack();
            myStack.push(1);
            myStack.push(2);
            myStack.top(); // return 2
            myStack.pop(); // return 2
            myStack.empty(); // return False


    - Constraints:
        1 <= x <= 9
        At most 100 calls will be made to push, pop, top, and empty.
        All the calls to pop and top are valid.

    - Follow-up: Can you implement the stack using only one queue?
*/

public class ImplementStackUsingQueues {

    static class MyStack1 {

        private Queue<Integer> queue1;
        private Queue<Integer> queue2;

        public MyStack1() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        /**
         * Pushes element x to the top of the stack.
         */
        public void push(int x) {
            queue2.add(x);
            while (!queue1.isEmpty()) {
                queue2.add(queue1.poll());
            }
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        /**
         * Removes the element on the top of the stack and returns it.
         */
        public int pop() {
            if (queue1.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return queue1.poll();
        }

        /**
         * Returns the element on the top of the stack.
         */
        public int top() {
            if (queue1.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return queue1.peek();
        }

        /**
         * Returns true if the stack is empty, false otherwise.
         */
        public boolean empty() {
            return queue1.isEmpty();
        }
    }

    /* Follow-up: Implementing the stack using only one queue */
    static class MyStack2 {

        Queue<Integer> queue;

        public MyStack2() {
            queue = new LinkedList<>();
        }

        /**
         * Pushes element x to the top of the stack.
         */
        public void push(int x) {
            queue.add(x);
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.add(queue.poll());
            }
        }

        /**
         * Removes the element on the top of the stack and returns it.
         */
        public int pop() {
            if (queue.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return queue.poll();
        }

        /**
         * Returns the element on the top of the stack.
         */
        public int top() {
            if (queue.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return queue.peek();
        }

        /**
         * Returns true if the stack is empty, false otherwise.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack1 myStack = new MyStack1();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());

        System.out.println();

        MyStack2 myStack2 = new MyStack2();
        myStack2.push(1);
        myStack2.push(2);
        System.out.println(myStack2.top());
        System.out.println(myStack2.pop());
        System.out.println(myStack2.empty());
    }

}
