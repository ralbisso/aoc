package aoc2015;

import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day02Part02 extends AdventOfCode {

    public static int solve() {
        List<String> dimensions = getData(FileConstants.AOC_2015_02);
        int totalLength = 0;
        for (String line : dimensions) {
            int[] sortedDimensions = Day02Part01.getDimensions(line);
            totalLength += getRibbonLength(sortedDimensions);
        }
        return totalLength;
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
