package com.gradle.codechallenge;

import com.gradle.codechallenge.algorithm.BundlesCalculator;
import com.gradle.codechallenge.model.Bundle;
import com.gradle.codechallenge.model.Order;
import com.gradle.codechallenge.model.OrderItem;

import java.util.List;

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

        for (OrderItem orderItem : order.getOrderItemList()) {
            calculator.matchFormatPackage(orderItem);
            List<Bundle> bestBundles = calculator.matchBestBundles(orderItem, calculator.matchFormatPackage(orderItem));
            output.printInFormat(orderItem, bestBundles);
        }
        output.printToFile();
    }
}
