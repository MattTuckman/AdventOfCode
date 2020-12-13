package com.tuckman.advent.of.code.day.k;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BusScheduler {

    public long findSoonestBus(List<String> schedules) {
        long myArrival = Long.parseLong(schedules.get(0));

        MutablePair<Long, Long> soonestBus = Arrays.stream(schedules.get(1).split(","))
                .filter(str -> !str.equals("x"))
                .map(Long::parseLong)
                .map(schedule -> new MutablePair<Long, Long>(schedule - (myArrival % schedule), schedule))
                .sorted(Comparator.comparing(Pair::getKey))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No match"));
        return soonestBus.getKey() * soonestBus.getValue();
    }

    /**
     * Part 2 is just a system of congruence equations, so we will
     * print the modulus and remainder and use an online CRT calculator
     */
    public void printCRTInput(List<String> schedules) {
        List<String> departures = Arrays.stream(schedules.get(1).split(","))
                .collect(Collectors.toList());

        // bus id and offset
        List<MutablePair<Long, Long>> departuresAndOffsets = new ArrayList<>();
        for (int i = 0; i < departures.size(); i++) {
            if (!departures.get(i).equals("x")) {
                long num = Long.parseLong(departures.get(i));
                departuresAndOffsets.add(new MutablePair<>(num, (long) -i));
            }
        }
        System.out.println(departuresAndOffsets);
    }
}
