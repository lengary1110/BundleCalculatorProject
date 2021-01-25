package com.gradle.codechallenge;

import java.util.List;

public class BestBundlesOptionsMatcher {

    public int[] find(int n, List<Integer> bundlesOptions) {
        int[] num = new int[n + 1];
        int[] index = new int[n + 1];
        num[0] = 0;
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.MAX_VALUE - 1;
            index[i] = -1;
        }

        for (int j = 0; j < bundlesOptions.size(); j++) {
            for (int i = 1; i <= n; i++) {
                if (i >= bundlesOptions.get(j)) {
                    if (num[i - bundlesOptions.get(j)] + 1 < num[i]) {
                        num[i] = 1 + num[i - bundlesOptions.get(j)];
                        index[i] = j;
                    }
                }
            }
        }
        return index;
    }
}
