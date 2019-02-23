package com.itaj.matrixMultiplication;

import com.google.common.base.Preconditions;
import com.itaj.common.Math;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class MergeMatrixMultiplication implements MatrixMultiplication {

    @Override
    public int[][] multiplication(int[][] a, int[][] b) {
        Preconditions.checkArgument(a[0].length == b.length, "输入矩阵有误");
        int square = Math.max(a.length, a[0].length);
        return mergeMatrixMultiplication(new SubSquareMatrix(square, a, 0, 0),
                new SubSquareMatrix(square, b, 0, 0))
                .toArray();
    }

    private  ResultMatrix mergeMatrixMultiplication(SubSquareMatrix a, SubSquareMatrix b) {
        int square = a.getSquare();
        if (square == 1) {
            return new RowResultMatrix(new int[][]{new int[]{a.get(0, 0) * b.get(0, 0)}});
        }
        SubSquareMatrix[][] splitA = a.split();
        SubSquareMatrix[][] splitB = b.split();
        return new MergeResultMatrix(add(mergeMatrixMultiplication(splitA[0][0], splitB[0][0]), mergeMatrixMultiplication(splitA[0][1], splitB[1][0])),
                add(mergeMatrixMultiplication(splitA[0][0], splitB[0][1]), mergeMatrixMultiplication(splitA[0][1], splitB[1][1])),
                add(mergeMatrixMultiplication(splitA[1][0], splitB[0][0]), mergeMatrixMultiplication(splitA[1][1], splitB[1][0])),
                add(mergeMatrixMultiplication(splitA[1][0], splitB[0][1]), mergeMatrixMultiplication(splitA[1][1], splitB[1][1])));
}

    private ResultMatrix add(ResultMatrix a, ResultMatrix b) {
        int height = a.height();
        int length = a.length();
        int[][] result = new int[height][length];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                result[i][j] = a.get(i, j) + b.get(i, j);
            }
        }
        return new RowResultMatrix(result);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    private static class SubSquareMatrix {

        private int square;

        private int[][] matrix;

        private int startX;

        private int startY;

        public int get(int x, int y) {
            if (startX + x < matrix.length && startY + y < matrix[0].length) {
                return matrix[startX + x][startY + y];
            }
            return 0;
        }

        public SubSquareMatrix[][] split() {
            int mid = (square + 1) >> 1;
            return new SubSquareMatrix[][]{
                    new SubSquareMatrix[]{
                            new SubSquareMatrix(mid, matrix, startX, startY),
                            new SubSquareMatrix(mid, matrix, startX, startY + mid)
                    },
                    new SubSquareMatrix[]{
                            new SubSquareMatrix(mid, matrix, startX + mid, startY),
                            new SubSquareMatrix(mid, matrix, startX + mid, startY + mid)
                    }
            };
        }



    }

    private interface ResultMatrix {

        int length();

        int height();

        int get(int i, int j);

        int[][] toArray();
    }

    @AllArgsConstructor
    private static class RowResultMatrix implements ResultMatrix {

        private int[][] matrix;

        @Override
        public int length() {
            return matrix[0].length;
        }

        @Override
        public int height() {
            return matrix.length;
        }

        @Override
        public int get(int i, int j) {
            return matrix[i][j];
        }

        @Override
        public int[][] toArray() {
            return matrix;
        }
    }

    private static class MergeResultMatrix implements ResultMatrix{

        MergeResultMatrix(ResultMatrix ... resultMatrices) {
            this.resultMatrices = resultMatrices;
        }

        private ResultMatrix[] resultMatrices;

        @Override
        public int length() {
            return resultMatrices[0].length() + resultMatrices[1].length();
        }

        @Override
        public int height() {
            return resultMatrices[0].height() + resultMatrices[2].height();
        }

        @Override
        public int get(int i, int j) {
            int index = 0;
            if (i >= resultMatrices[0].height()) {
                i -= resultMatrices[0].height();
                index += 2;
            }
            if (j >= resultMatrices[0].length()) {
                j -= resultMatrices[0].length();
                index += 1;
            }
            return resultMatrices[index].get(i, j);
        }

        @Override
        public int[][] toArray() {
            int height = height();
            int length = length();
            int[][] result = new int[height][length];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < length; j++) {
                    result[i][j] = get(i, j);
                }
            }
            return result;
        }
    }

}
