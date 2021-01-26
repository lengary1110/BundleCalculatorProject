package com.gradle.codechallenge;

import com.gradle.codechallenge.model.Bundle;
import com.gradle.codechallenge.model.OrderItem;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

public class OrderOutput {

    String outputFilename = "output.txt";
    String outContent = "";

    public void printToFile() {

        try {
            PrintStream out = new PrintStream(outputFilename);
            out.println(outContent);
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void printInFormat(OrderItem orderItem, List<Bundle> bestBundles) {

        outContent+= orderItem.toString();

        bestBundles
                .forEach(bestBundle ->
                        outContent+= bestBundle.getBundleOption() + " x " +
                                bestBundle.getRequiredBundleNum() + " $" + bestBundle.getBundlePrice() * bestBundle.getRequiredBundleNum()+"\n");

        double totalPrice = bestBundles.stream().mapToDouble(bestBundle -> bestBundle.getRequiredBundleNum() * bestBundle.getBundlePrice()).sum();

        outContent+= "Total: $" + totalPrice + "\n";
    }
}
