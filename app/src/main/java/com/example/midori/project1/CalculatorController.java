package com.example.midori.project1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by midori on 2017/12/28.
 */
public class CalculatorController {
    private String result;

    public boolean invalidStringMathExpression(String mathExpression) {
        boolean isConsequenceOfOperator = false;
        for (int i = 0; i < mathExpression.length(); i++) {
            if (i == mathExpression.length() - 1 || i == 0) {
                if (isOperator(mathExpression.charAt(i))) {
                    return false;
                }
            }
            if (!isOperator(mathExpression.charAt(i))) {
                isConsequenceOfOperator = false;
                continue;
            }

            if (isConsequenceOfOperator) {
                return false;
            }
            isConsequenceOfOperator = true;
        }
        setResult(mathExpression);
        return true;
    }

    private boolean isOperator(char character) {
        return Arrays.asList('+', '-', '*', '/').contains(character);
    }

    private void setResult(String mathExpression) {
        this.result = handleOperation(
                handleOperationMultiplicationAndDivisionOnList(
                        convertStringToList(mathExpression)));
    }

    public String getResult() {
        return result;
    }

    List<String> convertStringToList(String mathExpression) {
        int previous = 0;
        List<String> result = new ArrayList<>();

        for (int i = 0; i < mathExpression.length(); i++) {
            char currentChar = mathExpression.charAt(i);
            if (isOperator(currentChar)) {
                if (previous < i) {
                    result.add(mathExpression.substring(previous, i));
                }
                result.add(String.valueOf(currentChar));
                previous = i + 1;
            }
        }
        if (previous < mathExpression.length() - 1) {
            result.add(mathExpression.substring(previous, mathExpression.length()));
        }
        return result;
    }

    // List contains operation(+,-,*,/) to List contains operation(+,-)
    List<String> handleOperationMultiplicationAndDivisionOnList(List<String> mathExpressionList) {
        Queue<String> queue = new LinkedList<>(mathExpressionList);
        Stack<String> stack = new Stack<>();
        for (; ; ) {
            if (queue.isEmpty()) {
                break;
            }

            String str = queue.poll();
            if (str.equals("*")) {
                stack.push(String.valueOf(Double.parseDouble(stack.pop()) * Double.parseDouble(queue.poll())));
                continue;
            }
            if (str.equals("/")) {
                stack.push(String.valueOf(Double.parseDouble(stack.pop()) / Double.parseDouble(queue.poll())));
                continue;
            }
            stack.push(str);
        }
        return new ArrayList<>(stack);
    }

    //List contains operation(+,-) to result
    String handleOperation(List<String> mathExpressionList) {
        Queue<String> queue = new LinkedList<>(mathExpressionList);
        Stack<Double> stack = new Stack<>();
        for (; ; ) {
            if (queue.isEmpty()) {
                break;
            }

            String str = queue.poll();
            if (str.equals("+")) {
                stack.push(stack.pop() + Double.parseDouble(queue.poll()));
                continue;
            }
            if (str.equals("-")) {
                stack.push(stack.pop() - Double.parseDouble(queue.poll()));
                continue;
            }
            stack.push(Double.parseDouble(str));
        }

        return String.valueOf(stack.pop());
    }
}
