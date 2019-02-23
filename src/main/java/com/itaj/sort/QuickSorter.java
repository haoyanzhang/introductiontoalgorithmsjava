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
        int mid = data[from];
        int i = from + 1;
        int j = to - 1;
        while (i < j) {
            while (data[i] <= mid && i < j) {
                i++;
            }
            while (data[j] > mid && i < j) {
                j--;
            }
            if (i != j) {
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        if (mid > data[i]) {
            data[from] = data[i];
            data[i] = mid;
        }
        quickSort(data, from, i);
        quickSort(data, i, to);
    }
}
