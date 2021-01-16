package aoc2015;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day03Part02 extends AdventOfCode {

    public static int solve() {
        String instructions = getLine(FileConstants.AOC_2015_03);
        int[] santaCoordinates = { 0, 0 };
        int[] botCoordinates = { 0, 0 };
        Set<String> houses = new HashSet<>();
        houses.add(Arrays.toString(santaCoordinates));
        for (int i = 0; i < instructions.length(); i++) {
            Day03Part01.moveToNext(instructions.charAt(i), santaCoordinates);
            houses.add(Arrays.toString(santaCoordinates));
            Day03Part01.moveToNext(instructions.charAt(++i), botCoordinates);
            houses.add(Arrays.toString(botCoordinates));
        }
        return houses.size();
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
