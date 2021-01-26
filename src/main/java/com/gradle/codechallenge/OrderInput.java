package com.gradle.codechallenge;

import com.gradle.codechallenge.model.Order;
import com.gradle.codechallenge.model.OrderItem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OrderInput {

    String inputFilename = "input.txt";
    Scanner inputStream = null;

    public Scanner getInputStream() {

        try {
            inputStream = new Scanner(new FileInputStream(inputFilename));

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + inputFilename);
            System.exit(0);
        }
        return inputStream;
    }

    // TODO: add try catch return exception
//  System.out.println("This order line is illegal.\n");
    public Order getOrder(Scanner inputStream) {

        Order order = new Order();
        while (inputStream.hasNextLine()) {
            String[] subset = inputStream.nextLine().split(" ");
            if (subset.length == 2) {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderItemDemandNumber(Integer.parseInt(subset[0]));
                orderItem.setOrderItemFormatCode(subset[1]);
                order.addOrderItem(orderItem);
            }
        }
        return order;
    }
}
