package aoc2020;

import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day05Part01 extends AdventOfCode {

    public static int solve() {
        List<String> seats = getData(FileConstants.AOC_2020_05);
        int highest = 0;
        for (String seat : seats) {
            String binaryRow = seat.substring(0, 7).replaceAll("F", "0").replaceAll("B", "1");
            String binaryCol = seat.substring(7).replaceAll("L", "0").replaceAll("R", "1");
            int row = Integer.parseInt(binaryRow, 2);
            int col = Integer.parseInt(binaryCol, 2);
            int seatID = row * 8 + col;
            if (seatID > highest) {
                highest = seatID;
            }
        }
        return highest;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
