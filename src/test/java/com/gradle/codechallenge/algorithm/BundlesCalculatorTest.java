package com.gradle.codechallenge.algorithm;

import com.gradle.codechallenge.model.FormatPackage;
import com.gradle.codechallenge.model.OrderItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BundlesCalculatorTest {

    private final BundlesCalculator testBundlesCalculator = new BundlesCalculator();

    private final OrderItem testOrderItem = new OrderItem(10, "IMG");


    @Test
    void canMatchFormatPackage() {
        testBundlesCalculator.initializeFormatPackageMap();
        FormatPackage result = testBundlesCalculator.map.getFormatPackageMap().get(testOrderItem.getOrderItemFormatCode());
        assertEquals(result, testBundlesCalculator.matchFormatPackage(testOrderItem));

    }
}