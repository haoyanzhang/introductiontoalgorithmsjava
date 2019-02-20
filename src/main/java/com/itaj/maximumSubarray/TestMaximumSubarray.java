package com.itaj.maximumSubarray;

import com.itaj.common.Printer;
import com.itaj.common.RandomGenerator;
import com.itaj.common.Tester;

public class TestMaximumSubarray {

    public static void main(String[] args) {
        int[] array = RandomGenerator.generateIntArray(100000);
        Printer.print(array);

        Tester.<MaximumSubarray, Integer>create(maximumSubarray -> maximumSubarray.maximumSubarray(array.clone()))
                .andThen(Printer::print)
                .test(new MergeMaximumSubarray());
    }
}
