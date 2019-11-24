package com.itaj.select;

import com.itaj.common.Printer;
import com.itaj.common.RandomGenerator;
import com.itaj.common.Tester;

public class TestSelect {

    public static void main(String[] args) {

        int[] array = RandomGenerator.generatePositiveIntArray(10);
        int i = RandomGenerator.generateInt(10);
        Printer.print(array);
        Printer.print(i);

        Tester.<Select, Integer>create(select -> select.select(array, i))
                .andThen(System.out::println)
                .test(new QuickSelect());
    }
}
