package com.tuckman.advent.of.code.day.o;

import com.tuckman.advent.of.code.commons.AdventUtils;
import com.tuckman.advent.of.code.twenty.day.o.PockerDimensionSimulator4D;
import com.tuckman.advent.of.code.twenty.day.o.PocketDimensionSimulator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PocketDimensionSimulatorTest {
    PocketDimensionSimulator pocketDimensionSimulator = new PocketDimensionSimulator();
    PockerDimensionSimulator4D pockerDimensionSimulator4D = new PockerDimensionSimulator4D();

    @Test
    void test_exampleInput() {
        List<String> exampleInput = AdventUtils.listLinesOfResource("twenty/exampleDimension.txt");
        int activeCount = pocketDimensionSimulator.simulatePocketDimension(exampleInput);
        System.out.println("Example active: " + activeCount);
        assertEquals(112, activeCount);
    }

    @Test
    void test_actualInput() {
        List<String> actualInput = AdventUtils.listLinesOfResource("twenty/dimension.txt");
        int activeCount = pocketDimensionSimulator.simulatePocketDimension(actualInput);
        System.out.println("Active: " + activeCount);
        assertEquals(348, activeCount);
    }

    @Test
    void test_exampleInput_4D() {
        List<String> exampleInput = AdventUtils.listLinesOfResource("twenty/exampleDimension.txt");
        int activeCount = pockerDimensionSimulator4D.simulatePocketDimension(exampleInput);
        System.out.println("Example active 4D: " + activeCount);
        assertEquals(848, activeCount);
    }

    @Test
    void test_actualInput_4D() {
        List<String> actualInput = AdventUtils.listLinesOfResource("twenty/dimension.txt");
        int activeCount = pockerDimensionSimulator4D.simulatePocketDimension(actualInput);
        System.out.println("Active 4D: " + activeCount);
        assertEquals(2236, activeCount);
    }
}