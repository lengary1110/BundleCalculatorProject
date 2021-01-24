package com.gradle.codechallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FiledOrder {
    List<String> order = new ArrayList<>();

    public List<String> ParseFile(Scanner inputStream) {
        while (inputStream.hasNextLine()) {
            order.add(inputStream.nextLine());
        }
        return order;
    }
}
