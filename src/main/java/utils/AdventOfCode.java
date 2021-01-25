package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AdventOfCode {

    protected static String getLine(String input) {
        String line = "";
        try (BufferedReader br = Files.newBufferedReader(Paths.get(input))) {
            line = br.readLine();
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return line;
    }

    protected static List<String> getData(String input) {
        List<String> data = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(input))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return data;
    }

    protected static List<Integer> getIntData(String input) {
        List<Integer> data = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(input))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return data;
    }

    protected static List<Long> getLongData(String input) {
        List<Long> data = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(input))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(Long.parseLong(line));
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return data;
    }

    protected static char[][] getMatrixData(String input) {
        List<String> list = getData(input);
        char[][] matrix = new char[list.size()][list.size()];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = list.get(i).charAt(j);
            }
        }
        return matrix;
    }
}
