package aoc2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day09Part02 {

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
        long value = 25918798L;
        long min = Long.MAX_VALUE, max = 0L;
        loop: for (int size = 2; size < outputs.size(); size++) {
            long sum = 0L;
            for (int i = 0; i < size; i++) {
                sum += outputs.get(i);
            }
            int lower = 0;
            while (lower + size < outputs.size()) {
                sum -= outputs.get(lower);
                sum += outputs.get(lower + size);
                lower++;
                if (sum == value) {
                    for (int i = lower; i < lower + size; i++) {
                        long check = outputs.get(i);
                        if (check < min) {
                            min = check;
                        } else if (check > max) {
                            max = check;
                        }
                    }
                    break loop;
                }
            }
        }
        System.out.println("Answer: " + (min + max));
    }

}
