package com.tuckman.advent.of.code.leet;

import java.util.PriorityQueue;

/**
 * Moving window solution does not work as increasing window size can cause older values to now be valid.
 */
public class SubsetThreshold {

    public static int validSubarraySize(int[] nums, int threshold) {
        int res = -1;
        if (nums.length < 1) return res;

        int start = 0;
        int end = 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue();
        minHeap.add(nums[0]);

        while (true) {
            // meets check
            if (minHeap.peek() > (threshold / minHeap.size())) {
                res = Math.max(minHeap.size(), res);
                end++;
                if (end == nums.length) break;
                minHeap.add(nums[end]);
            } else {
                // remove start
                minHeap.remove(nums[start]);
                start++;

                if (start > end) {
                    end++;
                    if (end == nums.length) break;
                    minHeap.add(nums[end]);
                }
            }
        }
        return res;
    }
}
