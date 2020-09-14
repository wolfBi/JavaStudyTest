package com.study.algorithm.sort;

import com.study.Utils;

/**
 *  原地堆排序
 *
 */
public class HeapfiySort extends CustomSort {

    public static void main(String[] args) {
        int[] sortArr = Utils.getIntArr(0,10,10);
        new HeapfiySort(sortArr).go("原地堆排序",true);
    }

    public HeapfiySort(int[] sortArr) {
        super(sortArr);
    }
    /**
     * 100000 13ms
     * @return
     */
    @Override
    int[] sort() {
        int n = sortArr.length;
        for (int i = (n-1)/2; i >= 0 ; i--) {
            shifdown(sortArr,n,i);
        }
        output();
        for (int i = n-1; i > 0 ; i--) {
            swap(sortArr,0,i);
            shifdown(sortArr,i,0);
        }
        return sortArr;
    }

    int[] shifdown(int[] arr, int n, int k) {
        System.out.println(" n = " + n + ", k = " + k + "");
        while(2*k +1 <n){ //不越界
            int j = 2*k+1;
            if(j+1 < n && arr[j+1]>arr[j]){
                j +=1;
            }
            System.out.println("\t j arr["+j+"]:" + arr[j] + "");
            if(arr[k] >= arr[j]){
                System.out.println("\t k arr["+k+"]:" + arr[k] + " break");
                break;
            }
            System.out.println("\t k arr["+k+"]:" + arr[k] + " swap");
            swap(arr,k,j);
            k=j;
            System.out.println("\t update k="+k);
            output();
        }
        return sortArr;
    }

}
