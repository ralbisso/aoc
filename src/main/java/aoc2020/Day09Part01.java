package aoc2020;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day09Part01 extends AdventOfCode {

    public static long solve() {
        List<Long> outputs = getLongData(FileConstants.AOC_2020_09);
        Set<Long> sums = new TreeSet<>();
        int preamble = 25;
        for (int i = 0; i < preamble; i++) {
            for (int j = i + 1; j < preamble; j++) {
                sums.add(outputs.get(i) + outputs.get(j));
            }
        }
        int lower = 0;
        long value = 0L;
        for (int i = preamble; i < outputs.size(); i++) {
            long check = outputs.get(i);
            if (!sums.contains(check)) {
                value = check;
                break;
            }
            sums = new TreeSet<>();
            lower++;
            for (int j = lower; j < lower + preamble; j++) {
                for (int k = j + 1; k < lower + preamble; k++) {
                    sums.add(outputs.get(j) + outputs.get(k));
                }
            }
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
