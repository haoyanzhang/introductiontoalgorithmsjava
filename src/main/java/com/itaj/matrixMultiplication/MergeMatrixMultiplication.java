package com.itaj.matrixMultiplication;

import com.google.common.base.Preconditions;

public class MergeMatrixMultiplication implements MatrixMultiplication {

    @Override
    public int[][] multiplication(int[][] a, int[][] b) {
        Preconditions.checkArgument(a[0].length == b.length, "输入矩阵有误");

        return new int[0][];
    }

    private  void mergeMatrixMultiplication(int square, int[][] a, int ax, int ay,  int[][] b, int bx, int by, int[][] result , int rx, int ry, int[][] additionSpace) {
        int mid = (square + 1) >> 1;

    }

    private int get(int square, int[][] data, int x, int y, int tx, int ty) {

    }
}
