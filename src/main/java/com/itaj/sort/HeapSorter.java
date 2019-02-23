package com.itaj.sort;

public class HeapSorter implements Sorter {

    @Override
    public int[] sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int value = data[i];
            int j = i;
            while (true) {
                int parent = (j - 1) >> 1;
                if (j > 0 && value > data[parent]) {
                    data[j] = data[parent];
                    j = parent;
                } else {
                    data[j] = value;
                    break;
                }
            }
        }
        for (int i = data.length - 1; i >= 0; i--) {
            int temp = data[i];
            data[i] = data[0];
            data[0] = temp;
            int j = 0;
            while (true) {
                int l = j * 2 + 1;
                int r = l + 1;
                if (l >= i) {
                    break;
                } else if (r >= i || data[l] >= data[r]) {
                    temp = data[j];
                    data[j] = data[l];
                    data[l] = temp;
                    j = l;
                } else {
                    temp = data[j];
                    data[j] = data[r];
                    data[r] = temp;
                    j = r;
                }
            }
        }
        return data;
    }
}
