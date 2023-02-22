package com.tuckman.advent.of.code.day.i;

import com.tuckman.advent.of.code.commons.AdventUtils;
import com.tuckman.advent.of.code.twenty.day.i.AdapterArray;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdapterArrayTest {

    AdapterArray adapterArray = new AdapterArray();
    @Test
    void test_exampleInput1_differences() {
        Stream<String> exampleInput = AdventUtils.streamLinesOfResource("twenty/exampleAdapter.txt");
        long diffs = adapterArray.numberOfDifferences(exampleInput);
        System.out.println("Example 1 diffs: " + diffs);
        assertEquals(35, diffs);
    }

    @Test
    void test_exampleInput2_differences() {
        Stream<String> exampleInput = AdventUtils.streamLinesOfResource("twenty/exampleAdapter2.txt");
        long diffs = adapterArray.numberOfDifferences(exampleInput);
        System.out.println("Example 2 diffs: " + diffs);
        assertEquals(220, diffs);
    }

    @Test
    void test_actualInput_differences() {
        Stream<String> actualInput = AdventUtils.streamLinesOfResource("twenty/adapter.txt");
        long diffs = adapterArray.numberOfDifferences(actualInput);
        System.out.println("Actual diffs: " + diffs);
        assertEquals(2059, diffs);
    }

    @Test
    void test_exampleInput1_arrangements_fullRecursion() {
        Stream<String> exampleInput = AdventUtils.streamLinesOfResource("twenty/exampleAdapter.txt");
        long diffs = adapterArray.numberOfArrangementsFullyRecursive(exampleInput);
        System.out.println("Example 1 arrangements: " + diffs);
        assertEquals(8, diffs);
    }

    @Test
    void test_exampleInput2_arrangements_fullRecursion() {
        Stream<String> exampleInput = AdventUtils.streamLinesOfResource("twenty/exampleAdapter2.txt");
        long diffs = adapterArray.numberOfArrangementsFullyRecursive(exampleInput);
        System.out.println("Example 2 arrangements: " + diffs);
        assertEquals(19208, diffs);
    }

    @Test
    void test_exampleInput1_arrangements() {
        Stream<String> exampleInput = AdventUtils.streamLinesOfResource("twenty/exampleAdapter.txt");
        long diffs = adapterArray.numberOfArrangements(exampleInput);
        System.out.println("Example 1 arrangements: " + diffs);
        assertEquals(8, diffs);
    }

    @Test
    void test_exampleInput2_arrangements() {
        Stream<String> exampleInput = AdventUtils.streamLinesOfResource("twenty/exampleAdapter2.txt");
        long diffs = adapterArray.numberOfArrangements(exampleInput);
        System.out.println("Example 2 arrangements: " + diffs);
        assertEquals(19208, diffs);
    }

    @Test
    void test_actualInput_arrangements() {
        Stream<String> actualInput = AdventUtils.streamLinesOfResource("twenty/adapter.txt");
        long diffs = adapterArray.numberOfArrangements(actualInput);
        System.out.println("Actual arrangements: " + diffs);
        assertEquals(86812553324672L, diffs);
    }
}