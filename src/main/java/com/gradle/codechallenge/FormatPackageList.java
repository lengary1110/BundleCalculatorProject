package com.gradle.codechallenge;

import java.util.ArrayList;
import java.util.List;


public class FormatPackageList {

    List<FormatPackage> formatPackageList = new ArrayList<>();

    public void setDefaultFormatPackageList(){
        FormatPackage img = new FormatPackage();
        img.setFormatCode("IMG");
        img.addBundles(5, 450.0);
        img.addBundles(10, 800.0);

        FormatPackage flac = new FormatPackage();
        flac.setFormatCode("FLAC");
        flac.addBundles(3, 427.5);
        flac.addBundles(6, 810.0);
        flac.addBundles(9, 1147.5);

        FormatPackage vid = new FormatPackage();
        vid.setFormatCode("VID");
        vid.addBundles(3, 570.0);
        vid.addBundles(5, 900.0);
        vid.addBundles(9, 1530.0);

        formatPackageList.add(img);
        formatPackageList.add(flac);
        formatPackageList.add(vid);

    }

    public void addFormatPackage(FormatPackage formatPackage){
        formatPackageList.add(formatPackage);
    }
}