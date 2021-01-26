package com.gradle.codechallenge.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public List<OrderItem> orderItemList = new ArrayList<>();

    public void addOrderItem(OrderItem orderItem) {
        orderItemList.add(orderItem);
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }
}
