package com.deepak.training.ncr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Entry {

    public static void main(String[] args) {
        new Entry().parse();
    }

    private void parse() {
        try (Scanner sc = new Scanner(System.in)) {
            ICalculator calculator = new CalculatorImpl();
            while (true) {
                if (processInput(sc, calculator)) break;
            }
        } catch (IllegalArgumentException iae) {
            String allowedOpeartors = String.join(" ,", Arrays.stream(OPERATORS.values()).map(OPERATORS::getOpStr).collect(Collectors.toCollection(ArrayList::new)));
            String allowedNumbers = String.join(" ,", Arrays.stream(WordToNumber.values()).map(Enum::toString).collect(Collectors.toCollection(ArrayList::new)));
            System.out.println("Please verify the input.\nEven Places can have `" + allowedOpeartors + "`. \nOdd places can have `" + allowedNumbers + "`.");
            iae.printStackTrace();
            throw iae;
        }
    }

    private boolean processInput(Scanner sc, ICalculator calculator) {
        String  inputLine = readInput(sc);
        if (inputLine == null) return true;
        String value = calculator.computeSequence(inputLine);
//                value = calculator.formattingResult(value);
        System.out.println("Result: " + value + "\n");
        return false;
    }

    private String readInput(Scanner sc) {
        System.out.println("Please enter a calculation:");
        String inputLine = sc.nextLine().toUpperCase().trim();
        if (inputLine.equalsIgnoreCase("quit")) {
            return null;
        }
        return inputLine;
    }
}
