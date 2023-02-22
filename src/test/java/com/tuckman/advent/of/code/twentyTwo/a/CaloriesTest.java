package com.tuckman.advent.of.code.twentyTwo.a;

import com.tuckman.advent.of.code.commons.AdventUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CaloriesTest {

    Calories calories = new Calories();

    @Test
    void test() {
        List<String> input = AdventUtils.listLinesOfResource("twentyTwo/a");
        int mostCalories = calories.getMostCalories(input);
        assertEquals(72602, mostCalories);
    }

    @Test
    void test2() {
        List<String> input = AdventUtils.listLinesOfResource("twentyTwo/a");
        int mostCalories = calories.getTopThreeCalories(input);
        assertEquals(207410, mostCalories);
    }
}