package aoc2015;

import org.apache.commons.lang3.StringUtils;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day01Part01 extends AdventOfCode {

    public static int solve() {
        String instructions = getLine(FileConstants.AOC_2015_01);
        int numberOfUps = StringUtils.countMatches(instructions, '(');
        int numberOfDowns = StringUtils.countMatches(instructions, ')');
        return numberOfUps - numberOfDowns;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
