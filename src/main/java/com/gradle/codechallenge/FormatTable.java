package com.gradle.codechallenge;

import java.util.ArrayList;
import java.util.List;


public class FormatTable {

    List<Format> formatList  = new ArrayList<>();

    public void setDefaultFormatTable(){
        Format img = new Format();
        img.setFormatType("IMG");
        img.addBundlesOptions(5, 450.0);
        img.addBundlesOptions(10, 800.0);

        Format flac = new Format();
        flac.setFormatType("FLAC");
        flac.addBundlesOptions(3, 427.5);
        flac.addBundlesOptions(6, 810.0);
        flac.addBundlesOptions(9, 1147.5);

        Format vid = new Format();
        vid.setFormatType("VID");
        vid.addBundlesOptions(3, 570.0);
        vid.addBundlesOptions(5, 900.0);
        vid.addBundlesOptions(9, 1530.0);

        formatList.add(img);
        formatList.add(flac);
        formatList.add(vid);
    }
    public void addFormat(Format format){
        formatList.add(format);
    }
}
