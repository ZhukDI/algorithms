package com.zhukdi.algorithms.task_1.sort;

public class HybridSort {

    private static int number = 154;

    public static void hybridSort(int[] arr, int start, int end) {
        if ( end - start < number) {
            insertionSort(arr, start, end);
        } else {
            if (start < end) {
                int part = QuickSort.partition(arr, start, end);
                hybridSort(arr, start, part - 1);
                hybridSort(arr, part + 1, end);
            }
        }
    }

    private static void insertionSort(int[] arr, int start, int end) {
//        System.out.println("In sort is work");
        for (int i = start; i <= end; i++) {
            int tmp = arr[i];
            for (int j = i - 1; j >= 0 && tmp < arr[j] ; j-- ) {
                arr[j+1] = arr[j];
                arr[j] = tmp ;
            }
        }
    }

}
