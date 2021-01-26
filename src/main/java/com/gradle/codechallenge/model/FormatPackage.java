package com.gradle.codechallenge.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FormatPackage {

    String formatCode;
    List<Bundle> BundleList = new ArrayList<>();

    public void setFormatCode(String formatCode) {
        this.formatCode = formatCode;
    }

    public String getFormatCode() {
        return formatCode;
    }

    public void addBundle(Bundle bundle) {
        BundleList.add(bundle);
    }

    public void inputBundle(Integer bundleOption, Double bundlePrice) {
        Bundle inputBundle = new Bundle();
        inputBundle.setBundleOption(bundleOption);
        inputBundle.setBundlePrice(bundlePrice);
        BundleList.add(inputBundle);
    }

    public void removeBundle(Bundle bundle) {
        BundleList.remove(bundle);
    }

    public List<Bundle> getBundleList() {
        return BundleList;
    }

    public List<Integer> getBundlesOptions() {

        return getBundleList().stream().map(Bundle::getBundleOption).collect(Collectors.toList());
    }

}
