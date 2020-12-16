package aoc2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day14Part02 extends AdventOfCode {

    public static long solve() {
        List<String> program = getData(FileConstants.AOC_2020_14);
        Map<Long, Long> memory = new TreeMap<>();
        String mask = "";
        for (String s : program) {
            if (s.startsWith("mem")) {
                String[] split = s.replaceAll("mem\\[|\\]", "").replace(" = ", ",").split(",");
                StringBuilder sbAddress = new StringBuilder(addLeadingZeroes(mask, split[0]));
                StringBuilder sbValue = new StringBuilder(addLeadingZeroes(mask, split[1]));
                applyMask(mask, sbAddress);
                List<StringBuilder> addressesPrevious = applyMaskAndAddInList(sbAddress);
                List<StringBuilder> addressesCurrent = new ArrayList<>();
                while (addressesPrevious.get(0).indexOf("X") > 0) {
                    for (StringBuilder sb : addressesPrevious) {
                        List<StringBuilder> maskedAddresses = applyMaskAndAddInList(sb);
                        addressesCurrent.addAll(maskedAddresses);
                    }
                    addressesPrevious = new ArrayList<>(addressesCurrent);
                    addressesCurrent = new ArrayList<>();
                }
                addressesCurrent = addressesPrevious;
                for (StringBuilder addressCurrent : addressesCurrent) {
                    long address = Long.parseLong(addressCurrent.toString(), 2);
                    long value = Long.parseLong(sbValue.toString(), 2);
                    memory.put(address, value);
                }
            } else {
                mask = s.replace("mask = ", "");
            }
        }
        long sum = 0L;
        for (Entry<Long, Long> e : memory.entrySet()) {
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

    private static void applyMask(String mask, StringBuilder sb) {
        for (int i = 0; i < mask.length(); i++) {
            char c = mask.charAt(i);
            if (c != '0') {
                sb.setCharAt(i, c);
            }
        }
    }

    private static List<StringBuilder> applyMaskAndAddInList(StringBuilder sbAddress) {
        List<StringBuilder> addresses = new ArrayList<>();
        for (int i = 0; i < sbAddress.length(); i++) {
            char c = sbAddress.charAt(i);
            if (c == 'X') {
                sbAddress.setCharAt(i, '0');
                addresses.add(new StringBuilder(sbAddress));
                sbAddress.setCharAt(i, '1');
                addresses.add(sbAddress);
                break;
            }
        }
        return addresses;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
