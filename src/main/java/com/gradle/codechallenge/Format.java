package com.gradle.codechallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Format {

    String formatType;
    Map<Integer, Double> formatMap = new HashMap<>();

    public void setFormatType(String formatType) {
        this.formatType = formatType;
    }

    public String getFormatType() {
        return formatType;
    }

    public void addBundles(Integer bundlesOption, Double bundlePrice) {
        formatMap.put(bundlesOption, bundlePrice);
    }

    public void removeBundles(Integer bundlesOption) {
        formatMap.remove(bundlesOption);
    }

    public Map<Integer, Double> getFormatMap() {
        return formatMap;
    }

    public List<Integer> getBundlesOptions() {
        return new ArrayList<>(formatMap.keySet());
    }
}
