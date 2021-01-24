package com.gradle.tutorial;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Output {

    String outputFilename = "output.txt";

    public void output(Scanner input) {

        try {
            PrintStream out = new PrintStream(outputFilename);
            System.setOut(out);
            Calculator calculator = new Calculator();
            ParseFile pf = new ParseFile();
            calculator.setFormatTable();
            calculator.readFormatCollocation(pf.ParseFile(input));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
