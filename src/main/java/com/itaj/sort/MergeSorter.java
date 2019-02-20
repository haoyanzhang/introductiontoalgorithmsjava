package com.itaj.sort;

public class MergeSorter implements Sorter {

    public int[] sort(int[] data) {
        mergeSort(data, 0 ,data.length, new int[data.length]);
        return data;
    }

    private void mergeSort(int[] data, int start, int end, int[] additionSpace) {
        if (end - start <= 1) {
            return;
        }
        int mid = ((end - start)>>1) + start;
        mergeSort(data, start, mid, additionSpace);
        mergeSort(data, mid, end, additionSpace);
        System.arraycopy(data, start, additionSpace, start, end -start);
        int i = start;
        int j = mid;
        int pos = start;
        while (i < mid && j < end) {
            if (additionSpace[i] < additionSpace[j]) {
                data[pos] = additionSpace[i];
                i++;
            } else {
                data[pos] = additionSpace[j];
                j++;
            }
            pos++;
        }
        while (i<mid){
            data[pos] = additionSpace[i];
            pos++;
            i++;
        }
        while (j < end){
            data[pos] = additionSpace[j];
            pos++;
            j++;
        }
    }
}
