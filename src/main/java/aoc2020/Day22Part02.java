package aoc2020;

import java.util.ArrayList;
import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day22Part02 extends AdventOfCode {

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
        try {
            game(p1Deck, p2Deck);
        } catch (Exception e) {
            e.printStackTrace();
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

    private static int game(List<Integer> p1Deck, List<Integer> p2Deck) throws Exception {
        int rounds = 0;
        /*
         * List<String> memo = new ArrayList<>(); if (memo.contains(p1Deck + ":" +
         * p2Deck)) { int size = p1Deck.size(); System.out.println(memo.size()); int
         * score = 0; for (int i = size - 1; i >= 0; i--) { int card = size - i; score
         * += p1Deck.get(i) * card; } System.out.println(score);
         * System.out.println("Win game p1"); throw new Exception(); } else {
         * memo.add(p1Deck + ":" + p2Deck); }
         */
        while (!p1Deck.isEmpty() && !p2Deck.isEmpty()) {
            int cardP1 = p1Deck.remove(0);
            int cardP2 = p2Deck.remove(0);
            int winsub = 0;
            if (p1Deck.size() <= cardP1 && p2Deck.size() <= cardP2) {
                winsub = game(new ArrayList<>(p1Deck), new ArrayList<>(p2Deck));
            } else {
                if (cardP1 > cardP2) {
                    p1Deck.add(cardP1);
                    p1Deck.add(cardP2);
                } else if (cardP2 > cardP1) {
                    p2Deck.add(cardP2);
                    p2Deck.add(cardP1);
                }
            }
            if (winsub == 1) {
                p1Deck.add(cardP1);
                p1Deck.add(cardP2);
            } else if (winsub == 2) {
                p2Deck.add(cardP2);
                p2Deck.add(cardP1);
            }
        }
        rounds++;
        if (!p1Deck.isEmpty() || rounds > 1000) {
            System.out.println(rounds);
            return 1;
        } else {
            return 2;
        }
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }

}
