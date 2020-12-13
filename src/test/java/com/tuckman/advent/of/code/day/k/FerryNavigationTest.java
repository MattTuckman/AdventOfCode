package com.tuckman.advent.of.code.day.k;

import com.tuckman.advent.of.code.commons.AdventUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FerryNavigationTest {
    FerryNavigation ferryNavigation = new FerryNavigation();

    @Test
    void test_exampleInput() {
        List<String> exampleInput = AdventUtils.listLinesOfResource("exampleFerryInstructions.txt");
        int distance = ferryNavigation.manhattanDistanceAfter(exampleInput);
        System.out.println("Example distance: " + distance);
        assertEquals(25, distance);
    }

    @Test
    void test_actualInput() {
        List<String> actualInput = AdventUtils.listLinesOfResource("ferryInstructions.txt");
        int distance = ferryNavigation.manhattanDistanceAfter(actualInput);
        System.out.println("Distance: " + distance);
        assertEquals(439, distance);
    }

    @Test
    void test_exampleInput_waypoint() {
        List<String> exampleInput = AdventUtils.listLinesOfResource("exampleFerryInstructions.txt");
        int distance = ferryNavigation.manhattanDistanceAfterWaypoint(exampleInput);
        System.out.println("Example waypoint distance: " + distance);
        assertEquals(286, distance);
    }

    @Test
    void test_actualInput_waypoint() {
        List<String> actualInput = AdventUtils.listLinesOfResource("ferryInstructions.txt");
        int distance = ferryNavigation.manhattanDistanceAfterWaypoint(actualInput);
        System.out.println("Waypoint distance: " + distance);
        assertEquals(12385, distance);
    }
}