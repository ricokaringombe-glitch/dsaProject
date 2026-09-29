public class PostfixEvaluator {
    private int[] stack;
    private int top;
    private int capacity;

    public PostfixEvaluator(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = -1;
    }

    public void push(int value) {
        if (top == capacity - 1) { System.out.println("Stack overflow"); return; }
        stack[++top] = value;
    }

    public int pop() {
        if (top == -1) { System.out.println("Stack underflow"); return -1; }
        return stack[top--];
    }

    public int peek() {
        if (top == -1) return -1;
        return stack[top];
    }

    public boolean isEmpty() { return top == -1; }

    public int evaluate(String expression) {
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (token.matches("-?\\d+")) {
                push(Integer.parseInt(token));
            } else {
                int operand2 = pop();
                int operand1 = pop();
                int result = 0;
                switch (token) {
                    case "+": result = operand1 + operand2; break;
                    case "-": result = operand1 - operand2; break;
                    case "x": case "*": result = operand1 * operand2; break;
                    case "/": result = operand1 / operand2; break;
                    default: System.out.println("Unknown operator: " + token);
                }
                push(result);
            }
            System.out.println("Stack after " + token + ": " + this);
        }
        return pop();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            sb.append(stack[i]);
            if (i < top) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}