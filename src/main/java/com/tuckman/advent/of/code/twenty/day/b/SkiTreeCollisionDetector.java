package com.tuckman.advent.of.code.twenty.day.b;

import java.util.List;

public class SkiTreeCollisionDetector {

    private final static char TREE = '#';
    private final static char AIR = '.';

    public long howManyTreesWereHit(List<String> slope, int xSlope, int ySlope) {

        int currX = 0;
        int currY = 0;
        long numCollisions = 0;
        int slopeWidth = slope.get(0).length();

        while(currY < slope.size()) {
            String line = slope.get(currY);

            if (line.charAt(currX) == TREE) {
                numCollisions++;
            }

            // Add slope, mod slope width to simulate infinite width :)
            currX = (currX + xSlope) % slopeWidth;
            currY += ySlope;
        }


        return numCollisions;
    }

}
