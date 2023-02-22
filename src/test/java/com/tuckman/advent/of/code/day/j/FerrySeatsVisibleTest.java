package com.tuckman.advent.of.code.day.j;

import com.tuckman.advent.of.code.commons.AdventUtils;
import com.tuckman.advent.of.code.twenty.day.j.FerrySeatsVisible;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FerrySeatsVisibleTest {
    FerrySeatsVisible ferrySeats = new FerrySeatsVisible();

    @Test
    void test_exampleInput() {
        List<String> exampleInput = AdventUtils.listLinesOfResource("twenty/exampleFerrySeats.txt");
        int count = ferrySeats.simulateFerrySeats(exampleInput);
        System.out.println("Example visible occupied seats: " + count);
        assertEquals(26, count);
    }

    @Test
    void test_actualInput() {
        List<String> actualInput = AdventUtils.listLinesOfResource("twenty/ferrySeats.txt");
        int count = ferrySeats.simulateFerrySeats(actualInput);
        System.out.println("Occupied visible seats: " + count);
        assertEquals(2259, count);
    }
}