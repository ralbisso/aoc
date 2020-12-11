package aoc2020;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day08Part01 extends AdventOfCode {

    public static void main(String[] args) {

        // File processing
        List<String> instructions = getData(FileConstants.AOC_2020_08);

        // Problem solving
        int accumulator = 0;
        Set<String> history = new HashSet<>();
        for (int i = 0; i < instructions.size(); i++) {
            String instruction = instructions.get(i);
            if (!history.add(i + ":" + instruction)) {
                break;
            }
            String[] split = instruction.split(" ");
            String command = split[0];
            int value = Integer.parseInt(split[1].replace("+", ""));
            if ("acc".equals(command)) {
                accumulator += value;
            } else if ("jmp".equals(command)) {
                i += value - 1;
            }
        }
        System.out.println("Answer: " + accumulator);
    }

}
