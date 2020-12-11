package aoc2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Day09Part01 {

    public static void main(String[] args) {

        // File processing
        List<Long> outputs = new ArrayList<>();
        try (BufferedReader br = Files
                .newBufferedReader(Paths.get("src/main/resources/2020/day09.data"))) {
            String line;
            while ((line = br.readLine()) != null) {
                outputs.add(Long.parseLong(line));
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        // Problem solving
        Set<Long> sums = new TreeSet<>();
        int preamble = 25;
        for (int i = 0; i < preamble; i++) {
            for (int j = i + 1; j < preamble; j++) {
                sums.add(outputs.get(i) + outputs.get(j));
            }
        }
        int lower = 0;
        long value = 0L;
        for (int i = preamble; i < outputs.size(); i++) {
            long check = outputs.get(i);
            if (!sums.contains(check)) {
                value = check;
                break;
            }
            sums = new TreeSet<>();
            lower++;
            for (int j = lower; j < lower + preamble; j++) {
                for (int k = j + 1; k < lower + preamble; k++) {
                    sums.add(outputs.get(j) + outputs.get(k));
                }
            }
        }
        System.out.println("Answer: " + value);
    }

}
