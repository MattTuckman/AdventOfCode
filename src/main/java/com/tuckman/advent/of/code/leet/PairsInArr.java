package com.tuckman.advent.of.code.leet;

public class PairsInArr {
    public static int[] numberOfPairs(int[] nums) {
        int pairs = 0;

        int[] counts = new int[101];

        for (int num : nums) {
            if (++counts[num] % 2 == 0) {
                pairs++;
            }
        }

        return new int[]{pairs, nums.length - (2 * pairs)};
    }
}
