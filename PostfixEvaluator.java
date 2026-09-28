package dsa521s;

public class PostfixEvaluator {

    public static int evaluatePostfix(String expression) {

        Stack stack = new Stack(50);

        String[] tokens = expression.split(" ");

        for (String token : tokens) {

            // If the token is a number, push it onto the Stack
            if (token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/")) {

                // Pop the second operand first
                int operand2 = stack.pop();

                // Pop the first operand
                int operand1 = stack.pop();

                int result = 0;

                // Perform the required operation
                if (token.equals("+")) {
                    result = operand1 + operand2;
                } 
                else if (token.equals("-")) {
                    result = operand1 - operand2;
                } 
                else if (token.equals("*")) {
                    result = operand1 * operand2;
                } 
                else if (token.equals("/")) {
                    result = operand1 / operand2;
                }

                // Push the result back onto the Stack
                stack.push(result);

            } else {
                // Token is a number
                int number = Integer.parseInt(token);
                stack.push(number);
            }
        }

        // Final result is the last value on the Stack
        return stack.pop();
    }
}
