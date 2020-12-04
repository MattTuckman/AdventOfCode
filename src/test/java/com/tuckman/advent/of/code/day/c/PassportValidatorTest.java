package com.tuckman.advent.of.code.day.c;

import com.tuckman.advent.of.code.commons.AdventUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PassportValidatorTest {

    @Test
    void test_exampleProblem() {
        List<String> input = AdventUtils.listLinesOfResource("examplePassports.txt");

        List<String> required = Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");//, "cid");
        PassportValidator passportValidator = new PassportValidator(required);
        long validCount = passportValidator.countValidPassports(input);
        System.out.println("Valid passport count: " + validCount);
        assertEquals(2L, validCount);
    }

    @Test
    void test_actualProblem() {
        List<String> lines = AdventUtils.listLinesOfResource("passportsInput.txt");

        List<String> required = Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");//, "cid");
        PassportValidator passportValidator = new PassportValidator(required);
        long validCount = passportValidator.countValidPassports(lines);
        System.out.println("Valid passport count: " + validCount);
        assertEquals(226L, validCount);
    }



}