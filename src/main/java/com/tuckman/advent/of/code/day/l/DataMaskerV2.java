package com.tuckman.advent.of.code.day.l;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataMaskerV2 {
    private Pattern MASK_PAT = Pattern.compile("mask = ([0X1]+)");
    private Pattern MEM_PAT = Pattern.compile("mem\\[(\\d+)\\] = (\\d+)");

    // OR with number so we force 0 -> 1 where we have mask set
    private long onesMask = 0L;
    // AND with number so we force 1 -> 0 where we have mask set (which enables us to populate all variations)
    private long xsMask = 0L;

    private List<Long> xMasks;

    private Map<Long, Long> memoryAddresses;

    public long sumAllDataFrom(List<String> input) {
        memoryAddresses = new HashMap<>();

        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i);

            Matcher maskMch = MASK_PAT.matcher(line);
            if (maskMch.find()) {
                updateMaskWith(maskMch.group(1));
                continue;
            }

            Matcher memMch = MEM_PAT.matcher(line);
            if (memMch.find()) {
                long address = Long.parseLong(memMch.group(1));
                storeAllVariations(address, memMch.group(2));
                continue;
            }
        }

        return memoryAddresses.values()
                .stream()
                .reduce((a, b) -> a + b)
                .get();
    }

    private void storeAllVariations(long address, String strValue) {
        long value = Long.parseLong(strValue);
        address |= onesMask;
        address &= xsMask;

        // Go through all possible variations for Xs appear in the mask (2^(numx))
        for (int i = 0; i < Math.pow(2, xMasks.size()); i++) {
            long currMask = 0L;

            // For each variation, we OR the current mask with the mask in the xMasks
            // array IF, the bit is on in the current i. By doing this we end up looping
            // through all possible masks and updating those memory addresses
            for (int j = 0; j < xMasks.size(); j++) {
                if (((1L << j) & i) != 0) {
                    currMask |= xMasks.get(j);
                }
            }

            long currAddress = address | currMask;
            memoryAddresses.put(currAddress, value);
        }
    }

    private void updateMaskWith(String mask) {
        long tempOnesMask = 0L;
        long tempXsMask = 0L;
        xMasks = new ArrayList<>();

        for (int i = 0; i < mask.length(); i++) {
            char currChar = mask.charAt(mask.length() - 1 - i);

            switch (currChar) {
                case '1':
                    tempOnesMask |= 1L << i;
                    break;
                case 'X':
                    long currMask = 1L << i;
                    tempXsMask |= currMask;
                    xMasks.add(currMask);
                    break;
                default:
                    break;
            }
        }
        xsMask = ~tempXsMask;
        onesMask = tempOnesMask;
    }
}
