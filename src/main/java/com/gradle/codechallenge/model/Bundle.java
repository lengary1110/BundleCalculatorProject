package com.gradle.codechallenge.model;

public class Bundle {

    Integer bundleOption;
    Double bundlePrice;
    Integer requiredBundleNum = 0;

    public Integer getBundleOption() {
        return bundleOption;
    }

    public void setBundleOption(Integer bundleOption) {
        this.bundleOption = bundleOption;
    }

    public Double getBundlePrice() {
        return bundlePrice;
    }

    public void setBundlePrice(Double bundlePrice) {
        this.bundlePrice = bundlePrice;
    }

    public Integer getRequiredBundleNum() {
        return requiredBundleNum;
    }

    public void addOneRequiredBundle() {
        requiredBundleNum++;
    }
}
