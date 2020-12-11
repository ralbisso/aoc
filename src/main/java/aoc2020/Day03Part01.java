package aoc2020;

import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day03Part01 extends AdventOfCode {

    public static int solve() {
        List<String> grid = getData(FileConstants.AOC_2020_03);
        int treesCount = 0, index = 0;
        for (String row : grid) {
            while (row.length() <= index) {
                row += row;
            }
            if (row.charAt(index) == '#') {
                treesCount++;
            }
            index += 3;
        }
        return treesCount;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
