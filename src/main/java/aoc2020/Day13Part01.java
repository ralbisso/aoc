package aoc2020;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day13Part01 extends AdventOfCode {

    public static int solve() {
        List<String> notes = getData(FileConstants.AOC_2020_13);
        Set<Integer> busesIDs = getBusIDs(notes.get(1));
        int min = Integer.MAX_VALUE;
        int earliest = 0;
        int estimate = Integer.parseInt(notes.get(0));
        for (int busID : busesIDs) {
            int wait = busID - estimate % busID;
            if (wait < min) {
                min = wait;
                earliest = wait * busID;
            }
        }
        return earliest;
    }

    private static Set<Integer> getBusIDs(String buses) {
        String[] split = buses.split(",");
        Set<Integer> ids = new TreeSet<>();
        for (String s : split) {
            if (!s.equals("x")) {
                ids.add(Integer.parseInt(s));
            }
        }
        return ids;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
