package com.tuckman.advent.of.code.twenty.day.h;

import java.util.List;
import java.util.stream.Collectors;

public class XmasDecoder {

    public long findFirstInvalidNumber(List<String> input, int preambleLength) {
        List<Long> longInput = input.stream()
                .map(Long::parseLong)
                .collect(Collectors.toList());

        for (int i = preambleLength; i < input.size(); i++) {
            if (!combinationExists(longInput.subList(i - preambleLength, i), longInput.get(i))) {
                return longInput.get(i);
            }
        }

        throw new RuntimeException("Reached end of the list and found no invalid numbers");
    }

    public long findContinuousSum(List<String> input, int preambleLength, long targetNumber) {
        List<Long> longInput = input.stream()
                .map(Long::parseLong)
                .collect(Collectors.toList());

        long currentSum = longInput.get(0);
        int startIndex = 0;
        int endIndex = 0;

        while (startIndex < longInput.size()) {
            if (currentSum == targetNumber) {
                System.out.println("Indicies: " + startIndex + ", " + endIndex);
                System.out.println("Values:   " + longInput.get(startIndex) + ", " + longInput.get(endIndex));
                List<Long> answerList = longInput.subList(startIndex, endIndex + 1);
                answerList.sort(Long::compare);
                System.out.println("Largest/Smallest: "
                        + answerList.get(0) + "/" + answerList.get(answerList.size() - 1));
                return answerList.get(0) + answerList.get(answerList.size() - 1);
            }


            if (endIndex != longInput.size() - 1 && (currentSum < targetNumber || startIndex == endIndex)) {
                currentSum += longInput.get(++endIndex);
            } else {
                currentSum -= longInput.get(startIndex++);
            }
        }

        throw new RuntimeException("Reached end of the list and found no invalid numbers");
    }

    /**
     * Brute force check if a combination exists
     */
    private boolean combinationExists(List<Long> list, Long target) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
