package com.tuckman.advent.of.code.twenty.day.o;

import java.util.List;

public class PocketDimensionSimulator {

    private char ACTIVE = '#';
    private char INACTIVE = '.';

    public int simulatePocketDimension(List<String> startingState) {
        int numberOfSimulations = 6;

        int xStartSize = startingState.size();
        int yStartSize = startingState.get(0).length();
        int zStartSize = 1;

        // Each time a simulation runs, the size of the dimension can increase by 1 in each direction
        int xEndSize = xStartSize + (2 * numberOfSimulations);
        int yEndSize = yStartSize + (2 * numberOfSimulations);
        int zEndSize = zStartSize + (2 * numberOfSimulations);

        // Initialize and fill with INACTIVE
        char[][][] dimension = new char[xEndSize][yEndSize][zEndSize];
        for (int x = 0; x < xEndSize; x++) {
            for (int y = 0; y < yEndSize; y++) {
                for (int z = 0; z < zEndSize; z++) {
                    dimension[x][y][z] = INACTIVE;
                }
            }
        }

        // Populating the middle of the universe with the starting pattern
        for (int x = 0; x < startingState.size(); x++) {
            char[] chars = startingState.get(x).toCharArray();
            for (int y = 0; y < chars.length; y++) {
                dimension[x + numberOfSimulations][y + numberOfSimulations][numberOfSimulations] = chars[y];
            }
        }

        int activeCount = 0;

        // Simulate dimension
        for (int i = 0; i < numberOfSimulations; i++) {
            char[][][] nextDimension = new char[xEndSize][yEndSize][zEndSize];

            for (int x = 0; x < xEndSize; x++) {
                for (int y = 0; y < yEndSize; y++) {
                    for (int z = 0; z < zEndSize; z++) {
                        if (willBeActive(x, y, z, dimension)) {
                            nextDimension[x][y][z] = ACTIVE;

                            // Count active on last loop
                            if (i == numberOfSimulations - 1) {
                                activeCount++;
                            }
                        } else {
                            nextDimension[x][y][z] = INACTIVE;
                        }
                    }
                }
            }
            dimension = nextDimension;

            System.out.println("After cycle " + (i + 1));
            printDim(dimension);
        }

        return activeCount;
    }

    private boolean willBeActive(int x, int y, int z, char[][][] dimension) {
        int count = 0;

        for (int xOffset = -1; xOffset < 2; xOffset++) {
            for (int yOffset = -1; yOffset < 2; yOffset++) {
                for (int zOffset = -1; zOffset < 2; zOffset++) {
                    if (!(xOffset == 0 && yOffset == 0 && zOffset == 0)
                            && isInboundsAndActive(x + xOffset, y + yOffset, z + zOffset, dimension)) {
                        count++;
                    }
                }
            }
        }

        return dimension[x][y][z] == ACTIVE ? (count == 2 || count == 3) : count == 3;
    }

    private boolean isInboundsAndActive(int x, int y, int z, char[][][] dimension) {
        if (0 <= x && x < dimension.length
                && 0 <= y && y < dimension[0].length
                && 0 <= z && z < dimension[0][0].length) {
            return dimension[x][y][z] == ACTIVE;
        }
        return false;
    }

    private void printDim(char[][][] dimension) {
        StringBuilder sb = new StringBuilder();
        for (int z = 0; z < dimension[0][0].length; z++) {
            for (int y = 0; y < dimension[0].length; y++) {
                for (int x = 0; x < dimension.length; x++) {
                    sb.append(dimension[x][y][z]);
                }
                sb.append('\n');
            }
            sb.append("Z was ").append(z).append('\n');
        }
        System.out.println(sb.toString());
    }
}
