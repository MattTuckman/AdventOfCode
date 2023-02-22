package com.tuckman.advent.of.code.twenty.day.j;

import java.util.List;

public class FerrySeats {

    private static final char OCCUPADO = '#';
    private static final char EMPTY = 'L';
    private static final char FLOOR = '.';

    public int simulateFerrySeats(List<String> seatLayouts) {
        // Count
        char[][] seatingChart = new char[seatLayouts.get(0).length()][seatLayouts.size()];
        int[][] seatCount = new int[seatLayouts.get(0).length()][seatLayouts.size()];

        for (int i = 0; i < seatLayouts.size(); i++) {
            char[] seatLayout = seatLayouts.get(i).toCharArray();
            for (int j = 0; j < seatLayout.length; j++) {
                seatingChart[i][j] = seatLayout[j];
            }
        }

        int numUpdates;
        do {
            countSeats(seatingChart, seatCount);
            numUpdates = simulateSeatChanges(seatingChart, seatCount);
            System.out.println("Simulation run, seats updated: " + numUpdates);
        } while (numUpdates != 0);

        return countSeats(seatingChart, seatCount);
    }

    private int countSeats(char[][] seatingChart, int[][] adjacentCount) {
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int x = 0; x < seatingChart.length; x++) {
            for (int y = 0; y < seatingChart.length; y++) {
                if (seatingChart[x][y] == OCCUPADO) {
                    incrementInboundAdjacentSeats(x, y, adjacentCount);
                    count++;
                }
                sb.append(seatingChart[x][y]);
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
        return count;
    }

    private void incrementInboundAdjacentSeats(int x, int y, int[][] adjacentCount) {
        incrementIfInbound(x - 1, y - 1, adjacentCount);
        incrementIfInbound(x - 1, y, adjacentCount);
        incrementIfInbound(x - 1, y + 1, adjacentCount);

        incrementIfInbound(x, y - 1, adjacentCount);
        incrementIfInbound(x, y + 1, adjacentCount);

        incrementIfInbound(x + 1, y - 1, adjacentCount);
        incrementIfInbound(x + 1, y, adjacentCount);
        incrementIfInbound(x + 1, y + 1, adjacentCount);
    }

    private void incrementIfInbound(int x, int y, int[][] adjacentCount) {
        if (x >= 0 && y >= 0 && x < adjacentCount.length && y < adjacentCount[0].length) {
            adjacentCount[x][y]++;
        }
    }

    private int simulateSeatChanges(char[][] seatingChart, int[][] adjacentCount) {
        int changes = 0;
        StringBuilder sb = new StringBuilder();

        for (int x = 0; x < seatingChart.length; x++) {
            for (int y = 0; y < seatingChart.length; y++) {
                if (seatingChart[x][y] == OCCUPADO && adjacentCount[x][y] >= 4) {
                    seatingChart[x][y] = EMPTY;
                    changes++;
                } else if (seatingChart[x][y] == EMPTY && adjacentCount[x][y] == 0) {
                    seatingChart[x][y] = OCCUPADO;
                    changes++;
                }
                // reset the count for next iteration
                sb.append(adjacentCount[x][y]);
                adjacentCount[x][y] = 0;
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
        return changes;
    }
}
