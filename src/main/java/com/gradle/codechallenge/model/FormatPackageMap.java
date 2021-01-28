package com.gradle.codechallenge.model;

import java.util.HashMap;
import java.util.Map;

public class FormatPackageMap {

    private final Map<String, FormatPackage> formatPackageMap = new HashMap<>();

    public void setDefaultFormatPackageMap() {
        FormatPackage img = new FormatPackage();
        img.setFormatCode("IMG");
        img.inputBundle(5, 450.0);
        img.inputBundle(10, 800.0);

        FormatPackage flac = new FormatPackage();
        flac.setFormatCode("FLAC");
        flac.inputBundle(3, 427.5);
        flac.inputBundle(6, 810.0);
        flac.inputBundle(9, 1147.5);

        FormatPackage vid = new FormatPackage();
        vid.setFormatCode("VID");
        vid.inputBundle(3, 570.0);
        vid.inputBundle(5, 900.0);
        vid.inputBundle(9, 1530.0);

        addFormatPackage(img);
        addFormatPackage(flac);
        addFormatPackage(vid);
    }

    public void addFormatPackage(FormatPackage formatPackage) {
        formatPackageMap.put(formatPackage.getFormatCode(), formatPackage);
    }

    public Map<String, FormatPackage> getDefaultFormatPackageMap() {
        setDefaultFormatPackageMap();
        return formatPackageMap;
    }
}