package com.tuckman.advent.of.code.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkPatternTest {

    @Test
    void happy() {
        assertTrue(WorkPattern.wordPattern("abba", "cat dog dog cat"));
        assertFalse(WorkPattern.wordPattern("abba", "cat dog dog fish"));
        assertTrue(WorkPattern.wordPattern("abca", "cat dog fish cat"));
        assertFalse(WorkPattern.wordPattern("abba", "cat cat cat cat"));
    }
}