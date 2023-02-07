package com.algorithm.B_CharSort;

/**
 * 逐个比较
 *  2 1 4 5 3 6 7
 * @author xugang
 * @date 2022/9/15
 */
public class BFSort {

    /**
     * 蛮力法
     * Brute Force
     *
     * @param haystack 草垛
     * @param needle   针
     * @return 首次出现位置
     */
    public int strStr(String haystack, String needle) {
        int hayLen = haystack.length();
        int needLen = needle.length();

        if (hayLen < needLen) {
            return -1;
        }

        if (needLen == 0) {
            return 0;
        }

        // 需要匹配的次数
        for (int i = 0; i < hayLen - needLen + 1; ++i) {
            int j;
            for (j = 0; j < needLen; j++) {
                // 不符合的情况 直接跳出 主串指针后移一位
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            // 匹配成功
            if (j == needLen) {
                return i;
            }
        }
        return -1;
    }

}
