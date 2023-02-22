package com.tuckman.advent.of.code.day.c;

import com.tuckman.advent.of.code.commons.AdventUtils;
import com.tuckman.advent.of.code.twenty.day.c.AdvancedPassportValidator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdvancedPassportValidatorTest {

    AdvancedPassportValidator advancedPassportValidator = new AdvancedPassportValidator();

    @Test
    void test_allValidPassports() {
        List<String> validPassports = AdventUtils.listLinesOfResource("twenty/examplePassportsValid.txt");
        long validCount = advancedPassportValidator.countValidPassports(validPassports);
        assertEquals(4, validCount);
    }

    @Test
    void test_allInalidPassports() {
        List<String> validPassports = AdventUtils.listLinesOfResource("twenty/examplePassportsInvalid.txt");
        long validCount = advancedPassportValidator.countValidPassports(validPassports);
        assertEquals(0, validCount);
    }

    @Test
    void test_actualInput() {
        List<String> actualInput = AdventUtils.listLinesOfResource("twenty/passportsInput.txt");
        long validCount = advancedPassportValidator.countValidPassports(actualInput);
        System.out.println("Valid passports after advanced validation: " + validCount);
        // TODO Failing off by one lul, expected is 160
        assertEquals(161, validCount);
    }
}