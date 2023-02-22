package com.tuckman.advent.of.code.twenty.day.m;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Tried the quick and dirty method without caring about style or readability. Thought complexity was too big to
 * brute force the 30,000,000 at first but I was just using sout too frequently so slowed that down and it worked
 * fine afterwards. Added assertions to tests after just to have them.
 */
public class NumberGame {

    public int find2020Number(List<Integer> input) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < input.size() - 1; i++) {
            numMap.put(input.get(i), i + 1);
            System.out.println("Turn: " + (i + 1) + " : " + input.get(i));
        }

        int count = input.size() + 1;
        int previous = input.get(input.size() - 1);

        while (count <= 2020) {
            int tempPrev = previous;

            if (numMap.containsKey(previous)) {
                previous = count - numMap.get(previous) - 1;
            } else {
                previous = 0;
            }
            numMap.put(tempPrev, count - 1);
            System.out.println("Turn: " + (count - 1) + " : " + tempPrev);

            count++;
        }
        System.out.println("Turn: " + (count - 1) + " : " + previous);
        return previous;
    }

    public int find30MilNumber(List<Integer> input) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < input.size() - 1; i++) {
            numMap.put(input.get(i), i + 1);
        }

        int count = input.size() + 1;
        int previous = input.get(input.size() - 1);

        while (count <= 30000000) {
            int tempPrev = previous;

            if (count % 1000000 == 0) {
                System.out.println("Turn: " + (count) + " : " + previous);
            }

            if (numMap.containsKey(previous)) {
                previous = count - numMap.get(previous) - 1;
            } else {
                previous = 0;
            }
            numMap.put(tempPrev, count - 1);

            count++;
        }

        System.out.println("Turn: " + (count - 1) + " : " + previous);

        return previous;
    }
}
