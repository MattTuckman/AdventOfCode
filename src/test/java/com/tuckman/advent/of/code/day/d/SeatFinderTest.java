package com.tuckman.advent.of.code.day.d;

import com.tuckman.advent.of.code.commons.AdventUtils;
import com.tuckman.advent.of.code.twenty.day.d.SeatFinder;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SeatFinderTest {
    SeatFinder seatFinder = new SeatFinder();

    @Test
    void test_acutalInput() {
        Stream<String> input = AdventUtils.streamLinesOfResource("twenty/seatIds.txt");
        int seatId = seatFinder.findSeatId(input);
        System.out.println("My seat is: " + seatId);
        assertEquals(727, seatId);
    }

}