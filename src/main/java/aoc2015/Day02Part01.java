package aoc2015;

import java.util.Arrays;
import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day02Part01 extends AdventOfCode {

    public static int solve() {
        List<String> dimensions = getData(FileConstants.AOC_2015_02);
        int totalSurface = 0;
        for (String line : dimensions) {
            int[] sortedDimensions = getDimensions(line);
            totalSurface += getWrappingPaperSurface(sortedDimensions);
        }
        return totalSurface;
    }

    static int[] getDimensions(String line) {
        int[] dimensions = new int[3];
        String[] split = line.split("x");
        for (int i = 0; i < dimensions.length; i++) {
            dimensions[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(dimensions);
        return dimensions;
    }

    private static int getWrappingPaperSurface(int[] dimensions) {
        int surface = 0;
        surface += 3 * dimensions[0] * dimensions[1];
        surface += 2 * dimensions[0] * dimensions[2];
        surface += 2 * dimensions[1] * dimensions[2];
        return surface;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
