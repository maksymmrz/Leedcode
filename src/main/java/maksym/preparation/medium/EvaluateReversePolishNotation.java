package maksym.preparation.medium;

import java.util.Deque;
import java.util.LinkedList;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();

        for (String token : tokens) {
            if (token.matches("-?[0-9]+")) {
                stack.push(Integer.parseInt(token));
            } else {
                int n2 = stack.pop();
                int n1 = stack.pop();
                stack.push(op(n1, n2, token));
            }
        }
        return stack.pop();
    }

    public int op(int n1, int n2, String op) {
        switch (op) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            default:
                return n1 / n2;
        }
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation instance = new EvaluateReversePolishNotation();
        System.out.println(instance.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
