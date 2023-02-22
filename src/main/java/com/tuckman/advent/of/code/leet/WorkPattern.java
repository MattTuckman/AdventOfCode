package com.tuckman.advent.of.code.leet;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class WorkPattern {

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        String[] prev = new String[26];
        Set<String> takenWords = new HashSet<>();
        return words.length == pattern.length() &&
                IntStream.range(0, pattern.length())
                .allMatch(i -> {
                    String currWord = words[i];
                    char currLetter = pattern.charAt(i);
                    int currIndex = currLetter - 'a';
                    if (prev[currIndex] == null) {
                        prev[currIndex] = currWord;
                        return takenWords.add(currWord);
                    } else {
                        return currWord.equals(prev[currIndex]);
                    }
                });
    }


}
