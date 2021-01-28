package com.gradle.codechallenge;

import com.gradle.codechallenge.model.Order;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class OrderOutput {

    String outputFilename = "output.txt";

    public void printToFile(Order calculatedOrder) {
        try {
            PrintStream out = new PrintStream(outputFilename);
            System.setOut(out);
            printInFormat(calculatedOrder);
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void printInFormat(Order calculatedOrder) {
        calculatedOrder.getOrderItemList()
                .forEach(orderItem -> System.out.println(orderItem.toString()));
    }
}
