package com.gradle.tutorial;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindBestBundlesOptionsTest {

    @Test
    public void testFindBestBundlesOptions(){

        List<Integer> testBundlesOptions = new ArrayList<>();

        testBundlesOptions.add(3);
        testBundlesOptions.add(2);
        testBundlesOptions.add(4);

        int[] expectedIndex = {0, -1, 1, 0, 2, 1, 0};

        FindBestBundlesOptions fb = new FindBestBundlesOptions();

        assertEquals(Arrays.toString(expectedIndex),Arrays.toString(fb.find(6,testBundlesOptions)));

    }

}