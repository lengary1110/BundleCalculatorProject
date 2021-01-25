package com.gradle.codechallenge;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;

public class BestBundlesOptionsMatcherTest {

    @Test
    public void testFind() {

        FormatPackage formatPackage = new FormatPackage();
        formatPackage.setFormatCode("GIF");

        formatPackage.addBundles(3, 450.0);
        formatPackage.addBundles(2, 300.0);
        formatPackage.addBundles(4, 550.0);

        int[] expectedIndex = {0, -1, 0, 1, 2, 1, 1};

        BestBundlesOptionsMatcher matcher = new BestBundlesOptionsMatcher();

        assertEquals(Arrays.toString(expectedIndex), Arrays.toString(matcher.find(6, formatPackage.getBundlesOptions())));

    }

}