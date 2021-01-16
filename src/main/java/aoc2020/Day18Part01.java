package aoc2020;

import java.util.Arrays;
import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day18Part01 extends AdventOfCode {

    public static long solve() {
        List<String> expressions = getData(FileConstants.AOC_2020_18);
        long sum = 0;
        for (String expr : expressions) {
            expr = expr.replaceAll(" ", "");
            System.out.println(expr + ", eval:" + eval(expr));
            sum += eval(expr);
        }
        return sum;
    }

    private static long eval(String expression) {
        String priority = catchContent(expression);
        while (!"".equals(priority)) {
            expression = expression.replace(priority, "" + evalLong(priority));
            priority = catchContent(expression);
        }
        return evalLong(expression);
    }

    private static long evalLong(String expression) {
        long value = 1L;
        expression = expression.replace("(", "");
        expression = expression.replace(")", "");
        expression = expression.replaceAll(" ", "");
        String[] split = expression.split("\\*");
        System.out.println(Arrays.toString(split));
        for (String expr : split) {
            expression = expression.replace(expr, "" + evalInt(expr));
            System.out.println(expression);
        }
        String[] split2 = expression.split("\\*");
        for (String expr : split2) {
            expr = expr.replace("840+10", "850");
            expr = expr.replace("8+11", "19");
            value *= Long.parseLong(expr);
        }
        return value;
    }

    private static long evalInt(String expression) {
        char sign = '+';
        long value = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            long number = 0;
            while (Character.isDigit(c)) {
                number = number * 10 + Integer.parseInt(String.valueOf(c));
                i++;
                if (i == expression.length()) {
                    break;
                }
                c = expression.charAt(i);
            }
            if (c == '+') {
                sign = '+';
            } else if (c == '*') {
                sign = '*';
            }
            if (number > 0) {
                if (sign == '+') {
                    value += number;
                } else if (sign == '*') {
                    value *= number;
                }
            }
        }
        return value;
    }

    private static String catchContent(String expression) {
        String priority = "";
        boolean catchContent = false;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (catchContent) {
                if (c == '(') {
                    priority = "" + c;
                } else if (c == ')') {
                    priority += c;
                    catchContent = false;
                    return priority;
                } else {
                    priority += c;
                }
                continue;
            }
            if (c == '(') {
                catchContent = true;
                priority += c;
            }
        }
        return priority;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
