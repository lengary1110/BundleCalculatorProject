package com.gradle.codechallenge;

public class ResultPrinter {

    public void print(int[] index, int n, Format format) {
        if (index[index.length - 1] == -1) {
            System.out.println("The order does not have suitable bundles.\n");
            return;
        }

        int start = index.length - 1;
        System.out.println("---------" + n +" "+ format.formatType + "---------");

        double total = 0.0;
        while (start != 0) {
            int j = index[start];
            double price = format.getFormatMap().get(format.getBundlesOptions().get(j));
            System.out.println(format.getBundlesOptions().get(j) + " x 1 " + "$" + price);
            start = start - format.getBundlesOptions().get(j);
            total = total + price;
        }
        System.out.println("Total: $" + total + "\n");
    }
}
