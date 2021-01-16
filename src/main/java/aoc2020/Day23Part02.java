package aoc2020;

import java.util.HashMap;
import java.util.Map;

import utils.Cup;

public class Day23Part02 {

    private static int solve() {
        Map<Integer, Cup> circle = initCircle("219347865");
        circle.get(5).setNext(circle.get(10));
        int number = 11;
        while (number <= 1000000) {
            circle.put(number, new Cup(number));
            circle.get(number - 1).setNext(circle.get(number));
            number++;
        }
        circle.get(1000000).setNext(circle.get(2));
        int move = 1;
        Cup current = circle.get(2);
        while (move <= 10000000) {
            Cup first = current.getNext();
            Cup second = first.getNext();
            Cup third = second.getNext();
            Cup fourth = third.getNext();
            Cup destination = circle.get(current.getValue() - 1);
            if (destination == null) {
                destination = circle.get(1000000);
            } else {
                while (destination.getValue() == first.getValue()
                        || destination.getValue() == second.getValue()
                        || destination.getValue() == third.getValue()) {
                    int value = destination.getValue() - 1;
                    destination = (value > 0) ? circle.get(value) : circle.get(1000000);
                }
            }
            current.setNext(fourth);
            current = current.getNext();
            third.setNext(destination.getNext());
            destination.setNext(first);
            move++;
        }
        Cup one = circle.get(1);
        long v1 = one.getNext().getValue();
        long v2 = one.getNext().getNext().getValue();
        System.out.println("v1: " + v1 + ", v2: " + v2 + ", prod: " + (v1 * v2));
        return 0;
    }

    private static Map<Integer, Cup> initCircle(String input) {
        String[] split = input.split("");
        Map<Integer, Cup> circle = new HashMap<>();
        int value = 0;
        for (int i = 0; i < split.length; i++) {
            value = Integer.parseInt(split[i]);
            circle.put(value, new Cup(value));
            if (i > 0) {
                int previous = Integer.parseInt(split[i - 1]);
                circle.get(previous).setNext(circle.get(value));
            }
        }
        circle.get(value).setNext(circle.get(10));
        int number = 11;
        while (number <= 1000000) {
            circle.put(number, new Cup(number));
            circle.get(number - 1).setNext(circle.get(number));
            number++;
        }
        circle.get(1000000).setNext(circle.get(Integer.parseInt(split[0])));
        return circle;
    }

    public static void main(String args[]) {
        System.out.println("Answer: " + solve());
    }
}
