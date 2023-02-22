package com.tuckman.advent.of.code.twentyTwo.b;

import com.tuckman.advent.of.code.commons.AdventUtils;
import com.tuckman.advent.of.code.twentyTwo.a.Calories;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RPS {

    // Not sure why I was inspired to make a 2d array but w/e
    private static final int[][] SCORE_KEY = {
            {3, 6, 0},
            {0, 3, 6},
            {6, 0, 3}
    };

    public int getScore(Stream<String> rounds) {
        List<MutablePair<Character, Character>> moves = rounds.map(a -> new MutablePair<>(a.charAt(0), a.charAt(2)))
                .collect(Collectors.toList());
        int playScore = moves.stream().map(move -> move.right - 'W').reduce(Integer::sum).orElse(0);
        int winScore = moves.stream().map(move -> SCORE_KEY[move.left - 'A'][move.right - 'X'])
                .reduce(Integer::sum).orElse(0);
        return playScore + winScore;
    }

    // Written out in notes why
    private static final int[][] SCORE_KEY_2 = {
            {3, 1, 2},
            {1, 2, 3},
            {2, 3, 1}
    };

    public int getScore2(Stream<String> rounds) {
        List<MutablePair<Character, Character>> moves = rounds.map(a -> new MutablePair<>(a.charAt(0), a.charAt(2)))
                .collect(Collectors.toList());

        // X lose, Y tie, Z win so 0, 3, 6 points
        int winScore = moves.stream().map(move -> 3 * move.right - 'X').reduce(Integer::sum).orElse(0);
        int playScore = moves.stream().map(move -> SCORE_KEY_2[move.left - 'A'][move.right - 'X'])
                .reduce(Integer::sum).orElse(0);
        return playScore + winScore;
    }

}
