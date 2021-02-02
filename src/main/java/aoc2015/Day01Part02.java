package aoc2015;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day01Part02 extends AdventOfCode {

    public static int solve() {
        String instructions = getLine(FileConstants.AOC_2015_01);
        int floor = 0;
        int position = 0;
        while (floor > -1) {
            char c = instructions.charAt(position++);
            floor += (c == 40) ? 1 : -1;
        }
        return position;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
