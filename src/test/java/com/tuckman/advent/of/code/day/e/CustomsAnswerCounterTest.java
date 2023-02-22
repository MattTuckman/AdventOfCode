package com.tuckman.advent.of.code.day.e;

import com.tuckman.advent.of.code.commons.AdventUtils;
import com.tuckman.advent.of.code.twenty.day.e.CustomsAnswerCounter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomsAnswerCounterTest {
    CustomsAnswerCounter customsAnswerCounter = new CustomsAnswerCounter();


    @Test
    void test_acutalInput() {
        List<String> input = AdventUtils.listLinesOfResource("twenty/customsDeclarations.txt");
        int numAnswers = customsAnswerCounter.countTotalAnswers(input);
        System.out.println("Total actual answers: " + numAnswers);

    }

    @Test
    void test_exampleInput() {
        List<String> input = AdventUtils.listLinesOfResource("twenty/exampleCustomsDeclarations.txt");
        int numAnswers = customsAnswerCounter.countTotalAnswers(input);
        System.out.println("Total example answers: " + numAnswers);

        assertEquals(11, numAnswers);
    }

    @Test
    void test_acutalInput_2() {
        List<String> input = AdventUtils.listLinesOfResource("twenty/customsDeclarations.txt");
        int numAnswers = customsAnswerCounter.countTotalAnswers2(input);
        System.out.println("Total actual answers: " + numAnswers);

    }

    @Test
    void test_exampleInput_2() {
        List<String> input = AdventUtils.listLinesOfResource("twenty/exampleCustomsDeclarations.txt");
        int numAnswers = customsAnswerCounter.countTotalAnswers2(input);
        System.out.println("Total example answers: " + numAnswers);

        assertEquals(6, numAnswers);
    }
}