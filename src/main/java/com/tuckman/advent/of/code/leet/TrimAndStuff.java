package com.tuckman.advent.of.code.leet;

import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * Originally tried to parse as int, then long, then thought about BigInt. There was no reason to parse at all
 * since we are just comparing from the front which is natural for a String.compareTo. To optimize this further,
 * cache on the trimmed number so you don't have to repeat that step.
 */
public class TrimAndStuff {

    public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        return Arrays.stream(queries)
                .mapToInt(query -> parseTrimmedNums(nums, query[1], query[0]))
                .toArray();
    }

    private static int parseTrimmedNums(String[] nums, int trim, int kth) {
        PriorityQueue<SimplePair> res = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            String num = nums[i];
            int len = num.length();

            String currNumStr = num.substring(len - trim, len);

            res.add(new SimplePair(currNumStr, i));
        }

        for (int i = 0; i < kth - 1; i++) {
            res.poll();
        }
        return res.poll().r;
    }


    private static class SimplePair implements Comparable<SimplePair> {
        String l;
        int r;

        public SimplePair(String l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(SimplePair o) {
            return Objects.equals(this.l, o.l) ? Integer.compare(this.r, o.r) : this.l.compareTo(o.l);
        }
    }
}
