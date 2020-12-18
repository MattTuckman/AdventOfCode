package com.tuckman.advent.of.code.day.n;

import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * PROCEED WITH CAUTION, THIS CODE WAS WRITTEN WITH NO SLEEP
 */
public class ValidTicket {

    private Pattern FIELD_PAT = Pattern.compile("(.*): (\\d+)-(\\d+) or (\\d+)-(\\d+)");

    public long findInvalidTicket(List<String> input) {
        Map<String, Predicate<Integer>> fieldRules = new HashMap<>();

        int index = 0;
        while (!input.get(index).isEmpty()) {
            Matcher mch = FIELD_PAT.matcher(input.get(index));
            if (!mch.find()) {
                throw new RuntimeException("No Match???");
            }

            String fieldName = mch.group(1);
            Integer fieldLow1 = Integer.parseInt(mch.group(2));
            Integer fieldHigh1 = Integer.parseInt(mch.group(3));
            Integer fieldLow2 = Integer.parseInt(mch.group(4));
            Integer fieldHigh2 = Integer.parseInt(mch.group(5));

            // Valid for the field if it is in one of the ranges
            fieldRules.put(fieldName, num -> (fieldLow1 <= num && num <= fieldHigh1)
                    || (fieldLow2 <= num && num <= fieldHigh2));
            index++;
        }
        index += 2;
        String myTicket = input.get(index);
        index += 3;

        long total = 0;

        while (index < input.size()) {
            List<Integer> currFieldValues = Arrays.stream(input.get(index).split(","))
                    .map(Integer::parseInt)

                    .collect(Collectors.toList());

            total += currFieldValues.stream()
                    .filter(value -> !fieldRules.values()
                            .stream()
                            .anyMatch(pred -> pred.test(value)))
                    .reduce((a, b) -> a + b)
                    .orElse(0);
            index++;
        }
        return total;
    }

    public long findTicketFieldsWithDeparture(List<String> input) {
        Map<String, Predicate<Integer>> fieldRules = new HashMap<>();

        int index = 0;
        while (!input.get(index).isEmpty()) {
            Matcher mch = FIELD_PAT.matcher(input.get(index));
            if (!mch.find()) {
                throw new RuntimeException("No Match???");
            }

            String fieldName = mch.group(1);
            Integer fieldLow1 = Integer.parseInt(mch.group(2));
            Integer fieldHigh1 = Integer.parseInt(mch.group(3));
            Integer fieldLow2 = Integer.parseInt(mch.group(4));
            Integer fieldHigh2 = Integer.parseInt(mch.group(5));

            // Valid for the field if it is in one of the ranges
            fieldRules.put(fieldName, num -> (fieldLow1 <= num && num <= fieldHigh1)
                    || (fieldLow2 <= num && num <= fieldHigh2));
            index++;
        }
        index += 2;
        List<Integer> myTicket = Arrays.stream(input.get(index).split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        index += 3;

        List<List<Integer>> validTickets = new ArrayList<>();
        validTickets.add(myTicket);

        while (index < input.size()) {
            List<Integer> currFieldValues = Arrays.stream(input.get(index).split(","))
                    .map(Integer::parseInt)

                    .collect(Collectors.toList());

            boolean isValid = !currFieldValues.stream()
                    .anyMatch(value -> !fieldRules.values()
                            .stream()
                            .anyMatch(pred -> pred.test(value)));

            if (isValid) {
                validTickets.add(currFieldValues);
            }

            index++;
        }

        List<Set<String>> possibleFields = new ArrayList<>();
        for (int i = 0; i < myTicket.size(); i++) {
            Set<String> newSet = new HashSet<>();
            newSet.addAll(fieldRules.keySet());
            possibleFields.add(newSet);
        }

        for (List<Integer> validTicket : validTickets) {
            for (int j = 0; j < validTicket.size(); j++) {
                Integer currValue = validTicket.get(j);
                for (String field : fieldRules.keySet()) {
                    if (!fieldRules.get(field).test(currValue)) {
                        possibleFields.get(j).remove(field);
                    }
                }
            }
        }

        Set<String> solvedFields = new HashSet<>();

        boolean done = false;
        while (!done) {
            done = true;

            for (Set<String> possible : possibleFields) {
                if (possible.size() == 1) {
                    String foundValue = possible.stream().findFirst().orElse(null);

                    if (solvedFields.contains(foundValue)) {
                        continue;
                    }

                    for (Set<String> otherFields : possibleFields) {
                        if (otherFields.size() != 1) {
                            otherFields.remove(foundValue);
                        }
                    }

                    solvedFields.add(foundValue);

                    done = false;
                    break;
                }
            }
        }

        long total = 1;

        for (int i = 0; i < possibleFields.size(); i++) {
            String fieldName = possibleFields.get(i).stream().findFirst().orElse(null);

            if (fieldName.startsWith("departure")) {
                total *= myTicket.get(i);
            }
        }

        System.out.println(possibleFields);

        return total;
    }
}
