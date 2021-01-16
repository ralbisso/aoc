package aoc2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day21Part01 extends AdventOfCode {

    private static int solve() {
        List<String> list = getData(FileConstants.AOC_2020_21);
        int count = 0;
        Map<String, List<String>> map = new TreeMap<>();
        for (String item : list) {
            String[] split = item.replace("(contains ", "").replace(", ", ",").replace(")", "")
                    .split(" ");
            List<String> ingredients = new ArrayList<>();
            String allergens = "";

            for (int i = 0; i < split.length; i++) {
                if (i < split.length - 1) {
                    ingredients.add(split[i]);
                    if (!split[i].equals("vpzxk") && !split[i].equals("bkgmcsx")
                            && !split[i].equals("qfzv") && !split[i].equals("tjtgbf")
                            && !split[i].equals("rjdqt") && !split[i].equals("hbnf")
                            && !split[i].equals("jspkl") && !split[i].equals("hdcj")) {
                        count++;
                    }
                } else {
                    allergens = split[split.length - 1];
                }
            }
            System.out.println(ingredients);
            for (String allergen : allergens.split(",")) {
                if (!map.containsKey(allergen)) {
                    map.put(allergen, new ArrayList<>(ingredients));
                } else {
                    map.get(allergen).retainAll(ingredients);
                }
            }
        }
        System.out.println(map);
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }

}
