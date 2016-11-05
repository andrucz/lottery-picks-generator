package com.andrucz.lottery;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public final class PickGenerator {

	private PickGenerator() {
	}
	
	private static Random random;

    private static Random acquireRandom() {
        if (random == null) {
            random = new Random();
        }
        return random;
    }
	
	public static Set<Integer> generatePick(int count, int min, int max) {
		if (count <= 0) {
            throw new IllegalArgumentException("count must be a non-zero positive number");
        }

        if (min > max) {
            throw new IllegalArgumentException("min greater than max");
        }

        if (count > (1 + max - min)) {
            throw new IllegalArgumentException("count greater than number range");
        }

        int range = max - min + 1;

        Set<Integer> result = new TreeSet<Integer>();
        Random r = acquireRandom();
        
        while (result.size() < count) {
            int b = min + r.nextInt(range);
            result.add(Integer.valueOf(b));
        }
        
        return result;
	}
	
}
