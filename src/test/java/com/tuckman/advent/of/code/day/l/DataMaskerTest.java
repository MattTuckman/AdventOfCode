package com.tuckman.advent.of.code.day.l;

import com.tuckman.advent.of.code.commons.AdventUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataMaskerTest {
    @Test
    void test_exampleInput() {
        DataMasker dataMasker = new DataMasker();
        List<String> exampleInput = AdventUtils.listLinesOfResource("exampleMasks.txt");
        long result = dataMasker.sumAllDataFrom(exampleInput);
        System.out.println("Example result: " + result);
        assertEquals(165L, result);
    }

    @Test
    void test_actualInput() {
        DataMasker dataMasker = new DataMasker();
        List<String> actualInput = AdventUtils.listLinesOfResource("masks.txt");
        long result = dataMasker.sumAllDataFrom(actualInput);
        System.out.println("Result: " + result);
        assertEquals(6513443633260L, result);
    }

    @Test
    void test_exampleInput_v2() {
        DataMaskerV2 dataMasker = new DataMaskerV2();
        List<String> exampleInput = AdventUtils.listLinesOfResource("exampleMasks2.txt");
        long result = dataMasker.sumAllDataFrom(exampleInput);
        System.out.println("Example result: " + result);
        assertEquals(208L, result);
    }

    @Test
    void test_actualInput_v2() {
        DataMaskerV2 dataMasker = new DataMaskerV2();
        List<String> actualInput = AdventUtils.listLinesOfResource("masks.txt");
        long result = dataMasker.sumAllDataFrom(actualInput);
        System.out.println("Result: " + result);
        assertEquals(3442819875191L, result);
    }
}