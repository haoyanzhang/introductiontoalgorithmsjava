package com.itaj.sort;

import com.itaj.common.Arrays;

public class QuickSorter implements Sorter {

    @Override
    public int[] sort(int[] data) {
        quickSort(data, 0, data.length);
        return data;
    }

    private void quickSort(int[] data, int from, int to) {
        if (to - from <= 1) {
            return;
        }
        int last = data[to - 1];
        int i = from - 1;
        for (int j = from; j <= to - 2; j++) {
            if (data[j] < last) {
                i++;
                Arrays.swap(data, i, j);
            }
        }
        i++;
        Arrays.swap(data, to - 1, i);
        quickSort(data, from, i);
        quickSort(data, i + 1, to);
    }
}
