package aoc2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day19Part01 extends AdventOfCode {

    public static int solve() {
        List<String> list = getData(FileConstants.AOC_2020_19);
        Map<String, String> rules = new TreeMap<>();
        List<String> patterns = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i < 135) {
                String[] split = list.get(i).split(":");
                rules.put(split[0], split[1].trim().replaceAll("\"", ""));
            } else if (i > 135) {
                patterns.add(list.get(i));
            }
        }
        System.out.println(rules);
        System.out.println(patterns);
        System.out.println(getPattern("42", rules));
        System.out.println(getPattern("31", rules));
        Map<String, Integer> memo = new TreeMap<>();
        for (Entry<String, String> e : rules.entrySet()) {
            memo.put(e.getKey(), nbRule(e.getValue(), rules));
        }
        System.out.println(memo);
        int count = 0;
        for (String p : patterns) {
            if (checkRule(p, rules.get("0"), rules, memo)) {
                count++;
            }
        }
        return count;
    }

    private static boolean checkRule(String pattern, String rule, Map<String, String> rules,
            Map<String, Integer> memo) {
        if (rule.contains("|")) {
            String[] split = rule.split("\\|");
            return checkRule(pattern, split[0].trim(), rules, memo)
                    || checkRule(pattern, split[1].trim(), rules, memo);
        } else if (rule.length() == 1) {
            try {
                if ((rule.equals("a") && pattern.charAt(0) == 'a')
                        || (rule.equals("b") && pattern.charAt(0) == 'b')) {
                    return true;
                } else {
                    return false;
                }
            } catch (StringIndexOutOfBoundsException sioobe) {
                // System.out.println("T'avais pas plus crade ? " + rule + ", " + pattern);
                return false;
            }
        }
        // System.out.println("On check " + rule + " sur: " + pattern);
        String[] split = rule.split(" ");
        for (String element : split) {
            // System.out.println("On commence par " + element + " c'est-à-dire " +
            // rules.get(element)
            // + " sur: " + pattern);
            if (!checkRule(pattern, rules.get(element), rules, memo)) {
                return false;
            }
            // System.out.println("Bah écoute " + rules.get(element) + " est OK sur: " +
            // pattern);
            pattern = pattern.substring(memo.get(element));
        }
        return true;
    }

    private static String getPattern(String rule, Map<String, String> rules) {
        if (rule.equals("a")) {
            return "a";
        }
        if (rule.equals("b")) {
            return "b";
        }
        if (rule.contains("|")) {
            return "(" + getPattern(rule.split("\\|")[0].trim(), rules) + "|"
                    + getPattern(rule.split("\\|")[1].trim(), rules) + ")";
        }
        String[] split = rule.split(" ");
        String s = "";
        for (String element : split) {
            s += getPattern(rules.get(element), rules);
        }
        return s;
    }

    private static int nbRule(String rule, Map<String, String> rules) {
        if (rule.equals("a") || rule.equals("b")) {
            return 1;
        }
        if (rule.contains("|")) {
            return nbRule(rule.split("\\|")[0].trim(), rules);
        }
        String[] split = rule.split(" ");
        int count = 0;
        for (String element : split) {
            count += nbRule(rules.get(element), rules);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
