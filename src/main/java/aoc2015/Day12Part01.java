package aoc2015;

import org.json.JSONArray;
import org.json.JSONObject;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day12Part01 extends AdventOfCode {

    public static int solve() {
        String string = getLine(FileConstants.AOC_2015_12);
        JSONArray json = new JSONArray(string);
        return getArrayValue(json);
    }

    private static int getArrayValue(JSONArray array) {
        int value = 0;
        for (int i = 0; i < array.length(); i++) {
            Object element = array.get(i);
            if (element instanceof JSONArray) {
                value += getArrayValue((JSONArray) element);
            } else if (element instanceof JSONObject) {
                value += getObjectValue((JSONObject) element);
            } else if (element instanceof Integer) {
                value += (Integer) element;
            }
        }
        return value;
    }

    private static int getObjectValue(JSONObject object) {
        int value = 0;
        for (int i = 0; i < object.names().length(); i++) {
            Object element = object.get(object.names().getString(i));
            if (element instanceof JSONArray) {
                value += getArrayValue((JSONArray) element);
            } else if (element instanceof JSONObject) {
                value += getObjectValue((JSONObject) element);
            } else if (element instanceof Integer) {
                value += (Integer) element;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
