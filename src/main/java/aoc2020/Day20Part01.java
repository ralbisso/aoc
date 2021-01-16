package aoc2020;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day20Part01 extends AdventOfCode {

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
        Map<Integer, List<char[]>> borders = new TreeMap<>();
        for (Entry<Integer, char[][]> e : tiles.entrySet()) {
            borders.put(e.getKey(), getEdges(e.getValue()));
        }
        long product = 1L;
        for (Entry<Integer, List<char[]>> t1 : borders.entrySet()) {
            List<char[]> edgesT1 = t1.getValue();
            int neighbours = 0;
            for (Entry<Integer, List<char[]>> t2 : borders.entrySet()) {
                if (t1.getKey() != t2.getKey()) {
                    List<char[]> edgesT2 = t2.getValue();
                    loop: for (char[] edgeT1 : edgesT1) {
                        for (char[] edgeT2 : edgesT2) {
                            char[] reverseEdgeT2 = reverseEdge(edgeT2);
                            if (Arrays.equals(edgeT1, edgeT2)
                                    || Arrays.equals(edgeT1, reverseEdgeT2)) {
                                neighbours++;
                                break loop;
                            }
                        }
                    }
                }
            }
            if (neighbours == 2) {
                System.out.println(t1.getKey() + " has " + neighbours);
                product *= t1.getKey();
            }
        }

        return product;
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
