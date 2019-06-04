package com.study.algorithm.sort;

import com.study.Utils;

/**
 * 冒泡排序
 * 时间复杂度为O(n^2）
 * 依次比较相邻的两个数，将小数放在前面，大数放在后面。即在第一趟：首先比较第1个和第2个数，将小数放前，大数放后。
 * 然后比较第2个数和第3个数，将小数放前，大数放后，如此继续，直至比较最后两个数，将小数放前，大数放后。至此第一趟结束，
 *
 * 1、冒泡排序是一种用时间换空间的排序方法，n小时好
 * 2、最坏情况是把顺序的排列变成逆序，或者把逆序的数列变成顺序，最差时间复杂度O(N^2)只是表示其操作次数的数量级
 * 3、最好的情况是数据本来就有序，复杂度为O(n)
 */
public class BubbleSort extends CustomSort {

    public static void main(String[] args) {
        int[] sortArr = Utils.getIntArr(0,10,10);
        new BubbleSort(sortArr).go();
    }

    public BubbleSort(int[] sortArr) {
        super(sortArr);
    }

    @Override
    int[] sort() {
        return sort1();
    }

    /**
     * 100000 15851ms
     * 8 6 3 4 0 7 1 6 6 5
     * run 0 limit j < 9
     * 6 3 4 0 7 1 6 6 5 8
     * run 1 limit j < 8
     * 3 4 0 6 1 6 6 5 7 8
     * run 2 limit j < 7
     * 3 0 4 1 6 6 5 6 7 8
     * run 3 limit j < 6
     * 0 3 1 4 6 5 6 6 7 8
     * run 4 limit j < 5
     * 0 1 3 4 5 6 6 6 7 8
     * run 5 limit j < 4
     * 0 1 3 4 5 6 6 6 7 8
     * run 6 limit j < 3
     * 0 1 3 4 5 6 6 6 7 8
     * run 7 limit j < 2
     * 0 1 3 4 5 6 6 6 7 8
     * run 8 limit j < 1
     * 0 1 3 4 5 6 6 6 7 8
     * 0 1 3 4 5 6 6 6 7 8
     * args = 1ms
     * @return
     */
    int[] sort1() {
        for(int i =0;i<sortArr.length-1;i++) {
            System.out.println("run "+i + " limit j < "+(sortArr.length-i-1));
            for(int j=0;j<sortArr.length-i-1;j++) {//-1为了防止溢出
                if(sortArr[j]>sortArr[j+1]) {
                    swap(sortArr,j,j+1);
                }
            }
            output();
        }
        return sortArr;
    }
    /**
     * 100000  ms
     * @return
     */
    int[] sort2() {

        return sortArr;
    }
}
