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

    @Test
    public void day03Part01Test() {
        assertEquals(2565, Day03Part01.solve());
    }

    @Test
    public void day03Part02Test() {
        assertEquals(2639, Day03Part02.solve());
    }

    @Test
    public void day04Part01Test() {
        assertEquals(282749, Day04Part01.solve());
    }

    @Test
    public void day04Part02Test() {
        assertEquals(9962624, Day04Part02.solve());
    }

    @Test
    public void day05Part01Test() {
        assertEquals(238, Day05Part01.solve());
    }

    @Test
    public void day05Part02Test() {
        assertEquals(69, Day05Part02.solve());
    }
}
