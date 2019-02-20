package com.itaj.common;



public class Printer {

    public static <T> void print(T data) {
        System.out.println(data);
    }

    public static void print(int[] data) {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < data.length; i++) {
            stringBuilder.append(data[i]);
            if (i != data.length-1) {
                stringBuilder.append(",");
            }
            if (i == 20 && data.length > 60) {
                stringBuilder.append("......");
                i = data.length - 30;
            }
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
    }

    public static void print(int[][] data) {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < data.length; i++) {
            stringBuilder.append("[");
            for (int j = 0; j < data[i].length; j++) {
                stringBuilder.append(data[i][j]);
                if (j != data[i].length-1) {
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append("]");
            if (i != data.length-1) {
                stringBuilder.append("\n");
            }
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
    }
}
