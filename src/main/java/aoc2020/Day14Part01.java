package aoc2020;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day14Part01 extends AdventOfCode {

    public static long solve() {
        List<String> program = getData(FileConstants.AOC_2020_14);
        Map<Integer, Long> memory = new TreeMap<>();
        String mask = "";
        for (String s : program) {
            if (s.startsWith("mem")) {
                String[] split = s.replaceAll("mem\\[|\\]", "").replace(" = ", ",").split(",");
                int address = Integer.parseInt(split[0]);
                String valueBeforeMask = addLeadingZeroes(mask, split[1]);
                long value = Long.parseLong(applyMask(mask, valueBeforeMask), 2);
                memory.put(address, value);
            } else {
                mask = s.replace("mask = ", "");
            }
        }
        long sum = 0L;
        for (Entry<Integer, Long> e : memory.entrySet()) {
            sum += e.getValue();
        }
        return sum;
    }

    private static String addLeadingZeroes(String mask, String value) {
        String binary = Integer.toBinaryString(Integer.parseInt(value));
        while (mask.length() > binary.length()) {
            binary = "0" + binary;
        }
        return binary;
    }

    private static String applyMask(String mask, String binary) {
        StringBuilder sb = new StringBuilder(binary);
        for (int i = 0; i < mask.length(); i++) {
            char c = mask.charAt(i);
            if (c != 'X') {
                sb.setCharAt(i, c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
