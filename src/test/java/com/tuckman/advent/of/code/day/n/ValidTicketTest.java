package com.tuckman.advent.of.code.day.n;

import com.tuckman.advent.of.code.commons.AdventUtils;
import com.tuckman.advent.of.code.twenty.day.n.ValidTicket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidTicketTest {
    ValidTicket validTicket = new ValidTicket();

    @Test
    void test_exampleInput() {
        List<String> exampleInput = AdventUtils.listLinesOfResource("twenty/exampleTickets.txt");
        long result = validTicket.findInvalidTicket(exampleInput);
        System.out.println("Ex result: " + result);
        assertEquals(71L, result);
    }

    @Test
    void test_actualInput() {
        List<String> actualInput = AdventUtils.listLinesOfResource("twenty/tickets.txt");
        long result = validTicket.findInvalidTicket(actualInput);
        System.out.println("Result: " + result);
        assertEquals(71L, result);
    }

    @Test
    void test_exampleInput_findFields() {
        List<String> exampleInput = AdventUtils.listLinesOfResource("twenty/exampleTickets2.txt");
        validTicket.findTicketFieldsWithDeparture(exampleInput);
    }

    @Test
    void test_actualInput_findFields() {
        List<String> actualInput = AdventUtils.listLinesOfResource("twenty/tickets.txt");
        long result = validTicket.findTicketFieldsWithDeparture(actualInput);
        System.out.println("Wowee: " + result);
    }
}