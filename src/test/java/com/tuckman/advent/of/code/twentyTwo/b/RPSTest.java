package com.tuckman.advent.of.code.twentyTwo.b;

import com.tuckman.advent.of.code.commons.AdventUtils;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RPSTest {

    RPS rps = new RPS();

    @Test
    public void test1() {
        Stream<String> scoreStream = AdventUtils.streamLinesOfResource("twentyTwo/b");
        int score = rps.getScore(scoreStream);
        assertEquals(13682, score);
    }

    @Test
    public void test2() {
        Stream<String> scoreStream = AdventUtils.streamLinesOfResource("twentyTwo/b");
        int score = rps.getScore2(scoreStream);
        System.out.println(score);
//        assertEquals(13682, score);
    }
}