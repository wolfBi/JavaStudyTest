package com.study.algorithm.sort;

import com.study.Utils;

/**
 * 希尔排序:插入排序改进版
 * O(N1.3)
 */
public class ShellSort extends CustomSort {

    public static void main(String[] args) {
        int[] sortArr = Utils.getIntArr(0,100000,100000);
        new ShellSort(sortArr).go("希尔",true);
    }

    public ShellSort(int[] sortArr) {
        super(sortArr);
    }

    @Override
    int[] sort() {
        return sort1();
    }

    /**
     * 100000  14ms
     * @return
     */
    int[] sort1() {
        int len = sortArr.length;
        int counter = 1;

        int h = 1;
        while(3*h+1<len){  //确定第一轮排序时的间隔
            h = 3*h+1;
        }

//        System.out.println("第一轮排序的间隔: "+h );
        while(h>0){
            for(int i=0;i<h;i++){
                shellInsertSort(i,h);  //对间隔为h的元素进行插入排序
            }

            h = (h-1)/3;  //下一轮排序的间隔

//            System.out.println("排序的间隔: "+h );
//            System.out.println("第"+counter+"轮排序结果：");
//            output();
            counter++;
        }
        return sortArr;
    }
    /**
     * 希尔排序内部使用的插入排序:
     * 需要进行插入排序的元素为array[beginIndex]、array[beginIndex+increment]、array[beginIndex+2*increment]...
     *@param beginIndex 起始下标
     *@param increment 增量
     */
    private void shellInsertSort(int beginIndex,int increment) {

        int targetIndex = beginIndex + increment;  //欲插入元素的下标

        while (targetIndex < sortArr.length) {
            int temp = sortArr[targetIndex];

            int previousIndex = targetIndex - increment;  //前一个元素下标，间隔为increment
//            System.out.println(" "+targetIndex+"排序下标 "+ previousIndex +" ");
            while (previousIndex >= 0 && sortArr[previousIndex] > temp) {
                sortArr[previousIndex + increment] = sortArr[previousIndex];  //比欲插入数据项大的元素后移一位
                previousIndex = previousIndex - increment;
            }
//            System.out.println(" "+targetIndex+"排序后下标 "+ previousIndex +" ");
            sortArr[previousIndex + increment] = temp;  //插入到合适的位置
//            output();
            targetIndex = targetIndex + increment;  //插入下一个元素
        }
    }
}
