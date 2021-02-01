package aoc2015;

import java.util.List;

import utils.FileConstants;

public class Day02Part02 {

    public static int solve() {
        List<int[]> dimensions = Day02Part01.getData(FileConstants.AOC_2015_02);
        return dimensions.parallelStream().mapToInt(row -> getRibbonLength(row)).sum();
    }

    private static int getRibbonLength(int[] dimensions) {
        int length = 2 * (dimensions[0] + dimensions[1]);
        length += dimensions[0] * dimensions[1] * dimensions[2];
        return length;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
