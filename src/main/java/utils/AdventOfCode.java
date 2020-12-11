package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AdventOfCode {

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

}
