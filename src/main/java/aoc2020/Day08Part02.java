package aoc2020;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day08Part02 extends AdventOfCode {

    public static int solve() {
        List<String> instructions = getData(FileConstants.AOC_2020_08);
        int accumulator = 0;
        for (int i = 0; i < instructions.size(); i++) {
            while (instructions.get(i).startsWith("acc")) {
                i++;
            }
            swap(instructions, i);
            boolean infinite = false;
            Set<String> history = new HashSet<>();
            for (int j = 0; j < instructions.size(); j++) {
                String instruction = instructions.get(j);
                if (!history.add(j + ":" + instruction)) {
                    infinite = true;
                    break;
                }
                String[] split = instruction.split(" ");
                String command = split[0];
                int value = Integer.parseInt(split[1].replace("+", ""));
                if ("acc".equals(command)) {
                    accumulator += value;
                } else if ("jmp".equals(command)) {
                    j += value - 1;
                }
            }
            if (!infinite) {
                break;
            }
            accumulator = 0;
            swap(instructions, i);
        }
        return accumulator;
    }

    private static void swap(List<String> list, int index) {
        String replace = "";
        if (list.get(index).startsWith("jmp")) {
            replace = list.get(index).replace("jmp", "nop");
        } else if (list.get(index).startsWith("nop")) {
            replace = list.get(index).replace("nop", "jmp");
        }
        list.set(index, replace);
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
