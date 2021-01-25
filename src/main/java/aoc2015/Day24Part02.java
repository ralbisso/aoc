package aoc2015;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import utils.AdventOfCode;
import utils.FileConstants;

public class Day24Part02 extends AdventOfCode {

    public static int solve() {
        List<Integer> packages = getIntData(FileConstants.AOC_2015_24);
        System.out.println(packages.stream().reduce(0, (a, b) -> a + b));
        // 508
        List<int[]> groups = new ArrayList<>();
        for (int i = 0; i < packages.size(); i++) {
            int p1 = packages.get(i);
            for (int j = i + 1; j < packages.size(); j++) {
                int p2 = packages.get(j);
                for (int k = j + 1; k < packages.size(); k++) {
                    int p3 = packages.get(k);
                    for (int l = k + 1; l < packages.size(); l++) {
                        int p4 = packages.get(l);
                        for (int m = l + 1; m < packages.size(); m++) {
                            int p5 = packages.get(m);
                            for (int n = m + 1; n < packages.size(); n++) {
                                int p6 = packages.get(n);
                                if (p1 + p2 + p3 + p4 + p5 + p6 == 508) {
                                    int[] g6 = { p1, p2, p3, p4, p5, p6 };
                                    groups.add(g6);
                                    break;
                                }
                                for (int o = n + 1; o < packages.size(); o++) {
                                    int p7 = packages.get(o);
                                    if (p1 + p2 + p3 + p4 + p5 + p6 + p7 > 508) {
                                        break;
                                    }
                                    for (int p = o + 1; p < packages.size(); p++) {
                                        int p8 = packages.get(p);
                                        if (p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8 == 508) {
                                            int[] g8 = { p1, p2, p3, p4, p5, p6, p7, p8 };
                                            groups.add(g8);
                                            break;
                                        }
                                        for (int q = p + 1; q < packages.size(); q++) {
                                            int p9 = packages.get(q);
                                            if (p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8 + p9 > 508) {
                                                break;
                                            }
                                            for (int r = q + 1; r < packages.size(); r++) {
                                                int p10 = packages.get(r);
                                                int sum10 = p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8
                                                        + p9 + p10;
                                                if (sum10 >= 508) {
                                                    if (sum10 == 508) {
                                                        int[] g10 = { p1, p2, p3, p4, p5, p6, p7,
                                                                p8, p9, p10 };
                                                        groups.add(g10);
                                                        break;
                                                    }
                                                    break;
                                                }
                                                for (int s = r + 1; s < packages.size(); s++) {
                                                    int p11 = packages.get(s);
                                                    if (p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8 + p9
                                                            + p10 + p11 > 508) {
                                                        break;
                                                    }
                                                    for (int t = s + 1; t < packages.size(); t++) {
                                                        int p12 = packages.get(t);
                                                        int sum12 = p1 + p2 + p3 + p4 + p5 + p6 + p7
                                                                + p8 + p9 + p10 + p11 + p12;
                                                        if (sum12 >= 508) {
                                                            if (sum12 == 508) {
                                                                int[] g12 = { p1, p2, p3, p4, p5,
                                                                        p6, p7, p8, p9, p10, p11,
                                                                        p12 };
                                                                groups.add(g12);
                                                            }
                                                            break;
                                                        }
                                                        for (int u = t + 1; u < packages
                                                                .size(); u++) {
                                                            int p13 = packages.get(u);
                                                            if (p1 + p2 + p3 + p4 + p5 + p6 + p7
                                                                    + p8 + p9 + p10 + p11 + p12
                                                                    + p13 >= 508) {
                                                                break;
                                                            }
                                                            for (int v = u + 1; v < packages
                                                                    .size(); v++) {
                                                                int p14 = packages.get(v);
                                                                int sum14 = p1 + p2 + p3 + p4 + p5
                                                                        + p6 + p7 + p8 + p9 + p10
                                                                        + p11 + p12 + p13 + p14;
                                                                if (sum14 >= 508) {
                                                                    if (sum14 == 508) {
                                                                        int[] g14 = { p1, p2, p3,
                                                                                p4, p5, p6, p7, p8,
                                                                                p9, p10, p11, p12,
                                                                                p13, p14 };
                                                                        groups.add(g14);
                                                                    }
                                                                    break;
                                                                }
                                                                for (int w = v + 1; w < packages
                                                                        .size(); w++) {
                                                                    int p15 = packages.get(w);
                                                                    if (p1 + p2 + p3 + p4 + p5 + p6
                                                                            + p7 + p8 + p9 + p10
                                                                            + p11 + p12 + p13 + p14
                                                                            + p15 >= 508) {
                                                                        break;
                                                                    }
                                                                    for (int x = w + 1; x < packages
                                                                            .size(); x++) {
                                                                        int p16 = packages.get(x);
                                                                        int sum16 = p1 + p2 + p3
                                                                                + p4 + p5 + p6 + p7
                                                                                + p8 + p9 + p10
                                                                                + p11 + p12 + p13
                                                                                + p14 + p15 + p16;
                                                                        if (sum16 >= 508) {
                                                                            if (sum16 == 508) {
                                                                                int[] g16 = { p1,
                                                                                        p2, p3, p4,
                                                                                        p5, p6, p7,
                                                                                        p8, p9, p10,
                                                                                        p11, p12,
                                                                                        p13, p14,
                                                                                        p15, p16 };
                                                                                groups.add(g16);
                                                                            }
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(groups.size());
        BigInteger min = null;
        for (int i = 0; i < groups.size(); i++) {
            int[] g1 = groups.get(i);
            if (g1.length == 6) {
                for (int j = i + 1; j < groups.size(); j++) {
                    int[] g2 = groups.get(j);
                    if (!hasCommonElements(g1, g2)) {
                        for (int k = j + 1; k < groups.size(); k++) {
                            int[] g3 = groups.get(k);
                            if (!hasCommonElements(g1, g3) && !hasCommonElements(g2, g3)) {
                                for (int l = k + 1; l < groups.size(); l++) {
                                    int[] g4 = groups.get(l);
                                    if (!hasCommonElements(g1, g4) && !hasCommonElements(g2, g4)
                                            && !hasCommonElements(g3, g4)) {
                                        BigInteger quantum = getQuantumEntanglement(g1);
                                        if (min == null) {
                                            min = quantum;
                                            System.out.println(quantum);
                                        } else if (quantum.compareTo(min) < 0) {
                                            min = quantum;
                                            System.out.println(quantum);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    private static boolean hasCommonElements(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static BigInteger getQuantumEntanglement(int[] arr) {
        BigInteger quantum = BigInteger.ONE;
        for (int i = 0; i < arr.length; i++) {
            quantum = quantum.multiply(BigInteger.valueOf(arr[i]));
        }
        return quantum;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
