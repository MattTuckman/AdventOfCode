package com.tuckman.advent.of.code.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleCalcTest {

    @Test
    void constructRectangle() {
        int[] ints = RectangleCalc.constructRectangle(20);
        assertEquals(5, ints[0]);
        assertEquals(4, ints[1]);

        ints = RectangleCalc.constructRectangle(23);
        assertEquals(23, ints[0]);
        assertEquals(1, ints[1]);

        ints = RectangleCalc.constructRectangle(4);
        assertEquals(2, ints[0]);
        assertEquals(2, ints[1]);
    }
}