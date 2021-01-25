package com.gradle.codechallenge;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderInput {

    Scanner inputStream = null;
    String inputFilename = "input.txt";
    List<String> order = new ArrayList<>();

    public List<String> input() {

        try {
            inputStream = new Scanner(new FileInputStream(inputFilename));
            while (inputStream.hasNextLine()) {
                order.add(inputStream.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + inputFilename);
            System.exit(0);
        }
        return order;
    }
}
