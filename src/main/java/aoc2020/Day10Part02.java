package aoc2020;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day10Part02 extends AdventOfCode {

    public static long solve() {
        List<Integer> adapters = getIntData(FileConstants.AOC_2020_10);
        adapters.sort(Comparator.naturalOrder());
        Map<Integer, Integer> memo = new HashMap<>();
        // Solves the problem, however this is extremely dirty and slow (~5sec.)
        countWays(adapters, 0, 0, 50, memo);
        return memo.get(80) * countWays(adapters, 50, 80, Integer.MAX_VALUE, memo);
    }

    private static long countWays(List<Integer> adapters, int index, int joltage, int limit,
            Map<Integer, Integer> memo) {
        if (index >= limit || index == adapters.size()) {
            if (memo.containsKey(joltage)) {
                memo.put(joltage, memo.get(joltage) + 1);
            } else {
                memo.put(joltage, 1);
            }
            return 1L;
        }
        long count = 0L;
        for (int i = index; i < adapters.size(); i++) {
            int gap = adapters.get(i) - joltage;
            if (gap <= 3) {
                count += countWays(adapters, i + 1, adapters.get(i), limit, memo);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
