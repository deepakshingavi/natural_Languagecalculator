package com.deepak.training.ncr;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public abstract class Calculator implements ICalculator {

    public String computeSequence(String inputLine) {
        Stack<String> inputStack = divide(inputLine);
        String value = inputStack.pop();
        Stack<String> tempStack = multiply(inputStack, value);
        value = subtractAndAdd(tempStack);
        value = formattingResult(value);
        return value;
    }

    public String formattingResult(String value) {
        boolean isFloat =  Double.parseDouble(value) % 1 != 0;
        value =  new BigDecimal(value).setScale(isFloat ? 2:0, isFloat ? RoundingMode.HALF_UP:RoundingMode.UP).toString();
        return value;
    }
}
