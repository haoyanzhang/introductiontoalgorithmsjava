package com.itaj.heap;

public class Heaps {

    private static void maxHeapify(int[] array, int length, int index) {
        int value = array[index];
        int curIndex = index;
        while (true) {
            int leftIndex = 2 * curIndex + 1;
            int rightIndex = 2 * curIndex + 2;
            int nextIndex = curIndex;
            if (rightIndex < length) {
                if (array[leftIndex] > array[rightIndex]) {
                    nextIndex = leftIndex;
                } else {
                    nextIndex = rightIndex;
                }
            } else if (leftIndex < length) {
                nextIndex = leftIndex;
            }
            if (nextIndex == curIndex || array[nextIndex] < value) {
                array[curIndex] = value;
                break;
            } else {
                array[curIndex] = array[nextIndex];
                curIndex = nextIndex;
            }
        }
    }

    public static void makeHeap(int[] array) {
        makeHeap(array, array.length);
    }

    public static void makeHeap(int[] array, int length) {
        for (int i = length - 1; i >= 0; i--) {
            maxHeapify(array, length, i);
        }
    }

    public static int removeFirst(int[] array, int length) {
        int result = array[0];
        array[0] = array[length - 1];
        maxHeapify(array, length - 1, 0);
        return result;
    }
}
