package aoc2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import utils.FileConstants;

public class Day04Part01 {

    public static int solve() {
        List<Map<String, String>> passports = getData(FileConstants.AOC_2020_04);
        int validPassportsCount = 0;
        for (Map<String, String> passport : passports) {
            if (isPassportValid(passport)) {
                validPassportsCount++;
            }
        }
        return validPassportsCount;
    }

    private static List<Map<String, String>> getData(String input) {
        List<Map<String, String>> data = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(input))) {
            String line;
            Map<String, String> passport = new TreeMap<>();
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    String[] splitLine = line.split(" ");
                    for (String split : splitLine) {
                        String[] splitField = split.split(":");
                        String key = splitField[0];
                        String value = splitField[1];
                        passport.put(key, value);
                    }
                } else {
                    data.add(passport);
                    passport = new TreeMap<>();
                }
            }
            data.add(passport);
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return data;
    }

    private static boolean isPassportValid(Map<String, String> passport) {

        // byr (Birth Year)
        if (passport.get("byr") == null) {
            return false;
        }

        // iyr (Issue Year)
        if (passport.get("iyr") == null) {
            return false;
        }

        // eyr (Expiration Year)
        if (passport.get("eyr") == null) {
            return false;
        }

        // hgt (Height)
        if (passport.get("hgt") == null) {
            return false;
        }

        // hcl (Hair Color)
        if (passport.get("hcl") == null) {
            return false;
        }

        // ecl (Eye Color)
        if (passport.get("ecl") == null) {
            return false;
        }

        // pid (Passport ID)
        if (passport.get("pid") == null) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
