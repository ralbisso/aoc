package aoc2015;

import java.util.List;

import org.apache.commons.text.StringEscapeUtils;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day08Part01 extends AdventOfCode {

    public static int solve() {
        List<String> literals = getData(FileConstants.AOC_2015_08);
        int total = 0;
        int memory = 0;
        for (String literal : literals) {
            total += literal.length();
            String escaped = literal.substring(1, literal.length() - 1)
                    .replace("\\\"", "\"")
                    .replace("\\\\", "/")
                    .replaceAll("\\\\x", "\\\\u00");
            System.out.println(literal + ", size: " + literal.length());
            System.out.println(escaped + ", size: " + escaped.length());
            if (escaped.contains("\\u00")) {
                escaped = StringEscapeUtils.unescapeJava(escaped);
                System.out.println(escaped + ", size: " + escaped.length());
            }
            memory += escaped.length();
            System.out.println();
        }
        return total - memory;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
