package aoc2020;

public class Day25Part01 {

    public static long solve() {
        int cardPublicKey = 9717666;
        int doorPublicKey = 20089533;
        int cardSecretLoop = getSecretLoop(7, cardPublicKey);
        return getEncryptionKey(cardSecretLoop, doorPublicKey);
    }

    private static int getSecretLoop(int subject, int publicKey) {
        int value = 1;
        int loop = 0;
        while (value != publicKey) {
            loop++;
            value *= subject;
            value %= 20201227;
            if (value == publicKey) {
                break;
            }
        }
        return loop;
    }

    private static long getEncryptionKey(int secretLoop, int publicKey) {
        long value = 1L;
        for (int i = 0; i < secretLoop; i++) {
            value *= publicKey;
            value %= 20201227;
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve());
    }
}
