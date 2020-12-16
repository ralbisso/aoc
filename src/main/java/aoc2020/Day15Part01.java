package aoc2020;

import java.util.HashMap;
import java.util.Map;

public class Day15Part01 {

    public static long solve() {
        Map<Integer, Integer> previousIndexOf = new HashMap<>();
        Map<Integer, Integer> lastIndexOf = initializeData();
        int numTurn = 7;
        int offset = 0;
        while (numTurn <= 2020) {
            int last = offset;
            if (previousIndexOf.containsKey(last)) {
                offset = lastIndexOf.get(last) - previousIndexOf.get(last);
                Integer add = lastIndexOf.put(offset, numTurn);
                if (add != null) {
                    previousIndexOf.put(offset, add);
                }
            } else {
                offset = 0;
                previousIndexOf.put(0, lastIndexOf.put(0, numTurn));
            }
            numTurn++;
        }
        return offset;
    }

    private static Map<Integer, Integer> initializeData() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(13, 2);
        map.put(1, 3);
        map.put(8, 4);
        map.put(6, 5);
        map.put(15, 6);
        return map;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
