package aoc2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day02Part01 {

    public static void main(String[] args) {

        // File processing
        int[] program = null;
        try (BufferedReader br = Files
                .newBufferedReader(Paths.get("src/main/resources/2019/day02.data"))) {
            String[] split = br.readLine().split(",");
            program = new int[split.length];
            for (int i = 0; i < program.length; i++) {
                program[i] = Integer.parseInt(split[i]);
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        // Problem solving
        program[1] = 12;
        program[2] = 2;
        int pointer = 0;
        while (program[pointer] != 99) {
            if (program[pointer] == 1) {
                program[program[pointer + 3]] = program[program[pointer + 1]]
                        + program[program[pointer + 2]];
            } else if (program[pointer] == 2) {
                program[program[pointer + 3]] = program[program[pointer + 1]]
                        * program[program[pointer + 2]];
            }
            pointer += 4;
        }
        System.out.println("Answer: " + program[0]);
    }

}
