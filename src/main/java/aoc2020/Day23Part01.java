package aoc2020;

import java.util.HashMap;
import java.util.Map;

import utils.AdventOfCode;
import utils.Cup;

public class Day23Part01 extends AdventOfCode {

    private static int solve() {
        Map<Integer, Cup> circle = initCircle("389125467");
        System.out.println(circle);
        int max = 9;
        int move = 0;
        Cup current = circle.get(3);
        while (move < 10) {
            System.out.println("Move: " + (move + 1));
            System.out.println("Current: " + current);
            Cup first = current.getNext();
            System.out.println("First: " + first);
            Cup second = first.getNext();
            System.out.println("Second: " + second);
            Cup third = second.getNext();
            System.out.println("Third: " + third);
            Cup fourth = third.getNext();
            Cup destination = circle.get(current.getValue() - 1);
            if (destination == null) {
                destination = circle.get(max);
            } else {
                while (destination.getValue() == first.getValue()
                        || destination.getValue() == second.getValue()
                        || destination.getValue() == third.getValue()) {
                    int value = destination.getValue() - 1;
                    destination = (value > 0) ? circle.get(value) : circle.get(max);
                }
            }
            System.out.println("Destination: " + destination);
            System.out.println();
            current.setNext(fourth);
            current = current.getNext();
            third.setNext(destination.getNext());
            destination.setNext(first);
            move++;
        }
        System.out.println(circle);
        int answer = 0;
        Cup nextOne = circle.get(1).getNext();
        System.out.println(nextOne);
        while (nextOne.getValue() != 1) {
            answer = answer * 10 + nextOne.getValue();
            nextOne = nextOne.getNext();
        }
        return answer;
    }

    private static Map<Integer, Cup> initCircle(String input) {
        String[] split = input.split("");
        Map<Integer, Cup> circle = new HashMap<>();
        int first = 0;
        int value = 0;
        for (int i = 0; i < split.length; i++) {
            value = Integer.parseInt(split[i]);
            circle.put(value, new Cup(value));
            if (i > 0) {
                int previous = Integer.parseInt(split[i - 1]);
                circle.get(previous).setNext(circle.get(value));
            } else {
                first = value;
            }
        }
        circle.get(value).setNext(circle.get(first));
        return circle;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
