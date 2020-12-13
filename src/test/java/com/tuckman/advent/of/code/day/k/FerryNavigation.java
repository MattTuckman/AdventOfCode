package com.tuckman.advent.of.code.day.k;

import com.tuckman.advent.of.code.day.j.Ferry;
import com.tuckman.advent.of.code.day.j.WaypointFerry;

import java.util.List;

public class FerryNavigation {

    public int manhattanDistanceAfter(List<String> instructions) {
        Ferry ferry = new Ferry();
        for (String instruction : instructions) {
            ferry.interpret(instruction);
        }
        return Math.abs(ferry.getX()) + Math.abs(ferry.getY());
    }

    public int manhattanDistanceAfterWaypoint(List<String> instructions) {
        WaypointFerry ferry = new WaypointFerry();
        for (String instruction : instructions) {
            ferry.interpret(instruction);
        }
        return Math.abs(ferry.getX()) + Math.abs(ferry.getY());
    }
}
