package aoc2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day16Part01 extends AdventOfCode {

    public static int solve() {
        List<String> list = getData(FileConstants.AOC_2020_16);

        // Parse rules
        List<int[]> rules = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String[] intervals = list.get(i).split(": ")[1].split(" or ");
            int[] rule = new int[4];
            rule[0] = Integer.parseInt(intervals[0].split("-")[0]);
            rule[1] = Integer.parseInt(intervals[0].split("-")[1]);
            rule[2] = Integer.parseInt(intervals[1].split("-")[0]);
            rule[3] = Integer.parseInt(intervals[1].split("-")[1]);
            rules.add(rule);
        }
        List<int[]> tickets = new ArrayList<>();
        for (int i = 25; i < list.size(); i++) {
            String[] split = list.get(i).split(",");
            int[] ticket = new int[split.length];
            for (int j = 0; j < ticket.length; j++) {
                ticket[j] = Integer.parseInt(split[j]);
            }
            // System.out.println(Arrays.toString(ticket));
            tickets.add(ticket);
        }
        System.out.println(tickets.size());
        List<Integer> toRemove = new ArrayList<>();
        for (int i = 0; i < tickets.size(); i++) {
            for (int j = 0; j < tickets.get(i).length; j++) {
                boolean valid = false;
                int value = tickets.get(i)[j];
                for (int[] rule : rules) {
                    if ((value >= rule[0] && value <= rule[1])
                            || (value >= rule[2] && value <= rule[3])) {
                        valid = true;
                        break;
                    }
                }
                if (!valid) {
                    toRemove.add(i);
                    break;
                }
            }
        }
        List<int[]> ticketsAfter = new ArrayList<>();
        for (int i = 0; i < tickets.size(); i++) {
            if (!toRemove.contains(i)) {
                ticketsAfter.add(tickets.get(i));
            }
        }
        Map<Integer, List<int[]>> possibleRulesByColumn = new TreeMap<>();
        for (int column = 0; column < ticketsAfter.get(0).length; column++) {
            Set<Integer> columnValues = new TreeSet<>();
            for (int[] ticket : ticketsAfter) {
                columnValues.add(ticket[column]);
            }
            for (int[] rule : rules) {
                boolean allValid = false;
                for (int value : columnValues) {
                    if ((value >= rule[0] && value <= rule[1])
                            || (value >= rule[2] && value <= rule[3])) {
                        allValid = true;
                    } else {
                        allValid = false;
                        break;
                    }
                }
                if (allValid) {
                    if (!possibleRulesByColumn.containsKey(column)) {
                        possibleRulesByColumn.put(column, new ArrayList<>());
                    }
                    possibleRulesByColumn.get(column).add(rule);
                }
            }
        }
        for (Entry<Integer, List<int[]>> e : possibleRulesByColumn.entrySet()) {
            String s = "";
            for (int[] array : e.getValue()) {
                s += Arrays.toString(array);
            }
            System.out.println(e.getKey() + ", " + s);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
