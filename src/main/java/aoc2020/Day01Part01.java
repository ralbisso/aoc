package aoc2020;

import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day01Part01 extends AdventOfCode {

    public static int solve() {
        List<Integer> expenses = getIntData(FileConstants.AOC_2020_01);
        int product = 0;
        loop: for (int i = 0; i < expenses.size(); i++) {
            for (int j = i + 1; j < expenses.size(); j++) {
                if (expenses.get(i) + expenses.get(j) == 2020) {
                    product = expenses.get(i) * expenses.get(j);
                    break loop;
                }
            }
        }
        return product;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
