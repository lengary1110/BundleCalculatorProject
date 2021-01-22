package com.gradle.tutorial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author lengary1110
 */

public class Calculator {

    /**
     * @param args program Arguments
     */
    public static void main(String[] args){

        Scanner inputStream = null;
        String inputFilename = "input.txt";

        try {
            inputStream = new Scanner(new FileInputStream(inputFilename));
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + inputFilename);
            System.exit(0);
        }

        ArrayList<String> order = new ArrayList<>();
        while(inputStream.hasNextLine())
        {
            order.add(inputStream.nextLine());
        }

        String outputFilename = "output.txt";

        try {
            PrintStream out = new PrintStream(outputFilename);
            System.setOut(out);
            Calculator calculator = new Calculator();
            calculator.readFormatCollocation(order);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param formatCollocation is one line converted by input.txt file's line by line
     */
    public void readFormatCollocation(ArrayList<String> formatCollocation){

        for (String fc : formatCollocation) {
            String[] line = fc.split(" ");
            if (line.length == 2){
            collocationMatch(Integer.parseInt(line[0]), line[1]);
            } else {
                System.out.println("This order line is illegal.\n");
            }
        }

    }

    /**
     * @param n is the number of the corresponding format type in this order
     * @param formatType is one of the format types
     */
    public void collocationMatch(int n, String formatType){

        int[] IMG_bundlesOptions = {5,10};
        int[] Flac_bundlesOptions = {3,6,9};
        int[] VID_bundlesOptions = {3,5,9};

        Map<Integer, Double> IMG_map = new HashMap<>();
        Map<Integer, Double> Flac_map = new HashMap<>();
        Map<Integer, Double> VID_map = new HashMap<>();

        IMG_map.put(5,400.0);
        IMG_map.put(10,800.0);
        IMG_map.put(3,427.5);

        Flac_map.put(3,427.5);
        Flac_map.put(6,810.0);
        Flac_map.put(9,1147.5);

        VID_map.put(3,570.0);
        VID_map.put(5,900.0);
        VID_map.put(9,1530.0);

        switch (formatType) {
            case "IMG" -> loadBundles(n, IMG_bundlesOptions, IMG_map);
            case "FLAC" -> loadBundles(n, Flac_bundlesOptions, Flac_map);
            case "VID" -> loadBundles(n, VID_bundlesOptions, VID_map);
            default -> System.out.println("Something wrong with the order line.\n");
        }

    }

    /**
     * @param n is the number of the corresponding format type in this order
     * @param bundlesOptions is the bundles options of the corresponding format type
     * @param formatMap is the bundles list of one format type
     * @return int: the minimal number of bundles for this format type except "no suitable bundles" condition
     */
    public int loadBundles(int n, int[] bundlesOptions, Map<Integer, Double> formatMap) {

        int[] num = new int[n + 1];
        int[] index = new int[n + 1];
        num[0] = 0;
        for (int i = 1; i <= n; i++){
            num[i] = Integer.MAX_VALUE-1;
            index[i] = -1;
        }

        for (int j = 0; j < bundlesOptions.length; j++){
            for (int i = 1; i <= n; i++){
                if (i >= bundlesOptions[j]){
                    if (num[i-bundlesOptions[j]]+1 < num[i]){
                        num[i] = 1 + num[i-bundlesOptions[j]];
                        index[i] = j;
                    }
                }
            }
        }
        printBundlesCombination(index,bundlesOptions,formatMap);
        return num[n];
    }

    /**
     * @param index stores the information of loadBundles and the final options of this format
     * @param bundlesOptions is the bundles options of the corresponding format type
     * @param formatMap is the bundles list of one format type
     */
    public void printBundlesCombination(int[] index, int[] bundlesOptions,Map<Integer, Double> formatMap){

        if (index[index.length - 1] == -1){
            System.out.println("The order does not have suitable bundles.\n");
            return;
        }

        int start = index.length - 1;
        System.out.println("Bundles used to combine the format: ");

        double total = 0.0;
        while (start != 0) {
            int j = index[start];
            double price = formatMap.get(bundlesOptions[j]);
            System.out.println(bundlesOptions[j] + " x 1 " + price);
            start = start - bundlesOptions[j];
            total = total + price;
        }
        System.out.println("Total: " + total + "\n");
    }

}
