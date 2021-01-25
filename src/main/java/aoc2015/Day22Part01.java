package aoc2015;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Day22Part01 {

    public static int solve() {
        int min = Integer.MAX_VALUE;
        Set<String> set = new TreeSet<>();
        for (int i = 0; i < 10000000; i++) {
            int[] timers = { 0, 0, 0 };
            int mana = 500;
            int spent = 0;
            int playerPoints = 50;
            int bossPoints = 71;
            int damage = 10;
            String spells = "";
            while (playerPoints > 0 && bossPoints > 0) {
                playerPoints--;
                // Player turn
                if (timers[0] >= 0) {
                    timers[0]--;
                }
                if (--timers[1] >= 0) {
                    bossPoints -= 3;
                }
                if (--timers[2] >= 0) {
                    mana += 101;
                }
                String spell = nextRandomSpell(mana, timers);
                if (spell == null) {
                    break;
                }
                spells += spell + " ";
                int cost = 0;
                if ("Magic Missile".equals(spell)) {
                    cost = 53;
                    bossPoints -= 4;
                } else if ("Drain".equals(spell)) {
                    cost = 73;
                    bossPoints -= 2;
                    playerPoints += 2;
                } else if ("Shield".equals(spell)) {
                    cost = 113;
                    timers[0] = 6;
                } else if ("Poison".equals(spell)) {
                    cost = 173;
                    timers[1] = 6;
                } else if ("Recharge".equals(spell)) {
                    cost = 229;
                    timers[2] = 5;
                }
                mana -= cost;
                spent += cost;
                // Boss turn
                int armor = 0;
                if (--timers[0] >= 0) {
                    armor = 7;
                }
                if (--timers[1] >= 0) {
                    bossPoints -= 3;
                }
                if (--timers[2] >= 0) {
                    mana += 101;
                }
                if (bossPoints <= 0) {
                    set.add(spells.trim());
                    if (spent < min) {
                        min = spent;
                        System.out.println("You win with only " + spent + " mana spent");
                    }
                    break;
                }
                playerPoints -= Math.max(damage - armor, 1);
            }
        }
        return min;
    }

    private static String nextRandomSpell(int mana, int[] timers) {
        Random random = new Random();
        List<String> spells = new ArrayList<>();
        if (mana < 53) {
            return null;
        }
        if (mana >= 53) {
            spells.add("Magic Missile");
        }
        if (mana >= 73) {
            spells.add("Drain");
        }
        if (mana >= 113 && timers[0] <= 0) {
            spells.add("Shield");
        }
        if (mana >= 173 && timers[1] <= 0) {
            spells.add("Poison");
        }
        if (mana >= 229 && timers[2] <= 0) {
            spells.add("Recharge");
        }
        return spells.get(random.nextInt(spells.size()));
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}