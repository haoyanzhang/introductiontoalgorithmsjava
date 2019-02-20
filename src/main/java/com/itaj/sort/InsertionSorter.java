package com.itaj.sort;

public class InsertionSorter implements Sorter {

    public int[] sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < i; j++) {
                if (data[j] > data[i]) {
                    int temp = data[i];
                    System.arraycopy(data, j, data, j + 1, i - j);
                    data[j] = temp;
                    break;
                }
            }
        }
        return data;
    }
}
