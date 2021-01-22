package com.gradle.tutorial;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CalculatorTest {

    @Test
    public void canLoadBundles() {

        Calculator cal = new Calculator();
        final int n = 30;
        final int[] Flac_bundlesOptions = {3,6,9};
        final Map<Integer, Double> Flac_map = new HashMap<>();
        Flac_map.put(3,427.5);
        Flac_map.put(6,810.0);
        Flac_map.put(9,1147.5);
        assertEquals(4, cal.loadBundles(n,Flac_bundlesOptions, Flac_map));
    }

}