package aoc2020;

import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day09Part02 extends AdventOfCode {

    public static long solve() {
        List<Long> outputs = getLongData(FileConstants.AOC_2020_09);
        long value = Day09Part01.solve();
        long min = Long.MAX_VALUE, max = 0L;
        loop: for (int size = 2; size < outputs.size(); size++) {
            long sum = 0L;
            for (int i = 0; i < size; i++) {
                sum += outputs.get(i);
            }
            int lower = 0;
            while (lower + size < outputs.size()) {
                sum -= outputs.get(lower);
                sum += outputs.get(lower + size);
                lower++;
                if (sum == value) {
                    for (int i = lower; i < lower + size; i++) {
                        long check = outputs.get(i);
                        if (check < min) {
                            min = check;
                        } else if (check > max) {
                            max = check;
                        }
                    }
                    break loop;
                }
            }
        }
        return min + max;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
