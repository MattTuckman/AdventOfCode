package com.tuckman.advent.of.code.day.g;

import com.tuckman.advent.of.code.commons.AdventUtils;
import com.tuckman.advent.of.code.twenty.day.g.AssemblyInterpreter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AssemblyInterpreterTest {
    private AssemblyInterpreter assemblyInterpreter = new AssemblyInterpreter();

    @Test
    void test_exampleInput() {
        List<String> assemblyLines = AdventUtils.listLinesOfResource("twenty/exampleInfiniteLoop.txt");
        long accumulator = assemblyInterpreter.findAccumulatorAtTimeOfLoop(assemblyLines);
        System.out.println("Example accumulator at time of loop: " + accumulator);
        assertEquals(5, accumulator);
    }

    @Test
    void test_actualInput() {
        List<String> assemblyLines = AdventUtils.listLinesOfResource("twenty/infiniteLoopAssembly.txt");
        long accumulator = assemblyInterpreter.findAccumulatorAtTimeOfLoop(assemblyLines);
        System.out.println("Actual accumulator at time of loop: " + accumulator);
        assertEquals(1671, accumulator);
    }

    @Test
    void test_exampleInput_glitch() {
        List<String> assemblyLines = AdventUtils.listLinesOfResource("twenty/exampleInfiniteLoop.txt");
        long accumulator = assemblyInterpreter.fixGlitchFindFinalAccumulator(assemblyLines);
        System.out.println("Example accumulator at time of termination: " + accumulator);
        assertEquals(8, accumulator);
    }

    @Test
    void test_actualInput_glitch() {
        List<String> assemblyLines = AdventUtils.listLinesOfResource("twenty/infiniteLoopAssembly.txt");
        long accumulator = assemblyInterpreter.fixGlitchFindFinalAccumulator(assemblyLines);
        System.out.println("Actual accumulator at time of termination: " + accumulator);
        assertEquals(892, accumulator);
    }
}