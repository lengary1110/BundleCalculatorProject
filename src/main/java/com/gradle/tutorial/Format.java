package com.gradle.tutorial;

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

    public void addBundlesOptions(Integer bundle, Double bundlePrice) {
        formatMap.put(bundle, bundlePrice);
    }

    public Map<Integer, Double> getFormatMap() {
        return formatMap;
    }

    public List<Integer> getBundlesOptions(Map<Integer, Double> formatMap) {
        return new ArrayList<>(formatMap.keySet());
    }

    public String getFormatType() {
        return formatType;
    }
}
