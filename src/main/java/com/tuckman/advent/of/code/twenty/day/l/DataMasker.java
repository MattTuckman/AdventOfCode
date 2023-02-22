package com.tuckman.advent.of.code.twenty.day.l;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataMasker {
    private Pattern MASK_PAT = Pattern.compile("mask = ([0X1]+)");
    private Pattern MEM_PAT = Pattern.compile("mem\\[(\\d+)\\] = (\\d+)");

    // OR with number so we force 0 -> 1 where we have mask set
    private long onesMask = 0L;
    // AND with number so we force 1 -> 0 where we have mask set (mask is inverse of where 0s are in the string)
    private long zerosMask = 0L;

    public long sumAllDataFrom(List<String> input) {
        Map<String, Long> memoryAddresses = new HashMap<>();

        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i);

            Matcher maskMch = MASK_PAT.matcher(line);
            if (maskMch.find()) {
                updateMaskWith(maskMch.group(1));
                continue;
            }

            Matcher memMch = MEM_PAT.matcher(line);
            if (memMch.find()) {
                long valueToStore = Long.parseLong(memMch.group(2));
                valueToStore |= onesMask;
                valueToStore &= zerosMask;
                memoryAddresses.put(memMch.group(1), valueToStore);
                continue;
            }
        }

        return memoryAddresses.values()
                .stream()
                .reduce((a, b) -> a + b)
                .get();
    }

    private void updateMaskWith(String mask) {
        long tempOnesMask = 0L;
        long tempZerosMask = 0L;

        for (int i = 0; i < mask.length(); i++) {
            char currChar = mask.charAt(mask.length() - 1 - i);

            switch (currChar) {
                case '0':
                    tempZerosMask |= 1L << i;
                    break;
                case '1':
                    tempOnesMask |= 1L << i;
                    break;
                default:
                    break;
            }
        }
        onesMask = tempOnesMask;
        zerosMask = ~tempZerosMask;
    }
}
