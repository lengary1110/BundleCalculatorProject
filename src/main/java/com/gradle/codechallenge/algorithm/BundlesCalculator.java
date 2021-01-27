package com.gradle.codechallenge.algorithm;

import com.gradle.codechallenge.model.Bundle;
import com.gradle.codechallenge.model.FormatPackage;
import com.gradle.codechallenge.model.FormatPackageMap;
import com.gradle.codechallenge.model.OrderItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class BundlesCalculator {

    private static final Logger logger = LogManager.getLogger(BundlesCalculator.class);

    FormatPackageMap map = new FormatPackageMap();

    public void initializeFormatPackageMap() {
        map.setDefault();
    }

    public FormatPackage matchFormatPackage(OrderItem orderItem) {

        try {
            if (!map.getFormatPackageMap().containsKey(orderItem.getOrderItemFormatCode())) {
                throw new Exception(orderItem.getOrderItemFormatCode() + " does not have matched format.");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            System.exit(0);
        }

        return map.getFormatPackageMap().get(orderItem.getOrderItemFormatCode());
    }

    public List<Bundle> matchBestBundles(OrderItem orderItem, FormatPackage matchedFormatPackage) {

        int n = orderItem.getOrderItemDemandNumber();
        int[] num = new int[n + 1];
        int[] index = new int[n + 1];
        num[0] = 0;

        for (int i = 1; i <= n; i++) {
            num[i] = Integer.MAX_VALUE - 1;
            index[i] = -1;
        }

        for (int j = 0; j < matchedFormatPackage.getBundlesOptions().size(); j++) {
            for (int i = 1; i <= n; i++) {
                if (i >= matchedFormatPackage.getBundlesOptions().get(j)) {
                    if (num[i - matchedFormatPackage.getBundlesOptions().get(j)] + 1 < num[i]) {
                        num[i] = 1 + num[i - matchedFormatPackage.getBundlesOptions().get(j)];
                        index[i] = j;
                    }
                }
            }
        }

        int start = index.length - 1;

        try {
            if (index[start] == -1) {
                throw new Exception(orderItem.getOrderItemFormatCode() + " does not have suitable bundles.");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            System.exit(0);
        }

        List<Bundle> bestBundles = new ArrayList<>();

        while (start != 0) {
            int k = index[start];
            matchedFormatPackage.getBundleList().stream().
                    filter(bundle -> bundle.getBundleOption().equals(matchedFormatPackage.getBundlesOptions().get(k))).
                    forEach(bundle -> {
                        bundle.addOneRequiredBundle();
                        if (!bestBundles.contains(bundle)) {
                            bestBundles.add(bundle);
                        }
                    });

            start = start - matchedFormatPackage.getBundlesOptions().get(k);
        }
        return bestBundles;
    }

}
