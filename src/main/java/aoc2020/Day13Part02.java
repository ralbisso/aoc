package aoc2020;

import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day13Part02 extends AdventOfCode {

    public static long solve() {
        List<String> notes = getData(FileConstants.AOC_2020_13);

        // Chinese remainders theorem
        int[] modulo = new int[9];
        int[] remainders = new int[9];
        fillModuloAndRemainders(notes.get(1), modulo, remainders);
        long n = getN(modulo);
        long[] ni = getNI(n, modulo);
        long x = getX(n, modulo, remainders, ni);
        return n - x;
    }

    private static void fillModuloAndRemainders(String buses, int[] modulo, int[] remainders) {
        String[] split = buses.split(",");
        int index = 0;
        for (int i = 0; i < split.length; i++) {
            if (!split[i].equals("x")) {
                modulo[index] = Integer.parseInt(split[i]);
                remainders[index] = i;
                index++;
            }
        }
    }

    private static long getN(int[] modulo) {
        long n = 1L;
        for (int i = 0; i < modulo.length; i++) {
            n *= modulo[i];
        }
        return n;
    }

    private static long[] getNI(long n, int[] modulo) {
        long[] ni = new long[modulo.length];
        for (int i = 0; i < modulo.length; i++) {
            ni[i] = n / modulo[i];
        }
        return ni;
    }

    private static long getX(long n, int[] modulo, int[] remainders, long[] ni) {
        long x = 0L;
        for (int i = 0; i < modulo.length; i++) {
            x += ni[i] * remainders[i] * getInverse(ni[i], modulo[i]);
        }
        return x %= n;
    }

    private static long getInverse(long a, long b) {
        long m = b, t = 0, q = 0;
        long x = 0, y = 1;
        if (b == 1) {
            return 0;
        }
        while (a > 1) {
            q = a / b;
            t = b;
            b = a % b;
            a = t;
            t = x;
            x = y - q * x;
            y = t;
        }
        if (y < 0) {
            y += m;
        }
        return y;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
