package aoc2015;

public class Day25Part01 {

    public static long solve() {
        int[] coordinates = { 1, 1 };
        int row = 1;
        long value = 20151125;
        while (coordinates[0] != 2981 || coordinates[1] != 3075) {
            value = getNext(value);
            if (--coordinates[0] == 0) {
                coordinates[0] = ++row;
                coordinates[1] = 1;
            } else {
                coordinates[1]++;
            }
        }
        return value;
    }

    private static long getNext(long value) {
        return (value * 252533) % 33554393;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
