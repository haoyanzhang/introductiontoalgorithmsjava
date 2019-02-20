package com.itaj.common;

public class Math {

    public static int max(int... array) {
        int max = -2147483648;
        for (int i : array) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
