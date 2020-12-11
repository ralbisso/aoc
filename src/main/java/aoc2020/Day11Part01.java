package aoc2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day11Part01 {

    public static void main(String[] args) {

        // File processing
        List<String> grid = new ArrayList<>();
        try (BufferedReader br = Files
                .newBufferedReader(Paths.get("src/main/resources/2020/day11.data"))) {
            String line;
            while ((line = br.readLine()) != null) {
                grid.add(line);
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        // Problem solving
        System.out.println(grid.size());

        char[][] matrix = new char[97][100];
        for (int i = 0; i < 97; i++) {
            for (int j = 0; j < 91; j++) {
                matrix[i][j] = grid.get(i).charAt(j);
            }
        }

        int previous = -1;
        int current = -1;

        print(matrix);
        process(matrix);
        current = count(matrix);

        while (previous != current) {
            print(matrix);
            process(matrix);
            previous = current;
            current = count(matrix);
        }

        System.out.println("Answer: " + current);
    }

    private static int count(char[][] matrix) {
        int occ = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == '#') {
                    occ++;
                }
            }
        }
        return occ;
    }

    private static void print(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int countOcc(char[][] matrix, int i, int j) {
        int nbOccupied = 0;
        if (j + 1 < matrix.length && matrix[i][j + 1] == '#') {
            nbOccupied++;
        }
        if (j - 1 >= 0 && matrix[i][j - 1] == '#') {
            nbOccupied++;
        }
        if (i + 1 < matrix.length && matrix[i + 1][j] == '#') {
            nbOccupied++;
        }
        if (i - 1 >= 0 && matrix[i - 1][j] == '#') {
            nbOccupied++;
        }
        if (i + 1 < matrix.length && j + 1 < matrix.length && matrix[i + 1][j + 1] == '#') {
            nbOccupied++;
        }
        if (i - 1 >= 0 && j - 1 >= 0 && matrix[i - 1][j - 1] == '#') {
            nbOccupied++;
        }
        if (i + 1 < matrix.length && j - 1 >= 0 && matrix[i + 1][j - 1] == '#') {
            nbOccupied++;
        }
        if (i - 1 >= 0 && j + 1 < matrix.length && matrix[i - 1][j + 1] == '#') {
            nbOccupied++;
        }
        return nbOccupied;
    }

    private static void process(char[][] matrix) {
        List<int[]> toOccupied = new ArrayList<>();
        List<int[]> toFree = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 'L') {
                    int nbOccupied = countOcc(matrix, i, j);
                    if (nbOccupied == 0) {
                        int[] coord = { i, j };
                        toOccupied.add(coord);
                    }
                } else if (matrix[i][j] == '#') {
                    int nbOccupied = countOcc(matrix, i, j);
                    if (nbOccupied >= 4) {
                        int[] coord = { i, j };
                        toFree.add(coord);
                    }
                }
            }
        }
        for (int[] array : toOccupied) {
            matrix[array[0]][array[1]] = '#';
        }
        for (int[] array : toFree) {
            matrix[array[0]][array[1]] = 'L';
        }
    }

}
