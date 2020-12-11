package aoc2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import utils.FileConstants;

public class Day07Part01 {

    public static int solve() {
        Map<String, List<String>> bags = getData(FileConstants.AOC_2020_07);
        int bagCount = 0;
        for (String bag : bags.keySet()) {
            if (canContainBag(bag, "shiny gold", bags)) {
                bagCount++;
            }
        }
        return bagCount;
    }

    private static Map<String, List<String>> getData(String input) {
        Map<String, List<String>> data = new TreeMap<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(input))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = cleanLine(line).split(",");
                String key = null;
                List<String> value = new ArrayList<>();
                for (String s : split) {
                    if (key == null) {
                        key = s.trim();
                    } else {
                        value.add(s.trim());
                    }
                    data.put(key, value);
                }
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return data;
    }

    private static String cleanLine(String line) {
        return line.replace("contain", ",").replace(".", "").replaceAll("(bags|bag|no other)", "");
    }

    private static boolean canContainBag(String container, String content,
            Map<String, List<String>> data) {
        if (data.get(container) == null || data.get(container).isEmpty()
                || data.get(container).get(0).equals("")) {
            return false;
        } else {
            for (String inner : data.get(container)) {
                String child = inner.substring(2);
                if (child.equals(content) || canContainBag(child, content, data)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
