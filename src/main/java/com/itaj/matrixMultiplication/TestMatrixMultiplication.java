package com.itaj.matrixMultiplication;

import com.itaj.common.Printer;
import com.itaj.common.RandomGenerator;
import com.itaj.common.Tester;

public class TestMatrixMultiplication {

    public static void main(String[] args) {
        int[][] a = RandomGenerator.generateIntMatrix(7, 8);
        int[][] b = RandomGenerator.generateIntMatrix(8, 15);
        Printer.print(a);
        Printer.print(b);

        Tester.<MatrixMultiplication, int[][]>create(matrixMultiplication -> matrixMultiplication.multiplication(a, b))
                .andThen(Printer::print)
                .test(new SimpleMatrixMultiplication())
                .test(new MergeMatrixMultiplication());
    }
}
