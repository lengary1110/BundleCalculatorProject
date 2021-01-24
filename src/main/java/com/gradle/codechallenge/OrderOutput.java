package com.gradle.codechallenge;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class OrderOutput {

    String outputFilename = "output.txt";


    public void output(Scanner input) {

        try {
            PrintStream out = new PrintStream(outputFilename);
            System.setOut(out);
            FiledOrder pf = new FiledOrder();
            Calculator calculator = new Calculator();
            calculator.readFiledOrder(pf.ParseFile(input));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
