package com.algorithm.A_DataStructure.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xugang
 * @date 2022/9/15
 */
public class Test {

    public static void main(String[] args) {
        // 12 67 56 16 25 37 22 29 15 47 48 34
        List<Integer> rawValue = new ArrayList<>();
        rawValue.add(12);
        rawValue.add(67);
        rawValue.add(56);
        rawValue.add(16);
        rawValue.add(25);
        rawValue.add(37);
        rawValue.add(22);
        rawValue.add(29);
        rawValue.add(15);
        rawValue.add(47);
        rawValue.add(48);
        rawValue.add(34);

        HashTable hashTable = new HashTable();
        for (Integer intA : rawValue) {
            hashTable.insertHash(intA);
        }

        for (int i = 0; i < hashTable.element.length; i++) {
            System.out.println("position= " + i + "___" + hashTable.element[i]);
        }


        System.out.println(hashTable.searchHash(25) + "__" + hashTable.searchHash(37));
    }
}
