package com.study.algorithm.sort;

import com.study.Utils;

import java.util.Arrays;

public class CustomSort {
    private static final int MAX_OUTPUT_LENGTH = 20;
    int[] sortArr;

    public CustomSort(int[] sortArr){
        this.sortArr = sortArr;
    }
    public CustomSort(int min,int max,int length){
        this.sortArr = Utils.getIntArr(min,max,length);
    }
    void output(){
        if(sortArr.length > MAX_OUTPUT_LENGTH){
            System.out.println("\t "+Arrays.toString(sortArr));
        }else{
            int i = 0;
            System.out.print("\t ");
            for (i = 0; i < MAX_OUTPUT_LENGTH && i < sortArr.length; i++) {
                System.out.print(sortArr[i]+" ");
            }
            if(i < sortArr.length){
                System.out.print("...");
            }
            System.out.println(" ");
        }
    }
    void go(){
        output();
        System.out.println("排序开始");
        long start = System.currentTimeMillis();
        sortArr = sort();
        long end = System.currentTimeMillis();
        System.out.println("排序结束");
        output();
        System.out.println("args = " + (end-start) + "ms");
    }

    int[] sort(){
        return sortArr;
    }


    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
