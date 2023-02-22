package com.tuckman.advent.of.code.twenty.day.c;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassportValidator {

    private static final Pattern fieldPat = Pattern.compile("([a-z]+):");

    private List<String> requiredFields = Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");

    public long countValidPassports(List<String> passports) {
        StringBuilder passwordBatch = new StringBuilder();

        long numValid = 0;

        for (int i = 0; i < passports.size(); i++) {
            String currLine = passports.get(i);

            if (StringUtils.isBlank(currLine)) {
                 if (isValidPassport(passwordBatch.toString())) {
                     numValid++;
                 }
                 passwordBatch = new StringBuilder();
            } else {
                passwordBatch.append(currLine);
                passwordBatch.append(' ');
            }
        }

        // Last passport check
        if (isValidPassport(passwordBatch.toString())) {
            numValid++;
        }

        return numValid;
    }

    protected boolean isValidPassport(String passport) {
        Matcher matches = fieldPat.matcher(passport);
        Set<String> allMatches = new HashSet<>();
        while(matches.find()) {
            // Group 1 is apparently the match while group 0 is the while thing ;)
            allMatches.add(matches.group(1));
        }

        boolean result = !requiredFields.stream()
                .anyMatch(field -> !allMatches.contains(field));
        return result;
    }
}
