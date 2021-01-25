package com.gradle.codechallenge;

public class ResultPrinter {

    public void print(int[] index, int n, FormatPackage formatPackage) {
        if (index[index.length - 1] == -1) {
            System.out.println("The order item does not have suitable bundles.\n");
            return;
        }

        int start = index.length - 1;
        System.out.println("---------" + n + " " + formatPackage.formatCode + "---------");

        double total = 0.0;
        while (start != 0) {
            int j = index[start];
            double price = formatPackage.getFormatMap().get(formatPackage.getBundlesOptions().get(j));
            System.out.println(formatPackage.getBundlesOptions().get(j) + " x 1 " + "$" + price);
            start = start - formatPackage.getBundlesOptions().get(j);
            total = total + price;
        }
        System.out.println("Total: $" + total + "\n");
    }
}
