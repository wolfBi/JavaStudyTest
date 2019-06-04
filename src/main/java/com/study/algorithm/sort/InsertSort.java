package com.study.algorithm.sort;

import com.study.Utils;

/**
 * 插入排序算法
 * 时间复杂度为O(n^2）
 */
public class InsertSort extends CustomSort {

    public static void main(String[] args) {
        int[] sortArr = Utils.getIntArr(0,100000,100000);
        new InsertSort(sortArr).go("插入",true);
    }

    @Override
    int[] sort() {
        return dirteSort();
    }
    /**
     * 直接插入排序的算法思路：
     * （1） 设置监视哨r[0]，将待插入记录的值赋值给r[0]；
     * （2） 设置开始查找的位置j；
     * （3） 在数组中进行搜索，搜索中将第j个记录后移，直至r[0].key≥r[j].key为止；
     * （4） 将r[0]插入r[j+1]的位置上。
     *  100000  923ms
     */
    int[] dirteSort(){
        int inx;
        int j;
        for (int i = 1; i < sortArr.length; i++) {
            inx = sortArr[i];
            for (j = i-1; j >=0 && inx < sortArr[j]; j--) {
//                System.out.println("move index: "+(j+1)+", val:" +sortArr[j+1] );
                sortArr[j+1] = sortArr[j];
            }
            sortArr[j+1] = inx;
//            output();
        }
        return sortArr;
    }

    /**
     * 折半插入排序（二分插入排序）
     * @return
     */
    int[] midInsertSort(){
        return sortArr;
    }
    public InsertSort(int min, int max, int length) {
        super(min, max, length);
    }
    public InsertSort(int[] sortArr) {
        super(sortArr);
    }
}
