package com.gradle.codechallenge;

import java.util.ArrayList;
import java.util.List;


public class FormatTable {

    List<Format> formatList  = new ArrayList<>();

    public void setDefaultFormatTable(){
        Format img = new Format();
        img.setFormatType("IMG");
        img.addBundles(5, 450.0);
        img.addBundles(10, 800.0);

        Format flac = new Format();
        flac.setFormatType("FLAC");
        flac.addBundles(3, 427.5);
        flac.addBundles(6, 810.0);
        flac.addBundles(9, 1147.5);

        Format vid = new Format();
        vid.setFormatType("VID");
        vid.addBundles(3, 570.0);
        vid.addBundles(5, 900.0);
        vid.addBundles(9, 1530.0);

        formatList.add(img);
        formatList.add(flac);
        formatList.add(vid);
    }
    public void addFormat(Format format){
        formatList.add(format);
    }
}
