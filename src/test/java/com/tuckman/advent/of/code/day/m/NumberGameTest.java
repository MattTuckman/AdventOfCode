package com.tuckman.advent.of.code.day.m;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberGameTest {
    @Test
    void test_exampleInput() {
        List<Integer> input = Arrays.asList(0,3,6);
        NumberGame numberGame = new NumberGame();
        int result = numberGame.find2020Number(input);
        assertEquals(436, result);
    }

    @Test
    void test_actualInput() {
        List<Integer> input = Arrays.asList(9,12,1,4,17,0,18);
        NumberGame numberGame = new NumberGame();
        int result = numberGame.find2020Number(input);
        assertEquals(610, result);
    }

    @Test
    void test_exampleInput_30mil() {
        List<Integer> input = Arrays.asList(0,3,6);
        NumberGame numberGame = new NumberGame();
        int result = numberGame.find30MilNumber(input);
        assertEquals(175594, result);
    }

    @Test
    void test_actualInput_30mil() {
        List<Integer> input = Arrays.asList(9,12,1,4,17,0,18);
        NumberGame numberGame = new NumberGame();
        int result = numberGame.find30MilNumber(input);
        assertEquals(1407, result);
    }
}