package aoc2020;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day24Part02 extends AdventOfCode {

    public static int solve() {
        List<String> flips = getData(FileConstants.AOC_2020_24);
        Set<String> blackTiles = Day24Part01.getBlackTiles(flips);
        int size = 40;
        for (int day = 1; day <= 100; day++) {
            Set<String> switchToBlack = new HashSet<>();
            Set<String> switchToWhite = new HashSet<>();
            for (int i = -size; i < size; i++) {
                for (int j = -size; j < size; j++) {
                    int[] current = { i, j };
                    String key = Arrays.toString(current);
                    Set<String> blackNeighbours = getNeighbours(i, j);
                    blackNeighbours.retainAll(blackTiles);
                    if (blackTiles.contains(key)) {
                        if (blackNeighbours.size() == 0 || blackNeighbours.size() > 2) {
                            switchToWhite.add(key);
                        }
                    } else if (blackNeighbours.size() == 2) {
                        switchToBlack.add(key);
                    }
                }
            }
            blackTiles.addAll(switchToBlack);
            blackTiles.removeAll(switchToWhite);
            size++;
        }
        return blackTiles.size();

    }

    private static Set<String> getNeighbours(int i, int j) {
        Set<String> neighbours = new HashSet<>();
        int[] east = { i + 2, j };
        int[] southEast = { i + 1, j - 1 };
        int[] southWest = { i - 1, j - 1 };
        int[] west = { i - 2, j };
        int[] northWest = { i - 1, j + 1 };
        int[] northEast = { i + 1, j + 1 };
        neighbours.add(Arrays.toString(east));
        neighbours.add(Arrays.toString(southEast));
        neighbours.add(Arrays.toString(southWest));
        neighbours.add(Arrays.toString(west));
        neighbours.add(Arrays.toString(northWest));
        neighbours.add(Arrays.toString(northEast));
        return neighbours;
    }

    public static void main(String args[]) {
        System.out.println("Answer: " + solve());
    }
}
