package com.gradle.codechallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormatPackage {

    String formatCode;
    Map<Integer, Double> formatMap = new HashMap<>();

    public void setFormatCode(String formatCode) {
        this.formatCode = formatCode;
    }

    public String getFormatCode() {
        return formatCode;
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
