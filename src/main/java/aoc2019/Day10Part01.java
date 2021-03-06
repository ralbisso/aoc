package aoc2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day10Part01 {

    public static void main(String[] args) {

        // File processing
        List<Integer> modules = new ArrayList<>();
        try (BufferedReader br = Files
                .newBufferedReader(Paths.get("src/main/resources/2019/day10.data"))) {
            String line;
            while ((line = br.readLine()) != null) {
                modules.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

    }

}
