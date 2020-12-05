package com.tuckman.advent.of.code.day.d;

import com.tuckman.advent.of.code.commons.AdventUtils;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SeatFinderTest {
    SeatFinder seatFinder = new SeatFinder();

    @Test
    void test_acutalInput() {
        Stream<String> input = AdventUtils.streamLinesOfResource("seatIds.txt");
        int seatId = seatFinder.findSeatId(input);
        System.out.println("My seat is: " + seatId);
        assertEquals(727, seatId);
    }

}