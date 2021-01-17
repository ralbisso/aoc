package aoc2015;

import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day06Part02 extends AdventOfCode {

    public static long solve() {
        List<String> instructions = getData(FileConstants.AOC_2015_06);
        byte[][] grid = new byte[1000][1000];
        int brightness = 0;
        for (String instruction : instructions) {
            Action action = new Action(instruction);
            for (int i = action.rowStart; i <= action.rowEnd; i++) {
                for (int j = action.colStart; j <= action.colEnd; j++) {
                    if (action.command.equals("turn-on")) {
                        grid[i][j]++;
                        brightness++;
                    } else if (action.command.equals("turn-off")) {
                        if (grid[i][j] > 0) {
                            brightness--;
                        }
                        grid[i][j] = (byte) Math.max(grid[i][j] - 1, 0);
                    } else if (action.command.equals("toggle")) {
                        grid[i][j] += 2;
                        brightness += 2;
                    }
                }
            }
        }
        return brightness;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
