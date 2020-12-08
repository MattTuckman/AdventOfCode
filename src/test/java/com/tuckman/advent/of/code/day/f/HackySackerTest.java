package com.tuckman.advent.of.code.day.f;

import com.tuckman.advent.of.code.commons.AdventUtils;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HackySackerTest {

    HackySacker hackySacker = new HackySacker();

    @Test
    void test_exampleInput() {
        List<String> exampleInput = AdventUtils.listLinesOfResource("exampleHackySacks.txt");
        Set<String> goldSacks = hackySacker.sacksContainingGold(exampleInput);
        System.out.println("Sacks with gold: " + goldSacks);
        System.out.println("# sacks that can contain gold:" + goldSacks.size());
        assertEquals(4, goldSacks.size());
    }

    @Test
    void test_actualInput() {
        List<String> actualInput = AdventUtils.listLinesOfResource("hackySacks.txt");
        Set<String> goldSacks = hackySacker.sacksContainingGold(actualInput);
        System.out.println("Sacks with gold: " + goldSacks);
        System.out.println("# sacks that can contain gold: " + goldSacks.size());
        assertEquals(119, goldSacks.size());
    }

    @Test
    void test_exampleInput1_problem2() {
        List<String> exampleInput = AdventUtils.listLinesOfResource("exampleHackySacks.txt");
        long goldSacks = hackySacker.bagsInGoldBag(exampleInput);
        System.out.println("Sacks in gold sack: " + goldSacks);
        assertEquals(32, goldSacks);
    }

    @Test
    void test_exampleInput2_problem2() {
        List<String> exampleInput = AdventUtils.listLinesOfResource("exampleHackySacks2.txt");
        long goldSacks = hackySacker.bagsInGoldBag(exampleInput);
        System.out.println("Sacks in gold sack: " + goldSacks);
        assertEquals(126, goldSacks);
    }

    @Test
    void test_actualInput_problem2() {
        List<String> actualInput = AdventUtils.listLinesOfResource("hackySacks.txt");
        long goldSacks = hackySacker.bagsInGoldBag(actualInput);
        System.out.println("Sacks in gold sack: " + goldSacks);
    }
}