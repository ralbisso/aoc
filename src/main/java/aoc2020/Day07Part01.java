package aoc2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Day07Part01 {

    public static void main(String[] args) {

        // File processing
        Map<String, List<String>> bags = new TreeMap<>();
        try (BufferedReader br = Files
                .newBufferedReader(Paths.get("src/main/resources/2020/day07.data"))) {
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
                    bags.put(key, value);
                }
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        // Problem solving
        int bagCount = 0;
        for (String bag : bags.keySet()) {
            if (canContainBag(bag, "shiny gold", bags)) {
                bagCount++;
            }
        }
        System.out.println("Answer: " + bagCount);
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
}
