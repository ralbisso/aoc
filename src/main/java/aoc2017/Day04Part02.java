package aoc2017;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day04Part02 extends AdventOfCode {

    public static int solve() {
        List<String> passphrases = getData(FileConstants.AOC_2017_04);
        int count = 0;
        for (String passphrase : passphrases) {
            String[] split = passphrase.split(" ");
            for (int i = 0; i < split.length; i++) {
                split[i] = getSortedString(split[i]);
            }
            Set<String> set = new HashSet<>(Arrays.asList(split));
            if (split.length == set.size()) {
                count++;
            }
        }
        return count;
    }

    private static String getSortedString(String string) {
        String sorted = "";
        String[] split = string.split("");
        Arrays.sort(split);
        for (int i = 0; i < split.length; i++) {
            sorted += split[i];
        }
        return sorted;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
