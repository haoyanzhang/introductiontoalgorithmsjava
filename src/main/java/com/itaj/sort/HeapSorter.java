package com.itaj.sort;

import com.itaj.heap.Heaps;

public class HeapSorter implements Sorter {

    @Override
    public int[] sort(int[] data) {
        Heaps.makeHeap(data);
        int[] result = new int[data.length];
        for (int i = 0 ;i < data.length; i++) {
            result[data.length - i - 1] = Heaps.removeFirst(data, data.length - i);
        }
        return result;
    }
}
