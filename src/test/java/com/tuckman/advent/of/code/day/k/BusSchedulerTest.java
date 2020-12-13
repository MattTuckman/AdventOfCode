package com.tuckman.advent.of.code.day.k;

import com.tuckman.advent.of.code.commons.AdventUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BusSchedulerTest {
    BusScheduler busScheduler = new BusScheduler();

    @Test
    void test_exampleInput() {
        List<String> exampleInput = AdventUtils.listLinesOfResource("exampleBus.txt");
        long soonestNum = busScheduler.findSoonestBus(exampleInput);
        System.out.println("Example soonest: " + soonestNum);
        assertEquals(295L, soonestNum);
    }

    @Test
    void test_actualInput() {
        List<String> actualInput = AdventUtils.listLinesOfResource("bus.txt");
        long soonestNum = busScheduler.findSoonestBus(actualInput);
        System.out.println("Soonest: " + soonestNum);
        assertEquals(174L, soonestNum);
    }

    /**
     * Part 2 is just a system of congruence equations, so we will
     * print the modulus and remainder and use an online CRT calculator
     */
    @Test
    void test_exampleInput_congruence() {
        List<String> exampleInput = AdventUtils.listLinesOfResource("exampleBus.txt");
        busScheduler.printCRTInput(exampleInput);
    }

    @Test
    void test_actualInput_congruence() {
        List<String> actualInput = AdventUtils.listLinesOfResource("bus.txt");
        busScheduler.printCRTInput(actualInput);
    }
}