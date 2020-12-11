package aoc2020;

import java.util.Comparator;
import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day10Part01 extends AdventOfCode {

    public static void main(String[] args) {

        // File processing
        List<Integer> adapters = getIntData(FileConstants.AOC_2020_10);

        // Problem solving
        adapters.add(0);
        adapters.sort(Comparator.naturalOrder());
        int jolts1 = 0;
        int jolts3 = 0;
        for (int i = 1; i < adapters.size(); i++) {
            int difference = adapters.get(i) - adapters.get(i - 1);
            if (difference == 1) {
                jolts1++;
            } else if (difference == 3) {
                jolts3++;
            }
        }
        jolts3++;
        System.out.println("Answer: " + (jolts1 * jolts3));
    }

}
