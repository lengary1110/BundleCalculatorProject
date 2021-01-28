package com.gradle.codechallenge.algorithm;

import com.gradle.codechallenge.model.Bundle;
import com.gradle.codechallenge.model.FormatPackage;
import com.gradle.codechallenge.model.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BundlesCalculator {

    private Map<String, FormatPackage> map = new HashMap<>();

    private static final Logger logger = LogManager.getLogger(BundlesCalculator.class);

    public BundlesCalculator() {
    }

    public BundlesCalculator(Map<String, FormatPackage> inputFormatPackageMap) {
        map = inputFormatPackageMap;
    }

    public Order calculateOrder(Order order) {

        order.getOrderItemList().forEach(orderItem -> {
            try {
                if (!map.containsKey(orderItem.getOrderItemFormatCode())) {
                    throw new Exception(orderItem.getOrderItemFormatCode() + " does not have matched format.");
                } else {
                    orderItem.setMatchedFormatPackage(map.get(orderItem.getOrderItemFormatCode()));
                    orderItem.setCalculatedBestBundles(
                            matchBestBundlesForOrderItem(orderItem.getOrderItemDemandNumber(),
                                    orderItem.getMatchedFormatPackage()));
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
                System.exit(1);
            }
        });

        return order;
    }

    private List<Bundle> matchBestBundlesForOrderItem(Integer requiredNumberForOrderItem, FormatPackage matchedFormatPackageForOrderItem) {

        int n = requiredNumberForOrderItem;
        int[] num = new int[n + 1];
        int[] index = new int[n + 1];
        num[0] = 0;

        for (int i = 1; i <= n; i++) {
            num[i] = Integer.MAX_VALUE - 1;
            index[i] = -1;
        }

        for (int j = 0; j < matchedFormatPackageForOrderItem.getBundlesOptions().size(); j++) {
            for (int i = 1; i <= n; i++) {
                if (i >= matchedFormatPackageForOrderItem.getBundlesOptions().get(j)) {
                    if (num[i - matchedFormatPackageForOrderItem.getBundlesOptions().get(j)] + 1 < num[i]) {
                        num[i] = 1 + num[i - matchedFormatPackageForOrderItem.getBundlesOptions().get(j)];
                        index[i] = j;
                    }
                }
            }
        }

        int start = index.length - 1;

        try {
            if (index[start] == -1) {
                throw new Exception(requiredNumberForOrderItem + " does not have suitable bundles for this format.");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            System.exit(1);
        }

        List<Bundle> bestBundlesForOrderItem = new ArrayList<>();

        while (start != 0) {
            int k = index[start];
            matchedFormatPackageForOrderItem.getBundleList().stream().
                    filter(bundle -> bundle.getBundleOption().equals(matchedFormatPackageForOrderItem.getBundlesOptions().get(k))).
                    forEach(bundle -> {
                        bundle.addOneRequiredBundle();
                        if (!bestBundlesForOrderItem.contains(bundle)) {
                            bestBundlesForOrderItem.add(bundle);
                        }
                    });

            start = start - matchedFormatPackageForOrderItem.getBundlesOptions().get(k);
        }

        return bestBundlesForOrderItem;
    }

}
