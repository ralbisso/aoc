package aoc2015;

import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day05Part02 extends AdventOfCode {

    public static int solve() {
        List<String> strings = getData(FileConstants.AOC_2015_05);
        int count = 0;
        for (String string : strings) {
            if (isNiceString(string)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isNiceString(String string) {
        boolean atLeastOnePatternRepetition = string.matches("^.*(..).*\\1.*$");
        boolean atLeastOneRepetitionAfterLetter = string.matches("^.*(.).\\1.*$");
        return atLeastOnePatternRepetition && atLeastOneRepetitionAfterLetter;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
