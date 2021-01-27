package com.gradle.codechallenge.model;

public class OrderItem {
    Integer OrderItemDemandNumber;
    String OrderItemFormatCode;

    public OrderItem() {
    }

    public OrderItem(Integer DemandNumber, String FormatCode) {
        OrderItemDemandNumber = DemandNumber;
        OrderItemFormatCode = FormatCode;
    }

    public Integer getOrderItemDemandNumber() {
        return OrderItemDemandNumber;
    }

    public void setOrderItemDemandNumber(Integer orderItemDemandNumber) {
        OrderItemDemandNumber = orderItemDemandNumber;
    }

    public String getOrderItemFormatCode() {
        return OrderItemFormatCode;
    }

    public void setOrderItemFormatCode(String orderItemFormatCode) {
        OrderItemFormatCode = orderItemFormatCode;
    }

    @Override
    public String toString() {
        return "---------" + OrderItemDemandNumber + " " + OrderItemFormatCode + "---------" + "\n";
    }
}
