package aoc2015;

import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day05Part01 extends AdventOfCode {

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
        boolean atLeastThreeVowels = string.matches("^(.*[aeiou].*){3,}$");
        boolean atLeastOneRepetition = string.matches("^.*(.)\\1.*$");
        boolean containsForbidden = string.matches("^.*(ab|cd|pq|xy).*$");
        return atLeastThreeVowels && atLeastOneRepetition && !containsForbidden;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
