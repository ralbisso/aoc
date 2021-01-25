package aoc2015;

import java.util.ArrayList;
import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day18Part02 extends AdventOfCode {

    public static int solve() {
        char[][] seats = getMatrixData(FileConstants.AOC_2015_18);
        for (int i = 0; i < 100; i++) {
            applySeatingRules(seats);
        }
        return countAllOccupiedSeats(seats);
    }

    private static void applySeatingRules(char[][] seats) {
        List<int[]> freeToOccupied = new ArrayList<>();
        List<int[]> occupiedToFree = new ArrayList<>();
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                if (seats[i][j] == '.') {
                    int nbOccupied = countNearbyOccupiedSeats(seats, i, j);
                    if (nbOccupied == 3) {
                        int[] coord = { i, j };
                        freeToOccupied.add(coord);
                    }
                } else if (seats[i][j] == '#') {
                    int nbOccupied = countNearbyOccupiedSeats(seats, i, j);
                    if (nbOccupied < 2 || nbOccupied > 3) {
                        int[] coord = { i, j };
                        occupiedToFree.add(coord);
                    }
                }
            }
        }
        for (int[] array : freeToOccupied) {
            seats[array[0]][array[1]] = '#';
        }
        for (int[] array : occupiedToFree) {
            seats[array[0]][array[1]] = '.';
        }
        seats[0][0] = '#';
        seats[0][99] = '#';
        seats[99][0] = '#';
        seats[99][99] = '#';
    }

    private static int countNearbyOccupiedSeats(char[][] seats, int i, int j) {
        int nearbyOccupiedSeats = 0;
        if (j + 1 < seats[0].length && seats[i][j + 1] == '#') {
            nearbyOccupiedSeats++;
        }
        if (j - 1 >= 0 && seats[i][j - 1] == '#') {
            nearbyOccupiedSeats++;
        }
        if (i + 1 < seats.length && seats[i + 1][j] == '#') {
            nearbyOccupiedSeats++;
        }
        if (i - 1 >= 0 && seats[i - 1][j] == '#') {
            nearbyOccupiedSeats++;
        }
        if (i + 1 < seats.length && j + 1 < seats[0].length && seats[i + 1][j + 1] == '#') {
            nearbyOccupiedSeats++;
        }
        if (i - 1 >= 0 && j - 1 >= 0 && seats[i - 1][j - 1] == '#') {
            nearbyOccupiedSeats++;
        }
        if (i + 1 < seats.length && j - 1 >= 0 && seats[i + 1][j - 1] == '#') {
            nearbyOccupiedSeats++;
        }
        if (i - 1 >= 0 && j + 1 < seats[0].length && seats[i - 1][j + 1] == '#') {
            nearbyOccupiedSeats++;
        }
        return nearbyOccupiedSeats;
    }

    private static int countAllOccupiedSeats(char[][] seats) {
        int occupiedSeats = 0;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                if (seats[i][j] == '#') {
                    occupiedSeats++;
                }
            }
        }
        return occupiedSeats;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }

}
