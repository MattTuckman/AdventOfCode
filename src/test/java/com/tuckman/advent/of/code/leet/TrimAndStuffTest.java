package com.tuckman.advent.of.code.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrimAndStuffTest {

    @Test
    void test() {
        String[] strInput = {"102","473","251","814"};
        int[][] queryInput = {{1,1},{2,3},{4,2},{1,2}};

        int[] result = TrimAndStuff.smallestTrimmedNumbers(strInput, queryInput);

        assertArrayEquals(new int[]{2,2,1,0}, result);
    }

    @Test
    void test2() {
        String[] strInput = {"24","37","96","04"};
        int[][] queryInput = {{2,1},{2,2}};

        int[] result = TrimAndStuff.smallestTrimmedNumbers(strInput, queryInput);

        assertArrayEquals(new int[]{3,0}, result);
    }


}