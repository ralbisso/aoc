package aoc2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.FileConstants;

public class Day02Part01 {

    public static int solve() {
        List<int[]> dimensions = getData(FileConstants.AOC_2015_02);
        return dimensions.stream().mapToInt(row -> getWrappingPaperSurface(row)).sum();
    }

    static List<int[]> getData(String input) {
        List<int[]> data = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(input))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split("x");
                int[] dimensions = new int[3];
                for (int i = 0; i < dimensions.length; i++) {
                    dimensions[i] = Integer.parseInt(split[i]);
                }
                Arrays.sort(dimensions);
                data.add(dimensions);
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return data;
    }

    private static int getWrappingPaperSurface(int[] dimensions) {
        int surface = 0;
        surface += 3 * dimensions[0] * dimensions[1];
        surface += 2 * dimensions[0] * dimensions[2];
        surface += 2 * dimensions[1] * dimensions[2];
        return surface;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
