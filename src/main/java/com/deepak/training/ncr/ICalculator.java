package com.deepak.training.ncr;

import java.util.NoSuchElementException;
import java.util.Stack;

public interface ICalculator {

    /**
     * Evaluates all division expressions
     * @param inputLine Raw and transformed expression
     * @return Reverse order of the expression
     */
    public Stack<String> divide(String inputLine);

    /**
     * Evaluates all multiplication expressions
     * @param inputStack
     * @param value
     * @return Stack with numbers and +/- operators and correct order of the expression
     */
    Stack<String> multiply(Stack<String> inputStack, String value);

    /**
     *
     * @param tempStack - Stack of numbers and operators in the right sequence.
     * @return final value
     */
    String subtractAndAdd(Stack<String> tempStack);


    String computeSequence(String inputLine) throws NoSuchElementException;

    /**
     * Format the value based on value type. Trimming decimals for int and rounding up for decimal up to 2 places.
     *
     * @param value - Final value
     * @return formatted value e.g. 1.116 -> 1.12, 2.00 -> 2
     */
    String formattingResult(String value);

}
