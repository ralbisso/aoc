package aoc2015;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day07Part01 extends AdventOfCode {

    public static int solve() {
        List<String> instructions = getData(FileConstants.AOC_2015_07);
        Map<String, Integer> map = new TreeMap<>();
        int count = 0;
        while (!map.containsKey("a")) {
            for (String instruction : instructions) {
                String[] split = instruction.split(" -> ");
                String expression = split[0];
                if (expression.contains("OR")) {
                    String[] splitExp = expression.split(" OR ");
                    if ((map.containsKey(splitExp[0]) || splitExp[0].matches("[0-9]+"))
                            && (map.containsKey(splitExp[1]) || splitExp[1].matches("[0-9]+"))) {
                        int a = map.get(splitExp[0]) == null ? Integer.parseInt(splitExp[0])
                                : map.get(splitExp[0]);
                        int b = map.get(splitExp[1]) == null ? Integer.parseInt(splitExp[1])
                                : map.get(splitExp[1]);
                        map.put(split[1], a | b);
                    }
                } else if (expression.contains("AND")) {
                    String[] splitExp = expression.split(" AND ");
                    if ((map.containsKey(splitExp[0]) || splitExp[0].matches("[0-9]+"))
                            && (map.containsKey(splitExp[1]) || splitExp[1].matches("[0-9]+"))) {
                        int a = map.get(splitExp[0]) == null ? Integer.parseInt(splitExp[0])
                                : map.get(splitExp[0]);
                        int b = map.get(splitExp[1]) == null ? Integer.parseInt(splitExp[1])
                                : map.get(splitExp[1]);
                        map.put(split[1], a & b);
                    }
                } else if (expression.contains("LSHIFT")) {
                    String[] splitExp = expression.split(" LSHIFT ");
                    if ((map.containsKey(splitExp[0]) || splitExp[0].matches("[0-9]+"))
                            && (map.containsKey(splitExp[1]) || splitExp[1].matches("[0-9]+"))) {
                        int a = map.get(splitExp[0]) == null ? Integer.parseInt(splitExp[0])
                                : map.get(splitExp[0]);
                        int b = map.get(splitExp[1]) == null ? Integer.parseInt(splitExp[1])
                                : map.get(splitExp[1]);
                        map.put(split[1], a << b);
                    }
                } else if (expression.contains("RSHIFT")) {
                    String[] splitExp = expression.split(" RSHIFT ");
                    if ((map.containsKey(splitExp[0]) || splitExp[0].matches("[0-9]+"))
                            && (map.containsKey(splitExp[1]) || splitExp[1].matches("[0-9]+"))) {
                        int a = map.get(splitExp[0]) == null ? Integer.parseInt(splitExp[0])
                                : map.get(splitExp[0]);
                        int b = map.get(splitExp[1]) == null ? Integer.parseInt(splitExp[1])
                                : map.get(splitExp[1]);
                        map.put(split[1], a >> b);
                    }
                } else if (expression.contains("NOT")) {
                    String splitExp = expression.substring(4);
                    if (map.containsKey(splitExp) || splitExp.matches("[0-9]+")) {
                        int a = map.get(splitExp) == null ? Integer.parseInt(splitExp)
                                : map.get(splitExp);
                        map.put(split[1], ~a);
                    }
                } else {
                    if (map.containsKey(split[0]) || split[0].matches("[0-9]+")) {
                        int a = map.get(split[0]) == null ? Integer.parseInt(split[0])
                                : map.get(split[0]);
                        map.put(split[1], a);
                    }
                }
            }
            count++;
        }
        System.out.println(count);
        System.out.println(map);
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
