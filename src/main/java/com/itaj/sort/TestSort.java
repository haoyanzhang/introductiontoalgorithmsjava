package com.itaj.sort;

import com.itaj.common.Printer;
import com.itaj.common.RandomGenerator;
import com.itaj.common.Tester;
import com.itaj.common.TimeMonitor;

public class TestSort {

    public static void main(String[] args) {
        int[] array = RandomGenerator.generatePositiveIntArray(100000);
        Printer.print(array);

        Tester.<Sorter, int[]>create(sorter -> sorter.sort(array.clone()))
                .andThen(Printer::print)
                .test(new InsertionSorter())
                .test(new MergeSorter())
                .test(new HeapSorter());

    }
}
