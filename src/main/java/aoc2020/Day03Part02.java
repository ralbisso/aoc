package aoc2020;

import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day03Part02 extends AdventOfCode {

    public static int solve() {
        List<String> grid = getData(FileConstants.AOC_2020_03);
        int treesCount11 = countTrees(grid, 1, 1);
        int treesCount31 = countTrees(grid, 3, 1);
        int treesCount51 = countTrees(grid, 5, 1);
        int treesCount71 = countTrees(grid, 7, 1);
        int treesCount12 = countTrees(grid, 1, 2);
        int product = treesCount11 * treesCount31 * treesCount51 * treesCount71 * treesCount12;
        return product;
    }

    private static int countTrees(List<String> grid, int right, int down) {
        int treesCount = 0, index = 0;
        for (int i = 0; i < grid.size(); i += down) {
            String row = grid.get(i);
            while (row.length() <= index) {
                row += row;
            }
            if (row.charAt(index) == '#') {
                treesCount++;
            }
            index += right;
        }
        return treesCount;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
