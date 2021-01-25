package com.gradle.codechallenge;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestBundlesOptionsCalculatorTest {

    @Test
    public void testFindBestBundlesOptions() {

        Format format = new Format();
        format.setFormatType("GIF");
        format.addBundles(3, 550.0);
        format.addBundles(2, 750.0);
        format.addBundles(2, 1000.0);

        int[] expectedIndex = {0, -1, 1, 0, 2, 1, 0};

        BestBundlesOptionsCalculator matcher = new BestBundlesOptionsCalculator();

        assertEquals(Arrays.toString(expectedIndex), Arrays.toString(matcher.find(6,format.getBundlesOptions())));

    }

}