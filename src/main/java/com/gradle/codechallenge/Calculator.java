package com.gradle.codechallenge;

import java.util.*;

/**
 * @author lengary1110
 */

public class Calculator {

    public static void main(String[] args) {

        OrderInput input = new OrderInput();
        OrderOutput output = new OrderOutput();
        output.output(input.input());
    }

    public void readFiledOrder(List<String> order) {

        order
                .forEach(orderItem -> {
                    String[] line = orderItem.split(" ");
                    if (line.length == 2) {
                        matchFormatTable(Integer.parseInt(line[0]), line[1]);
                    } else {
                        System.out.println("This order line is illegal.\n");
                    }
                });
    }

    public void matchFormatTable(int n, String formatType) {

        FormatTable formatTable = new FormatTable();
        formatTable.setDefaultFormatTable();

        formatTable.formatList.stream().filter(ft -> ft.getFormatType().equals(formatType)).forEach(ft -> {
            BestBundlesOptionsCalculator cal = new BestBundlesOptionsCalculator();
            ResultPrinter pr = new ResultPrinter();
            pr.print(cal.find(n, ft.getBundlesOptions()), n, ft);
        });

        if (formatTable.formatList.stream().noneMatch(i -> i.getFormatType().equals(formatType))) {
            System.out.println("Given format does not exist in the format table.\n");
        }
    }
}
