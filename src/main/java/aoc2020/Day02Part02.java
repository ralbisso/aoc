package aoc2020;

import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day02Part02 extends AdventOfCode {

    public static int solve() {
        List<String> passwords = getData(FileConstants.AOC_2020_02);
        int validPasswordsCount = 0;
        for (String password : passwords) {
            String[] split = password.split(" ");
            String[] bounds = split[0].split("-");
            int first = Integer.parseInt(bounds[0]);
            int second = Integer.parseInt(bounds[1]);
            char letter = split[1].charAt(0);
            String toCheck = split[2];
            if (isPasswordValid(first, second, letter, toCheck)) {
                validPasswordsCount++;
            }
        }
        return validPasswordsCount;
    }

    private static boolean isPasswordValid(int first, int second, char letter, String toCheck) {
        char firstLetter = toCheck.charAt(first - 1);
        char secondLetter = toCheck.charAt(second - 1);
        return firstLetter != secondLetter && (firstLetter == letter || secondLetter == letter);
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
