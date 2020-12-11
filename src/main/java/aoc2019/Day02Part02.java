package aoc2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day02Part02 {

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
        int output = 0;
        loop: for (int noun = 0; noun <= 99; noun++) {
            for (int verb = 0; verb <= 99; verb++) {
                int[] copy = program.clone();
                copy[1] = noun;
                copy[2] = verb;
                int pointer = 0;
                while (copy[pointer] != 99) {
                    if (copy[pointer] == 1) {
                        copy[copy[pointer + 3]] = copy[copy[pointer + 1]] + copy[copy[pointer + 2]];
                    } else if (program[pointer] == 2) {
                        copy[copy[pointer + 3]] = copy[copy[pointer + 1]] * copy[copy[pointer + 2]];
                    }
                    pointer += 4;
                }
                if (copy[0] == 19690720) {
                    output = 100 * noun + verb;
                    break loop;
                }
            }
        }
        System.out.println("Answer: " + output);
    }
}
