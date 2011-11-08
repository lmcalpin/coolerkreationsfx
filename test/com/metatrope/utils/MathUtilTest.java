package com.metatrope.utils;

import org.junit.Assert;
import org.junit.Test;

public class MathUtilTest {
    /**
     * It's theoretically possible that the random number generator might not return every single number in range
     * for the duration of the test, but this "test" is intended to protect us only from the stupidest of errors 
     * and an occasional false flag every couple dozen centuries or so is probably acceptable.
     */
    @Test
    public void testRandomIntEventuallyReturnsAllNumbersInRange() {
        allNumbersReturnedEventually(5, 15);
    }
    
    @Test
    public void testRandomIntAlwaysReturnsTheSameNumber() {
        for (int i = 0; i < 1000; i++) {
            Assert.assertEquals(i, MathUtil.randomInt(i, i));
        }
    }
    
    private void allNumbersReturnedEventually(int lowerLimit, int higherLimit) {
        int range = higherLimit - lowerLimit + 1;
        int numberOfTests = range * 1000; // totally unscientific
        boolean[] found = new boolean[range];
        for (int i = 0; i < 100; i++) {
            int returned = MathUtil.randomInt(lowerLimit, higherLimit);
            found[returned - lowerLimit] = true;
        }
        for (int i = 0; i < range; i++) {
            Assert.assertTrue("random number returned " + (lowerLimit+i), found[i]);
        }
    }
}
