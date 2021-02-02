package aoc2015;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day01Part01 extends AdventOfCode {

    public static int solve() {
        // 40 is the ascii code for '(' and 41 for ')'
        return getLine(FileConstants.AOC_2015_01)
                .chars()
                .map(c -> c == 40 ? 1 : c == 41 ? -1 : 0)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
