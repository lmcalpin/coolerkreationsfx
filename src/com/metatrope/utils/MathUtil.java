package com.metatrope.utils;

import java.util.Random;

public class MathUtil {
    private static Random generator = new Random();
    public static int randomInt(int lower, int higher) {
        if (lower > higher)
            throw new IllegalArgumentException(lower + " should be less than or equal to " + higher);
        int range = higher - lower + 1;
        int val = generator.nextInt(range) + lower;
        return val;
    }
}
