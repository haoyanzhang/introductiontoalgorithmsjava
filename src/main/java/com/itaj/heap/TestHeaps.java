package com.itaj.heap;

import com.itaj.common.Printer;
import com.itaj.common.RandomGenerator;

public class TestHeaps {

    public static void main(String[] args) {

        int[] array = RandomGenerator.generateIntArray(10);
        Printer.print(array);
        Heaps.makeHeap(array);
        Printer.print(array);
        for (int i = 10 ; i > 1; i--) {
            System.out.println(Heaps.removeFirst(array, i));
        }
    }
}
