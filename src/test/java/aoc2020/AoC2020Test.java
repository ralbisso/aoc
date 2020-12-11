package aoc2020;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AoC2020Test {

    @Test
    public void day01Part01Test() {
        assertEquals(987339, Day01Part01.solve());
    }

    @Test
    public void day01Part02Test() {
        assertEquals(259521570, Day01Part02.solve());
    }

    @Test
    public void day02Part01Test() {
        assertEquals(439, Day02Part01.solve());
    }

    @Test
    public void day02Part02Test() {
        assertEquals(584, Day02Part02.solve());
    }

    @Test
    public void day03Part01Test() {
        assertEquals(171, Day03Part01.solve());
    }

    @Test
    public void day03Part02Test() {
        assertEquals(1206576000, Day03Part02.solve());
    }
}
