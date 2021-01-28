package com.gradle.codechallenge.model;

import java.util.List;

public class OrderItem {

    private Integer OrderItemRequiredNumber;
    private String OrderItemFormatCode;
    private FormatPackage matchedFormatPackage;
    private List<Bundle> calculatedBestBundles;

    public OrderItem() {
    }

    public OrderItem(Integer requiredNumber, String FormatCode) {
        OrderItemRequiredNumber = requiredNumber;
        OrderItemFormatCode = FormatCode;
    }

    public Integer getOrderItemDemandNumber() {
        return OrderItemRequiredNumber;
    }

    public void setOrderItemDemandNumber(Integer requiredNumber) {
        OrderItemRequiredNumber = requiredNumber;
    }

    public String getOrderItemFormatCode() {
        return OrderItemFormatCode;
    }

    public void setOrderItemFormatCode(String orderItemFormatCode) {
        OrderItemFormatCode = orderItemFormatCode;
    }

    public FormatPackage getMatchedFormatPackage() {
        return matchedFormatPackage;
    }

    public void setMatchedFormatPackage(FormatPackage matchedFormatPackage) {
        this.matchedFormatPackage = matchedFormatPackage;
    }

    public void setCalculatedBestBundles(List<Bundle> calculatedBestBundles) {
        this.calculatedBestBundles = calculatedBestBundles;
    }

    public Double getTotalPrice() {
        return calculatedBestBundles.stream().mapToDouble(
                bestBundle -> bestBundle.getRequiredBundleNum() * bestBundle.getBundlePrice()).sum();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("---------").append(OrderItemRequiredNumber).append(" ").append(OrderItemFormatCode).append("---------" + "\n");

        calculatedBestBundles.forEach(b -> sb.append(b.getRequiredBundleNum()).append(" X ")
                .append(b.getBundleOption()).append(" $")
                .append(b.getBundlePrice()*(b.getRequiredBundleNum())).append("\n")
        );

        sb.append("Total: $").append(getTotalPrice()).append("\n\n");
        return sb.toString();
    }
}
