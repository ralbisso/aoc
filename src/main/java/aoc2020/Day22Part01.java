package aoc2020;

import java.util.ArrayList;
import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day22Part01 extends AdventOfCode {

    private static int solve() {
        List<String> list = getData(FileConstants.AOC_2020_22);
        System.out.println(list);
        List<Integer> p1Deck = new ArrayList<>();
        List<Integer> p2Deck = new ArrayList<>();
        boolean p1 = true;
        for (String s : list) {
            if (!"".equals(s)) {
                if (!s.contains("Player")) {
                    if (p1) {
                        p1Deck.add(Integer.parseInt(s));
                    } else {
                        p2Deck.add(Integer.parseInt(s));
                    }
                }
            } else {
                p1 = false;
            }
        }
        System.out.println(p1Deck);
        System.out.println(p2Deck);
        while (!p1Deck.isEmpty() && !p2Deck.isEmpty()) {
            int cardP1 = p1Deck.remove(0);
            int cardP2 = p2Deck.remove(0);
            if (cardP1 > cardP2) {
                p1Deck.add(cardP1);
                p1Deck.add(cardP2);
            } else if (cardP2 > cardP1) {
                p2Deck.add(cardP2);
                p2Deck.add(cardP1);
            } else {
                System.out.println("Bataille lol !");
            }
        }
        int score = 0;
        if (!p1Deck.isEmpty()) {
            int size = p1Deck.size();
            for (int i = size - 1; i >= 0; i--) {
                int card = size - i;
                score += p1Deck.get(i) * card;
            }
        } else {
            int size = p2Deck.size();
            for (int i = size - 1; i >= 0; i--) {
                int card = size - i;
                score += p2Deck.get(i) * card;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }

}
