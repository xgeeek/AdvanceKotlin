package com.algorithm.A_DataStructure.hash;

/**
 * @author xugang
 * @date 2022/9/15
 */
public class HashTable {

    int[] element; // 散列表存储数组
    public int count = 0; // 散列表插入数据数量
    public int size = 12; // 散列表最大容量
    public final int NULLKEY = Integer.MIN_VALUE; // 散列表初始值

    public HashTable() {
        element = new int[size];
        for (int i = 0; i < size; i++) {
            element[i] = NULLKEY;
        }
    }

    // 插入元素 除留余数法
    public void insertHash(int key) {
        if (count == size) {
            return;
        }
        int index = key % size; // 插入散列地址
        // 判断是否有冲突
        while (element[index] != NULLKEY) {
            index = (index + 1) % size; // 线性探测法
        }
        element[index] = key;
        count++;
    }

    public String searchHash(int key) {
        int index = key % size;
        while (element[index] != key) {
            index = (index + 1) % size;

            // 不存在情况 散列地址初始值，循环一圈到原来位置
            if (element[index] == NULLKEY || index == key % size) {
                return "不存在";
            }
        }
        return "存在,索引为 " + index;
    }
}
