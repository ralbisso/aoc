package aoc2020;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day05Part02 extends AdventOfCode {

    public static void main(String[] args) {

        // File processing
        List<String> seats = getData(FileConstants.AOC_2020_05);

        // Problem solving
        Set<Integer> seatIDs = new TreeSet<>();
        for (String seat : seats) {
            String binaryRow = seat.substring(0, 7).replaceAll("F", "0").replaceAll("B", "1");
            String binaryCol = seat.substring(7).replaceAll("L", "0").replaceAll("R", "1");
            int row = Integer.parseInt(binaryRow, 2);
            int col = Integer.parseInt(binaryCol, 2);
            seatIDs.add(row * 8 + col);
        }
        int mySeat = 0;
        for (int id = 1; id <= 1000; id++) {
            if (!seatIDs.contains(id) && seatIDs.contains(id + 1) && seatIDs.contains(id - 1)) {
                mySeat = id;
                break;
            }
        }
        System.out.println("Answer: " + mySeat);
    }
}
