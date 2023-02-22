package com.tuckman.advent.of.code.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubsetThresholdTest {

    @Test
    void test() {
        int[] input = {1,3,4,3,1};
        int result = SubsetThreshold.validSubarraySize(input, 6);
        assertEquals(3, result);
    }
}