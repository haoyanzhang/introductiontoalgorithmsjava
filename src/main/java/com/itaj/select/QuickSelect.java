package com.itaj.select;

import com.itaj.common.Arrays;

public class QuickSelect implements Select {

    @Override
    public int select(int[] array, int i) {
        return quickSelect(array, 0 ,array.length, i);
    }

    private int quickSelect(int[] array,int from, int to, int i) {
        if (i == 1) {
            return array[from];
        }
        int last = array[to-1];
        int pos = from - 1;
        for (int j = from ; j < to - 1; j++) {
            if (array[j] < last) {
                pos++;
                Arrays.swap(array, pos, j);
            }
        }
        pos++;
        Arrays.swap(array, pos, to - 1);
        if (pos - from >= i) {
            return quickSelect(array, from, pos, i);
        } else if (pos + 1 - from == i) {
            return array[pos];
        } else {
            return quickSelect(array, pos + 1, to, i - pos - 1 + from);
        }
    }
}
