package aoc2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day10Part02 {

    public static void main(String[] args) {

        // File processing
        List<Integer> adapters = new ArrayList<>();
        try (BufferedReader br = Files
                .newBufferedReader(Paths.get("src/main/resources/2020/day10.data"))) {
            String line;
            while ((line = br.readLine()) != null) {
                adapters.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        // Problem solving
        adapters.sort(Comparator.naturalOrder());
        System.out.println(adapters);
        System.out.println("Answer: " + countsWays(adapters, 0, 0));

    }

    private static long countsWays(List<Integer> adapters, int joltage, int index) {
        if (index == adapters.size()) {
            return 1;
        }
        long count = 0;
        for (int i = index; i < adapters.size(); i++) {
            if (adapters.get(i) - joltage == 1) {
                count += countsWays(adapters, joltage + 1, i + 1);
            }
            if (adapters.get(i) - joltage == 2) {
                count += countsWays(adapters, joltage + 2, i + 1);
            }
            if (adapters.get(i) - joltage == 3) {
                count += countsWays(adapters, joltage + 3, i + 1);
            }
        }
        return count;
    }

}
