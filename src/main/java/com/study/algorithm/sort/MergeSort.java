package com.study.algorithm.sort;

import com.study.Utils;

/**
 * 归并排序  O(N*log2N) 稳定
 *1、n大时好，归并比较占用内存，内存随n的增大而增大，但却是效率高且稳定的排序算法。
 * 算法与数据结构 三/1-5
 *
 */
public class MergeSort extends CustomSort{


    public static void main(String[] args) {
        int[] sortArr = Utils.getIntArr(0,100000,100000);
        new MergeSort(sortArr).go("归并",true);
    }

    /**
     * 100000 18ms
     * @return
     */
    @Override
    int[] sort() {
        return mergeSort(sortArr,0,sortArr.length-1);
    }
    //递归使用归并算法,对arr[l....r]元素进行排序
    int[] mergeSort(int[] arr, int l, int r) {
//        if(l >= r)
//            return arr;
        if(r-l <= 15){//优化一
            insertionSort(arr,l,r);
            return arr;
        }
        int mid = (l+r)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        //优化二 忘了取值该是啥了, ArrayIndexOutOfBoundsException
//        System.out.println("mid = [" + mid + "]");
        if(arr[mid] > arr[mid+1]){
            merge(arr,l,mid,r);
        }
        return arr;
    }
    //归并
    void merge(int[] arr, int l, int mid, int r){
//        System.out.println("merge start arr = [" + arr + "], l = [" + l + "], mid = [" + mid + "], r = [" + r + "]");
       int[] aux = new int[r-l+1];
        for (int i = l; i <= r; i++) {
            aux[i-l] = arr[i];
        }
        int i = l, j = mid +1;
        for (int k = l; k <= r ; k++) {
            if(i > mid){
                arr[k] = aux[j-l];
                j++;
            }else if( j > r){
//                System.out.println("r = [" + r + "], k = [" + k + "], i-l = [" + (i-l) + "], ");
                arr[k] = aux[i-l];
                i++;
            }else if (aux[i-l] < aux[j-l]){
                arr[k] = aux[i-l];
                i++;
            }else{
                arr[k] = aux[j-l];
                j++;
            }
        }
    }

    public MergeSort(int[] sortArr) {
        super(sortArr);
    }

}
