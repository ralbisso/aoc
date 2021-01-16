package aoc2015;

public class Day04Part02 {

    public static int solve() {
        return Day04Part01.getLowestStartingWith("yzbqklnj", "000000");
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
