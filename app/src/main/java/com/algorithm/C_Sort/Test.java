package com.algorithm.C_Sort;

import java.util.Arrays;

/**
 * @author xugang
 * @date 2022/9/15
 */
public class Test {

    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 7, 6, 2, 1, 3};
        Sort sort = new Sort();
        int[] bubbleSort = sort.bubbleSort(array);
        System.out.println(Arrays.toString(bubbleSort));
    }
}
