package com.zhukdi.algorithms.task_2.search;

public class InterpolationSearch {
    public static int interpolationSearch(int[] arr, int start, int end, int value, int depth) {
        if (arr[start] == value) {
//            return start;
            System.out.println("IS Position: " + start);
            return depth;
        } else if (!(arr[start]<=value && arr[end]>=value)) {
//            return -1;
            System.out.println("IS -1");
            return depth;
        }
//        int pos = start + ((end - start) / (arr[end] - arr[start])) * (value - arr[start]);
        int pos = start + (int)(((double)(end - start) / (arr[end] - arr[start])) * (value - arr[start]));
        if (arr[pos] == value) {
            //found
//            return pos;
            System.out.println("IS Position: " + pos);
            return depth;
        } else if (arr[pos] < value) {
            //continue in the right part of the arr
            depth++;
            return interpolationSearch(arr, pos + 1, end, value, depth);
        } else {
            //continue in the left part of the arr
            depth++;
            return interpolationSearch(arr,  start, pos - 1, value, depth);
        }
    }
}
