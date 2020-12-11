package aoc2020;

import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day02Part01 extends AdventOfCode {

    public static void main(String[] args) {

        // File processing
        List<String> passwords = getData(FileConstants.AOC_2020_02);

        // Problem solving
        int validPasswordsCount = 0;
        for (String password : passwords) {
            String[] split = password.split(" ");
            String[] bounds = split[0].split("-");
            int lower = Integer.parseInt(bounds[0]);
            int upper = Integer.parseInt(bounds[1]);
            char letter = split[1].charAt(0);
            String toCheck = split[2];
            if (isPasswordValid(lower, upper, letter, toCheck)) {
                validPasswordsCount++;
            }
        }
        System.out.println("Answer: " + validPasswordsCount);
    }

    private static boolean isPasswordValid(int lower, int upper, char letter, String toCheck) {
        int count = (int) toCheck.chars().filter(c -> c == letter).count();
        return count >= lower && count <= upper;
    }

}
