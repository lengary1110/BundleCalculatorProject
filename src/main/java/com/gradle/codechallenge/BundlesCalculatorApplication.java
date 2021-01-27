package com.gradle.codechallenge;

import com.gradle.codechallenge.algorithm.BundlesCalculator;
import com.gradle.codechallenge.model.Order;

/**
 * @author lengary1110
 */

public class BundlesCalculatorApplication {

    public static void main(String[] args) {

        OrderInput input = new OrderInput();
        Order order = input.getOrder(input.getInputStream());

        BundlesCalculator calculator = new BundlesCalculator();
        calculator.initializeFormatPackageMap();

        OrderOutput output = new OrderOutput();

        order.getOrderItemList().forEach(orderItem -> {
            calculator.matchFormatPackage(orderItem);
            output.printInFormat(orderItem, calculator.matchBestBundles(orderItem, calculator.matchFormatPackage(orderItem)));
        });

        output.printToFile();
    }
}
