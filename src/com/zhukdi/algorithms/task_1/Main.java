package com.zhukdi.algorithms.task_1;

import com.zhukdi.algorithms.task_1.sort.HybridSort;
import com.zhukdi.algorithms.task_1.sort.InsertionSort;
import com.zhukdi.algorithms.task_1.sort.QuickSort;

import java.util.Random;

public class Main {

    private static final int LENGTH = 117;
    private static final int RANGE = 100_000;

    public static void main(String[] args) {
//        int[] arr = new int[LENGTH];
//        initialize(arr);
//        System.out.println(calculateQuickSortTime(arr));
//        int[] arr2 = new int[LENGTH];
//        int[] arr3 = new int[LENGTH];
//        int[] arr4 = new int[LENGTH];
//        initialize(arr4);
//        FileService.writeFile(arr4);
//        FileService.readFile(arr4);

//        System.arraycopy(arr1,0, arr2, 0, LENGTH);
//        System.arraycopy(arr1,0, arr3, 0, LENGTH);
//        InsertionSort.insertionSort(arr);
//        QuickSort.quickSort(arr, 0, LENGTH-1);
//        HybridSort.hybridSort(arr, 0, LENGTH-1);
//        System.out.println(Arrays.toString(arr));
//        long start = System.nanoTime();
//        QuickSort.quickSort(arr, 0, LENGTH-1);
//        long finish = System.nanoTime();
//        calculateQuickSortTime(arr1);
//        calculateQuickSortTime(arr2);
//        calculateQuickSortTime(arr3);
//        System.out.println(Arrays.toString(arr1));
        test(5000);
    }


    private static void initialize(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < LENGTH; i++) {
            arr[i] = random.nextInt(2 * RANGE + 1) - RANGE;
        }
    }

    private static long calculateQuickSortTime(int[] arr) {
        long start = System.nanoTime();
        QuickSort.quickSort(arr, 0, LENGTH-1);
        long finish = System.nanoTime();
        long time = finish - start;
//        System.out.println("\nSpent time: " + (time)/1_000_000 + "ns.");
        return time;
    }

    private static long calculateHybridSortTime(int[] arr) {
        long start = System.nanoTime();
        HybridSort.hybridSort(arr, 0, LENGTH-1);
        long finish = System.nanoTime();
        long time = finish - start;
//        System.out.println("\nSpent time: " + (time)/1_000_000 + "ns.");
        return time;
    }

    private static long calculateInsertionSortTime(int[] arr) {
        long start = System.nanoTime();
        InsertionSort.insertionSort(arr);
        long finish = System.nanoTime();
        long time = finish - start;
//        System.out.println("\nSpent time: " + (time)/1_000_000 + "ns.");
        return time;
    }

    private static void test(int n) {
        System.out.println("Test");
        int[] arr = new int[LENGTH];
        long avgQsTime = 0;
//        long avgHsTime = 0;
        long avgIsTime = 0;
        for (int i = 0; i < n; i++) {
            initialize(arr); // инициализирую рандомно
            FileService.writeFile(arr); // записываю в файл
            avgQsTime += calculateQuickSortTime(arr); // сортирую кв.с и считаю время
            FileService.readFile(arr); // считываю с файла
//            System.out.println(Arrays.toString(arr));
//            avgHsTime += calculateHybridSortTime(arr); // сортирую г.с и считаю время
            avgIsTime += calculateInsertionSortTime(arr);
        }
        System.out.println("Average QuickSort time:  " + avgQsTime/n);
        System.out.println("Average InsertSort time: " + avgIsTime/n);
//        System.out.println("Average HybridSort time: " + avgHsTime/n);
    }
}
