package com.example.midori.project1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by midori on 2017/12/28.
 */

public class CalculatorController {
    private String mathExpression;
    public String result;

    public boolean invalidStringMathExpression(String mathExpression) {
        boolean isConsequenceOfOperator = false;
        for (int i = 0; i < mathExpression.length(); i++) {
            if (i == mathExpression.length() - 1 || i == 0) {
                if(isOperator(mathExpression.charAt(i))) {
                    return false;
                }
            }
            if (isOperator(mathExpression.charAt(i))) {
                if (isConsequenceOfOperator) {
                    return false;
                }
                isConsequenceOfOperator = true;
                continue;
            }
            isConsequenceOfOperator = false;
        }
        setMathExpression(mathExpression);
        setResult();
        return true;
    }

    private boolean isOperator(char character) {
        return Arrays.asList('+', '-', '*', '/').contains(character);
    }

    private void setMathExpression(String mathExpression){
        this.mathExpression = mathExpression;
    }

    public String getMathExpression(){
        return mathExpression;
    }

    private void setResult(){
        this.result = handleOperation(
                handleOperationMultiplicationAndDivisionOnList(
                        convertStringToList(mathExpression)));
    }

    public String getResult(){
        return result;
    }

    public List<String> convertStringToList(String mathExpression) {
        int previous = 0, current;
        char currentChar;
        List<String> result = new ArrayList<>();

        for (current = 0; current < mathExpression.length(); current++) {
            currentChar = mathExpression.charAt(current);
            if (Arrays.asList('+', '-', '*', '/').contains(currentChar)) {
                if (previous < current) result.add(mathExpression.substring(previous, current));
                result.add(currentChar + "");
                previous = current + 1;
            }
        }
        if (previous < current) {
            result.add(mathExpression.substring(previous, current));
        }
        return result;
    }

    //List contains operation(+,-,*,/) to List contains operation(+,-)
    public List<String> handleOperationMultiplicationAndDivisionOnList(List<String> mathExpressionList) {
        double temp = 0;
        String current, next, pre = "";

        for (ListIterator<String> mathExpressionIterator = mathExpressionList.listIterator(); mathExpressionIterator.hasNext(); ) {

            if (mathExpressionIterator.nextIndex() == 0) {
                pre = String.valueOf(mathExpressionIterator.next());
                continue;
            }
            current = String.valueOf(mathExpressionIterator.next());

            if (Arrays.asList("*", "/").contains(current)) {
                if (!mathExpressionIterator.hasNext()) break;
                if (current.equals("*")) {
                    temp = Double.parseDouble(pre) * Double.parseDouble(String.valueOf(mathExpressionIterator.next()));
                }
                if (current.equals("/")) {
                    temp = Double.parseDouble(pre) / Double.parseDouble(String.valueOf(mathExpressionIterator.next()));
                }
                mathExpressionIterator.previous();
                mathExpressionIterator.set(temp + "");
                mathExpressionIterator.previous();
                mathExpressionIterator.remove();
                mathExpressionIterator.previous();
                mathExpressionIterator.remove();
            }
            pre = String.valueOf(current);
        }
        return mathExpressionList;
    }

    //List contains operation(+,-) to result
    public String handleOperation(List<String> mathExpressionList){
        double result=0d;
        int flag=0;
        String temp;
        for (Iterator<String> iterator = mathExpressionList.iterator();iterator.hasNext();) {
            temp = iterator.next().toString();
            if (flag == 0) {
                result = Double.parseDouble(temp);
                flag++;
            }
            if (Arrays.asList("+","-").contains(temp)) {
                if (!iterator.hasNext()) return null;
                if (temp.equals("+")) result = result + Double.parseDouble((iterator.next()).toString());
                if (temp.equals("-")) result = result - Double.parseDouble((iterator.next()).toString());
            }
        }
        return result+"";
    }
}
