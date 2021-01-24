package com.gradle.tutorial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lengary1110
 */

public class Calculator {

    private List<Format> formatList = new ArrayList<>();

    /**
     * @param args program Arguments
     */
    public static void main(String[] args) {

        Input ip = new Input();
        Output op = new Output();
        op.output(ip.input());
    }

    /**
     * @param formatCollocation is one line converted by input.txt file's line by line
     */
    public void readFormatCollocation(List<String> formatCollocation) {

        formatCollocation
                .forEach(fc -> {
                    String[] line = fc.split(" ");
                    if (line.length == 2) {
                        collocationMatch(Integer.parseInt(line[0]), line[1]);
                    } else {
                        System.out.println("This order line is illegal.\n");
                    }
                });
    }

    public void setFormatTable() {

        Format img = new Format();
        img.setFormatType("IMG");
        img.addBundlesOptions(5, 450.0);
        img.addBundlesOptions(10, 800.0);

        Format flac = new Format();
        flac.setFormatType("FLAC");
        flac.addBundlesOptions(3, 427.5);
        flac.addBundlesOptions(6, 810.0);
        flac.addBundlesOptions(9, 1147.5);

        Format vid = new Format();
        vid.setFormatType("VID");
        vid.addBundlesOptions(3, 570.0);
        vid.addBundlesOptions(5, 900.0);
        vid.addBundlesOptions(9, 1530.0);

        formatList = Stream.of(img, flac, vid).collect(Collectors.toList());
    }

    /**
     * @param n          is the number of the corresponding format type in this order
     * @param formatType is one of the format types
     */
    public void collocationMatch(int n, String formatType) {

        formatList.stream().filter(ft -> ft.getFormatType().equals(formatType)).forEach(ft -> {
            FindBestBundlesOptions find = new FindBestBundlesOptions();
            find.find(n, ft.getBundlesOptions(ft.getFormatMap()));
            PrintResult pr = new PrintResult();
            pr.print(find.find(n, ft.getBundlesOptions(ft.getFormatMap())), ft.getBundlesOptions(ft.getFormatMap()), ft.getFormatMap());
        });

        if (formatList.stream().noneMatch(i -> i.getFormatType().equals(formatType))) {
            System.out.println("This format does not have any bundles.");
        }
    }
}
