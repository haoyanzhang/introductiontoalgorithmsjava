package com.itaj.matrixMultiplication;

import com.google.common.base.Preconditions;

public class MergeMatrixMultiplication implements MatrixMultiplication {

    @Override
    public int[][] multiplication(int[][] a, int[][] b) {
        Preconditions.checkArgument(a[0].length == b.length, "输入矩阵有误");

        return new int[0][];
    }
}
