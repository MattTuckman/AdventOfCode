package com.tuckman.advent.of.code.day.b;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SkiTreeCollisionDetectorTest {

    SkiTreeCollisionDetector skiTreeCollisionDetector = new SkiTreeCollisionDetector();

    @Test
    void test_exampleInput() throws URISyntaxException, IOException {
        URI actualUri = getClass().getClassLoader().getResource("exampleSkiProblem.txt").toURI();
        Path actualPath = Paths.get(actualUri);
        BufferedReader br = Files.newBufferedReader(actualPath);
        List<String> input = br.lines().collect(Collectors.toList());

        long collisions = skiTreeCollisionDetector.howManyTreesWereHit(input, 3, 1);
        assertEquals(7, collisions);
    }

    @Test
    void test_actualInput() throws URISyntaxException, IOException {
        URI actualUri = getClass().getClassLoader().getResource("skiTreeProblem.txt").toURI();
        Path actualPath = Paths.get(actualUri);
        BufferedReader br = Files.newBufferedReader(actualPath);
        List<String> input = br.lines().collect(Collectors.toList());

        long collisions = skiTreeCollisionDetector.howManyTreesWereHit(input, 3, 1);
        System.out.println("Problem 1, num collisions: " + collisions);
        assertEquals(205, collisions);
    }

    @Test
    void test_secondProblem() throws URISyntaxException, IOException {
        URI actualUri = getClass().getClassLoader().getResource("skiTreeProblem.txt").toURI();
        Path actualPath = Paths.get(actualUri);
        BufferedReader br = Files.newBufferedReader(actualPath);
        List<String> input = br.lines().collect(Collectors.toList());

        long collisions11 = skiTreeCollisionDetector.howManyTreesWereHit(input, 1, 1);
        long collisions31 = skiTreeCollisionDetector.howManyTreesWereHit(input, 3, 1);
        long collisions51 = skiTreeCollisionDetector.howManyTreesWereHit(input, 5, 1);
        long collisions71 = skiTreeCollisionDetector.howManyTreesWereHit(input, 7, 1);
        long collisions32 = skiTreeCollisionDetector.howManyTreesWereHit(input, 1, 2);

        long result = collisions11 * collisions31 * collisions51 * collisions71 * collisions32;

        System.out.println("Problem 2, num collisions: "
                + collisions11 + "*"
                + collisions31 + "*"
                + collisions51 + "*"
                + collisions71 + "*"
                + collisions32 + "="
                + result);
        System.out.println("test: " + 4*2*3);
        assertEquals(3952146825L, result);
    }
}