package com.gradle.codechallenge;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

public class OrderOutput {

    String outputFilename = "output.txt";

    public void output(List<String> order) {

        try {
            PrintStream out = new PrintStream(outputFilename);
            System.setOut(out);
            BundlesCalculator bundlesCalculator = new BundlesCalculator();
            bundlesCalculator.readOrder(order);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
