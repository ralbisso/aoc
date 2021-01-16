package aoc2015;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class Day04Part01 {

    public static int solve() {
        return getLowestStartingWith("yzbqklnj", "00000");
    }

    static int getLowestStartingWith(String secret, String pattern) {
        int lowest = 1;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            String test = secret + lowest;
            byte[] hash = md.digest(test.getBytes());
            while (!Hex.encodeHexString(hash).startsWith(pattern)) {
                lowest++;
                test = secret + lowest;
                hash = md.digest(test.getBytes());
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return lowest;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
