package com.tuckman.advent.of.code.day.i;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * For part 2, after seeing that BFS if the whole list wouldn't work I realized that every time there is a 3, it
 * bottlenecks the combinations as it is the only option for a hop. Think of a balloon being tied every time there is
 * a 3. Just multiple all of the combinations that are formed between the bottlenecks and you have the answer.
 */
public class AdapterArray {

    public long numberOfDifferences(Stream<String> voltages) {
        List<Integer> sortedVoltages = voltages.map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        int previousNum = 0;
        Integer[] voltageDiffs = {0, 0, 0};

        for (int i = 0; i < sortedVoltages.size(); i++) {
            voltageDiffs[sortedVoltages.get(i) - previousNum - 1]++;
            previousNum = sortedVoltages.get(i);
        }
        // increment for device?
        voltageDiffs[2]++;

        return voltageDiffs[0] * voltageDiffs[2];
    }

    public long numberOfArrangementsFullyRecursive(Stream<String> voltages) {
        Stream<String> voltagesWStart = Stream.concat(Stream.of("0"), voltages);

        List<Integer> sortedVoltages = voltagesWStart.map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        return recurseArrangements(0, sortedVoltages);
    }

    public long numberOfArrangements(Stream<String> voltages) {
        Stream<String> voltagesWStart = Stream.concat(Stream.of("0"), voltages);

        List<Integer> sortedVoltages = voltagesWStart.map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        List<Integer> diffs = new ArrayList<>();
        for (int i = 0; i < sortedVoltages.size() - 1; i++) {
            diffs.add(sortedVoltages.get(i + 1) - sortedVoltages.get(i));
        }

        long combos = 1;
        int notComboedIndex = 0;

        // Break into separate lists every time theres a 3 and multiply them!!!
        for (int i = 0; i < diffs.size(); i++) {
            if (diffs.get(i) == 3) {
                List<Integer> knotList = sortedVoltages.subList(notComboedIndex, i + 1);
                combos *= recurseArrangements(0, knotList);
                notComboedIndex = i + 1;
            }
        }

        // In case theres left over at the end
        List<Integer> knotList = sortedVoltages.subList(notComboedIndex, sortedVoltages.size());
        combos *= recurseArrangements(0, knotList);

        return combos;
    }

    // As expected, only works for smaller sets
    private long recurseArrangements(int index, List<Integer> voltages) {
        // only one combo if we are on the last node
        if (index == voltages.size() - 1) return 1;

        long combos = 0;
        int start = index++;

        while(index < voltages.size() && voltages.get(index) - voltages.get(start) <= 3) {
            combos += recurseArrangements(index, voltages);
            index++;
        }

        return combos;
    }
}
