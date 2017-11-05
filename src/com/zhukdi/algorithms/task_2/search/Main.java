package com.zhukdi.algorithms.task_2.search;

import com.zhukdi.algorithms.services.FileService;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final int LENGTH = 10_000_000;//10_000_000
    private static final int RANGE = 4_000_000;//4_000_000

    public static void main(String[] args) {
        comparison(10); //50
    }

    private static void initialize(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < LENGTH; i++) {
            arr[i] = random.nextInt(RANGE);
        }
    }

    private static void comparison(int n) {
        int[] arr = new int[LENGTH];
        System.out.println("________________________________________");
        System.out.println("| i | BinarySearh | InterpolationSearh |");
        for (int i = 0; i < n; i++) {
            initialize(arr); // инициализирую рандомно
            Arrays.sort(arr);
//            Random random = new Random();
//            int x = random.nextInt(RANGE);
            int x = 2*1*2*1*9*9*8;// 2592
            FileService.writeFile(arr);
            System.out.println("| " + i + " |\t" + BinarySearch.binarySearch(arr, 0, LENGTH-1, x, 0)+"\t|\t" +
                                InterpolationSearch.interpolationSearch(arr, 0, LENGTH-1, x, 0) + "\t|");
        }
        System.out.println("________________________________________");
    }

}
