package com.deepak.training.ncr;

public enum WordToNumber {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    ZERO("0");

    private final String num;

    WordToNumber( String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }
}
