package aoc2015;

import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day06Part01 extends AdventOfCode {

    public static int solve() {
        List<String> instructions = getData(FileConstants.AOC_2015_06);
        boolean[][] grid = new boolean[1000][1000];
        int count = 0;
        for (String instruction : instructions) {
            Action action = new Action(instruction);
            for (int i = action.rowStart; i <= action.rowEnd; i++) {
                for (int j = action.colStart; j <= action.colEnd; j++) {
                    boolean isTurnedOn = grid[i][j];
                    if (action.command.equals("turn-on")) {
                        grid[i][j] = true;
                    } else if (action.command.equals("turn-off")) {
                        grid[i][j] = false;
                    } else if (action.command.equals("toggle")) {
                        grid[i][j] = !grid[i][j];
                    }
                    if (!isTurnedOn && grid[i][j]) {
                        count++;
                    } else if (isTurnedOn && !grid[i][j]) {
                        count--;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}

class Action {

    String command;
    int rowStart;
    int colStart;
    int rowEnd;
    int colEnd;

    public Action(String instruction) {
        instruction = instruction.replace("turn ", "turn-");
        String[] split = instruction.split(" ");
        String[] start = split[1].split(",");
        String[] end = split[3].split(",");
        this.command = split[0];
        this.rowStart = Integer.parseInt(start[0]);
        this.colStart = Integer.parseInt(start[1]);
        this.rowEnd = Integer.parseInt(end[0]);
        this.colEnd = Integer.parseInt(end[1]);
    }
}
