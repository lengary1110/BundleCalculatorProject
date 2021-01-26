package com.gradle.codechallenge;

import com.gradle.codechallenge.algorithm.BundlesCalculator;
import com.gradle.codechallenge.model.Bundle;
import com.gradle.codechallenge.model.FormatPackage;
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

        OrderOutput output = new OrderOutput();

        BundlesCalculator calculator = new BundlesCalculator();
        calculator.initializeFormatPackageMap();

        for (OrderItem orderItem : order.getOrderItemList()) {

            FormatPackage matchedFormatPackage = calculator.matchFormatPackage(orderItem);
            List<Bundle> bestBundles = calculator.matchBestBundles(orderItem, matchedFormatPackage);

            output.printInFormat(orderItem, bestBundles);
        }
        output.printToFile();
    }
}
