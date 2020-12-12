package aoc2020;

import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day12Part01 extends AdventOfCode {

    public static int solve() {
        List<String> instructions = getData(FileConstants.AOC_2020_12);
        char direction = 'E';
        int[] ship = { 0, 0 };
        for (String instruction : instructions) {
            char action = instruction.charAt(0);
            int value = Integer.parseInt(instruction.substring(1));
            switch (action) {
            case 'N':
                ship[0] += value;
                break;
            case 'S':
                ship[0] -= value;
                break;
            case 'E':
                ship[1] += value;
                break;
            case 'W':
                ship[1] -= value;
                break;
            case 'L':
                switch (value) {
                case 90:
                    switch (direction) {
                    case 'N':
                        direction = 'W';
                        break;
                    case 'S':
                        direction = 'E';
                        break;
                    case 'E':
                        direction = 'N';
                        break;
                    case 'W':
                        direction = 'S';
                        break;
                    }
                    break;
                case 180:
                    switch (direction) {
                    case 'N':
                        direction = 'S';
                        break;
                    case 'S':
                        direction = 'N';
                        break;
                    case 'E':
                        direction = 'W';
                        break;
                    case 'W':
                        direction = 'E';
                        break;
                    }
                    break;
                case 270:
                    switch (direction) {
                    case 'N':
                        direction = 'E';
                        break;
                    case 'S':
                        direction = 'W';
                        break;
                    case 'E':
                        direction = 'S';
                        break;
                    case 'W':
                        direction = 'N';
                        break;
                    }
                    break;
                }
                break;
            case 'R':
                switch (value) {
                case 90:
                    switch (direction) {
                    case 'N':
                        direction = 'E';
                        break;
                    case 'S':
                        direction = 'W';
                        break;
                    case 'E':
                        direction = 'S';
                        break;
                    case 'W':
                        direction = 'N';
                        break;
                    }
                    break;
                case 180:
                    switch (direction) {
                    case 'N':
                        direction = 'S';
                        break;
                    case 'S':
                        direction = 'N';
                        break;
                    case 'E':
                        direction = 'W';
                        break;
                    case 'W':
                        direction = 'E';
                        break;
                    }
                    break;
                case 270:
                    switch (direction) {
                    case 'N':
                        direction = 'W';
                        break;
                    case 'S':
                        direction = 'E';
                        break;
                    case 'E':
                        direction = 'N';
                        break;
                    case 'W':
                        direction = 'S';
                        break;
                    }
                    break;
                }
                break;
            case 'F':
                switch (direction) {
                case 'N':
                    ship[0] += value;
                    break;
                case 'S':
                    ship[0] -= value;
                    break;
                case 'E':
                    ship[1] += value;
                    break;
                case 'W':
                    ship[1] -= value;
                    break;
                }
                break;
            default:
                break;
            }
        }
        return Math.abs(ship[0]) + Math.abs(ship[1]);
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
