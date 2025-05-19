package dataStructures.stack;

import java.util.ArrayList;

public class StackArrayListDemo<T> {

    public ArrayList<T> stackList = new ArrayList<>();

    /**
     * Constructor to get the stack.
     */
    public ArrayList<T> getStackList() {
        return stackList;
    }

    /**
     * Prints the stack from top to bottom.
     */
    public void printStack() {
        for (int i = stackList.size()-1; i >= 0; i--) {
            System.out.println("        " + stackList.get(i));
        }
    }

    /**
     * Returns true if the stack is empty.
     *
     * @return - true if the stack is empty
     */
    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    /**
     * Returns the value of the top element in the stack.
     */
    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.get(stackList.size() - 1);
        }
    }

    /**
     * Returns the size of the stack.
     */
    public int size() {
        return stackList.size();
    }

    /**
     * Pushes a new value onto the stack.
     *
     * @param value - the value of the node to push
     */
    public void push(T value) {
        stackList.add(value);
    }

    /**
     * Pops the top element from the stack.
     *
     * @return - the popped value
     */
    public T pop() {
        return stackList.isEmpty() ?
                null :
                stackList.remove(stackList.size() - 1);
    }

    public static void main(String[] args) {
        StackArrayListDemo<Integer> stack = new StackArrayListDemo<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Stack size: " + stack.size());
        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack size after pop: " + stack.size());
        System.out.println("Is stack empty? " + stack.isEmpty());

        System.out.println("Stack elements:");
        stack.printStack();
    }

}
