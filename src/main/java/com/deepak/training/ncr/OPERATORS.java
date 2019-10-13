package com.deepak.training.ncr;

import java.util.Arrays;

public enum OPERATORS {
    ADD("ADD","+"),
    PLUS("PLUS","+"),
    MINUS("MINUS","-"),
    TIMES("TIMES","*"),
    OVER("OVER","/"),
    DIVIDED_BY("DIVIDED-BY","/");


    private final String opStr;
    private final String operator;

    OPERATORS(String opStr, String operator) {
        this.opStr=opStr;
        this.operator=operator;
    }

    public String getOperator() {
        return operator;
    }

    public String getOpStr() {
        return opStr;
    }

    public static OPERATORS findEnum(String opStr){
        return Arrays.asList(OPERATORS.values()).stream().filter( op -> op.getOpStr().equalsIgnoreCase(opStr)).findFirst().get();
    }
}
