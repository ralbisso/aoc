package aoc2020;

import java.util.ArrayList;
import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day11Part02 extends AdventOfCode {

    public static int solve() {
        char[][] seats = getMatrixData(FileConstants.AOC_2020_11);
        applySeatingRules(seats);
        int previous = -1;
        int current = countAllOccupiedSeats(seats);
        while (previous != current) {
            applySeatingRules(seats);
            previous = current;
            current = countAllOccupiedSeats(seats);
        }
        return current;
    }

    private static void applySeatingRules(char[][] seats) {
        List<int[]> freeToOccupied = new ArrayList<>();
        List<int[]> occupiedToFree = new ArrayList<>();
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                if (seats[i][j] == 'L') {
                    int nbOccupied = countNearbyOccupiedSeats(seats, i, j);
                    if (nbOccupied == 0) {
                        int[] coord = { i, j };
                        freeToOccupied.add(coord);
                    }
                } else if (seats[i][j] == '#') {
                    int nbOccupied = countNearbyOccupiedSeats(seats, i, j);
                    if (nbOccupied >= 5) {
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
            seats[array[0]][array[1]] = 'L';
        }
    }

    private static int countNearbyOccupiedSeats(char[][] seats, int i, int j) {
        int nearbyOccupiedSeats = 0;
        for (int k = 1; j + k < seats[0].length; k++) {
            if (seats[i][j + k] == '#') {
                nearbyOccupiedSeats++;
                break;
            } else if (seats[i][j + k] == 'L') {
                break;
            }
        }
        for (int k = 1; j - k >= 0; k++) {
            if (seats[i][j - k] == '#') {
                nearbyOccupiedSeats++;
                break;
            } else if (seats[i][j - k] == 'L') {
                break;
            }
        }
        for (int k = 1; i + k < seats.length; k++) {
            if (seats[i + k][j] == '#') {
                nearbyOccupiedSeats++;
                break;
            } else if (seats[i + k][j] == 'L') {
                break;
            }
        }
        for (int k = 1; i - k >= 0; k++) {
            if (seats[i - k][j] == '#') {
                nearbyOccupiedSeats++;
                break;
            } else if (seats[i - k][j] == 'L') {
                break;
            }
        }
        for (int k = 1; i + k < seats.length && j + k < seats[0].length; k++) {
            if (seats[i + k][j + k] == '#') {
                nearbyOccupiedSeats++;
                break;
            } else if (seats[i + k][j + k] == 'L') {
                break;
            }
        }
        for (int k = 1; Math.min(i - k, j - k) >= 0; k++) {
            if (seats[i - k][j - k] == '#') {
                nearbyOccupiedSeats++;
                break;
            } else if (seats[i - k][j - k] == 'L') {
                break;
            }
        }
        for (int k = 1; i - k >= 0 && j + k < seats[0].length; k++) {
            if (seats[i - k][j + k] == '#') {
                nearbyOccupiedSeats++;
                break;
            } else if (seats[i - k][j + k] == 'L') {
                break;
            }
        }
        for (int k = 1; i + k < seats.length && j - k >= 0; k++) {
            if (seats[i + k][j - k] == '#') {
                nearbyOccupiedSeats++;
                break;
            } else if (seats[i + k][j - k] == 'L') {
                break;
            }
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
