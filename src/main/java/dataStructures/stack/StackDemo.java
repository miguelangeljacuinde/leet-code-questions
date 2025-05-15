package dataStructures.stack;

public class StackDemo {

    public Node top;
    public int height;

    /*
     * Creates a stack with the given value.
     */
    public StackDemo(int value) {
        top = new Node(value);
        height = 1;
    }

    /*
     * Node Class
     */
    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    /*
     * Peeks the top element of the stack.
     */
    public void peek() {
        System.out.println("Top element: " + top.value);
    }

    /*
     * Gets the height of the stack.
     */
    public void getHeight() {
        System.out.println("Height of stack: " + height);
    }

    /*
     * Returns true if the stack is empty.
     */
    public boolean isEmpty() {
        return height == 0;
    }

    /**
     * Pushes a new value onto the stack.
     *
     * @param value - the value of the node to push
     */
    public void push(int value) {
        Node newNode = new Node(value);
        if (height != 0) {
            newNode.next = top;
        }
        top = newNode;
        height++;
    }

    /**
     * Pops the top value from the stack.
     *
     * @return - the popped node
     */
    public Node pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return null;
        }
        Node poppedNode = top;
        top = top.next;
        poppedNode.next = null;
        height--;
        return poppedNode;
    }

    /**
     * Inserts a value at the bottom of the stack.
     *
     * @param value - the value to insert
     */
    public void insertAtBottom(int value) {
        if (top == null) {
            push(value);
        }
        Node current = top;
        while (current.next != null) {
            current = current.next;
        }
        Node newNode = new Node (value);
        current.next = newNode;
        newNode.next = null;
        height++;
    }

    /**
     * Deletes the bottom value from the stack.
     *
     * @return - the deleted node
     */
    public Node deleteAtBottom() {
        Node removedNode;
        if (top == null) {
            System.out.println("Stack is empty");
            return null;
        } else if (top.next == null) {
            removedNode = top;
            top = null;
        } else {
            Node current = top;
            Node prev;
            while (current.next.next != null) {
                current = current.next;
            }
            prev = current;
            removedNode = current.next;
            prev.next = null;
        }
        height--;
        return removedNode;
    }

    public static void main(String[] args) {
        StackDemo stack = new StackDemo(1);
        System.out.println("Stack : ");
        stack.printStack();
        stack.peek();
        stack.getHeight();
        System.out.println("-----------------");

        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Stack : ");
        stack.printStack();
        stack.peek();
        stack.getHeight();
        System.out.println("-----------------");

        System.out.println("Popped Node : " + stack.pop().value);
        System.out.println("Stack : ");
        stack.printStack();
        stack.peek();
        stack.getHeight();
        System.out.println("-----------------");

        stack.insertAtBottom(0);
        System.out.println("Stack : ");
        stack.printStack();
        stack.peek();
        stack.getHeight();
        System.out.println("-----------------");

        System.out.println("Removed Node : " + stack.deleteAtBottom().value);
        System.out.println("Stack : ");
        stack.printStack();
        stack.peek();
        stack.getHeight();
        System.out.println("-----------------");
    }

    /*
     * Pushes a new value onto the stack.
     */
    public void printStack() {
        Node current = top;
        while (current != null) {
            System.out.println("        " + current.value);
            current = current.next;
        }
    }

}
