package com.itaj.matrixMultiplication;


import com.google.common.base.Preconditions;

public class SimpleMatrixMultiplication implements MatrixMultiplication {

    @Override
    public int[][] multiplication(int[][] a, int[][] b) {
        Preconditions.checkArgument(a[0].length == b.length, "输入矩阵有误");
        int[][] result = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < a[0].length; k++) {
                    sum += a[i][k] * b[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
}
