package com.gradle.codechallenge;

import java.util.List;

public class BundlesCalculator {

    public void readOrder(List<String> order) {

        order
                .forEach(orderItem -> {
                    String[] line = orderItem.split(" ");
                    if (line.length == 2) {
                        matchFormatPackage(Integer.parseInt(line[0]), line[1]);
                    } else {
                        System.out.println("This order line is illegal.\n");
                    }
                });
    }

    public void matchFormatPackage(int n, String formatType) {

        FormatPackageList list = new FormatPackageList();
        list.setDefaultFormatPackageList();

        list.formatPackageList.stream().filter(ft -> ft.getFormatCode().equals(formatType)).forEach(ft -> {
            BestBundlesOptionsMatcher cal = new BestBundlesOptionsMatcher();
            ResultPrinter pr = new ResultPrinter();
            pr.print(cal.find(n, ft.getBundlesOptions()), n, ft);
        });

        if (list.formatPackageList.stream().noneMatch(i -> i.getFormatCode().equals(formatType))) {
            System.out.println("Given format does not exist in the format table.\n");
        }
    }
}
