package com.tuckman.advent.of.code.twenty.day.c;

import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdvancedPassportValidator extends PassportValidator {

    private static final Pattern fieldPat = Pattern.compile("(\\S+):(\\S+)");

    private static Set<String> allowedEyeColors =
            new HashSet<>(Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth"));

    private static final Pattern hairColorRegex = Pattern.compile("#[a-f0-9]{6}");

    private static final Pattern passportIdRegex = Pattern.compile("[0-9]{9}");

    private static Map<String, Predicate<String>> fieldValidators;

    static {
        fieldValidators = new HashMap<>();
        fieldValidators.put("byr", input -> stringNumInRange(input, 1920, 2002));
        fieldValidators.put("iyr", input -> stringNumInRange(input, 2010, 2020));
        fieldValidators.put("eyr", input -> stringNumInRange(input, 2020, 2030));
        fieldValidators.put("hgt", input -> {
            if (input.endsWith("cm")) {
                return stringNumInRange(input.replaceFirst("cm", ""), 150, 193);
            } else if (input.endsWith("in")) {
                return stringNumInRange(input.replaceFirst("in", ""), 59, 76);
            } else {
                return false;
            }
        });
        fieldValidators.put("hcl", input -> {
            Matcher matcher = hairColorRegex.matcher(input);
            return matcher.find(); // If theres a match, it is valid
        });
        fieldValidators.put("ecl", input -> allowedEyeColors.contains(input));
        fieldValidators.put("pid", input -> {
            Matcher matcher = passportIdRegex.matcher(input);
            return matcher.find(); // If theres a match, it is valid
        });
    }


    @Override
    protected boolean isValidPassport(String passport) {
        Matcher matches = fieldPat.matcher(passport);
        Map<String, String> allMatches = new HashMap<>();
        while(matches.find()) {
            // Group 1 is match before ':', group 2 is match after ':'
            allMatches.put(matches.group(1), matches.group(2));
        }

        boolean result = !fieldValidators.keySet().stream()
                .anyMatch(requiredField -> {
                    // Check if any of the field validators ***DO NOT*** pass
                    if (allMatches.containsKey(requiredField)) {
                        // Get the value portion of the field and check that the validator predicate passes
                        String actualValue = allMatches.get(requiredField);
                        boolean isInvalid = fieldValidators.get(requiredField).negate().test(actualValue);
                        return isInvalid;
                    }

                    // Invalid case
                    return true;
                });
        return result;
    }

    private static boolean stringNumInRange(String num, int low, int high) {
        int inputNum = 0;
        try {
            inputNum = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return false;
        }
        return low <= inputNum && inputNum <= high;
    }
}
