package aoc2020;

import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day01Part02 extends AdventOfCode {

    public static int solve() {

        // File processing
        List<Integer> expenses = getIntData(FileConstants.AOC_2020_01);

        // Problem solving
        int product = 0;
        loop: for (int i = 0; i < expenses.size(); i++) {
            for (int j = i + 1; j < expenses.size(); j++) {
                for (int k = j + 1; k < expenses.size(); k++) {
                    if (expenses.get(i) + expenses.get(j) + expenses.get(k) == 2020) {
                        product = expenses.get(i) * expenses.get(j) * expenses.get(k);
                        break loop;
                    }
                }
            }
        }
        return product;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
