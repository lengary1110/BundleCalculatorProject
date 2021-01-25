package com.gradle.codechallenge;

/**
 * @author lengary1110
 */

public class Calculator {

    public static void main(String[] args) {

        OrderInput input = new OrderInput();
        OrderOutput output = new OrderOutput();
        output.output(input.input());
    }

}
