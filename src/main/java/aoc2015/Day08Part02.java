package aoc2015;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day08Part02 extends AdventOfCode {

    public static int solve() {
        List<String> literals = getData(FileConstants.AOC_2015_08);
        int total = 0;
        int memory = 0;
        for (String literal : literals) {
            total += literal.length();
            int numberOfEscapes = 2 + StringUtils.countMatches(literal, '"') + StringUtils.countMatches(literal, '\\');
            memory += numberOfEscapes + literal.length();
            System.out.println();
        }
        return memory - total;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
