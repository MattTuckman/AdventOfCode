package com.tuckman.advent.of.code.day.c;

import com.tuckman.advent.of.code.commons.AdventUtils;
import com.tuckman.advent.of.code.twenty.day.c.PassportValidator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PassportValidatorTest {

    @Test
    void test_exampleProblem() {
        List<String> input = AdventUtils.listLinesOfResource("twenty/examplePassports.txt");

        PassportValidator passportValidator = new PassportValidator();
        long validCount = passportValidator.countValidPassports(input);
        System.out.println("Valid passport count: " + validCount);
        assertEquals(2L, validCount);
    }

    @Test
    void test_actualProblem() {
        List<String> lines = AdventUtils.listLinesOfResource("twenty/passportsInput.txt");

        PassportValidator passportValidator = new PassportValidator();
        long validCount = passportValidator.countValidPassports(lines);
        System.out.println("Valid passport count: " + validCount);
        assertEquals(226L, validCount);
    }



}