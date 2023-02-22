package com.tuckman.advent.of.code.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairsInArrTest {

    @Test
    void pairs() {
        int[] ints = PairsInArr.numberOfPairs(new int[]{1,3,2,1,3,2,2});
        assertEquals(ints[0], 3);
        assertEquals(ints[1], 1);
    }
}