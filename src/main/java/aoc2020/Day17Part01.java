package aoc2020;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day17Part01 extends AdventOfCode {

    public static int solve() {
        List<String> actives = getData(FileConstants.AOC_2020_17);
        Set<String> activeCubes = new TreeSet<>();
        for (int y = 0; y < actives.size(); y++) {
            String line = actives.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == '#') {
                    int[] coordinates = { x, y, 0 };
                    activeCubes.add(Arrays.toString(coordinates));
                }
            }
        }
        System.out.println(activeCubes);
        System.out.println(0 + ": " + activeCubes.size());
        int cycle = 1;
        int xMin = -1;
        int xMax = 8;
        int yMin = -1;
        int yMax = 8;
        int zMin = -1;
        int zMax = 1;
        while (cycle <= 6) {
            Set<String> toAdd = new TreeSet<>();
            Set<String> toRemove = new TreeSet<>();
            for (int x = xMin; x <= xMax; x++) {
                for (int y = yMin; y <= yMax; y++) {
                    for (int z = zMin; z <= zMax; z++) {
                        int[] cube = { x, y, z };
                        Set<String> activesNeighbors = getActiveNeighbours(cube, activeCubes);
                        int count = activesNeighbors.size();
                        String cubeString = Arrays.toString(cube);
                        if (count == 3 && !activeCubes.contains(cubeString)) {
                            toAdd.add(cubeString);
                        } else if ((count < 2 || count > 3) && activeCubes.contains(cubeString)) {
                            toRemove.add(cubeString);
                        }
                    }
                }
            }
            xMin--;
            xMax++;
            yMin--;
            yMax++;
            zMin--;
            zMax++;
            System.out.println(toRemove);
            activeCubes.removeAll(toRemove);
            activeCubes.addAll(toAdd);
            System.out.println(activeCubes);
            System.out.println(cycle + ": " + activeCubes.size());
            cycle++;
        }
        System.out.println(activeCubes.size());
        return 0;
    }

    private static Set<String> getActiveNeighbours(int[] cube, Set<String> activeCubes) {
        Set<String> activeNeighbours = getNeighbours(cube);
        activeNeighbours.retainAll(activeCubes);
        return activeNeighbours;
    }

    private static Set<String> getNeighbours(int[] cube) {
        Set<String> neighbours = new TreeSet<>();
        for (int xNeighbour = cube[0] - 1; xNeighbour <= cube[0] + 1; xNeighbour++) {
            for (int yNeighbour = cube[1] - 1; yNeighbour <= cube[1] + 1; yNeighbour++) {
                for (int zNeighbour = cube[2] - 1; zNeighbour <= cube[2] + 1; zNeighbour++) {
                    if (xNeighbour == cube[0] && yNeighbour == cube[1] && zNeighbour == cube[2]) {
                        continue;
                    }
                    int[] neighbour = { xNeighbour, yNeighbour, zNeighbour };
                    neighbours.add(Arrays.toString(neighbour));
                }
            }
        }
        return neighbours;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
