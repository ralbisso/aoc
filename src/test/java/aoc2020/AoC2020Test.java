package aoc2020;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
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

    @Test
    public void day04Part01Test() {
        assertEquals(254, Day04Part01.solve());
    }

    @Test
    public void day04Part02Test() {
        assertEquals(184, Day04Part02.solve());
    }

    @Test
    public void day05Part01Test() {
        assertEquals(816, Day05Part01.solve());
    }

    @Test
    public void day05Part02Test() {
        assertEquals(539, Day05Part02.solve());
    }

    @Test
    public void day06Part01Test() {
        assertEquals(6686, Day06Part01.solve());
    }

    @Test
    public void day06Part02Test() {
        assertEquals(3476, Day06Part02.solve());
    }

    @Test
    public void day07Part01Test() {
        assertEquals(119, Day07Part01.solve());
    }

    @Test
    public void day07Part02Test() {
        assertEquals(155802, Day07Part02.solve());
    }

    @Test
    public void day08Part01Test() {
        assertEquals(1420, Day08Part01.solve());
    }

    @Test
    public void day08Part02Test() {
        assertEquals(1245, Day08Part02.solve());
    }

    @Test
    public void day09Part01Test() {
        assertEquals(25918798, Day09Part01.solve());
    }

    @Test
    public void day09Part02Test() {
        assertEquals(3340942, Day09Part02.solve());
    }

    @Test
    public void day10Part01Test() {
        assertEquals(2812, Day10Part01.solve());
    }

    @Test
    @Ignore
    public void day10Part02Test() {
        // Too slow (~5 sec.), needs optimization
        assertEquals(386869246296064L, Day10Part02.solve());
    }
}
