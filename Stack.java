package dsa521s;

public class Stack {

    private int[] stack;
    private int top;

    // Constructor
    public Stack(int size) {
        stack = new int[size];
        top = -1;
    }

    // Push a value onto the Stack
    public void push(int value) {
        if (top == stack.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }

        top++;
        stack[top] = value;
    }

    // Remove and return the top value
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }

        int value = stack[top];
        top--;

        return value;
    }

    // Return the top value without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        return stack[top];
    }

    // Check whether the Stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Display the Stack contents
    public void display() {
        System.out.print("Stack: ");

        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }

        System.out.println();
    }
}
