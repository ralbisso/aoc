package aoc2015;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day01Part01 extends AdventOfCode {

    public static int solve() {
        String instructions = getLine(FileConstants.AOC_2015_01);
        return instructions.chars().map(c -> ((char) c == '(') ? 1 : -1).sum();
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
