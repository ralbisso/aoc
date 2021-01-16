package aoc2015;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AoC2015Test {

    @Test
    public void day01Part01Test() {
        assertEquals(138, Day01Part01.solve());
    }

    @Test
    public void day01Part02Test() {
        assertEquals(1771, Day01Part02.solve());
    }

    @Test
    public void day02Part01Test() {
        assertEquals(1588178, Day02Part01.solve());
    }

    @Test
    public void day02Part02Test() {
        assertEquals(3783758, Day02Part02.solve());
    }
}
