package aoc2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.FileConstants;

public class Day19Part02 {

    public static int solve() {
        Data parameters = getData(FileConstants.AOC_2015_19);
        List<String[]> replacements = parameters.replacements;
        String target = parameters.molecule;
        Set<String> molecules = new HashSet<>();
        molecules.add("e");
        int i = 0;
        int low = 0;
        while (!molecules.contains(target)) {
            Set<String> possibilities = new HashSet<>();
            int quality = (low == 0) ? i - 1 : low++;
            for (String molecule : molecules) {
                for (String[] replacement : replacements) {
                    if (i < 100) {
                        possibilities
                                .addAll(getPossibilities(molecule, target, replacement, quality));
                    } else if (i < 60) {
                        possibilities.addAll(
                                getPossibilities(molecule, target, replacement, quality + 3));
                    } else {
                        possibilities.addAll(
                                getPossibilities(molecule, target, replacement, quality + 7));
                    }
                }
            }
            if (i == 0 || i == 11 || i % 17 != 0) {
                molecules = new HashSet<>(possibilities);
            } else {
                System.out.println("Trim ça lol ! " + possibilities.size());
                molecules = new HashSet<>();
                int trim = (i > 40) ? (i > 80) ? 24 : 8 : 12;
                int min = Integer.MAX_VALUE;
                target = target.substring(trim, target.length() - trim);
                for (String p : possibilities) {
                    int q = getQuality(p.substring(trim, p.length() - trim), target);
                    if (q < min) {
                        min = q;
                    }
                    molecules.add(p.substring(trim, p.length() - trim));
                }
                System.out.println(max + ", " + target);
                if (i > 90) {
                    low = Math.max(0, max - 1);
                } else if (i > 70) {
                    low = Math.max(0, max - 2);
                } else if (i > 30) {
                    low = Math.max(0, max - 3);
                } else {
                    low = Math.max(0, max - 4);
                }
            }
            System.out.println(
                    ++i + ", " + molecules.iterator().next() + ", size: " + molecules.size());
        }

        return 0;
    }

    private static Set<String> getPossibilities(String molecule, String target,
            String[] replacement, int quality) {
        Set<String> possibleMolecules = new HashSet<>();
        String before = replacement[0];
        String after = replacement[1];
        int size = before.length();
        for (int i = molecule.indexOf(before); i >= 0; i = molecule.indexOf(before, i + 1)) {
            String newMolecule = molecule.substring(0, i) + after + molecule.substring(i + size);
            if (getQuality(newMolecule, target) >= quality) {
                possibleMolecules.add(newMolecule);
            }
        }
        return possibleMolecules;
    }

    private static int getQuality(String molecule, String target) {
        int index = 0;
        int mLength = molecule.length() - 1;
        int tLength = target.length() - 1;
        while (molecule.charAt(index) == target.charAt(index)
                && molecule.charAt(mLength - index) == target.charAt(tLength - index)) {
            index++;
        }
        return index;
    }

    private static Data getData(String input) {
        List<String[]> replacements = new ArrayList<>();
        String molecule = null;
        try (BufferedReader br = Files.newBufferedReader(Paths.get(input))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(" => ")) {
                    if (!line.contains("CRn")) {
                        replacements.add(line.split(" => "));
                    }
                } else if (!line.isEmpty()) {
                    molecule = line;
                }
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return new Data(replacements, molecule);
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}

class Data {

    List<String[]> replacements;
    String molecule;

    Data(List<String[]> replacements, String molecule) {
        this.replacements = replacements;
        this.molecule = molecule;
    }
}
