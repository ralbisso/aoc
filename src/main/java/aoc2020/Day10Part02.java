package aoc2020;

import java.util.Comparator;
import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day10Part02 extends AdventOfCode {

    public static void main(String[] args) {

        // File processing
        List<Integer> adapters = getIntData(FileConstants.AOC_2020_10);

        // Problem solving
        adapters.sort(Comparator.naturalOrder());
        System.out.println(adapters);
        System.out.println("Answer: " + countsWays(adapters, 0, 0));

    }

    private static long countsWays(List<Integer> adapters, int joltage, int index) {
        if (index == adapters.size()) {
            return 1;
        }
        long count = 0;
        for (int i = index; i < adapters.size(); i++) {
            if (adapters.get(i) - joltage == 1) {
                count += countsWays(adapters, joltage + 1, i + 1);
            }
            if (adapters.get(i) - joltage == 2) {
                count += countsWays(adapters, joltage + 2, i + 1);
            }
            if (adapters.get(i) - joltage == 3) {
                count += countsWays(adapters, joltage + 3, i + 1);
            }
        }
        return count;
    }

}
