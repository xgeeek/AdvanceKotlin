package com.algorithm.C_Sort;

/**
 * @author xugang
 * @date 2022/9/15
 */
public class Sort {

//    public int[] simpleSort(int[] nums) {
//        int len = nums.length;
//        int min = 0;
//        for (int i = 0; i < len; ++i) {
//            min = i;
//            for (int j = i + 1; j < len; ++j) {
//                if (nums[min] > nums[j]) {
//                    min = j;
//                }
//            }
//            if (min != i) {
//                swap(nums, i, min);
//            }
//        }
//        return nums;
//    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] bubbleSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) { // 需要排序的次数
                if (nums[j] > nums[j + 1]) { // 往后排
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }
}
