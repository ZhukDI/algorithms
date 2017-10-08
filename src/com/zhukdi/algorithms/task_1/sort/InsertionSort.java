package com.zhukdi.algorithms.task_1.sort;

public class InsertionSort {

    public static void insertionSort(int[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            int tmp = arr[i];
//            for (int j = i - 1; j >= 0 && tmp < arr[j] ; j-- ) {
//                arr[j+1] = arr[j];
//                arr[j] = tmp ;
//            }
//        }
        int current, j;

        for (int i = 1; i < arr.length; ++i) {
            current = arr[i];
            j = i - 1;

            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                --j;
            }

            arr[j + 1] = current;
        }
    }

}
