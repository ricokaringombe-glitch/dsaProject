package dsa521s;

public class A3A4Test {

    public static void main(String[] args) {

        // ==============================
        // A3 - POSTFIX EVALUATION
        // ==============================

        System.out.println("===== A3 POSTFIX EVALUATION =====");

        String expression = "5 3 + 2 *";

        System.out.println("Expression: " + expression);
        System.out.println();

        Stack stack = new Stack(50);

        stack.push(5);
System.out.println("After reading 5:");
stack.display();
System.out.println("Top of stack: " + stack.peek());

        stack.push(3);
System.out.println("After reading 3:");
stack.display();
System.out.println("Top of stack: " + stack.peek());

        // Step 3: Perform 5 + 3
        int operand2 = stack.pop();
        int operand1 = stack.pop();
        int result = operand1 + operand2;
        stack.push(result);

        System.out.println("After 5 + 3:");
        stack.display();

        // Step 4: Push 2
        stack.push(2);
        System.out.println("After reading 2:");
        stack.display();

        // Step 5: Perform 8 * 2
        operand2 = stack.pop();
        operand1 = stack.pop();
        result = operand1 * operand2;
        stack.push(result);

        System.out.println("After 8 * 2:");
        stack.display();

        // Final result
        int finalResult = stack.pop();

        System.out.println();
        System.out.println("Final Result: " + finalResult);


        // ==============================
        // A4 - DAILY STATISTICS
        // ==============================

        DailyStatistics.displayStatistics();
    }
}