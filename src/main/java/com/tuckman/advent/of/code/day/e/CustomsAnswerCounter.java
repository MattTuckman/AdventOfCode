package com.tuckman.advent.of.code.day.e;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class CustomsAnswerCounter {

    public int countTotalAnswers(List<String> surveys) {
        StringBuilder answerBatch = new StringBuilder();

        int numAnswers = 0;

        for (int i = 0; i < surveys.size(); i++) {
            String currLine = surveys.get(i);

            if (StringUtils.isBlank(currLine)) {
                numAnswers += numAnswers(answerBatch.toString());
                answerBatch = new StringBuilder();
            } else {
                answerBatch.append(currLine);
            }
        }

        // Last group check
        numAnswers += numAnswers(answerBatch.toString());

        return numAnswers;
    }

    private int numAnswers(String groupInput) {
        Set answers = new HashSet<Character>();

        for (char chr : groupInput.toCharArray()) {
            answers.add(chr);
        }
        return answers.size();
    }

    public int countTotalAnswers2(List<String> surveys) {
        StringBuilder answerBatch = new StringBuilder();

        int numAnswers = 0;

        for (int i = 0; i < surveys.size(); i++) {
            String currLine = surveys.get(i);

            if (StringUtils.isBlank(currLine)) {
                numAnswers += numAnswers2(answerBatch.toString());
                answerBatch = new StringBuilder();
            } else {
                answerBatch.append(currLine);
                answerBatch.append(' ');
            }
        }

        // Last group check
        numAnswers += numAnswers2(answerBatch.toString());

        return numAnswers;
    }

    private int numAnswers2(String groupInput) {
        String[] splitGroupInput = groupInput.split(" ");

        List<Character> allAnsweredChars = splitGroupInput[0].chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toList());

        for (int i = 1; i < splitGroupInput.length; i++) {
            String currInput = splitGroupInput[i];
            for (int j = 0; j < allAnsweredChars.size(); j++) {
                Character currChar = allAnsweredChars.get(j);
                if (!currInput.contains("" + currChar)) {
                    allAnsweredChars.remove(j);
                    j--;
                }
            }
        }
        return allAnsweredChars.size();
    }
}
