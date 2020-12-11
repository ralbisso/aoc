package aoc2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day05Part02 {

    public static void main(String[] args) {

        // File processing
        int[] program = null;
        try (BufferedReader br = Files
                .newBufferedReader(Paths.get("src/main/resources/2019/day05.data"))) {
            String[] split = br.readLine().split(",");
            program = new int[split.length];
            for (int i = 0; i < program.length; i++) {
                program[i] = Integer.parseInt(split[i]);
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        // Problem solving
        int input = 5;
        int output = 0;
        int pointer = 0;
        int opcode = getOpcode(program[pointer]);
        int[] modes = getParametersModes(program[pointer]);
        while (opcode != 99) {
            if (opcode < 3) {
                int value1 = getValue(program, pointer + 1, modes[0]);
                int value2 = getValue(program, pointer + 2, modes[1]);
                if (opcode == 1) {
                    program[program[pointer + 3]] = value1 + value2;
                } else if (opcode == 2) {
                    program[program[pointer + 3]] = value1 * value2;
                }
                pointer += 4;
            } else if (opcode == 3) {
                program[program[pointer + 1]] = input;
                pointer += 2;
            } else if (opcode == 4) {
                output = getValue(program, pointer + 1, modes[0]);
                pointer += 2;
            } else if (opcode < 7) {
                int value1 = getValue(program, pointer + 1, modes[0]);
                int value2 = getValue(program, pointer + 2, modes[1]);
                if ((opcode == 5 && value1 != 0) || (opcode == 6 && value1 == 0)) {
                    pointer = value2;
                } else {
                    pointer += 3;
                }
            } else if (opcode < 9) {
                int value1 = getValue(program, pointer + 1, modes[0]);
                int value2 = getValue(program, pointer + 2, modes[1]);
                if ((opcode == 7 && value1 < value2) || (opcode == 8 && value1 == value2)) {
                    program[program[pointer + 3]] = 1;
                } else {
                    program[program[pointer + 3]] = 0;
                }
                pointer += 4;
            }
            opcode = getOpcode(program[pointer]);
            modes = getParametersModes(program[pointer]);
        }
        System.out.println("Answer: " + output);
    }

    private static int getOpcode(int value) {
        return value % 100;
    }

    private static int[] getParametersModes(int value) {
        int[] modes = new int[3];
        modes[0] = value < 100 ? 0 : value / 100 % 10;
        modes[1] = value < 1000 ? 0 : value / 1000 % 10;
        modes[2] = value < 10000 ? 0 : value / 10000;
        return modes;
    }

    private static int getValue(int[] program, int pointer, int mode) {
        return mode == 0 ? program[program[pointer]] : program[pointer];
    }

}
