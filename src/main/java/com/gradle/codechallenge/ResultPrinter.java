package com.gradle.codechallenge;

import java.util.List;
import java.util.Map;

public class ResultPrinter {

    public void print(int[] index, List<Integer> bundlesOptions, Map<Integer, Double> formatMap) {
        if (index[index.length - 1] == -1) {
            System.out.println("The order does not have suitable bundles.\n");
            return;
        }

        int start = index.length - 1;
        System.out.println("Bundles used to combine this format: ");

        double total = 0.0;
        while (start != 0) {
            int j = index[start];
            double price = formatMap.get(bundlesOptions.get(j));
            System.out.println(bundlesOptions.get(j) + " x 1 " + "$" + price);
            start = start - bundlesOptions.get(j);
            total = total + price;
        }
        System.out.println("Total: $" + total + "\n");
    }
}
