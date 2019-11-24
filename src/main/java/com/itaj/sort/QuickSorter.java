package com.itaj.sort;

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
        int index = from;
        for (int i = from ; i < to -1 ; i++) {
            if (data[i] < last) {
                if (index != i) {
                    int temp = data[index];
                    data[index] = data[i];
                    data[i] = temp;
                    index ++;
                }
            }
        }
        data[to - 1] = data[index];
        data[index] = last;
        quickSort(data, from, index);
        quickSort(data, index + 1, to);
    }
}
