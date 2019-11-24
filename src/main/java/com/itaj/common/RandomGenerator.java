package com.itaj.common;

import java.util.Random;

public class RandomGenerator {

    private static Random random = new Random();

    public static int generateInt(int bound) {
        return random.nextInt(bound);
    }

    public static int[] generatePositiveIntArray(int length){
        return random.ints(length, 0,length*10).toArray();
    }

    public static int[] generateIntArray(int length){
        return random.ints(length, -length*10,length*10).toArray();
    }

    public static int[][] generateIntMatrix(int row, int column){
        int[][] value = new int[row][];
        int num = row * column;
        for (int i=0; i< row; i++) {
            value[i] = random.ints(column, -num * 10, num * 10).toArray();
        }
        return value;
    }
}
