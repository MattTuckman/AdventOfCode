package com.tuckman.advent.of.code.twentyTwo.a;

import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Calories {

    @SneakyThrows
    public int getMostCalories(List<String> calories) {
        int max = 0;
        int currCal = 0;
        for (String calorie : calories) {
            if (StringUtils.isBlank(calorie)) {
                currCal = 0;
                continue;
            }
            currCal += Integer.parseInt(calorie);
            max = Math.max(max, currCal);
        }
        return max;
    }

    public TreeSet<Integer> getMostCalories2(List<String> calories) {
        int currCal = 0;
        TreeSet<Integer> elfCals = new TreeSet<>();
        for (String calorie : calories) {
            if (StringUtils.isBlank(calorie)) {
                elfCals.add(currCal);
                currCal = 0;
                continue;
            }
            currCal += Integer.parseInt(calorie);
        }
        return elfCals;
    }

    public int getTopThreeCalories(List<String> calories) {
        TreeSet<Integer> mostCalories2 = getMostCalories2(calories);
        Iterator<Integer> descendingIterator = mostCalories2.descendingIterator();
        return descendingIterator.next() + descendingIterator.next() + descendingIterator.next();
//        Integer[] cals = mostCalories2.toArray(new Integer[]{});
//        return cals[cals.length - 1] + cals[cals.length - 2] + cals[cals.length - 3];
    }
}
