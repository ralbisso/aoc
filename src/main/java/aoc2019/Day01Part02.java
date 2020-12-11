package aoc2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day01Part02 {

    public static void main(String[] args) {

        // File processing
        List<Integer> modules = new ArrayList<>();
        try (BufferedReader br = Files
                .newBufferedReader(Paths.get("src/main/resources/2019/day01.data"))) {
            String line;
            while ((line = br.readLine()) != null) {
                modules.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        // Problem solving
        int totalFuel = 0;
        for (int module : modules) {
            int fuel = module / 3 - 2;
            while (fuel > 0) {
                totalFuel += fuel;
                fuel = fuel / 3 - 2;
            }
        }
        System.out.println("Answer: " + totalFuel);
    }

}
