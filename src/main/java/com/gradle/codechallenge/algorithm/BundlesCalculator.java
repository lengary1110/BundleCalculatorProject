package com.gradle.codechallenge.algorithm;

import com.gradle.codechallenge.model.Bundle;
import com.gradle.codechallenge.model.FormatPackage;
import com.gradle.codechallenge.model.FormatPackageMap;
import com.gradle.codechallenge.model.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class BundlesCalculator {

    FormatPackageMap map = new FormatPackageMap();

    public void initializeFormatPackageMap() {
        map.setDefault();
    }

    public FormatPackage matchFormatPackage(OrderItem orderItem) {

        // TODO: add try catch return null exception
        // System.out.println("Given format does not exist in the format table.\n");
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
//         TODO: add try catch exception
//        if (index.length - 1 == -1) {
//            System.out.println("The order item does not have suitable bundles.\n");
//        }

        int start = index.length - 1;

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
