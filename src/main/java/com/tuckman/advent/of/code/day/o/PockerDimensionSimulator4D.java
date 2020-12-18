package com.tuckman.advent.of.code.day.o;

import java.util.List;

public class PockerDimensionSimulator4D {
    private char ACTIVE = '#';
    private char INACTIVE = '.';

    public int simulatePocketDimension(List<String> startingState) {
        int numberOfSimulations = 6;

        int xStartSize = startingState.size();
        int yStartSize = startingState.get(0).length();
        int zStartSize = 1;
        int wStartSize = 1;

        // Each time a simulation runs, the size of the dimension can increase by 1 in each direction
        int xEndSize = xStartSize + (2 * numberOfSimulations);
        int yEndSize = yStartSize + (2 * numberOfSimulations);
        int zEndSize = zStartSize + (2 * numberOfSimulations);
        int wEndSize = wStartSize + (2 * numberOfSimulations);

        // Initialize and fill with INACTIVE
        char[][][][] dimension = new char[xEndSize][yEndSize][zEndSize][wEndSize];
        for (int x = 0; x < xEndSize; x++) {
            for (int y = 0; y < yEndSize; y++) {
                for (int z = 0; z < zEndSize; z++) {
                    for (int w = 0; w < zEndSize; w++) {
                        dimension[x][y][z][w] = INACTIVE;
                    }
                }
            }
        }

        // Populating the middle of the universe with the starting pattern
        for (int x = 0; x < startingState.size(); x++) {
            char[] chars = startingState.get(x).toCharArray();
            for (int y = 0; y < chars.length; y++) {
                dimension[x + numberOfSimulations]
                         [y + numberOfSimulations]
                         [numberOfSimulations]
                         [numberOfSimulations] = chars[y];
            }
        }

        int activeCount = 0;

        // Simulate dimension
        for (int i = 0; i < numberOfSimulations; i++) {
            char[][][][] nextDimension = new char[xEndSize][yEndSize][zEndSize][wEndSize];

            for (int x = 0; x < xEndSize; x++) {
                for (int y = 0; y < yEndSize; y++) {
                    for (int z = 0; z < zEndSize; z++) {
                        for (int w = 0; w < zEndSize; w++) {
                            if (willBeActive(x, y, z, w, dimension)) {
                                nextDimension[x][y][z][w] = ACTIVE;

                                // Count active on last loop
                                if (i == numberOfSimulations - 1) {
                                    activeCount++;
                                }
                            } else {
                                nextDimension[x][y][z][w] = INACTIVE;
                            }
                        }
                    }
                }
            }
            dimension = nextDimension;

            System.out.println("After cycle " + (i + 1));
        }

        return activeCount;
    }

    private boolean willBeActive(int x, int y, int z, int w, char[][][][] dimension) {
        int count = 0;

        for (int xOffset = -1; xOffset < 2; xOffset++) {
            for (int yOffset = -1; yOffset < 2; yOffset++) {
                for (int zOffset = -1; zOffset < 2; zOffset++) {
                    for (int wOffset = -1; wOffset < 2; wOffset++) {
                        if (!(xOffset == 0 && yOffset == 0 && zOffset == 0 && wOffset == 0)
                                && isInboundsAndActive(x + xOffset, y + yOffset, z + zOffset, w + wOffset, dimension)) {
                            count++;
                        }
                    }
                }
            }
        }

        return dimension[x][y][z][w] == ACTIVE ? (count == 2 || count == 3) : count == 3;
    }


    private boolean isInboundsAndActive(int x, int y, int z, int w, char[][][][] dimension) {
        if (0 <= x && x < dimension.length
                && 0 <= y && y < dimension[0].length
                && 0 <= z && z < dimension[0][0].length
                && 0 <= w && w < dimension[0][0][0].length) {
            return dimension[x][y][z][w] == ACTIVE;
        }
        return false;
    }
}
