package com.study.algorithm.sort;

import com.study.Utils;

public class Test {

    public static void main(String[] args) {
        boolean output = false;
        //对随机数组排序
        int[] sortArr = Utils.getIntArr(0,100000,100000);
        new BubbleSort(sortArr.clone()).go("冒泡",output);
        new SelectSort(sortArr.clone()).go("选择",output);
        new QuickSort(sortArr.clone()).go("快速",output);
        new InsertSort(sortArr.clone()).go("插入",output);
        new HeapSort(sortArr.clone()).go("堆",output);
        new ShellSort(sortArr.clone()).go("希尔",output);
        new MergeSort(sortArr.clone()).go("归并",output);
        MergeSort bs = new MergeSort(sortArr.clone());
        bs.go("归并",output);
        sortArr = bs.sortArr;
        //对有序数组排序

        new BubbleSort(sortArr.clone()).go("冒泡",output);
        new SelectSort(sortArr.clone()).go("选择",output);
        new QuickSort(sortArr.clone()).go("快速",output);
        new InsertSort(sortArr.clone()).go("插入",output);
        new HeapSort(sortArr.clone()).go("堆",output);
        new ShellSort(sortArr.clone()).go("希尔",output);
        new MergeSort(sortArr.clone()).go("归并",output);

//              对无序数组排序
//        冒泡排序结束 耗時 16378ms
//        选择排序结束 耗時 4207ms
//                    快速排序结束 耗時 14ms
//        插入排序结束 耗時 822ms
//                                    堆排序结束 耗時 12ms
//                            希尔排序结束 耗時 13ms
//                                    归并排序结束 耗時 12ms
//        归并排序结束 耗時 8ms
//              对有序数组排序
//        冒泡排序结束 耗時 5753ms
//        选择排序结束 耗時 3649ms
//             快速排序结束 耗時 11ms
//                                  插入排序结束 耗時 0ms
//                  堆排序结束 耗時 7ms
//                        希尔排序结束 耗時 3ms
//                             归并排序结束 耗時 1ms

    }
}
