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

public class Day04Part02 {

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
        boolean byr = checkBirthYear(passport);

        // iyr (Issue Year)
        boolean iyr = checkIssueYear(passport);

        // eyr (Expiration Year)
        boolean eyr = checkExpirationYear(passport);

        // hgt (Height)
        boolean hgt = checkHeight(passport);

        // hcl (Hair Color)
        boolean hcl = checkHairColor(passport);

        // ecl (Eye Color)
        boolean ecl = checkEyeColor(passport);

        // pid (Passport ID)
        boolean pid = checkPassportID(passport);

        return byr && iyr && eyr && hgt && hcl && ecl && pid;
    }

    private static boolean checkBirthYear(Map<String, String> passport) {
        if (passport.get("byr") == null) {
            return false;
        } else {
            int byr = Integer.parseInt(passport.get("byr"));
            if (byr < 1920 || byr > 2002) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkIssueYear(Map<String, String> passport) {
        if (passport.get("iyr") == null) {
            return false;
        } else {
            int iyr = Integer.parseInt(passport.get("iyr"));
            if (iyr < 2010 || iyr > 2020) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkExpirationYear(Map<String, String> passport) {
        if (passport.get("eyr") == null) {
            return false;
        } else {
            int eyr = Integer.parseInt(passport.get("eyr"));
            if (eyr < 2020 || eyr > 2030) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkHeight(Map<String, String> passport) {
        String hgt = passport.get("hgt");
        if (hgt == null) {
            return false;
        } else {
            String unit = hgt.substring(hgt.length() - 2);
            if (!unit.equals("cm") && !unit.equals("in")) {
                return false;
            } else {
                int value = Integer.parseInt(hgt.substring(0, hgt.length() - 2));
                if (unit.equals("cm") && (value < 150 || value > 193)) {
                    return false;
                } else if (unit.equals("in") && (value < 59 || value > 76)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkHairColor(Map<String, String> passport) {
        String hcl = passport.get("hcl");
        return hcl != null && hcl.matches("^#[a-f0-9]{6}$");
    }

    private static boolean checkEyeColor(Map<String, String> passport) {
        String ecl = passport.get("ecl");
        return ecl != null && ecl.matches("amb|blu|brn|gry|grn|hzl|oth");
    }

    private static boolean checkPassportID(Map<String, String> passport) {
        String pid = passport.get("pid");
        return pid != null && pid.matches("^[0-9]{9}$");
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
