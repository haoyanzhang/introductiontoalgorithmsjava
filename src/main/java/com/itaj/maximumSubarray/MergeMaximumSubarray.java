package com.itaj.maximumSubarray;

import com.itaj.common.Math;

public class MergeMaximumSubarray implements MaximumSubarray {

    public int maximumSubarray(int[] array) {
        return mergeMaximumSubarray(array, 0, array.length);
    }

    private int mergeMaximumSubarray(int[] array, int start, int end) {
        if (end - start == 1) {
            return array[start];
        } else if (start == end) {
            return 0;
        } else {
            int mid = ((end - start)>>1) + start;
            int maxToMid = 0;
            int maxFromMid = 0;
            int sum = 0;
            for (int i = mid-1; i>=start; i--) {
                sum += array[i];
                if (sum > maxToMid) {
                    maxToMid = sum;
                }
            }
            sum = 0;
            for (int i = mid; i<end; i++) {
                sum += array[i];
                if (sum > maxFromMid) {
                    maxFromMid = sum;
                }
            }
            return Math.max(mergeMaximumSubarray(array, start, mid), mergeMaximumSubarray(array, mid, end), maxToMid + maxFromMid);
        }
    }
}
