package aoc2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day10Part01 {

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
        adapters.add(0);
        adapters.sort(Comparator.naturalOrder());
        int jolts1 = 0;
        int jolts3 = 0;
        for (int i = 1; i < adapters.size(); i++) {
            int difference = adapters.get(i) - adapters.get(i - 1);
            if (difference == 1) {
                jolts1++;
            } else if (difference == 3) {
                jolts3++;
            }
        }
        jolts3++;
        System.out.println("Answer: " + (jolts1 * jolts3));
    }

}
