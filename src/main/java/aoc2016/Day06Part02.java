package aoc2016;

import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day06Part02 extends AdventOfCode {

    public static String solve() {
        List<String> messages = getData(FileConstants.AOC_2016_06);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] c0 = new int[26];
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        int[] c3 = new int[26];
        int[] c4 = new int[26];
        int[] c5 = new int[26];
        int[] c6 = new int[26];
        int[] c7 = new int[26];
        for (String message : messages) {
            c0[alphabet.indexOf(message.charAt(0))]++;
            c1[alphabet.indexOf(message.charAt(1))]++;
            c2[alphabet.indexOf(message.charAt(2))]++;
            c3[alphabet.indexOf(message.charAt(3))]++;
            c4[alphabet.indexOf(message.charAt(4))]++;
            c5[alphabet.indexOf(message.charAt(5))]++;
            c6[alphabet.indexOf(message.charAt(6))]++;
            c7[alphabet.indexOf(message.charAt(7))]++;
        }
        String code = "";
        code += alphabet.charAt(getIndexOfArrayMin(c0));
        code += alphabet.charAt(getIndexOfArrayMin(c1));
        code += alphabet.charAt(getIndexOfArrayMin(c2));
        code += alphabet.charAt(getIndexOfArrayMin(c3));
        code += alphabet.charAt(getIndexOfArrayMin(c4));
        code += alphabet.charAt(getIndexOfArrayMin(c5));
        code += alphabet.charAt(getIndexOfArrayMin(c6));
        code += alphabet.charAt(getIndexOfArrayMin(c7));
        return code;
    }

    private static int getIndexOfArrayMin(int[] array) {
        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
