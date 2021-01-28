package com.gradle.codechallenge;

import com.gradle.codechallenge.algorithm.BundlesCalculator;
import com.gradle.codechallenge.model.FormatPackageMap;
import com.gradle.codechallenge.model.Order;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BundlesCalculatorApplication {

    public static void main(String[] args) {

        String inputFilename = "input.txt";
        Scanner inputStream = null;

        try {
            inputStream = new Scanner(new FileInputStream(inputFilename));

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + inputFilename);
            System.exit(1);
        }

        OrderInput input = new OrderInput();
        Order order = input.getOrder(inputStream);

        FormatPackageMap fpm = new FormatPackageMap();
        BundlesCalculator calculator = new BundlesCalculator(fpm.getDefaultFormatPackageMap());

        OrderOutput output = new OrderOutput();
        output.printToFile(calculator.calculateOrder(order));
    }
}
