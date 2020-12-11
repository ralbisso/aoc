package aoc2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import utils.FileConstants;

public class Day06Part02 {

    public static int solve() {
        List<Set<String>> allForms = getData(FileConstants.AOC_2020_06);
        int sum = 0;
        for (Set<String> group : allForms) {
            sum += group.size();
        }
        return sum;
    }

    private static List<Set<String>> getData(String input) {
        List<Set<String>> data = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(input))) {
            String line;
            boolean first = true;
            Set<String> set = new TreeSet<>();
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    if (first) {
                        set.addAll(Arrays.asList(line.split("")));
                        first = false;
                    } else {
                        set.retainAll(Arrays.asList(line.split("")));
                    }
                } else {
                    data.add(set);
                    set = new TreeSet<>();
                    first = true;
                }
            }
            data.add(set);
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return data;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
