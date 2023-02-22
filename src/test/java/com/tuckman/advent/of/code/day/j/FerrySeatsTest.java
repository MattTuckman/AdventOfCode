package com.tuckman.advent.of.code.day.j;

import com.tuckman.advent.of.code.commons.AdventUtils;
import com.tuckman.advent.of.code.twenty.day.j.FerrySeats;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FerrySeatsTest {
    FerrySeats ferrySeats = new FerrySeats();

    @Test
    void test_exampleInput() {
        List<String> exampleInput = AdventUtils.listLinesOfResource("twenty/exampleFerrySeats.txt");
        int count = ferrySeats.simulateFerrySeats(exampleInput);
        System.out.println("Example occupied seats: " + count);
        assertEquals(37, count);
    }

    @Test
    void test_actualInput() {
        List<String> actualInput = AdventUtils.listLinesOfResource("twenty/ferrySeats.txt");
        int count = ferrySeats.simulateFerrySeats(actualInput);
        System.out.println("Occupied seats: " + count);
        assertEquals(2470, count);
    }
}