package aoc2015;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day03Part01 extends AdventOfCode {

    public static int solve() {
        String instructions = getLine(FileConstants.AOC_2015_03);
        int[] coordinates = { 0, 0 };
        Set<String> houses = new HashSet<>();
        houses.add(Arrays.toString(coordinates));
        for (int i = 0; i < instructions.length(); i++) {
            moveToNext(instructions.charAt(i), coordinates);
            houses.add(Arrays.toString(coordinates));
        }
        return houses.size();
    }

    static void moveToNext(char instruction, int[] coordinates) {
        switch (instruction) {
        case '<':
            coordinates[0]--;
            break;
        case '>':
            coordinates[0]++;
            break;
        case 'v':
            coordinates[1]--;
            break;
        case '^':
            coordinates[1]++;
            break;
        default:
            break;
        }
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
