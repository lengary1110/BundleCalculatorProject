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

    public Order getOrder(Scanner inputStream) {

        Order order = new Order();
        while (inputStream.hasNextLine()) {
            String[] subset = inputStream.nextLine().split(" ");
            try {
                if (subset.length == 2) {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setOrderItemDemandNumber(Integer.parseInt(subset[0]));
                    orderItem.setOrderItemFormatCode(subset[1]);
                    order.addOrderItem(orderItem);
                } else
                    throw new Exception("The order have illegal order item.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return order;
    }
}
