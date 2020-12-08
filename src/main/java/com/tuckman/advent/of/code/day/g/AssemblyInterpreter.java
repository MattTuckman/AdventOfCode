package com.tuckman.advent.of.code.day.g;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AssemblyInterpreter {

    private static String INSTRUCTION_GROUP = "instruction";
    private static String SIGN_GROUP = "posOrNeg";
    private static String AMOUNT_GROUP = "actualAmountValue";

    // Tried new form, a bit hard to read, regex is: "([a-z]{3}) (?[+-])(?\\d*)";
    private static String INSTRUCTION_REGEX_STRING =
            "(?<" + INSTRUCTION_GROUP + ">[a-z]{3}) (?<" + SIGN_GROUP + ">[+-])(?<" + AMOUNT_GROUP + ">\\d*)";

    private static Pattern INSTRUCTION_PAT = Pattern.compile(INSTRUCTION_REGEX_STRING);
    private final String acc = "acc";
    private final String jmp = "jmp";
    private final String nop = "nop";

    public long findAccumulatorAtTimeOfLoop(List<String> instructions) {
        int instructionPointer = 0;
        long accumulator = 0;
        Set<Integer> previousPointers = new HashSet<>();

        while (instructionPointer < instructions.size()) {
            if (previousPointers.contains(instructionPointer)) {
                return accumulator;
            } else {
                previousPointers.add(instructionPointer);
            }

            String currInstructionString = instructions.get(instructionPointer);
            Matcher currInstructionMatcher = INSTRUCTION_PAT.matcher(currInstructionString);
            if (!currInstructionMatcher.find()) {
                throw new RuntimeException("Invalid instruction parsed on line: " + instructionPointer);
            }

            String instruction = currInstructionMatcher.group(INSTRUCTION_GROUP);
            int sign = "-".equals(currInstructionMatcher.group(SIGN_GROUP)) ? -1 : 1;
            int amount = Integer.parseInt(currInstructionMatcher.group(AMOUNT_GROUP));
            int signedAmount = sign * amount;

            switch (instruction) {
                case acc: accumulator += signedAmount; break;
                case "jmp" : instructionPointer += signedAmount - 1; break; // -1 since we increment at the end of loop
                case "nop" : break;
                default: throw new RuntimeException("No known instruction matched for instruction: " + instruction);
            }

            instructionPointer++;
        }

        throw new RuntimeException("No infinite loop found, accumulator:" + accumulator);
    }

    private enum GlitchState {
        HAVE_POSSIBLE_INDEX,
        LOOKING_FOR_POSSIBLE_INDEX,
        INDEX_JUST_FAILED
    }

    /**
     * Swap first nop/jmp that is found and continue as normal without swapping. If loop is found revert back to state
     * when the instruction was swapped and look for the next instruction to try swapping. Terminate when swapping an
     * instruction allow the end to be reached meaning we found the glitch index.
     * @param instructions
     * @return
     */
    public long fixGlitchFindFinalAccumulator(List<String> instructions) {
        int instructionPointer = 0;
        long accumulator = 0;

        // Default values, meaning no glitch index is set
        GlitchState state = GlitchState.LOOKING_FOR_POSSIBLE_INDEX;
        int possibleGlitchIndex = -1;
        Set<Integer> pointersAtGlitchIndex = null;
        long accumulatorAtGlitchIndex = -1;

        Set<Integer> previousPointers = new HashSet<>();

        while (instructionPointer < instructions.size()) {
            if (previousPointers.contains(instructionPointer) && GlitchState.INDEX_JUST_FAILED != state) {
                // Reset back to last flipped instruction
                instructionPointer = possibleGlitchIndex;
                previousPointers = new HashSet<>(pointersAtGlitchIndex);
                accumulator = accumulatorAtGlitchIndex;

                // Reset these values
                state = GlitchState.INDEX_JUST_FAILED;
                possibleGlitchIndex = -1;
                pointersAtGlitchIndex = null;
                accumulatorAtGlitchIndex = -1;
                continue;
            } else {
                previousPointers.add(instructionPointer);
            }

            String currInstructionString = instructions.get(instructionPointer);
            Matcher currInstructionMatcher = INSTRUCTION_PAT.matcher(currInstructionString);
            if (!currInstructionMatcher.find()) {
                throw new RuntimeException("Invalid instruction parsed on line: " + instructionPointer);
            }

            String instruction = currInstructionMatcher.group(INSTRUCTION_GROUP);
            int sign = "-".equals(currInstructionMatcher.group(SIGN_GROUP)) ? -1 : 1;
            int amount = Integer.parseInt(currInstructionMatcher.group(AMOUNT_GROUP));
            int signedAmount = sign * amount;

            // Case where we are looking for a new index
            if (GlitchState.LOOKING_FOR_POSSIBLE_INDEX == state) {
                // Swap instructions if we have a match, update states
                if (nop.equals(instruction) || jmp.equals(instruction)) {
                    instruction = nop.equals(instruction) ? jmp : nop;
                    possibleGlitchIndex = instructionPointer;
                    pointersAtGlitchIndex = new HashSet<>(previousPointers);
                    accumulatorAtGlitchIndex = accumulator;
                    state = GlitchState.HAVE_POSSIBLE_INDEX;
                }
            } else if (GlitchState.INDEX_JUST_FAILED == state) {
                state = GlitchState.LOOKING_FOR_POSSIBLE_INDEX;
            }

            switch (instruction) {
                case acc: accumulator += signedAmount; break;
                case jmp: instructionPointer += signedAmount - 1; break; // -1 since we increment at the end of loop
                case nop: break;
                default: throw new RuntimeException("No known instruction matched for instruction: " + instruction);
            }

            instructionPointer++;
        }
        System.out.println("Glitch index was: " + possibleGlitchIndex);
        return accumulator;
    }
}
