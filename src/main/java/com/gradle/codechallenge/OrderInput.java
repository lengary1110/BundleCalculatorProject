package com.gradle.codechallenge;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OrderInput {

    Scanner inputStream = null;
    String inputFilename = "input.txt";

    public Scanner input() {

        try {
            inputStream = new Scanner(new FileInputStream(inputFilename));
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + inputFilename);
            System.exit(0);
        }
        return inputStream;
    }
}
