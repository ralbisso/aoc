package aoc2015;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day01Part01 extends AdventOfCode {

    public static int solve() {
        String instructions = getLine(FileConstants.AOC_2015_01);
        int floor = 0;
        for (char c : instructions.toCharArray()) {
            floor += (c == '(') ? 1 : -1;
        }
        return floor;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
