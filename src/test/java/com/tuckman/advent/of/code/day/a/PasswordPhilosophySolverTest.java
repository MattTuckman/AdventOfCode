package com.tuckman.advent.of.code.day.a;

import com.tuckman.advent.of.code.twenty.day.a.PasswordPhilosophySolver;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordPhilosophySolverTest {

    PasswordPhilosophySolver passwordPhilosophySolver = new PasswordPhilosophySolver();

    @Test
    void test_actualInput1() throws URISyntaxException {
        URI actualUri = getClass().getClassLoader().getResource("twenty/passwordPhilosophyInput.txt").toURI();
        Path actualPath = Paths.get(actualUri);
        long result = passwordPhilosophySolver.countValidPasswords1(actualPath);
        System.out.println("Number of valid results using first verification:\t" + result);
        assertEquals(493L, result);
    }

    @Test
    void test_actualInput2() throws URISyntaxException {
        URI actualUri = getClass().getClassLoader().getResource("twenty/passwordPhilosophyInput.txt").toURI();
        Path actualPath = Paths.get(actualUri);
        long result = passwordPhilosophySolver.countValidPasswords2(actualPath);
        System.out.println("Number of valid results using second verification:\t" + result);
        assertEquals(593L, result);
    }
}