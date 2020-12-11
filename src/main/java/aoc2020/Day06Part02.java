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

public class Day06Part02 {

    public static void main(String[] args) {

        // File processing
        List<Set<String>> allForms = new ArrayList<>();
        try (BufferedReader br = Files
                .newBufferedReader(Paths.get("src/main/resources/2020/day06.data"))) {
            String line;
            boolean first = true;
            Set<String> groupAnswers = new TreeSet<>();
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    if (first) {
                        groupAnswers.addAll(Arrays.asList(line.split("")));
                        first = false;
                    } else {
                        groupAnswers.retainAll(Arrays.asList(line.split("")));
                    }
                } else {
                    allForms.add(groupAnswers);
                    groupAnswers = new TreeSet<>();
                    first = true;
                }
            }
            allForms.add(groupAnswers);
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        // Problem solving
        int sum = 0;
        for (Set<String> group : allForms) {
            sum += group.size();
        }
        System.out.println("Answer: " + sum);
    }

}
