package com.tuckman.advent.of.code.day.h;

import com.tuckman.advent.of.code.commons.AdventUtils;
import com.tuckman.advent.of.code.twenty.day.h.XmasDecoder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XmasDecoderTest {
    XmasDecoder xmasDecoder = new XmasDecoder();

    @Test
    void test_exampleInput() {
        List<String> exampleInput = AdventUtils.listLinesOfResource("twenty/exampleXmasCode.txt");
        long invalidNum = xmasDecoder.findFirstInvalidNumber(exampleInput, 5);
        System.out.println("Example invalid num: " + invalidNum);
        assertEquals(127L, invalidNum);
    }

    @Test
    void test_actualInput() {
        List<String> actualInput = AdventUtils.listLinesOfResource("twenty/xmasCode.txt");
        long invalidNum = xmasDecoder.findFirstInvalidNumber(actualInput, 25);
        System.out.println("Actual invalid num: " + invalidNum);
        assertEquals(1038347917L, invalidNum);
    }

    @Test
    void test_exampleInput_weakness() {
        List<String> exampleInput = AdventUtils.listLinesOfResource("twenty/exampleXmasCode.txt");
        long weakness = xmasDecoder.findContinuousSum(exampleInput, 5, 127L);
        System.out.println("Example invalid num: " + weakness);
        assertEquals(62L, weakness);
    }

    @Test
    void test_actualInput_weakness() {
        List<String> actualInput = AdventUtils.listLinesOfResource("twenty/xmasCode.txt");
        long weakness = xmasDecoder.findContinuousSum(actualInput, 25, 1038347917L);
        System.out.println("Actual invalid num: " + weakness);
        assertEquals(137394018L, weakness);
    }
}