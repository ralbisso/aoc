package aoc2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day20Part02 extends AdventOfCode {

    private static long solve() {
        List<String> list = getData(FileConstants.AOC_2020_20);
        Map<Integer, char[][]> tiles = new TreeMap<>();
        char[][] tile = new char[10][10];
        int row = 0;
        int id = 0;
        for (String s : list) {
            if (s.startsWith("Tile")) {
                id = Integer.parseInt(s.split(" ")[1].replaceAll(":", ""));
            } else if (!s.isEmpty()) {
                for (int i = 0; i < s.length(); i++) {
                    tile[row][i] = s.charAt(i);
                }
                row++;
            } else {
                tiles.put(id, tile);
                tile = new char[10][10];
                row = 0;
            }
        }
        tiles.put(id, tile);
        Map<Integer, List<char[]>> borders = new TreeMap<>();
        for (Entry<Integer, char[][]> e : tiles.entrySet()) {
            borders.put(e.getKey(), getEdges(e.getValue()));
        }
        long product = 1L;
        for (Entry<Integer, List<char[]>> t1 : borders.entrySet()) {
            List<char[]> edgesT1 = t1.getValue();
            List<Integer> neighbours = new ArrayList<>();
            for (Entry<Integer, List<char[]>> t2 : borders.entrySet()) {
                if (t1.getKey() != t2.getKey()) {
                    List<char[]> edgesT2 = t2.getValue();
                    loop: for (char[] edgeT1 : edgesT1) {
                        for (char[] edgeT2 : edgesT2) {
                            char[] reverseEdgeT2 = reverseEdge(edgeT2);
                            if (Arrays.equals(edgeT1, edgeT2)
                                    || Arrays.equals(edgeT1, reverseEdgeT2)) {
                                neighbours.add(t2.getKey());
                                break loop;
                            }
                        }
                    }
                }
            }
            if (neighbours.size() == 4) {
                product *= t1.getKey();
            }
        }
        int[][] puzzle = getPuzzleSolution();
        puzzle = flipSolution2(puzzle);
        char[][] image = new char[120][120];
        int rowImage = 0;
        int colImage = 0;
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length - 1; j++) {
                // System.out.println(puzzle[i][j] + " vs. " + puzzle[i][j + 1]);
                char[][] left = tiles.get(puzzle[i][j]);
                if (puzzle[i][j] == 2287 || puzzle[i][j] == 1097) {
                    left = flipTile(left);
                }
                char[][] right = tiles.get(puzzle[i][j + 1]);
                int count = 0;
                while (!checkLeftRightTiles(left, right)) {
                    if (count > 0 && count % 4 == 0) {
                        if (j == 0) {
                            left = rotateTile(left);
                        }
                        right = tiles.get(puzzle[i][j + 1]);
                    } else {
                        right = rotateTile(right);
                    }
                    count++;
                    if (count > 16) {
                        left = tiles.get(puzzle[i][j]);
                        right = flipTile(tiles.get(puzzle[i][j + 1]));
                        count = 0;
                        while (!checkLeftRightTiles(left, right)) {
                            if (count > 0 && count % 4 == 0) {
                                left = rotateTile(left);
                            }
                            right = rotateTile(right);
                            count++;
                            if (count > 16) {
                                System.out.println("Mais euh !");
                                break;
                            }
                        }
                        break;
                    }
                }
                if (puzzle[i][j] == 1721 || puzzle[i][j] == 2357) {
                    left = flipTile2(left);
                    right = flipTile2(right);
                }
                tiles.put(puzzle[i][j], left);
                tiles.put(puzzle[i][j + 1], right);
                // printTile(right);
                if (j == 0) {
                    if (i > 0) {
                        rowImage += 8;
                    }
                    colImage = 0;
                    for (int x = 1; x < left.length - 1; x++) {
                        for (int y = 1; y < left.length - 1; y++) {
                            image[rowImage][colImage++] = left[x][y];
                        }
                        colImage = 0;
                        rowImage++;
                    }
                    colImage += 8;
                    rowImage -= 8;
                }
                for (int x = 1; x < right.length - 1; x++) {
                    for (int y = 1; y < right.length - 1; y++) {
                        image[rowImage][colImage++] = right[x][y];
                    }
                    colImage -= 8;
                    rowImage++;
                }
                colImage = 8 * (j + 2);
                rowImage -= 8;
            }
        }
        printTile(image);
        image = flipTile(image);
        image = rotateTile(image);
        // image = rotateTile(image);
        // image = rotateTile(image);
        int nbTotal = 0;
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image.length; j++) {
                if (image[i][j] == '#') {
                    nbTotal++;
                }
            }
        }
        int nbDenver = 0;
        for (int i = 0; i < image.length - 1; i++) {
            for (int j = 18; j < image.length - 1; j++) {
                char seaMonsterA = image[i][j];
                if (seaMonsterA != '#') {
                    continue;
                }
                char seaMonsterB = image[i + 1][j + 1];
                if (seaMonsterB != '#') {
                    continue;
                }
                char seaMonsterC = image[i + 1][j];
                if (seaMonsterC != '#') {
                    continue;
                }
                char seaMonsterD = image[i + 1][j - 1];
                if (seaMonsterD != '#') {
                    continue;
                }
                char seaMonsterE = image[i + 2][j - 2];
                if (seaMonsterE != '#') {
                    continue;
                }
                char seaMonsterF = image[i + 2][j - 5];
                if (seaMonsterF != '#') {
                    continue;
                }
                char seaMonsterG = image[i + 1][j - 6];
                if (seaMonsterG != '#') {
                    continue;
                }
                char seaMonsterH = image[i + 1][j - 7];
                if (seaMonsterH != '#') {
                    continue;
                }
                char seaMonsterI = image[i + 2][j - 8];
                if (seaMonsterI != '#') {
                    continue;
                }
                char seaMonsterJ = image[i + 2][j - 11];
                if (seaMonsterJ != '#') {
                    continue;
                }
                char seaMonsterK = image[i + 1][j - 12];
                if (seaMonsterK != '#') {
                    continue;
                }
                char seaMonsterL = image[i + 1][j - 13];
                if (seaMonsterL != '#') {
                    continue;
                }
                char seaMonsterM = image[i + 2][j - 14];
                if (seaMonsterM != '#') {
                    continue;
                }
                char seaMonsterN = image[i + 2][j - 17];
                if (seaMonsterN != '#') {
                    continue;
                }
                char seaMonsterO = image[i + 1][j - 18];
                if (seaMonsterO != '#') {
                    continue;
                }
                nbDenver++;
                System.out.println("Denver, le dernier dinosaure");
            }
        }
        System.out.println(nbTotal);
        System.out.println(nbDenver);
        System.out.println(nbTotal - nbDenver * 15);
        return product;
    }

    private static boolean checkLeftRightTiles(char[][] left, char[][] right) {
        for (int i = 0; i < left.length; i++) {
            if (left[i][left.length - 1] != right[i][0]) {
                return false;
            }
        }
        return true;
    }

    private static char[][] flipTile(char[][] tile) {
        char[][] flip = new char[tile.length][tile.length];
        for (int i = 0; i < flip.length; i++) {
            for (int j = 0; j < flip.length; j++) {
                flip[i][j] = tile[i][tile.length - j - 1];
            }
        }
        return flip;
    }

    private static char[][] flipTile2(char[][] tile) {
        char[][] flip = new char[tile.length][tile.length];
        for (int i = 0; i < flip.length; i++) {
            for (int j = 0; j < flip.length; j++) {
                flip[i][j] = tile[tile.length - i - 1][j];
            }
        }
        return flip;
    }

    private static int[][] flipSolution2(int[][] solution) {
        int[][] flip = new int[solution.length][solution.length];
        for (int i = 0; i < flip.length; i++) {
            for (int j = 0; j < flip.length; j++) {
                flip[i][j] = solution[j][i];
            }
        }
        return flip;
    }

    private static int[][] flipSolution(int[][] solution) {
        int[][] flip = new int[solution.length][solution.length];
        for (int i = 0; i < flip.length; i++) {
            for (int j = 0; j < flip.length; j++) {
                flip[i][j] = solution[i][solution.length - j - 1];
            }
        }
        return flip;
    }

    private static int[][] rotateSolution(int[][] solution) {
        int[][] rotate = new int[solution.length][solution.length];
        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate.length; j++) {
                rotate[i][j] = solution[j][solution.length - i - 1];
            }
        }
        return rotate;
    }

    private static char[][] rotateTile(char[][] tile) {
        char[][] rotate = new char[tile.length][tile.length];
        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate.length; j++) {
                rotate[i][j] = tile[rotate.length - j - 1][i];
            }
        }
        return rotate;
    }

    private static int[][] getPuzzleSolution() {
        int[][] solution = {
                { 2383, 2287, 3541, 1307, 1823, 1741, 1097, 2129, 1721, 1279, 2357, 2593 },
                { 3779, 2411, 1289, 2659, 2237, 1069, 3203, 2731, 2027, 2609, 2389, 3907 },
                { 2503, 1987, 1867, 3109, 3719, 1753, 2791, 1801, 1667, 3299, 2297, 1663 },
                { 3847, 3853, 2797, 3041, 2819, 3527, 2687, 3137, 1619, 2633, 3413, 2273 },
                { 2063, 2251, 1163, 2087, 2707, 3709, 1907, 1627, 3797, 1637, 1213, 2711 },
                { 2833, 1283, 3169, 1381, 2671, 1787, 2549, 2953, 3167, 2999, 3989, 3319 },
                { 3049, 1487, 2003, 3181, 2971, 1609, 3329, 1597, 2467, 3433, 2683, 2113 },
                { 2239, 1879, 3671, 3877, 1423, 1319, 1303, 1399, 3533, 1543, 2381, 2309 },
                { 3593, 2099, 3833, 1009, 3547, 1559, 1873, 1783, 2393, 1997, 3701, 1583 },
                { 2663, 1367, 3947, 2179, 1699, 2749, 1021, 3499, 1453, 1483, 1433, 3343 },
                { 2039, 1427, 1091, 3323, 1049, 1201, 2267, 3389, 3457, 2459, 2017, 2539 },
                { 3881, 1019, 1747, 1291, 1709, 1499, 3761, 2213, 1171, 2011, 3889, 2753 } };
        return solution;
    }

    private static char[] reverseEdge(char[] edge) {
        char[] reverse = new char[edge.length];
        for (int i = edge.length - 1; i >= 0; i--) {
            reverse[i] = edge[edge.length - 1 - i];
        }
        return reverse;
    }

    private static void printTile(char[][] tile) {
        for (int i = 0; i < tile.length; i++) {
            for (int j = 0; j < tile.length; j++) {
                System.out.print(tile[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printSolution(int[][] solution) {
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution.length; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static List<char[]> getEdges(char[][] tile) {
        char[] top = new char[tile.length];
        char[] bottom = new char[tile.length];
        char[] left = new char[tile.length];
        char[] right = new char[tile.length];
        for (int i = 0; i < tile.length; i++) {
            top[i] = tile[0][i];
            bottom[i] = tile[tile.length - 1][i];
            left[i] = tile[i][0];
            right[i] = tile[i][tile.length - 1];
        }
        return Arrays.asList(top, bottom, left, right);
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());

    }

}
