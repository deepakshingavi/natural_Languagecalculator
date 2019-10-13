package com.deepak.training.ncr;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class CalculatorImpl extends Calculator {

    public Stack<String> divide(String inputLine) {
        String[] inputArr = inputLine.split(" ");
        Stack<String> inputStack = new Stack<>();

        //Validation , parsing and division operation
        for (int i = 0; i < inputArr.length; i++) {
            String value = i % 2 == 0 ? WordToNumber.valueOf(inputArr[i]).getNum() : OPERATORS.findEnum(inputArr[i]).getOperator();
            if (value.equals(OPERATORS.DIVIDED_BY.getOperator())) {
                value = new BigDecimal(inputStack.pop()).divide(new BigDecimal(WordToNumber.valueOf(inputArr[++i]).getNum()), 5, RoundingMode.HALF_UP).toString();
            }
            inputStack.push(value);
        }
        return inputStack;
    }

    public Stack<String> multiply(Stack<String> inputStack, String value) {
        Stack<String> tempStack = new Stack<>();
        tempStack.push(value);
        while (!inputStack.isEmpty()) {
            String temp = inputStack.pop();
            if (temp.equals(OPERATORS.TIMES.getOperator())) {
                temp = new BigDecimal(value).multiply(new BigDecimal(inputStack.pop())).toString();
                tempStack.pop();
            }
            value = temp;
            tempStack.push(value);
        }
        return tempStack;
    }


    public String subtractAndAdd(Stack<String> tempStack) {
        String value = tempStack.pop();
        //Perform addition and subtraction operations operations
        while (!tempStack.isEmpty()) {
            String tempValue = tempStack.pop();
            if (tempValue.equals(OPERATORS.ADD.getOperator())) {
                value = new BigDecimal(value).add(new BigDecimal(tempStack.pop())).toString();
            } else {
                value = new BigDecimal(value).subtract(new BigDecimal(tempStack.pop())).toString();
            }
        }
        return value;
    }

}
