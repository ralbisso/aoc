package aoc2020;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day24Part01 extends AdventOfCode {

    public static int solve() {
        List<String> flips = getData(FileConstants.AOC_2020_24);
        Set<String> blackTiles = getBlackTiles(flips);
        return blackTiles.size();
    }

    public static Set<String> getBlackTiles(List<String> flips) {
        Set<String> blackTiles = new HashSet<>();
        for (String flip : flips) {
            int[] current = { 0, 0 };
            while (!"".equals(flip)) {
                if (flip.startsWith("e")) {
                    current[0] += 2;
                    flip = flip.substring(1);
                } else if (flip.startsWith("se")) {
                    current[0]++;
                    current[1]--;
                    flip = flip.substring(2);
                } else if (flip.startsWith("sw")) {
                    current[0]--;
                    current[1]--;
                    flip = flip.substring(2);
                } else if (flip.startsWith("w")) {
                    current[0] -= 2;
                    flip = flip.substring(1);
                } else if (flip.startsWith("nw")) {
                    current[0]--;
                    current[1]++;
                    flip = flip.substring(2);
                } else if (flip.startsWith("ne")) {
                    current[0]++;
                    current[1]++;
                    flip = flip.substring(2);
                }
            }
            String key = Arrays.toString(current);
            if (!blackTiles.contains(key)) {
                blackTiles.add(key);
            } else {
                blackTiles.remove(key);
            }
        }
        return blackTiles;
    }

    public static void main(String args[]) {
        System.out.println("Answer: " + solve());
    }
}
