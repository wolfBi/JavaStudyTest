package com.study.algorithm.sort;

import com.study.Utils;

/**
 * 时间复杂度为O(n^2）
 * 第一次从下标为0的开始下标为0的这个数与后面的n-1个进行比较；找出最小或者最大的放在下标为0的这个位置；
 * 第二次从下标为1的开始比较；查询剩下的最大或者最小值；放在下标为1的位置；以此类推；直到排序完成
 */
public class SelectSort extends CustomSort {

    public static void main(String[] args) {
        int[] sortArr = Utils.getIntArr(0,100000,100000);
        new SelectSort(sortArr).go();
    }

    public SelectSort(int[] sortArr) {
        super(sortArr);
    }

    @Override
    int[] sort() {
        return sort1();
    }

    /**
     * 100000  4100ms
     * @return
     */
    int[] sort1() {
        for (int i = 0; i < sortArr.length; i++) {
            for (int j = i+1; j < sortArr.length; j++) {
                if(sortArr[j]<sortArr[i]){
                    swap(sortArr,i,j);
                }
            }
        }
        return sortArr;
    }
    /**
     * 100000  3509ms
     * @return
     */
    int[] sort2() {
        for (int i = 0; i < sortArr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < sortArr.length; j++) {
                if(sortArr[j]<sortArr[minIndex]){
                  minIndex = j;
                }
            }
            swap(sortArr,i,minIndex);
        }
        return sortArr;
    }
}
