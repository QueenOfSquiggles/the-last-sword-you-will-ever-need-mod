package com.queen.utils;

import java.util.Random;

import net.minecraft.client.util.math.Vector2f;

/**
 *  A single class to manage the drop rates. For now these variables are static, but I want to make them configurable later on
 * Such that modpack makers or tech savvy users can customize how this mod interacts with the world
 */
public class DropMetrics {

    /**
     * For the vectors:
     *  X = min value
     *  Y = max value
     */

    public static final DropRate END_DRAGON_DROP_RATE = new DropRate(1, 16); // need min of 1 to ensure players always get one. NO MORE COMPLAINTS ABOUT "It doesn't drop!!!!!! D: FIX PLZ" never again :3

    public static int getDrop(Random random, DropRate rate){
        float num = getDropCurve(random.nextFloat()) * (rate.maxF() - rate.minF()) + rate.minF();
        return Math.round(num); // round to nearest int instead of floor.
        // speed isn't a big deal and I want to hit the max a reasonable amount of times.
    }

    private static float getDropCurve(float linear){
        // creates a curve for affecting the random chances
        // linear is a float from 0.0 - 1.0
        // returns a cubic ease-out function, to push the average higher
        // ideally, I want to be able to configure which ease curve is used, or linear for a more pure random.
        return easeOutCubic(linear);
    }

    private static float easeOutCubic(float in){
        // easing curve where the average output (where in = [0.0-1.0]), is 0.75
        // This is a 50% increase from the raw Random:nextFloat.
        return 1.0f - (float)Math.pow(1.0 - in, 3.0);
    }
    public static class DropRate {
        public final int max;
        public final int min;

        public DropRate(int min, int max){
            this.min = min;
            this.max = max;
        }

        public float maxF(){ return (float) max;}
        public float minF(){ return (float) min;}

    }    
}
