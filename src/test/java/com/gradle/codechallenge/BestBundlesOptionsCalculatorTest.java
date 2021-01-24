package com.gradle.codechallenge;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestBundlesOptionsCalculatorTest {

    @Test
    public void testFindBestBundlesOptions() {

        List<Integer> testBundlesOptions = new ArrayList<>();

        testBundlesOptions.add(3);
        testBundlesOptions.add(2);
        testBundlesOptions.add(4);

        int[] expectedIndex = {0, -1, 1, 0, 2, 1, 0};

        BestBundlesOptionsCalculator matcher = new BestBundlesOptionsCalculator();

        assertEquals(Arrays.toString(expectedIndex), Arrays.toString(matcher.find(6, testBundlesOptions)));

    }

}