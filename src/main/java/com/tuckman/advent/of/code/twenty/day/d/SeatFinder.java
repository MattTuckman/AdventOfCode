package com.tuckman.advent.of.code.twenty.day.d;

import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SeatFinder {

    public int findSeatId(Stream<String> allSeats) {
        Set<Integer> occupadoSeats = allSeats
                .map(stringNum -> Integer.parseInt(stringNum, 2))
                .collect(Collectors.toSet());

        // 13-978 is the id range based on searching our input set
        OptionalInt match = IntStream.range(13, 979)
                .filter(num -> !occupadoSeats.contains(num))
                .findFirst();
        return match.getAsInt();
    }
}
