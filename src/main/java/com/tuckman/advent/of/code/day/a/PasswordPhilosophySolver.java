package com.tuckman.advent.of.code.day.a;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;

@NoArgsConstructor
public class PasswordPhilosophySolver {

    // Regex working fine in online checker but failing to match here. Will use substrings instead ¯\_(ツ)_/¯
    // private static final Pattern PASS_PATTERN = Pattern.compile("([0-9]+)-([0-9]+) ([a-z]): (.*)");
    // private static final int NUM_EXPECTED_GROUPS = 4;

    @SneakyThrows
    public long countValidPasswords1(Path path) {
        BufferedReader br = Files.newBufferedReader(path);

        return br.lines()
                .filter(this::passwordIsValid1)
                .count();
    }

    private boolean passwordIsValid1(String passwordLine) {

        int hyphenIndex = passwordLine.indexOf('-');
        int colonIndex = passwordLine.indexOf(':');
        int spaceIndex = passwordLine.indexOf(' ');

        int min = Integer.parseInt(passwordLine.substring(0, hyphenIndex));
        int max = Integer.parseInt(passwordLine.substring(hyphenIndex + 1, spaceIndex));

        char matchingChar = passwordLine.charAt(colonIndex - 1);

        String password = passwordLine.substring(colonIndex + 2);

        long numMatched = password.chars()
                .filter(ch -> ch == matchingChar)
                .count();

        return min <= numMatched && numMatched <= max;
    }

    @SneakyThrows
    public long countValidPasswords2(Path path) {
        BufferedReader br = Files.newBufferedReader(path);

        return br.lines()
                .filter(this::passwordIsValid2)
                .count();
    }

    private boolean passwordIsValid2(String passwordLine) {
        int hyphenIndex = passwordLine.indexOf('-');
        int colonIndex = passwordLine.indexOf(':');
        int spaceIndex = passwordLine.indexOf(' ');

        int index1 = Integer.parseInt(passwordLine.substring(0, hyphenIndex)) - 1;
        int index2 = Integer.parseInt(passwordLine.substring(hyphenIndex + 1, spaceIndex)) - 1;

        char expectedChar = passwordLine.charAt(colonIndex - 1);

        String password = passwordLine.substring(colonIndex + 2);

        char char1 = password.charAt(index1);
        char char2 = password.charAt(index2);

        return char1 == expectedChar ? char2 != expectedChar : char2 == expectedChar;
    }
}
