package com.gradle.codechallenge;

import com.gradle.codechallenge.model.Order;
import com.gradle.codechallenge.model.OrderItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class OrderInput {

    private static final Logger logger = LogManager.getLogger(OrderInput.class);

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
                } else {
                    throw new Exception("The order has illegal order item.");
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
        return order;
    }
}
