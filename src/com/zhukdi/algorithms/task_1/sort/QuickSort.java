package com.zhukdi.algorithms.task_1.sort;

public class QuickSort {

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int part = partition(arr, start, end);
            quickSort(arr, start, part - 1);
            quickSort(arr, part + 1, end);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left+right)/2];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        int tmp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = tmp;

        return i+1;
    }

}
